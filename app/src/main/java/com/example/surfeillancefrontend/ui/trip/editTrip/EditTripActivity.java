package com.example.surfeillancefrontend.ui.trip.editTrip;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.surfeillancefrontend.MainActivity;
import com.example.surfeillancefrontend.R;
import com.example.surfeillancefrontend.model.data.dto.UserInfoHolder;
import com.example.surfeillancefrontend.model.data.Trip;
import com.google.android.material.textfield.TextInputEditText;

public class EditTripActivity extends AppCompatActivity {
    RatingBar tripRatingBar;
    RatingBar forecastRatingBar;
    TextInputEditText editText;
    Button button;
    Trip trip;
    EditTripViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_trip);

        // instantiate view model
        viewModel = new ViewModelProvider(this).get(EditTripViewModel.class);

        // get trip from extra
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            trip = getIntent().getParcelableExtra("Trip", Trip.class);
        } else {
            trip = getIntent().getParcelableExtra("Trip");
        }

        Log.i("unparceled in edit", trip.toString());
        addListenerOnButtonClick();

    }

    public void addListenerOnButtonClick() {
        tripRatingBar = findViewById(R.id.ratingBar1);
        forecastRatingBar = findViewById(R.id.ratingBar2);
        button = (Button) findViewById(R.id.submitEditedTripButton);

        //Performing action on Button Click
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                int tripRating = (int) tripRatingBar.getRating();
                int forecastRating = (int) tripRatingBar.getRating();
                Trip editedTrip = trip;
                editedTrip.setSurfRating(tripRating);
                editedTrip.setInfoRating(forecastRating);
                viewModel.tripRepository.editTripInfo(editedTrip);
                Toast.makeText(getApplicationContext(), "Your update has been registered", Toast.LENGTH_LONG).show();
                Log.i("UserID in edit", UserInfoHolder.getInstance().getUserID());
                Intent intent = new Intent(EditTripActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
