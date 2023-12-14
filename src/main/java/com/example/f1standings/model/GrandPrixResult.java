package com.example.f1standings.model;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GrandPrixResult {

    public Integer position;
    public Integer number;
    public String driver;
    public String car;
    public Integer laps;
    public String time;
    public Double points;

    public GrandPrixResult() {}

    public GrandPrixResult(Element element) {
        Elements tds = element.getElementsByTag("td");
        String position = tds.get(1).text();
        String driver = tds.get(3).text();

        this.position = position.equals("NC") ? null : Integer.parseInt(position);
        this.number = Integer.parseInt(tds.get(2).text());
        this.driver = driver.substring(0, driver.length() - 4);
        this.car = tds.get(4).text();
        this.laps = Integer.parseInt(tds.get(5).text());
        this.time = tds.get(6).text();
        this.points = Double.parseDouble(tds.get(7).text());
    }

    public String toString() {
        return position + " " + number + " " + driver + " " + car + " " + laps + " " + time + " " + points;
    }
}
