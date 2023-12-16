package com.example.f1standings.service.scraper;

import com.example.f1standings.model.DriverGrandPrixStanding;
import com.example.f1standings.shared.Scraper;
import com.example.f1standings.shared.Urls;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import static com.example.f1standings.shared.Urls.DRIVER_STANDINGS_URL_PARAMETERIZED;

@Component
public class DriverStandingsScraper {

    @Autowired
    private Scraper<DriverGrandPrixStanding> scraper;

    /**
     * Standings of a specific driver in each Grand Prix.
     */
    public List<DriverGrandPrixStanding> getStandingsByDriver(String year, String driver) throws IOException {
        String startingPointUrl = String.format(DRIVER_STANDINGS_URL_PARAMETERIZED, year);
        Document document = Jsoup.connect(startingPointUrl).get();
        boolean nothingFound = document.getElementsByAttributeValueContaining("data-value", driver).isEmpty();

        if(nothingFound) return List.of();

        Element driversList = document.getElementsByClass("resultsarchive-filter-wrap").get(2);
        Elements driverStandingsListItem = driversList.getElementsByAttributeValueContaining("data-value", driver);

        if(driverStandingsListItem.isEmpty()) return List.of();

        String driverStandingsPath = driverStandingsListItem.get(0).attr("href");
        String driverStandingsFullUrl = Urls.FORMULA_ONE_SITE_BASE_URL + driverStandingsPath;

        return scraper.getResults(driverStandingsFullUrl, DriverGrandPrixStanding.class);
    }

}
