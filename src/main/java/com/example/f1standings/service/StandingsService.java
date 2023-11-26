package com.example.f1standings.service;

import com.example.f1standings.model.Standing;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class StandingsService {

    private final String STANDINGS_URL_PARAMETERIZED = "https://www.formula1.com/en/results.html/%s/drivers.html";

    /**
     * Returns the standings, already processed.
     */
    public List<Standing> getStandings() throws IOException {
        String url = String.format(STANDINGS_URL_PARAMETERIZED, "2023");
        List<Element> rawStandingsTable = this.getRawStandingsTable(url);
        return toStandingList(rawStandingsTable);
    }

    /**
     * Returns the standings of a specific year.
     */
    public List<Standing> getStandingsByYear(String year) throws IOException {
        String url = String.format(STANDINGS_URL_PARAMETERIZED, year);
        List<Element> rawStandingsTable = this.getRawStandingsTable(url);
        return toStandingList(rawStandingsTable);
    }

    /**
     * Gets the raw standings table from the F1 site as a list
     * of Element objects.
     */
    public List<Element> getRawStandingsTable(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        Element standingsTable = document.getElementsByClass("resultsarchive-table").get(0);
        Element standingsTableBody = standingsTable.getElementsByTag("tbody").get(0);
        return standingsTableBody.getElementsByTag("tr").stream().toList();
    }

    /**
     * Transforms the standings list to a list of Standing objects.
     */
    public List<Standing> toStandingList(List<Element> elements) {
        return elements.stream().map(Standing::new).toList();
    }

}
