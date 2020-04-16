package com.example.mattias.movietest.dal;
import java.util.List;

import com.example.mattias.movietest.dal.entities.Movie;
import com.google.gson.annotations.SerializedName;

public class MovieWrapper {
    @SerializedName("page")
    private long mPage;
    @SerializedName("total_results")
    private long mTotalResults;
    @SerializedName("total_pages")
    private long mTotalPages;
    @SerializedName("results")
    private List<Movie> mResults;

    public List<Movie> getMovies() {
        return mResults;
    }

    public void setMovies(List<Movie> data) {
        mResults = data;
    }
    public long getPage() {
        return mPage;
    }
    public void setPage(int page) {
        mPage = page;
    }
    public long getTotalResults() {
        return mTotalResults;
    }
    public void setTotalResults(long totalResults) {
        mTotalResults = totalResults;
    }
    public long getTotalPages() {
        return mTotalPages;
    }
    public void setTotalPages(long totalPages) {
        mTotalPages = totalPages;
    }
}
