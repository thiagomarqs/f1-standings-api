package com.example.f1standings.service;

import com.example.f1standings.model.DriverStanding;
import com.example.f1standings.model.DriverStanding;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DriversStandingsService {

    private final String STANDINGS_URL_PARAMETERIZED = "https://www.formula1.com/en/results.html/%s/drivers.html";

    /**
     * Returns the standings of the current season.
     */
    public List<DriverStanding> getStandings() throws IOException {
        String url = String.format(STANDINGS_URL_PARAMETERIZED, "2023");
        return this.getProcessedStandings(url);
    }

    /**
     * Returns the standings of a specific year.
     */
    public List<DriverStanding> getStandingsByYear(String year) throws IOException {
        String url = String.format(STANDINGS_URL_PARAMETERIZED, year);
        return this.getProcessedStandings(url);
    }

    /**
     * Returns the standings, already processed.
     */
    public List<DriverStanding> getProcessedStandings(String url) throws IOException {
        List<Element> rawStandings = this.getRawStandings(url);
        return rawStandings.stream().map(DriverStanding::new).toList();
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
