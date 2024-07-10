package com.example.surfeillancefrontend.ui.login;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.surfeillancefrontend.R;
import com.example.surfeillancefrontend.model.data.dto.AppUser;
import com.example.surfeillancefrontend.model.data.dto.AppUserDTO;
import com.example.surfeillancefrontend.model.data.dto.UserInfoHolder;
import com.example.surfeillancefrontend.service.ApiClient;
import com.example.surfeillancefrontend.service.AuthService;
import com.example.surfeillancefrontend.service.UserApiService;
import com.example.surfeillancefrontend.ui.profile.ProfileActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity  {
    private static final String TAG = "LoginActivity";
    private static final int RC_SIGN_IN = 9001;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private AuthService authService;

    //private UserApiService userApiService;
    //private UserApiService userApiServiceLogin;
    private GoogleSignInAccount account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SignInButton loginButton = findViewById(R.id.sign_in_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "loginButton Clicked");
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.server_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        mAuth = FirebaseAuth.getInstance();


        if (mAuth.getCurrentUser() == null) {
            //setLoggedOutUi();
        } else {
           // setLoggedInUi();
        }
    }




    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.i(TAG, "signInWithCredential:success");
                        //setLoggedInUi();
                        Snackbar.make(findViewById(android.R.id.content),
                                "Login successful", Snackbar.LENGTH_LONG).show();
                        FirebaseUser firebaseUser = mAuth.getCurrentUser();

                        // and then you are logged in so go to homepage?
                        // Start the new activity
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        startActivity(intent);

                        if (firebaseUser == null) {
                            Toast.makeText(this, "Google Login failed", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        firebaseUser.getIdToken(true)
                                .addOnCompleteListener(getIdTokenTask -> {
                                    if (getIdTokenTask.isSuccessful()) {
                                        String token = getIdTokenTask.getResult().getToken();
                                        authenticateWithBackend(token);
                                    } else {
                                        Log.w(TAG, "Fetching ID token failed", getIdTokenTask.getException());
                                        Snackbar.make(findViewById(android.R.id.content),
                                                "Login failed", Snackbar.LENGTH_LONG).show();
                                    }
                                });

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithCredential:failure", task.getException());
                        Snackbar.make(findViewById(android.R.id.content),
                                "Login failed", Snackbar.LENGTH_LONG).show();
                    }
                });
    }

    private void authenticateWithBackend(String idToken) {
        // trying to store token in a singleton
        UserInfoHolder userInfoHolder = UserInfoHolder.getInstance();
        Log.i(TAG, "Setting TOKEN here: " + idToken);

        userInfoHolder.setToken(idToken);
        String authHeader = "Bearer " + idToken;


        AppUserDTO appUser = new AppUserDTO(account.getId(),
                account.getDisplayName(), "","",
                "BEGINNER",account.getPhotoUrl().toString(), account.getEmail(),null);

        //authService = ApiClientLogin.getInstance().create(AuthService.class);

        UserApiService userApiService = ApiClient.getInstance().create(UserApiService.class);
        Call<AppUser> addUserCall = userApiService.addUser(appUser);
        Log.d(TAG, appUser.getUserName());
        addUserCall.enqueue(new Callback<AppUser>() {
            @Override
            public void onResponse(Call<AppUser> call, Response<AppUser> response) {
                if(response.isSuccessful()) {
                    Log.i("User added", " " + response.body());
                    AppUser appUser = response.body();
                    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                    intent.putExtra("User", appUser);
                    startActivity(intent);


                } else {
                    Log.e("ERROR", "Login failed: " + response.errorBody());
            }

                }


            @Override
            public void onFailure(Call<AppUser> call, Throwable throwable) {

                Log.e("ERROR", "Network error: " + throwable.getMessage());


            }



        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                 account = task.getResult(ApiException.class);
                if (account == null) {
                    throw new ApiException(Status.RESULT_INTERNAL_ERROR);
                }
                Log.i(TAG, "firebaseAuthWithGoogle:" + account.getId());

                // Adding account id to UserInfoHolder
                UserInfoHolder.getInstance().setUserID(account.getId());

                firebaseAuthWithGoogle(account.getIdToken());

            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                Snackbar.make(findViewById(android.R.id.content),
                        "Login failed", Snackbar.LENGTH_LONG).show();
            }
        }
    }

}