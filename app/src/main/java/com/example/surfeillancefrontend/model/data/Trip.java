package com.example.surfeillancefrontend.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.example.surfeillancefrontend.model.data.dto.AppUserDTO;

public class Trip implements Parcelable {
    private int tripId;
    private AppUserDTO appUserDTO;
    private Spot spot;
    private Integer surfRating;
    private Integer infoRating;
    private String date;
    private double waveHeight;
    private String waveDirection;
    private double wavePeriod;
    private double windSpeed;
    private String windDirection;
    private int gusts;
    private double tideHeight;


    public Trip(AppUserDTO appUserDTO, Spot spot, Integer surfRating, Integer infoRating, String date, double waveHeight, String waveDirection, double wavePeriod, double windSpeed, String windDirection, int gusts, double tideHeight) {
        this.appUserDTO = appUserDTO;
        this.spot = spot;
        this.surfRating = surfRating;
        this.infoRating = infoRating;
        this.date = date;
        this.waveHeight = waveHeight;
        this.waveDirection = waveDirection;
        this.wavePeriod = wavePeriod;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.gusts = gusts;
        this.tideHeight = tideHeight;
    }

    public Trip(AppUserDTO appUserDTO, Spot spot, String date, double waveHeight, String waveDirection, double wavePeriod, double windSpeed, String windDirection, int gusts, double tideHeight) {

        this.appUserDTO = appUserDTO;
        this.spot = spot;
        this.date = date;
        this.waveHeight = waveHeight;
        this.waveDirection = waveDirection;
        this.wavePeriod = wavePeriod;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.gusts = gusts;
        this.tideHeight = tideHeight;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public AppUserDTO getAppUserDTO() {
        return appUserDTO;
    }

    public void setAppUserDTO(AppUserDTO appUserDTO) {
        this.appUserDTO = appUserDTO;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Integer getSurfRating() {
        return surfRating;
    }

    public void setSurfRating(Integer surfRating) {
        this.surfRating = surfRating;
    }

    public Integer getInfoRating() {
        return infoRating;
    }

    public void setInfoRating(Integer infoRating) {
        this.infoRating = infoRating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getWaveHeight() {
        return waveHeight;
    }

    public void setWaveHeight(double waveHeight) {
        this.waveHeight = waveHeight;
    }

    public String getWaveDirection() {
        return waveDirection;
    }

    public void setWaveDirection(String waveDirection) {
        this.waveDirection = waveDirection;
    }

    public double getWavePeriod() {
        return wavePeriod;
    }

    public void setWavePeriod(double wavePeriod) {
        this.wavePeriod = wavePeriod;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public int getGusts() {
        return gusts;
    }

    public void setGusts(int gusts) {
        this.gusts = gusts;
    }

    public double getTideHeight() {
        return tideHeight;
    }

    public void setTideHeight(double tideHeight) {
        this.tideHeight = tideHeight;
    }

    protected Trip(Parcel in) {
        tripId = in.readInt();
        appUserDTO = in.readParcelable(AppUserDTO.class.getClassLoader());
        spot = in.readParcelable(Spot.class.getClassLoader());
        if (in.readByte() == 0) {
            surfRating = null;
        } else {
            surfRating = in.readInt();
        }
        if (in.readByte() == 0) {
            infoRating = null;
        } else {
            infoRating = in.readInt();
        }
        date = in.readString();
        waveHeight = in.readDouble();
        waveDirection = in.readString();
        wavePeriod = in.readDouble();
        windSpeed = in.readDouble();
        windDirection = in.readString();
        gusts = in.readInt();
        tideHeight = in.readDouble();
    }

    public static final Creator<Trip> CREATOR = new Creator<Trip>() {
        @Override
        public Trip createFromParcel(Parcel in) {
            return new Trip(in);
        }

        @Override
        public Trip[] newArray(int size) {
            return new Trip[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(tripId);
        dest.writeParcelable(appUserDTO, flags);
        dest.writeParcelable(spot, flags);
        if (surfRating == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(surfRating);
        }
        if (infoRating == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(infoRating);
        }
        dest.writeString(date);
        dest.writeDouble(waveHeight);
        dest.writeString(waveDirection);
        dest.writeDouble(wavePeriod);
        dest.writeDouble(windSpeed);
        dest.writeString(windDirection);
        dest.writeInt(gusts);
        dest.writeDouble(tideHeight);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripId=" + tripId +
                ", appUserDTO=" + appUserDTO +
                ", spot=" + spot +
                ", surfRating=" + surfRating +
                ", infoRating=" + infoRating +
                ", date='" + date + '\'' +
                ", waveHeight=" + waveHeight +
                ", waveDirection='" + waveDirection + '\'' +
                ", wavePeriod=" + wavePeriod +
                ", windSpeed=" + windSpeed +
                ", windDirection='" + windDirection + '\'' +
                ", gusts=" + gusts +
                ", tideHeight=" + tideHeight +
                '}';
    }
}