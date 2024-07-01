package com.example.surfeillancefrontend.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.surfeillancefrontend.MainActivity;
import com.example.surfeillancefrontend.R;
import com.example.surfeillancefrontend.model.Location;

import java.util.ArrayList;
import java.util.List;

public class SpotChoiceActivity extends AppCompatActivity {
    SpotAdapter adapter;
    List<Location> spots;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) { // You must implement this callback, which fires when the system creates your activity. Your implementation should initialize the essential components of your activity; for example, your app should create views and bind data to lists here.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_choice); // you must call setContentView() to define the layout for the activity's user interface. This method sets the content of the Activity to the specified layout, effectively populating the Activity’s window with the UI elements defined in the layout file. The method can take either a layout resource ID or a View object as its parameter. “Inflating a layout” in Android refers to the process of converting an XML layout file into a hierarchy of View objects that can be displayed on the screen - this code doe so implicitly but you can explicitly inflate a layout as follows:
        // LayoutInflater inflater = LayoutInflater.from(context);
        // View inflatedView = inflater.inflate(R.layout.your_layout, null);
        // setContentView(inflatedView);

        navigateToPreviousActivity();

        recyclerView = findViewById(R.id.recyclerViewOfSpots);

        // Instantiate a LinearLayoutManager class to allow the items to be displayed in a linear scrolling vertical list and assign this layout to the recyclerView variable
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // The context is this, referring to the current activity
        recyclerView.setLayoutManager(layoutManager);

        spots = new ArrayList<>();

        Location location1 = new Location("Fistral North", "50.25", "-4.75", "GMT","SW");
        Location location2 = new Location("Fistral South", "51.25", "-3.75", "GTB","NE");
        Location location3 = new Location("Fistral East", "41.25", "-1.75", "UTC","NE");

        spots.add(location1);
        spots.add(location2);
        spots.add(location3);

        adapter = new SpotAdapter(spots);
        recyclerView.setAdapter(adapter); // sets adapter to the recyclerView



    } // When onCreate() finishes, the next callback is always onStart(). As onCreate() exits, the activity enters the Started state, and the activity becomes visible to the user. This callback contains what amounts to the activity’s final preparations for coming to the foreground and becoming interactive.


    public void navigateToPreviousActivity() {
        ImageButton back = (ImageButton) findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity i.e. return to previous screen
                Intent intent = new Intent(SpotChoiceActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }



}