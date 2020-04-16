package com.example.mattias.movietest.service;

import com.example.mattias.movietest.dal.MovieWrapper;
import com.example.mattias.movietest.dal.entities.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieApiService {

    @GET("discover/movie?api_key=74eb0ca644c90551bacaf3a1aa9cfa37&language=en-US")
    Call<MovieWrapper> getMovies();

    @GET("movie/{id}?api_key=74eb0ca644c90551bacaf3a1aa9cfa37&language=en-US")
    Call<Movie> getMovie(@Path("id") long id);
}
