package com.example.surfeillancefrontend.ui.trip.tripchoice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.surfeillancefrontend.R;
import com.example.surfeillancefrontend.databinding.ActivityTripChoiceBinding;
import com.example.surfeillancefrontend.model.data.Trip;
import com.example.surfeillancefrontend.ui.trip.displaytrip.DisplayTripActivity;

import java.util.ArrayList;
import java.util.List;

public class TripChoiceActivity extends AppCompatActivity implements RecyclerViewInterface {

    private RecyclerView recyclerView;
    private List<Trip> tripList;
    private TripChoiceAdaptor tripAdaptor;
    private TripChoiceViewModel viewModel;
    private ActivityTripChoiceBinding binding;
    // clickhandler


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_choice);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trip_choice);
        TripChoiceViewModelFactory factory = new TripChoiceViewModelFactory(getApplication());
        viewModel = new ViewModelProvider(this, factory).get(TripChoiceViewModel.class);
        //viewModel = new ViewModelProvider(this).get(TripChoiceViewModel.class);
        binding.setLifecycleOwner(this);
        getAllTrips();

    }

    private void getAllTrips() {
        viewModel.getData().observe(this, new Observer<List<Trip>>() {
            @Override
            public void onChanged(List<Trip> trips) {
                if (trips != null && !trips.isEmpty()) {
                    tripList = new ArrayList<>(trips);
                    displayInRecyclerView(tripList);
                } else {
                    Log.i("object is null", "XXXXXXXXXXXXXXXXXXx: ");
                }
            }
        });
    }

    private void displayInRecyclerView(List<Trip> trips) {
        recyclerView = binding.recyclerViewTrips;
        tripAdaptor = new TripChoiceAdaptor(trips, this, this);
        recyclerView.setAdapter(tripAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //tripAdaptor.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, DisplayTripActivity.class);
        Trip trip = tripList.get(position);
        intent.putExtra("Trip", trip);
        Log.i("pre display trip", trip.toString());
        startActivity(intent);
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

}

