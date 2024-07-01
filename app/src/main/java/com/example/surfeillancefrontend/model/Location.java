package com.example.surfeillancefrontend.model;

public class Location {
    String name;
    String details;
    String requestTime;
    String latitude;
    String longitude;
    String timezone;
    Double waveHeight;
    String waveDirection;
    Double wavePeriod;
    Double windSpeed;
    Double gusts;
    Double highTideHeight;
    String highTideTime;
    Double lowTideHeight;
    String lowTideTime;

    public Location(String name, String details, String requestTime, String latitude, String longitude, String timezone, Double waveHeight, String waveDirection, Double wavePeriod, Double windSpeed, Double gusts, Double highTideHeight, String highTideTime, Double lowTideHeight, String lowTideTime) {
        this.name = name;
        this.details = details;
        this.requestTime = requestTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.waveHeight = waveHeight;
        this.waveDirection = waveDirection;
        this.wavePeriod = wavePeriod;
        this.windSpeed = windSpeed;
        this.gusts = gusts;
        this.highTideHeight = highTideHeight;
        this.highTideTime = highTideTime;
        this.lowTideHeight = lowTideHeight;
        this.lowTideTime = lowTideTime;
    }

    public Location(String name, String latitude, String longitude, String timezone, String waveDirection) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.waveDirection = waveDirection;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Double getWaveHeight() {
        return waveHeight;
    }

    public void setWaveHeight(Double waveHeight) {
        this.waveHeight = waveHeight;
    }

    public String getWaveDirection() {
        return waveDirection;
    }

    public void setWaveDirection(String waveDirection) {
        this.waveDirection = waveDirection;
    }

    public Double getWavePeriod() {
        return wavePeriod;
    }

    public void setWavePeriod(Double wavePeriod) {
        this.wavePeriod = wavePeriod;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getGusts() {
        return gusts;
    }

    public void setGusts(Double gusts) {
        this.gusts = gusts;
    }

    public Double getHighTideHeight() {
        return highTideHeight;
    }

    public void setHighTideHeight(Double highTideHeight) {
        this.highTideHeight = highTideHeight;
    }

    public String getHighTideTime() {
        return highTideTime;
    }

    public void setHighTideTime(String highTideTime) {
        this.highTideTime = highTideTime;
    }

    public Double getLowTideHeight() {
        return lowTideHeight;
    }

    public void setLowTideHeight(Double lowTideHeight) {
        this.lowTideHeight = lowTideHeight;
    }

    public String getLowTideTime() {
        return lowTideTime;
    }

    public void setLowTideTime(String lowTideTime) {
        this.lowTideTime = lowTideTime;
    }
}
