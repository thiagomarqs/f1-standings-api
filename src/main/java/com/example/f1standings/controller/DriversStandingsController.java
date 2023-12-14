package com.example.f1standings.controller;

import com.example.f1standings.model.DriverStanding;
import com.example.f1standings.service.DriversStandingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/{year}/standings/drivers")
public class DriversStandingsController {

    @Autowired
    private DriversStandingsService driversStandingsService;

    @GetMapping
    public ResponseEntity<List<DriverStanding>> getStandingsByYear(@PathVariable("year") String year) throws IOException {
        List<DriverStanding> driverStandings = driversStandingsService.getStandingsByYear(year);
        return ResponseEntity.ok(driverStandings);
    }

}
