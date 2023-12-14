package com.example.f1standings.service;

import com.example.f1standings.model.TeamStanding;
import com.example.f1standings.shared.Scraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TeamsStandingsService {

    private final String STANDINGS_URL_PARAMETERIZED = "https://www.formula1.com/en/results.html/%s/team.html";

    @Autowired
    private Scraper<TeamStanding> scraper;

    /**
     * Returns the standings of the current season.
     */
    public List<TeamStanding> getStandings() throws IOException {
        String url = String.format(STANDINGS_URL_PARAMETERIZED, "2023");
        return scraper.getResults(url, TeamStanding.class);
    }

    /**
     * Returns the standings of a specific year.
     */
    public List<TeamStanding> getStandingsByYear(String year) throws IOException {
        String url = String.format(STANDINGS_URL_PARAMETERIZED, year);
        return scraper.getResults(url, TeamStanding.class);
    }

}
