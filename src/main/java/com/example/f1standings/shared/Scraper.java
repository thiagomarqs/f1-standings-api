package com.example.f1standings.shared;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Scraper<T> {

    @Autowired
    private ElementMapper<T> mapper;

    /**
     * Generic method to get the results, because currently
     * the HTML structure of the results pages is basically the same.
     */
    public List<T> getResults(String url, Class<T> clazz) throws IOException {
        List<Element> rawStandings = this.getRawResultsTable(url);
        return rawStandings.stream().map(e -> mapper.map(e, clazz)).toList();
    }

    /**
     * Gets the raw results table from the F1 site as a list
     * of Jsoup’s Element objects.
     */
    private List<Element> getRawResultsTable(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        boolean isTableMissing = document.getElementsByClass("resultsarchive-table").isEmpty();

        if(isTableMissing) return List.of();

        Element table = document.getElementsByClass("resultsarchive-table").get(0);
        Elements tableBody = table.getElementsByTag("tbody");

        if(tableBody.isEmpty()) return List.of();

        return tableBody.get(0).getElementsByTag("tr").stream().toList();
    }

}
