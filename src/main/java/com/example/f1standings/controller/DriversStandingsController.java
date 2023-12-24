package com.example.f1standings.controller;

import com.example.f1standings.model.DriverChampionshipStanding;
import com.example.f1standings.model.DriverGrandPrixStanding;
import com.example.f1standings.service.DriversStandingsService;
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

import static com.example.f1standings.shared.StringUtils.containsOnlyLettersAndOrHyphens;

@RestController
@RequestMapping("/api/{year}/standings/drivers")
public class DriversStandingsController {

    @Autowired
    private DriversStandingsService driversStandingsService;

    @Autowired
    private Controller controller;

    @GetMapping
    @Operation(
        summary = "Driver standings",
        description = "The driver standings by year.",
        tags = { "Driver Standings" },
        parameters = {
            @Parameter(name = "year", description = "The year to search.")
        }
    )
    public ResponseEntity<List<DriverChampionshipStanding>> getStandingsByYear(@PathVariable("year") String year) throws IOException {

        if(!StringUtils.isNumeric(year)) return controller.resolveListResponse(List.of());

        List<DriverChampionshipStanding> driverChampionshipStandings = driversStandingsService.getStandingsByYear(year);
        return controller.resolveListResponse(driverChampionshipStandings);
    }

    @GetMapping("/{driver}")
    @Operation(
        summary = "Standings by driver",
        description = "The standings of a specific driver in a year.",
        tags = { "Driver Standings" },
        parameters = {
            @Parameter(name = "year", description = "The year to search."),
            @Parameter(name = "driver", description = "The driver's name, in kebab-case, like 'max-verstappen' or 'guanyu-zhou'.")
        }
    )
    public ResponseEntity<List<DriverGrandPrixStanding>> getStandingsByDriver(@PathVariable("year") String year, @PathVariable("driver") String driver) throws IOException {

        if(!StringUtils.isNumeric(year) || !containsOnlyLettersAndOrHyphens(driver)) {
            return controller.resolveListResponse(List.of());
        }

        List<DriverGrandPrixStanding> driverGrandPrixStandings = driversStandingsService.getStandingsByDriver(year, driver);
        return controller.resolveListResponse(driverGrandPrixStandings);
    }

}
