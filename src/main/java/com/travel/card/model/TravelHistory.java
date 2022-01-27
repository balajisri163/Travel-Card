package com.travel.card.model;

public class TravelHistory {
    Integer travel_id;
    String from_station;
    String to_station;
    String mode;
    String card_number;
    String fare_charged;

    public TravelHistory(){


    }

    public TravelHistory(Integer travel_id, String from_station, String to_station, String mode, String card_number, String fare_charged) {
        this.travel_id = travel_id;
        this.from_station = from_station;
        this.to_station = to_station;
        this.mode = mode;
        this.card_number = card_number;
        this.fare_charged = fare_charged;
    }

    public Integer getTravel_id() {
        return travel_id;
    }

    public void setTravel_id(Integer travel_id) {
        this.travel_id = travel_id;
    }

    public String getFrom_station() {
        return from_station;
    }

    public void setFrom_station(String from_station) {
        this.from_station = from_station;
    }

    public String getTo_station() {
        return to_station;
    }

    public void setTo_station(String to_station) {
        this.to_station = to_station;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getFare_charged() {
        return fare_charged;
    }

    public void setFare_charged(String fare_charged) {
        this.fare_charged = fare_charged;
    }
}
