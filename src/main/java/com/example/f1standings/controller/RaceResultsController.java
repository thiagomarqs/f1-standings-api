package com.example.f1standings.controller;

import com.example.f1standings.model.RaceResult;
import com.example.f1standings.service.RaceResultsService;
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

    @GetMapping
    public ResponseEntity<List<RaceResult>> getStandingsByYear(@PathVariable("year") String year) throws IOException {
        List<RaceResult> raceResults = raceResultsService.getStandingsByYear(year);
        return ResponseEntity.ok(raceResults);
    }

}
