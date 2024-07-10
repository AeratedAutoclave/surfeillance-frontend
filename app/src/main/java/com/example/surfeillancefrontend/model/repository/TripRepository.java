package com.example.surfeillancefrontend.model.repository;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.example.surfeillancefrontend.model.data.dto.AppUser;
import com.example.surfeillancefrontend.model.data.dto.UpdateRatingDTO;
import com.example.surfeillancefrontend.model.data.Location;
import com.example.surfeillancefrontend.model.data.NewTrip;
import com.example.surfeillancefrontend.model.data.Spot;
import com.example.surfeillancefrontend.model.data.Trip;
import com.example.surfeillancefrontend.service.ApiClient;
import com.example.surfeillancefrontend.service.NewTripBuilder;
import com.example.surfeillancefrontend.service.TripApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class TripRepository {
    private final MutableLiveData<List<Trip>> liveData = new MutableLiveData<>();
    private Trip returnedTripAfterPut;
    private Trip returnedTripAfterPost;
    private Application app;
    private final TripApiService tripApiService;
    private NewTripBuilder newTripBuilder;

    public TripRepository(Application app) {
        this.app = app;
        tripApiService = ApiClient.getInstance().create(TripApiService.class);

    }

    public MutableLiveData<List<Trip>> getMutableLiveDate() {

        // currently hardcoded but should take user id from active session once we have that implemented
        Call call = tripApiService.getTripsByUserId("1");

        call.enqueue(new Callback<List<Trip>>() {
            @Override
            public void onResponse(Call<List<Trip>> call, Response<List<Trip>> response) {
                List<Trip> trips = response.body();
                liveData.setValue(trips);
            }

            @Override
            public void onFailure(Call<List<Trip>> call, Throwable throwable) {
                Log.i("Get Trips Failing at apicall", "onFailure: ");
            }
        });
        return liveData;
    }

    public Trip editTripInfo(Trip editedTrip) {
       UpdateRatingDTO ratings = new UpdateRatingDTO(editedTrip.getSurfRating(), editedTrip.getInfoRating());
        Call call = tripApiService.editTripByTripId(editedTrip.getTripId(), ratings );
         call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                returnedTripAfterPut = (Trip) response.body();
            }

            @Override
            public void onFailure(Call call, Throwable throwable) {
                Log.i(
                        "repo faill edit", "onFailure: ");
            }
        });
         return returnedTripAfterPut;
    }
    public Trip addTrip(Location location) {

        newTripBuilder = new NewTripBuilder();
        Log.i("in trip repo", location.getName());
        Log.i("deets", location.toString());
        NewTrip tripToAdd = newTripBuilder
                // spot ID to be collected from backend pls
                .withSpot(new Spot( (int) location.getSpotId(), location.getName()))
                // userid also to come in from backend/session info
                .withUser(new AppUser(1))
                .withLocation(location)
                .build();
        Log.i("pre call", tripToAdd.toString());
        Call call = tripApiService.addTrip(tripToAdd);

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                returnedTripAfterPost = (Trip) response.body();
               // Log.i("trip added", returnedTripAfterPost.toString());
            }

            @Override
            public void onFailure(Call call, Throwable throwable) {
                Log.i("badd add", "onFailure: ");
            }
        });
        return returnedTripAfterPost;
    }
}




