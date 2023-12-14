package com.example.f1standings.service;

import com.example.f1standings.model.RaceResult;
import com.example.f1standings.shared.Scraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RaceResultsService {

    private final String RACE_RESULTS_URL_PARAMETERIZED = "https://www.formula1.com/en/results.html/%s/races.html";

    @Autowired
    private Scraper<RaceResult> scraper;

    /**
     * Returns the race results of the current season.
     */
    public List<RaceResult> getStandings() throws IOException {
        String url = String.format(RACE_RESULTS_URL_PARAMETERIZED, "2023");
        return scraper.getResults(url, RaceResult.class);
    }

    /**
     * Returns the racing results of a specific year.
     */
    public List<RaceResult> getStandingsByYear(String year) throws IOException {
        String url = String.format(RACE_RESULTS_URL_PARAMETERIZED, year);
        return scraper.getResults(url, RaceResult.class);
    }

}
