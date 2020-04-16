package com.example.mattias.movietest.dal.entities;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class BelongsToCollection {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("backdrop_path")
    private String backdropPath;

    /**
     * No args constructor for use in serialization
     *
     */
    public BelongsToCollection() {
    }

    /**
     *
     * @param name
     * @param id
     * @param backdropPath
     * @param posterPath
     */
    public BelongsToCollection(Integer id, String name, String posterPath, String backdropPath) {
        super();
        this.id = id;
        this.name = name;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
    }

    @SerializedName("id")
    public Integer getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @SerializedName("name")
    public String getName() {
        return name;
    }

    @SerializedName("name")
    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("poster_path")
    public String getPosterPath() {
        return posterPath;
    }

    @SerializedName("poster_path")
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @SerializedName("backdrop_path")
    public String getBackdropPath() {
        return backdropPath;
    }

    @SerializedName("backdrop_path")
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }
}
