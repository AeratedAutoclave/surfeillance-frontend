package com.example.surfeillancefrontend.model.repository;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.example.surfeillancefrontend.model.data.Trip;
import com.example.surfeillancefrontend.service.ApiClient;
import com.example.surfeillancefrontend.service.TripApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class TripRepository {
    private final MutableLiveData<List<Trip>> liveData = new MutableLiveData<>();
    private Trip returnedTrip;
    private Application app;
    private final TripApiService tripApiService;


    public TripRepository(Application app) {
        this.app = app;
        tripApiService = ApiClient.getInstance().create(TripApiService.class);
    }

    public MutableLiveData<List<Trip>> getMutableLiveDate() {
        Call call = tripApiService.getTripsByUserId("3");

        call.enqueue(new Callback<List<Trip>>() {
            @Override
            public void onResponse(Call<List<Trip>> call, Response<List<Trip>> response) {
                List<Trip> trips = response.body();
                liveData.setValue(trips);
                for (Trip trip : trips) {
                    Log.d(trip.getLocationConditions().getName(), "onResponse: ");
                }
            }

            @Override
            public void onFailure(Call<List<Trip>> call, Throwable throwable) {
                Log.i("Get Trips Failing at apicall", "onFailure: ");
            }

        });

        return liveData;
    }

    public Trip editTripInfo(Trip editedTrip) {
        Call call = tripApiService.editTripByTripId(editedTrip);
         call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                returnedTrip = (Trip) response.body();
            }

            @Override
            public void onFailure(Call call, Throwable throwable) {
                Log.i("repo faill edit", "onFailure: ");
            }
        });
         return returnedTrip;
    }
}




