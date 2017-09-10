package org.tutorials.hectorsdesign.udemymaterialdesign.pojo;

import org.tutorials.hectorsdesign.udemymaterialdesign.extras.UrlEndpoints;

import java.util.Date;

/**
 * Created by abelhectMACHOME on 9/17/16.
 */
public class Movie {
    private long id;
    private String title;
    private String overview;
    private Date releaseDate;
    private String posterPath;

//    constructor
    public Movie(){
        this.id=id;
        this.title=title;
        this.overview=overview;
        this.releaseDate=releaseDate;
        this.posterPath=posterPath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @Override
    public String toString() {
        return "ID: "+id+
                "Title: "+title+
                "Overview: "+overview+
                "Date: "+releaseDate+
                "PosterURL: "+posterPath;
//        "PosterURL: "+UrlEndpoints.URL_POSTER_IMAGE+posterPath;
    }
}


