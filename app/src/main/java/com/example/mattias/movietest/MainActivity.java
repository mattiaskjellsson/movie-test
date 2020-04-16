package com.example.mattias.movietest;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mattias.movietest.adapters.MovieAdapter;
import com.example.mattias.movietest.dal.entities.Movie;
import com.example.mattias.movietest.viewModels.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieAdapter.OnMovieListner {

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefresh;
    private MainViewModel mainViewModel;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefresh = findViewById(R.id.swiperefresh);
        recyclerView = findViewById(R.id.movieRecyclerView);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getMovies();

        swipeRefresh.setOnRefreshListener(() -> {
            getMovies();
        });

    }

    private void getMovies() {
        swipeRefresh.setRefreshing(true);
        mainViewModel.getAllMovies().observe(this, movieList -> prepareRecyclerView(movieList));
    }

    private void prepareRecyclerView(List<Movie> movieList) {
        movieAdapter = new MovieAdapter(movieList, this);

        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMovieClicked(int position) {
        Movie movie = this.mainViewModel.getAllMovies().getValue().get(position);

        Intent i = new Intent(this, DetailsActivity.class);
        i.putExtra("movieId", movie.getId());
        startActivity(i);
    }

    public void gotoFavorites(View view) {
        Intent i = new Intent(this, FavoritesActivity.class);
        startActivity(i);
    }
}
