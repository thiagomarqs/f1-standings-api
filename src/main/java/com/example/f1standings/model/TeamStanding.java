package com.example.f1standings.model;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TeamStanding {

    public Integer position;
    public String team;
    public Double points;

    public TeamStanding() {}

    public TeamStanding(Element element) {
        Elements tds = element.getElementsByTag("td");

        this.position = Integer.parseInt(tds.get(1).text());
        this.team = tds.get(2).text();
        this.points = Double.parseDouble(tds.get(3).text());
    }

    public String toString() {
        return position + " "  + team + " " + points;
    }

}
