package com.example.mattias.movietest.dal.entities;

import com.google.gson.annotations.SerializedName;

public class ProductionCountry {

    @SerializedName("iso_3166_1")
    private String iso31661;
    @SerializedName("name")
    private String name;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductionCountry() {
    }

    /**
     *
     * @param name
     * @param iso31661
     */
    public ProductionCountry(String iso31661, String name) {
        super();
        this.iso31661 = iso31661;
        this.name = name;
    }

    @SerializedName("iso_3166_1")
    public String getIso31661() {
        return iso31661;
    }

    @SerializedName("iso_3166_1")
    public void setIso31661(String iso31661) {
        this.iso31661 = iso31661;
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
