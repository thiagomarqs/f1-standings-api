package com.example.f1standings.controller;

import com.example.f1standings.model.Standing;
import com.example.f1standings.service.ScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/standings")
public class StandingsController {

    @Autowired
    private ScrapingService scrapingService;

    @GetMapping
    public ResponseEntity<List<Standing>> getStandings() throws IOException {
        List<Standing> standings = scrapingService.getStandings();
        return ResponseEntity.ok(standings);
    }

}
