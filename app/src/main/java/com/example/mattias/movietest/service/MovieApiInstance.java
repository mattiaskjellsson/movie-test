package com.example.mattias.movietest.service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieApiInstance {
    private static String BASE_URL = "https://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;

    public static MovieApiService getApiService() {
        if (retrofit == null) {
            retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }

        return retrofit.create(MovieApiService.class);
    }
}