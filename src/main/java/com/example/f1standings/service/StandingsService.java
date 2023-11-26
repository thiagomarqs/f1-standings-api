package com.example.f1standings.service;

import com.example.f1standings.model.DriverStanding;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class StandingsService<T> {

    /**
     * Returns the standings, already processed.
     */
    public List<T> getProcessedStandings(String url, Class<T> clazz) throws IOException {
        List<Element> rawStandings = this.getRawStandings(url);
        return rawStandings.stream().map(e -> mapToClass(e, clazz)).toList();
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

    /**
     * Gets the raw standings table from the F1 site as a list
     * of Jsoup’s Element objects.
     */
    public List<Element> getRawStandings(String url) throws IOException {
        Document document = Jsoup.connect(url).get();

        boolean nothingFound = document.getElementsByClass("resultsarchive-table").isEmpty();

        if(nothingFound) return List.of();

        Element standingsTable = document.getElementsByClass("resultsarchive-table").get(0);
        Element standingsTableBody = standingsTable.getElementsByTag("tbody").get(0);

        return standingsTableBody.getElementsByTag("tr").stream().toList();
    }

}
