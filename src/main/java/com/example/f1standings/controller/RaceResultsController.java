package com.example.f1standings.controller;

import com.example.f1standings.model.GrandPrixResult;
import com.example.f1standings.model.RaceResult;
import com.example.f1standings.service.RaceResultsService;
import com.example.f1standings.shared.Controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/{year}/results/races")
public class RaceResultsController {

    @Autowired
    private RaceResultsService raceResultsService;

    @Autowired
    private Controller controller;

    @GetMapping
    @Operation(
        summary = "Race results of a year.",
        description = "The final results of each race of a year.",
        tags = { "Race" },
        parameters = {
            @Parameter(name = "year", description = "The year to search.")
        }
    )
    public ResponseEntity<List<RaceResult>> getByYear(@PathVariable("year") String year) throws IOException {

        if(!StringUtils.isNumeric(year)) return controller.resolveListResponse(List.of());

        List<RaceResult> raceResults = raceResultsService.getByYear(year);
        return controller.resolveListResponse(raceResults);
    }

    @GetMapping("/{gp}")
    @Operation(
        summary = "Results of a Grand Prix.",
        description = "The final results of a specific Grand Prix.",
        tags = { "Race", "Grand Prix"},
        parameters = {
            @Parameter(name = "year", description = "The year to search."),
            @Parameter(name = "gp", description = "The Grand Prix to search. Must be written in kebab-case, like 'spain' or 'saudi-arabia'.")
        }
    )
    public ResponseEntity<List<GrandPrixResult>> getByGrandPrix(@PathVariable("year") String year, @PathVariable("gp") String gp) throws IOException {

        if(!StringUtils.isNumeric(year) || !StringUtils.isAlpha(gp)) {
            return controller.resolveListResponse(List.of());
        }

        List<GrandPrixResult> results = raceResultsService.getByGrandPrix(year, gp);
        return controller.resolveListResponse(results);
    }

}
