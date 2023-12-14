package com.example.f1standings.model;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RaceResult {

    public String grandPrix;
    public String date;
    public String winner;
    public String car;
    public Integer laps;
    public String time;

    public RaceResult() {}

    public RaceResult(Element element) {
        Elements tds = element.getElementsByTag("td");

        this.grandPrix = tds.get(1).text();
        this.date = tds.get(2).text();

        String winner = tds.get(3).text();
        this.winner = winner.substring(0, winner.length() - 4);

        this.car = tds.get(4).text();
        this.laps = Integer.parseInt(tds.get(5).text());
        this.time = tds.get(6).text();
    }

    public String toString() { return grandPrix + " " + date + " " + winner + " " + car + " " + laps + " " + time; }
}
