package com.example.f1standings.shared;

import com.example.f1standings.model.GrandPrixResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Scraper<T> {

    private final String FORMULA_ONE_SITE_BASE_URL = "https://www.formula1.com";

    /**
     * Generic method to get the results, because currently
     * the HTML structure of the results pages is basically the same.
     */
    public List<T> getResults(String url, Class<T> clazz) throws IOException {
        List<Element> rawStandings = this.getRawResultsTable(url);
        return rawStandings.stream().map(e -> mapToClass(e, clazz)).toList();
    }

    /**
     * Gets the results of a specific GP.
     * This method programatically navigates the website to
     * get to the results page of the desired GP and then
     * extract the data.
     * The starting point of this navigation is the provided url.
     */
    public List<Element> getGrandPrixResults(String startingPointUrl, String gp) throws IOException {
        Document document = Jsoup.connect(startingPointUrl).get();
        boolean nothingFound = document.getElementsByAttributeValueContaining("data-value", gp).isEmpty();

        if(nothingFound) return List.of();

        Element grandPrixListItem = document.getElementsByAttributeValueContaining("data-value", gp).get(0);
        String grandPrixResultsPath = grandPrixListItem.attr("href");
        String grandPrixResultsFullUrl = FORMULA_ONE_SITE_BASE_URL + grandPrixResultsPath;

        Document grandPrixResultsDocument = Jsoup.connect(grandPrixResultsFullUrl).get();

        Elements tableElement = grandPrixResultsDocument.getElementsByClass("resultsarchive-table");

        nothingFound = tableElement.isEmpty();

        if(nothingFound) return List.of();

        Element table = tableElement.get(0);
        Element tableBody = table.getElementsByTag("tbody").get(0);

        return tableBody.getElementsByTag("tr").stream().toList();
    }

    /**
     * Gets the raw results table from the F1 site as a list
     * of Jsoup’s Element objects.
     */
    private List<Element> getRawResultsTable(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        boolean nothingFound = document.getElementsByClass("resultsarchive-table").isEmpty();

        if(nothingFound) return List.of();

        Element table = document.getElementsByClass("resultsarchive-table").get(0);
        Element tableBody = table.getElementsByTag("tbody").get(0);

        return tableBody.getElementsByTag("tr").stream().toList();
    }

    /**
     * Necessary to make mapping to a generic type possible.
     */
    private T mapToClass(Element element, Class<T> clazz) {
        try {
            return clazz.getConstructor(Element.class).newInstance(element);
        } catch (Exception e) {
            throw new RuntimeException("Error mapping element to class", e);
        }
    }

}
