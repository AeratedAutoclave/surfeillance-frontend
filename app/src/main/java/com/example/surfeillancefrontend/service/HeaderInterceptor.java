package com.example.surfeillancefrontend.service;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class HeaderInterceptor implements Interceptor {

    private final String key;
    private final String value;

    public HeaderInterceptor(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request originalRequest = chain.request();

        // Create a new request with the added header
        Request.Builder builder = originalRequest.newBuilder()
                .header(key, value);

        Request newRequest = builder.build();

        // Proceed with the new request
        return chain.proceed(newRequest);
    }
}
