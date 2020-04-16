package com.example.mattias.movietest.dal.entities;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("adult")
    private Boolean adult;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("belongs_to_collection")
    private BelongsToCollection belongsToCollection;
    @SerializedName("budget")
    private Integer budget;
    @SerializedName("genres")
    private List<Genre> genres = null;
    @SerializedName("homepage")
    private String homepage;
    @SerializedName("id")
    private Integer id;
    @SerializedName("imdb_id")
    private String imdbId;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("overview")
    private String overview;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("production_companies")
    private List<ProductionCompany> productionCompanies = null;
    @SerializedName("production_countries")
    private List<ProductionCountry> productionCountries = null;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("revenue")
    private Integer revenue;
    @SerializedName("runtime")
    private Integer runtime;
    @SerializedName("spoken_languages")
    private List<SpokenLanguage> spokenLanguages = null;
    @SerializedName("status")
    private String status;
    @SerializedName("tagline")
    private String tagline;
    @SerializedName("title")
    private String title;
    @SerializedName("video")
    private Boolean video;
    @SerializedName("vote_average")
    private Double voteAverage;
    @SerializedName("vote_count")
    private Integer voteCount;


    /**
     * No args constructor for use in serialization
     *
     */
    public Movie() {
    }

    /**
     *
     * @param imdbId
     * @param video
     * @param title
     * @param productionCountries
     * @param revenue
     * @param genres
     * @param popularity
     * @param id
     * @param budget
     * @param posterPath
     * @param overview
     * @param voteAverage
     * @param releaseDate
     * @param belongsToCollection
     * @param runtime
     * @param originalLanguage
     * @param originalTitle
     * @param tagline
     * @param spokenLanguages
     * @param backdropPath
     * @param voteCount
     * @param adult
     * @param productionCompanies
     * @param homepage
     * @param status
     */
    public Movie(Boolean adult, String backdropPath, BelongsToCollection belongsToCollection, Integer budget, List<Genre> genres, String homepage, Integer id, String imdbId, String originalLanguage, String originalTitle, String overview, Double popularity, String posterPath, List<ProductionCompany> productionCompanies, List<ProductionCountry> productionCountries, String releaseDate, Integer revenue, Integer runtime, List<SpokenLanguage> spokenLanguages, String status, String tagline, String title, Boolean video, Double voteAverage, Integer voteCount) {
        super();
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.belongsToCollection = belongsToCollection;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.imdbId = imdbId;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spokenLanguages = spokenLanguages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    @SerializedName("adult")
    public Boolean getAdult() {
        return adult;
    }

    @SerializedName("adult")
    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    @SerializedName("backdrop_path")
    public String getBackdropPath() {
        return backdropPath;
    }

    @SerializedName("backdrop_path")
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    @SerializedName("belongs_to_collection")
    public BelongsToCollection getBelongsToCollection() {
        return belongsToCollection;
    }

    @SerializedName("belongs_to_collection")
    public void setBelongsToCollection(BelongsToCollection belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    @SerializedName("budget")
    public Integer getBudget() {
        return budget;
    }

    @SerializedName("budget")
    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    @SerializedName("genres")
    public List<Genre> getGenres() {
        return genres;
    }

    @SerializedName("genres")
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @SerializedName("homepage")
    public String getHomepage() {
        return homepage;
    }

    @SerializedName("homepage")
    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @SerializedName("id")
    public Integer getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @SerializedName("imdb_id")
    public String getImdbId() {
        return imdbId;
    }

    @SerializedName("imdb_id")
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @SerializedName("original_language")
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    @SerializedName("original_language")
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    @SerializedName("original_title")
    public String getOriginalTitle() {
        return originalTitle;
    }

    @SerializedName("original_title")
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    @SerializedName("overview")
    public String getOverview() {
        return overview;
    }

    @SerializedName("overview")
    public void setOverview(String overview) {
        this.overview = overview;
    }

    @SerializedName("popularity")
    public Double getPopularity() {
        return popularity;
    }

    @SerializedName("popularity")
    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    @SerializedName("poster_path")
    public String getPosterPath() {
        return posterPath;
    }

    @SerializedName("poster_path")
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @SerializedName("production_companies")
    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    @SerializedName("production_companies")
    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    @SerializedName("production_countries")
    public List<ProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    @SerializedName("production_countries")
    public void setProductionCountries(List<ProductionCountry> productionCountries) {
        this.productionCountries = productionCountries;
    }

    @SerializedName("release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    @SerializedName("release_date")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @SerializedName("revenue")
    public Integer getRevenue() {
        return revenue;
    }

    @SerializedName("revenue")
    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    @SerializedName("runtime")
    public Integer getRuntime() {
        return runtime;
    }

    @SerializedName("runtime")
    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    @SerializedName("spoken_languages")
    public List<SpokenLanguage> getSpokenLanguages() {
        return spokenLanguages;
    }

    @SerializedName("spoken_languages")
    public void setSpokenLanguages(List<SpokenLanguage> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    @SerializedName("status")
    public String getStatus() {
        return status;
    }

    @SerializedName("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @SerializedName("tagline")
    public String getTagline() {
        return tagline;
    }

    @SerializedName("tagline")
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    @SerializedName("title")
    public String getTitle() {
        return title;
    }

    @SerializedName("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @SerializedName("video")
    public Boolean getVideo() {
        return video;
    }

    @SerializedName("video")
    public void setVideo(Boolean video) {
        this.video = video;
    }

    @SerializedName("vote_average")
    public Double getVoteAverage() {
        return voteAverage;
    }

    @SerializedName("vote_average")
    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    @SerializedName("vote_count")
    public Integer getVoteCount() {
        return voteCount;
    }

    @SerializedName("vote_count")
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }
}

