package com.example.mattias.movietest.dal.entities;

import com.google.gson.annotations.SerializedName;

public class SpokenLanguage {

    @SerializedName("iso_639_1")
    private String iso6391;
    @SerializedName("name")
    private String name;

    /**
     * No args constructor for use in serialization
     *
     */
    public SpokenLanguage() {
    }

    /**
     *
     * @param name
     * @param iso6391
     */
    public SpokenLanguage(String iso6391, String name) {
        super();
        this.iso6391 = iso6391;
        this.name = name;
    }

    @SerializedName("iso_639_1")
    public String getIso6391() {
        return iso6391;
    }

    @SerializedName("iso_639_1")
    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
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
