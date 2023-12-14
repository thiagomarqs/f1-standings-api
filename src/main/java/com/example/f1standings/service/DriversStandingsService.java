package com.example.f1standings.service;

import com.example.f1standings.model.DriverChampionshipStanding;
import com.example.f1standings.model.DriverGrandPrixStanding;
import com.example.f1standings.service.scraper.DriverStandingsScraper;
import com.example.f1standings.shared.Scraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DriversStandingsService {

    private final String STANDINGS_URL_PARAMETERIZED = "https://www.formula1.com/en/results.html/%s/drivers.html";

    @Autowired
    private Scraper<DriverChampionshipStanding> scraper;

    @Autowired
    private DriverStandingsScraper driverStandingsScraper;

    /**
     * Returns the standings of a specific year.
     */
    public List<DriverChampionshipStanding> getStandingsByYear(String year) throws IOException {
        String url = String.format(STANDINGS_URL_PARAMETERIZED, year);
        return scraper.getResults(url, DriverChampionshipStanding.class);
    }

    /**
     * Returns the standings of a specific driver in each
     * Grand Prix.
     */
    public List<DriverGrandPrixStanding> getStandingsByDriver(String year, String driver) throws IOException {
        String url = String.format(STANDINGS_URL_PARAMETERIZED, year);
        return driverStandingsScraper.getStandingsByDriver(url, driver);
    }

}
