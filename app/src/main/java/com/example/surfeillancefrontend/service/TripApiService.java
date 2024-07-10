package com.example.surfeillancefrontend.service;

import com.example.surfeillancefrontend.model.data.dto.UpdateRatingDTO;
import com.example.surfeillancefrontend.model.data.NewTrip;
import com.example.surfeillancefrontend.model.data.Trip;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface TripApiService {


    @GET("users/trips/{userid}")
    Call<List<Trip>> getTripsByUserId(@Path("userid") String userid);



    @PUT("users/trips/{tripid}")
    Call<Trip> editTripByTripId(@Path("tripid") int tripid, @Body UpdateRatingDTO ratings);


    @POST("users/trips/add")
    Call<Trip> addTrip(@Body NewTrip tripToAdd);
}
