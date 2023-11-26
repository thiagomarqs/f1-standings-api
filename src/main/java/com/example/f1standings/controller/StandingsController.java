package com.example.f1standings.controller;

import com.example.f1standings.model.Standing;
import com.example.f1standings.service.StandingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/standings")
public class StandingsController {

    @Autowired
    private StandingsService standingsService;

    @GetMapping
    public ResponseEntity<List<Standing>> getStandings() throws IOException {
        List<Standing> standings = standingsService.getStandings();
        return ResponseEntity.ok(standings);
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Standing>> getStandingsByYear(@PathVariable("year") String year) throws IOException {
        List<Standing> standings = standingsService.getStandingsByYear(year);
        return ResponseEntity.ok(standings);
    }

}
