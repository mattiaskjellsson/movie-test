package com.example.mattias.movietest.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import com.example.mattias.movietest.dal.entities.Movie;
import com.example.mattias.movietest.dal.MovieRepository;
import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private MovieRepository movieRepository;

    public MainViewModel(Application application) {
        super(application);
        movieRepository = new MovieRepository(application);
    }

    public LiveData<List<Movie>> getAllMovies() {
        return movieRepository.getMutableLiveData();
    }
}