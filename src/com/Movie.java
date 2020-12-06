package com;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movie {

    String title;
    Director director;
    LocalDate premierDate;
    List<Actor> actors = new ArrayList<>();
    MovieType movieType;

    public Movie(String title, Director director, LocalDate premierDate,
                 List<Actor> actors, MovieType movieType) {
        this.title = title;
        this.director = director;
        this.premierDate = premierDate;
        this.actors = actors;
        this.movieType = movieType;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public LocalDate getPremierDate() {
        return premierDate;
    }

    public void setPremierDate(LocalDate premierDate) {
        this.premierDate = premierDate;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
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
                ", director=" + director +
                ", premierDate=" + premierDate +
                ", actors=" + actors +
                ", movieType=" + movieType +
                '}';
    }
}
