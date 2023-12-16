# F1 Standings API

## Summary
API that returns the Formula One drivers standings by scraping the official Formula 1 Website.  
Developed with Spring Boot and JSoup. Documented with Springdoc.


## Endpoints
### Drivers
- **Standings by Year:** `/api/{year}/standings/drivers`  
- **Standings by Driver:** `/api/{year}/standings/drivers/{driver}`  

### Constructors
- **Standings by Year:** `/api/{year}/standings/teams`   

### Races
- **Results by Year:** `/api/{year}/results/races`  
- **Results by Grand Prix** `/api/{year}/results/races/{gp}`


## Examples
<details>
  <summary>2023 Drivers Standings</summary>
  
  ```json
  [
      {
          "position": 1,
          "driver": "Max Verstappen",
          "nationality": "NED",
          "team": "Red Bull Racing Honda RBPT",
          "points": 575.0
      },
      {
          "position": 2,
          "driver": "Sergio Perez",
          "nationality": "MEX",
          "team": "Red Bull Racing Honda RBPT",
          "points": 285.0
      },
      {
          "position": 3,
          "driver": "Lewis Hamilton",
          "nationality": "GBR",
          "team": "Mercedes",
          "points": 234.0
      },
      {
          "position": 4,
          "driver": "Fernando Alonso",
          "nationality": "ESP",
          "team": "Aston Martin Aramco Mercedes",
          "points": 206.0
      },
      {
          "position": 5,
          "driver": "Charles Leclerc",
          "nationality": "MON",
          "team": "Ferrari",
          "points": 206.0
      },
      {
          "position": 6,
          "driver": "Lando Norris",
          "nationality": "GBR",
          "team": "McLaren Mercedes",
          "points": 205.0
      },
      {
          "position": 7,
          "driver": "Carlos Sainz",
          "nationality": "ESP",
          "team": "Ferrari",
          "points": 200.0
      },
      {
          "position": 8,
          "driver": "George Russell",
          "nationality": "GBR",
          "team": "Mercedes",
          "points": 175.0
      },
      {
          "position": 9,
          "driver": "Oscar Piastri",
          "nationality": "AUS",
          "team": "McLaren Mercedes",
          "points": 97.0
      },
      {
          "position": 10,
          "driver": "Lance Stroll",
          "nationality": "CAN",
          "team": "Aston Martin Aramco Mercedes",
          "points": 74.0
      },
      {
          "position": 11,
          "driver": "Pierre Gasly",
          "nationality": "FRA",
          "team": "Alpine Renault",
          "points": 62.0
      },
      {
          "position": 12,
          "driver": "Esteban Ocon",
          "nationality": "FRA",
          "team": "Alpine Renault",
          "points": 58.0
      },
      {
          "position": 13,
          "driver": "Alexander Albon",
          "nationality": "THA",
          "team": "Williams Mercedes",
          "points": 27.0
      },
      {
          "position": 14,
          "driver": "Yuki Tsunoda",
          "nationality": "JPN",
          "team": "AlphaTauri Honda RBPT",
          "points": 17.0
      },
      {
          "position": 15,
          "driver": "Valtteri Bottas",
          "nationality": "FIN",
          "team": "Alfa Romeo Ferrari",
          "points": 10.0
      },
      {
          "position": 16,
          "driver": "Nico Hulkenberg",
          "nationality": "GER",
          "team": "Haas Ferrari",
          "points": 9.0
      },
      {
          "position": 17,
          "driver": "Daniel Ricciardo",
          "nationality": "AUS",
          "team": "AlphaTauri Honda RBPT",
          "points": 6.0
      },
      {
          "position": 18,
          "driver": "Zhou Guanyu",
          "nationality": "CHN",
          "team": "Alfa Romeo Ferrari",
          "points": 6.0
      },
      {
          "position": 19,
          "driver": "Kevin Magnussen",
          "nationality": "DEN",
          "team": "Haas Ferrari",
          "points": 3.0
      },
      {
          "position": 20,
          "driver": "Liam Lawson",
          "nationality": "NZL",
          "team": "AlphaTauri Honda RBPT",
          "points": 2.0
      },
      {
          "position": 21,
          "driver": "Logan Sargeant",
          "nationality": "USA",
          "team": "Williams Mercedes",
          "points": 1.0
      },
      {
          "position": 22,
          "driver": "Nyck De Vries",
          "nationality": "NED",
          "team": "AlphaTauri Honda RBPT",
          "points": 0.0
      }
  ]
  ```
</details>  

<details>
  <summary>2023 Constructors Standings</summary>

  ```json
  [
    {
        "position": 1,
        "team": "Red Bull Racing Honda RBPT",
        "points": 860.0
    },
    {
        "position": 2,
        "team": "Mercedes",
        "points": 409.0
    },
    {
        "position": 3,
        "team": "Ferrari",
        "points": 406.0
    },
    {
        "position": 4,
        "team": "McLaren Mercedes",
        "points": 302.0
    },
    {
        "position": 5,
        "team": "Aston Martin Aramco Mercedes",
        "points": 280.0
    },
    {
        "position": 6,
        "team": "Alpine Renault",
        "points": 120.0
    },
    {
        "position": 7,
        "team": "Williams Mercedes",
        "points": 28.0
    },
    {
        "position": 8,
        "team": "AlphaTauri Honda RBPT",
        "points": 25.0
    },
    {
        "position": 9,
        "team": "Alfa Romeo Ferrari",
        "points": 16.0
    },
    {
        "position": 10,
        "team": "Haas Ferrari",
        "points": 12.0
    }
]
  ```
