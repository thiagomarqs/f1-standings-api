package com.example.f1standings.service.scraper;

import com.example.f1standings.model.GrandPrixResult;
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

import static com.example.f1standings.shared.Urls.RACE_RESULTS_URL_PARAMETERIZED;

@Component
public class RaceResultsScraper {

    @Autowired
    private Scraper<GrandPrixResult> scraper;

    /**
     * Gets the results of a specific GP.
     * This method programatically navigates the website
     * from the starting point URL to get to the results
     * page of the desired GP and then extract the data.
     */
    public List<GrandPrixResult> getGrandPrixResults(String year, String gp) throws IOException {
        String startingPointUrl = String.format(RACE_RESULTS_URL_PARAMETERIZED, year);
        Document document = Jsoup.connect(startingPointUrl).get();
        boolean nothingFound = document.getElementsByAttributeValueContaining("data-value", gp).isEmpty();

        if(nothingFound) return List.of();

        Element grandsPrixList = document.getElementsByClass("resultsarchive-filter-wrap").get(2);
        Elements grandPrixListItem = grandsPrixList.getElementsByAttributeValueContaining("data-value", gp);

        if(grandPrixListItem.isEmpty()) return List.of();

        String grandPrixResultsPath = grandPrixListItem.attr("href");
        String grandPrixResultsFullUrl = Urls.FORMULA_ONE_SITE_BASE_URL + grandPrixResultsPath;

        return scraper.getResults(grandPrixResultsFullUrl, GrandPrixResult.class);
    }

}
