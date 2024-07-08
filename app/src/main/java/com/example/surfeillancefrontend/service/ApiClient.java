
package com.example.surfeillancefrontend.service;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit == null) {

            // When adding headers like authentication tokens, ensure they are securely stored
            // and not hard-coded directly into your application. Consider using environment
            // variables or secure storage solutions for such sensitive information
            OkHttpClient client = new OkHttpClient.Builder()
//                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)) // Optional: For logging
                    .addInterceptor(new HeaderInterceptor("Your-Header-Key", "Your-Header-Value")) // Add your custom header here
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8080/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
