package com.example.f1standings.service.scraper;

import com.example.f1standings.model.GrandPrixResult;
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
public class RaceResultsScraper {

    @Autowired
    private Scraper<GrandPrixResult> scraper;

    /**
     * Gets the results of a specific GP.
     * This method programatically navigates the website to
     * get to the results page of the desired GP and then
     * extract the data.
     * The starting point of this navigation is the provided url.
     */
    public List<GrandPrixResult> getGrandPrixResults(String startingPointUrl, String gp) throws IOException {
        Document document = Jsoup.connect(startingPointUrl).get();
        boolean nothingFound = document.getElementsByAttributeValueContaining("data-value", gp).isEmpty();

        if(nothingFound) return List.of();

        Element grandPrixListItem = document.getElementsByAttributeValueContaining("data-value", gp).get(0);
        String grandPrixResultsPath = grandPrixListItem.attr("href");
        String grandPrixResultsFullUrl = Urls.FORMULA_ONE_SITE_BASE_URL + grandPrixResultsPath;

        return scraper.getResults(grandPrixResultsFullUrl, GrandPrixResult.class);
    }

}
