package com.example.surfeillancefrontend.ui.profile;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.surfeillancefrontend.R;
import com.example.surfeillancefrontend.databinding.ActivityProfileBinding;
import com.example.surfeillancefrontend.model.data.dto.AppUser;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {

   private ActivityProfileBinding binding;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            Log.i("line27", "onCreate: ");
            AppUser appUser = getIntent().getParcelableExtra("User", AppUser.class);
            Log.i("PROFILEACC",appUser.getUserName());
            String username = appUser.getUserName();
            TextView tv = findViewById(R.id.tv_name);
            tv.setText(username);
           // binding.setUser(appUser);
        }



    }

    private void signOut() {
        // Firebase sign out
        mAuth.signOut();

        // Google sign out
        mGoogleSignInClient.signOut().addOnCompleteListener(this,
                task -> {
                    //setLoggedOutUi();
                    Snackbar.make(findViewById(android.R.id.content),
                            "Logout successful", Snackbar.LENGTH_LONG).show();
                });
    }
}