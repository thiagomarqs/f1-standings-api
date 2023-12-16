package com.example.f1standings.controller;

import com.example.f1standings.model.GrandPrixResult;
import com.example.f1standings.model.RaceResult;
import com.example.f1standings.service.RaceResultsService;
import com.example.f1standings.shared.Controller;
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
    public ResponseEntity<List<RaceResult>> getByYear(@PathVariable("year") String year) throws IOException {
        List<RaceResult> raceResults = raceResultsService.getByYear(year);
        return controller.resolveListResponse(raceResults);
    }

    @GetMapping("/{gp}")
    public ResponseEntity<List<GrandPrixResult>> getByGrandPrix(@PathVariable("year") String year, @PathVariable("gp") String gp) throws IOException {
        List<GrandPrixResult> results = raceResultsService.getByGrandPrix(Integer.parseInt(year), gp);
        return controller.resolveListResponse(results);
    }

}
