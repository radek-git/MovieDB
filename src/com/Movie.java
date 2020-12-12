package com;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movie {

    String title;
//    Director director;
    LocalDate premierDate;
    List<Stuff> stuffList = new ArrayList<>();
    MovieType movieType;

    public Movie(String title, LocalDate premierDate, List<Stuff> stuffList, MovieType movieType) {
        this.title = title;
        this.premierDate = premierDate;
        this.stuffList = stuffList;
        this.movieType = movieType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPremierDate() {
        return premierDate;
    }

    public void setPremierDate(LocalDate premierDate) {
        this.premierDate = premierDate;
    }

    public List<Stuff> getStuffList() {
        return stuffList;
    }

    public void setStuffList(List<Stuff> stuffList) {
        this.stuffList = stuffList;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", premierDate=" + premierDate +
                ", stuffList=" + stuffList +
                ", movieType=" + movieType +
                '}';
    }
}
