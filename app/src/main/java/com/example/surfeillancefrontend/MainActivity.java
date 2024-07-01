package com.example.surfeillancefrontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.surfeillancefrontend.ui.SpotChoiceActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigateToSpotChoiceActivity();

    }
    public void navigateToSpotChoiceActivity() {
        Button chooseTrip = (Button) findViewById(R.id.chooseSpotButton);
        chooseTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(MainActivity.this, SpotChoiceActivity.class);
                startActivity(intent);
            }
        });
    }
}