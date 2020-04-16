package com.example.mattias.movietest.dal.entities;

import com.google.gson.annotations.SerializedName;

public class ProductionCompany {

    @SerializedName("id")
    private Integer id;
    @SerializedName("logo_path")
    private String logoPath;
    @SerializedName("name")
    private String name;
    @SerializedName("origin_country")
    private String originCountry;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductionCompany() {
    }

    /**
     *
     * @param logoPath
     * @param name
     * @param originCountry
     * @param id
     */
    public ProductionCompany(Integer id, String logoPath, String name, String originCountry) {
        super();
        this.id = id;
        this.logoPath = logoPath;
        this.name = name;
        this.originCountry = originCountry;
    }

    @SerializedName("id")
    public Integer getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @SerializedName("logo_path")
    public String getLogoPath() {
        return logoPath;
    }

    @SerializedName("logo_path")
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    @SerializedName("name")
    public String getName() {
        return name;
    }

    @SerializedName("name")
    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("origin_country")
    public String getOriginCountry() {
        return originCountry;
    }

    @SerializedName("origin_country")
    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

}
