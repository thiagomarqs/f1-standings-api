package com.example.f1standings.model;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Standing {

    public Integer position;
    public String driver;
    public String nationality;
    public String team;
    public Double points;

    public Standing() {}

    public Standing(Element element) {
        Elements tds = element.getElementsByTag("td");

        this.position = Integer.parseInt(tds.get(1).text());

        String driver = tds.get(2).text();
        this.driver = driver.substring(0, driver.length() - 4);

        this.nationality = tds.get(3).text();
        this.team = tds.get(4).text();
        this.points = Double.parseDouble(tds.get(5).text());
    }

    public String toString() {
        return position + " " + driver + " " + nationality + " " + team + " " + points;
    }

}
