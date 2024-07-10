package com.example.surfeillancefrontend.service;

import com.example.surfeillancefrontend.model.data.dto.AppUser;
import com.example.surfeillancefrontend.model.data.dto.AppUserDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApiService {

    @POST("users/add")
    Call<AppUser> addUser(@Body AppUserDTO user);

}
