package com.codeforfood.mapfood.domain;

public class Position {

    private Double longitude;
    private Double latitude;


    public Position(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }
}
