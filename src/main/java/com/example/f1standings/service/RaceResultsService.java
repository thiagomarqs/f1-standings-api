package com.example.f1standings.service;

import com.example.f1standings.model.GrandPrixResult;
import com.example.f1standings.model.RaceResult;
import com.example.f1standings.service.scraper.RaceResultsScraper;
import com.example.f1standings.shared.Scraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.example.f1standings.shared.Urls.RACE_RESULTS_URL_PARAMETERIZED;

@Service
public class RaceResultsService {

    @Autowired
    private Scraper<RaceResult> scraper;

    @Autowired
    private RaceResultsScraper raceResultsScraper;

    /**
     * Returns the race results of a specific year.
     */
    public List<RaceResult> getByYear(String year) throws IOException {
        String url = String.format(RACE_RESULTS_URL_PARAMETERIZED, year);
        return scraper.getResults(url, RaceResult.class);
    }

    /**
     * Returns the race results of a specific grand prix.
     */
    public List<GrandPrixResult> getByGrandPrix(String year, String gp) throws IOException {
        return raceResultsScraper.getGrandPrixResults(year, gp);
    }

}
