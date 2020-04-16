package com.example.mattias.movietest.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.mattias.movietest.dal.MovieRepository;
import com.example.mattias.movietest.dal.entities.Movie;

public class DetailsViewModel extends AndroidViewModel {
    private MovieRepository repository;
    private boolean isFavorite;

    public DetailsViewModel(Application application) {
        super(application);
        repository = new MovieRepository(application);
    }

    public LiveData<Movie> getMovie(long id) {
        return repository.getMovie(id);
    }

    public void setIsFavorite(boolean fav) {
        this.isFavorite = fav;
    }

    public boolean getIsFavorite() {
        return this.isFavorite;
    }
}
