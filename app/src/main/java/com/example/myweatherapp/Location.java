package com.example.myweatherapp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
    @JsonProperty ("location")
    double location[]=new double[2];

    public double[] getLocation() {
        return location;
    }
}
