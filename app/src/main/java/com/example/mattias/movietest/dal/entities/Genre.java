package com.example.mattias.movietest.dal.entities;

import com.google.gson.annotations.SerializedName;

public class Genre {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;

    /**
     * No args constructor for use in serialization
     */
    public Genre() {
    }

    /**
     * @param name
     * @param id
     */
    public Genre(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
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
}