</details>  

<details>
  <summary>2023 Brazil GP Results</summary>

  ```json
  [
    {
        "position": 1,
        "number": 1,
        "driver": "Max Verstappen",
        "car": "Red Bull Racing Honda RBPT",
        "laps": 71,
        "time": "1:56:48.894",
        "points": 25.0
    },
    {
        "position": 2,
        "number": 4,
        "driver": "Lando Norris",
        "car": "McLaren Mercedes",
        "laps": 71,
        "time": "+8.277s",
        "points": 19.0
    },
    {
        "position": 3,
        "number": 14,
        "driver": "Fernando Alonso",
        "car": "Aston Martin Aramco Mercedes",
        "laps": 71,
        "time": "+34.155s",
        "points": 15.0
    },
    {
        "position": 4,
        "number": 11,
        "driver": "Sergio Perez",
        "car": "Red Bull Racing Honda RBPT",
        "laps": 71,
        "time": "+34.208s",
        "points": 12.0
    },
    {
        "position": 5,
        "number": 18,
        "driver": "Lance Stroll",
        "car": "Aston Martin Aramco Mercedes",
        "laps": 71,
        "time": "+40.845s",
        "points": 10.0
    },
    {
        "position": 6,
        "number": 55,
        "driver": "Carlos Sainz",
        "car": "Ferrari",
        "laps": 71,
        "time": "+50.188s",
        "points": 8.0
    },
    {
        "position": 7,
        "number": 10,
        "driver": "Pierre Gasly",
        "car": "Alpine Renault",
        "laps": 71,
        "time": "+56.093s",
        "points": 6.0
    },
    {
        "position": 8,
        "number": 44,
        "driver": "Lewis Hamilton",
        "car": "Mercedes",
        "laps": 71,
        "time": "+62.859s",
        "points": 4.0
    },
    {
        "position": 9,
        "number": 22,
        "driver": "Yuki Tsunoda",
        "car": "AlphaTauri Honda RBPT",
        "laps": 71,
        "time": "+69.880s",
        "points": 2.0
    },
    {
        "position": 10,
        "number": 31,
        "driver": "Esteban Ocon",
        "car": "Alpine Renault",
        "laps": 70,
        "time": "+1 lap",
        "points": 1.0
    },
    {
        "position": 11,
        "number": 2,
        "driver": "Logan Sargeant",
        "car": "Williams Mercedes",
        "laps": 70,
        "time": "+1 lap",
        "points": 0.0
    },
    {
        "position": 12,
        "number": 27,
        "driver": "Nico Hulkenberg",
        "car": "Haas Ferrari",
        "laps": 70,
        "time": "+1 lap",
        "points": 0.0
    },
    {
        "position": 13,
        "number": 3,
        "driver": "Daniel Ricciardo",
        "car": "AlphaTauri Honda RBPT",
        "laps": 70,
        "time": "+1 lap",
        "points": 0.0
    },
    {
        "position": 14,
        "number": 81,
        "driver": "Oscar Piastri",
        "car": "McLaren Mercedes",
        "laps": 69,
        "time": "+2 laps",
        "points": 0.0
    },
    {
        "position": null,
        "number": 63,
        "driver": "George Russell",
        "car": "Mercedes",
        "laps": 57,
        "time": "DNF",
        "points": 0.0
    },
    {
        "position": null,
        "number": 77,
        "driver": "Valtteri Bottas",
        "car": "Alfa Romeo Ferrari",
        "laps": 39,
        "time": "DNF",
        "points": 0.0
    },
    {
        "position": null,
        "number": 24,
        "driver": "Zhou Guanyu",
        "car": "Alfa Romeo Ferrari",
        "laps": 22,
        "time": "DNF",
        "points": 0.0
    },
    {
        "position": null,
        "number": 20,
        "driver": "Kevin Magnussen",
        "car": "Haas Ferrari",
        "laps": 0,
        "time": "DNF",
        "points": 0.0
    },
    {
        "position": null,
        "number": 23,
        "driver": "Alexander Albon",
        "car": "Williams Mercedes",
        "laps": 0,
        "time": "DNF",
        "points": 0.0
    },
    {
        "position": null,
        "number": 16,
        "driver": "Charles Leclerc",
        "car": "Ferrari",
        "laps": 0,
        "time": "DNS",
        "points": 0.0
    }
]
  ```
</details>  

## Running  
The minimum JDK version needed is 17.  

| Step | Command |
| :------ | :----- |
| 1. Install dependencies and build | `mvn clean install -DskipTests` |
| 2. Run | `mvn spring-boot:run` |  

The Open API JSON documentation is available at `/v3/api-docs`, the HTML page documentation is available at `/swagger-ui.html`.  
