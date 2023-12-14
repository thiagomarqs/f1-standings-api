package com.example.f1standings.model;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DriverGrandPrixStanding {

    public String grandPrix;
    public String date;
    public String car;
    public Integer racePosition;
    public Double points;

    public DriverGrandPrixStanding() {}

    public DriverGrandPrixStanding(Element element) {
        Elements tds = element.getElementsByTag("td");
        String racePosition = tds.get(4).text();

        this.grandPrix = tds.get(1).text();
        this.date = tds.get(2).text();
        this.car = tds.get(3).text();
        this.racePosition = racePosition.equals("DNF") ? null : Integer.parseInt(racePosition);
        this.points = Double.parseDouble(tds.get(5).text());
    }

    public String toString() {
        return grandPrix + " " + date + " " + car + " " + racePosition + " " + points;
    }
}
