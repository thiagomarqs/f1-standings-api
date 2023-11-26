package com.example.f1standings.controller;

import com.example.f1standings.model.TeamStanding;
import com.example.f1standings.service.TeamsStandingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/standings/teams")
public class TeamStandingsController {

    @Autowired
    private TeamsStandingsService teamsStandingsService;

    @GetMapping
    public ResponseEntity<List<TeamStanding>> getStandings() throws IOException {
        List<TeamStanding> teamStandings = teamsStandingsService.getStandings();
        return ResponseEntity.ok(teamStandings);
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<TeamStanding>> getStandingsByYear(@PathVariable("year") String year) throws IOException {
        List<TeamStanding> teamStandings = teamsStandingsService.getStandingsByYear(year);
        return ResponseEntity.ok(teamStandings);
    }

}
