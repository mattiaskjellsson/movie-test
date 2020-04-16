package com.example.mattias.movietest;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageButton;

import com.example.mattias.movietest.adapters.MovieDetailsAdapter;
import com.example.mattias.movietest.dal.DbAdapter;
import com.example.mattias.movietest.dal.entities.Movie;
import com.example.mattias.movietest.viewModels.DetailsViewModel;

public class DetailsActivity extends AppCompatActivity implements MovieDetailsAdapter.OnMovieDetailsListner {
    private Movie mMovie;
    private DetailsViewModel viewModel;
    private MovieDetailsAdapter movieDetailsAdapter;
    private long movieId;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefresh;
    private DbAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        viewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);
        swipeRefresh = findViewById(R.id.swiperefresh);
        recyclerView = findViewById(R.id.movieRecyclerView);

        movieId = getIntent().getIntExtra("movieId", 0);

        getMovie(movieId);

        swipeRefresh.setOnRefreshListener(() -> {
            getMovie(movieId);
        });

        dbAdapter = new DbAdapter(this);
    }

    private void getMovie(long mId) {
        swipeRefresh.setRefreshing(true);
        viewModel.getMovie(mId).observe(this, movie -> prepareRecyclerView(movie));
    }

    private void prepareRecyclerView(Movie movie) {
        String s = dbAdapter.getData();
        boolean alreadyFavorite = dbAdapter.exists(movie.getId());

        movieDetailsAdapter = new MovieDetailsAdapter(movie, this, alreadyFavorite);
        mMovie = movie;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieDetailsAdapter);
        movieDetailsAdapter.notifyDataSetChanged();
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void onFavoriteClicked() {
        ImageButton favorite = findViewById(R.id.favorites);
        boolean isFavorite = dbAdapter.exists(mMovie.getId());
        if(isFavorite) {
            isFavorite = false;
            favorite.setImageResource(R.drawable.star_unfilled);
            int deleted = dbAdapter.delete(mMovie.getId());
        }else {
            isFavorite = true;
            favorite.setImageResource(R.drawable.star_filled);
            long count = dbAdapter.insertData(mMovie.getTitle(), mMovie.getId());
        }
    }
}
