package com.example.f1standings.service;

import com.example.f1standings.model.Standing;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ScrapingService {

    private final String STANDINGS_URL = "https://www.formula1.com/en/results.html/2023/drivers.html";

    /**
     * Returns the standings, already processed.
     */
    public List<Standing> getStandings() throws IOException {
        List<Element> rawStandingsTable = this.getRawStandingsTable();
        return toStandingList(rawStandingsTable);
    }

    /**
     * Gets the raw standings table from the F1 site as a list
     * of Element objects.
     */
    public List<Element> getRawStandingsTable() throws IOException {
        Document document = Jsoup.connect(STANDINGS_URL).get();
        Element standingsTable = document.getElementsByClass("resultsarchive-table").get(0);
        Element standingsTableBody = standingsTable.getElementsByTag("tbody").get(0);
        return standingsTableBody.getElementsByTag("tr").stream().toList();
    }

    /**
     * Transforms the standings list to a list of Standing objects.
     */
    public List<Standing> toStandingList(List<Element> elements) {
        return elements.stream()
                .map(Standing::new)
                .toList();
    }

}
