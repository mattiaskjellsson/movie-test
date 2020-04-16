package com.example.mattias.movietest.dal;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.mattias.movietest.dal.entities.Movie;
import com.example.mattias.movietest.service.MovieApiInstance;
import com.example.mattias.movietest.service.MovieApiService;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();

    private Movie mMovie = new Movie();
    private MutableLiveData<Movie> ldMmovie = new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData() {
        MovieApiService apiService = MovieApiInstance.getApiService();
        Call<MovieWrapper> call = apiService.getMovies();

        call.enqueue(new Callback<MovieWrapper>() {
            @Override
            public void onResponse(Call<MovieWrapper> call, Response<MovieWrapper> response) {
                MovieWrapper movieWrapper = response.body();
                if (movieWrapper != null && movieWrapper.getMovies() != null) {
                    movies = (ArrayList<Movie>) movieWrapper.getMovies();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<MovieWrapper> call, Throwable t) { }
        });

        return mutableLiveData;
    }

    public MutableLiveData<Movie> getMovie(long id){
        MovieApiService apiService = MovieApiInstance.getApiService();
        Call<Movie> call = apiService.getMovie(id);

        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie movie = response.body();
                Log.d("MovieReposiotry", "Response from Retrofit2: " + response.code());

                if(movie != null) {
                    mMovie = movie;

                    ldMmovie.setValue(mMovie);
                }

                Log.d("MovieRepository", "End of OnResponse");
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
            }
        });

        return ldMmovie;
    }
}