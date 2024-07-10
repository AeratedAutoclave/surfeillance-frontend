package com.example.surfeillancefrontend.service;

import android.util.Log;
import com.example.surfeillancefrontend.model.data.dto.AppUser;
import com.example.surfeillancefrontend.model.data.Location;
import com.example.surfeillancefrontend.model.data.NewTrip;
import com.example.surfeillancefrontend.model.data.Spot;

import java.time.LocalDate;

public class NewTripBuilder {
private Spot spot;
private AppUser user;
private String date;
private Location location;

public NewTripBuilder withSpot(Spot spot){
    this.spot = spot;
    return this;
}
public NewTripBuilder withUser(AppUser user){
    this.user = user;
    return this;
}
public NewTripBuilder withLocation(Location location) {
    this.location = location;
    return this;
}
    public NewTrip build(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDate currentDate = LocalDate.now();
             date = currentDate.toString();
        }
        Log.i("in builder", "build: ");

        NewTrip constructedTrip = new NewTrip(user,
                spot,
                date,
                location.getWaveHeight().doubleValue(),
                location.getWaveDirection(),
                location.getWavePeriod().doubleValue(),
                0,
                null,
                (int)Math.round(location.getGusts()),
                location.getLowTideHeight());
        return constructedTrip;
    }
}
