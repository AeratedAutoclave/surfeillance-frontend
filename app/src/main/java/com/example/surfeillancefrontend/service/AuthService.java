package com.example.surfeillancefrontend.service;

import com.example.surfeillancefrontend.model.data.AuthResponse;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.GET;

public interface AuthService {
    @GET("health")
    Call<AuthResponse> authenticate();
    @GET("health")
    Call<String> authenticate(@Header("Authorization") String authHeader);
}
