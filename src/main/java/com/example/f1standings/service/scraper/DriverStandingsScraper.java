package com.example.f1standings.service.scraper;

import com.example.f1standings.model.DriverGrandPrixStanding;
import com.example.f1standings.shared.Scraper;
import com.example.f1standings.shared.Urls;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class DriverStandingsScraper {

    @Autowired
    private Scraper<DriverGrandPrixStanding> scraper;

    /**
     * Standings of a specific driver in each Grand Prix.
     */
    public List<DriverGrandPrixStanding> getStandingsByDriver(String startingPointUrl, String driver) throws IOException {
        Document document = Jsoup.connect(startingPointUrl).get();
        boolean nothingFound = document.getElementsByAttributeValueContaining("data-value", driver).isEmpty();

        if(nothingFound) return List.of();

        Element driverStandingsListItem = document.getElementsByAttributeValueContaining("data-value", driver).get(0);
        String driverStandingsPath = driverStandingsListItem.attr("href");
        String driverStandingsFullUrl = Urls.FORMULA_ONE_SITE_BASE_URL + driverStandingsPath;

        return scraper.getResults(driverStandingsFullUrl, DriverGrandPrixStanding.class);
    }

}
