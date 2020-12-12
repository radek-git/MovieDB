package com;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MovieDB {
    static List<Movie> movieList = new ArrayList<>();

    static void menuSelection() {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        while (counter == 0) {
            System.out.println("1. Dodaj Film\n" +
                            "2. Szukaj filmu po nazwie\n" +
                            "3. Wypisz filmy z zakresu dat\n" +
                            "4. Sprawdz w jakich filmach grał dany aktor\n" +
                            "5. Ile kosztowalo wyprodukowanie danego filmu");

            int selectMenu = scanner.nextInt();
            switch (selectMenu) {
                case 1:
                    addMovie(movieList);
                    break;
                case 2:
                    findMovieByTitle(movieList);
                    break;
                case 3:
                    searchMovieFromRange();
                    break;
                case 4:
                    checkMoviesForActor(movieList);
                    break;
                case 5:
                    checkMovieBudget(movieList);
                    break;
                default:
                    System.out.println("Zły wybór");
                    counter++;
            }

        }
    }

    static void dataPreparation() {
        Director stevenSpilberg = new Director("Steven", "Spilberg", 2000);
        Director jamesCameron = new Director("James", "Cameron", 3000);

        Actor tomCruiz = new Actor("Tom", "Cruize", 1000);
        Actor juliaRoberts = new Actor("Juila", "Roberts", 1100);
        Actor stevenSigal = new Actor("Steven", "Seagal", 1200);

        Movie titanic = new Movie("Titanic", stevenSpilberg,
                LocalDate.of(2020, 12, 1), Arrays.asList(tomCruiz, juliaRoberts), MovieType.action);
        Movie rambo = new Movie("Rambo", jamesCameron,
                LocalDate.of(2018, 12, 1), Arrays.asList(tomCruiz, stevenSigal), MovieType.horror);
        movieList.add(titanic);
        movieList.add(rambo);
    }

    private static void findMovieByTitle(List<Movie> movieList) {
        System.out.println("Podaj nazwe szukanego filmu ");
        Scanner scanner1 = new Scanner(System.in);
        String movieTitle = scanner1.nextLine();

        for (Movie movie : movieList) {
            if (movie.getTitle().equals(movieTitle)) {
                String toString = movie.toString();
                System.out.println(toString);
            }
        }
    }


    private static void addMovie(List<Movie> movies) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj tytuł filmu");
        String title = sc.nextLine();
        movies.add(new Movie(title, null, null, null, MovieType.comedy));

        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }



//    public static void findListOfMoviesByActor(List<Movie> movieList) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Podaj nazwisko aktora");
//        String actorLastName = sc.nextLine();
//
//        List<Movie> movieWithActor =  movieList.stream()
//                .filter(movie -> movie.getActors().stream()
//                        .anyMatch(actor -> actor.getLastName().equals(actorLastName)))
//                .collect(Collectors.toList());
//
//        for (Movie movie : movieWithActor) {
//            System.out.println(movie);
//        }
//    }


    private static void checkMoviesForActor(List<Movie> movies) {
        System.out.println("Podaj imię i nazwisko");
        Scanner sc = new Scanner(System.in);
        String firstOrLastName = sc.nextLine();

        for (Movie movie : movies) {
            for (Actor actor : movie.getActors()) {
                if (actor.getFirstName().equals(firstOrLastName) || actor.getLastName().equals(firstOrLastName)) {
                    System.out.println(movie.getTitle());
                }
            }
        }
    }



    private static void checkMovieBudget(List<Movie> movieList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj tytuł filmu");
        String movieName = sc.nextLine();
        double budgetMovie = 0;

        for (Movie movie : movieList) {
            if (movie.getTitle().equals(movieName)) {
                budgetMovie += movie.getDirector().getPayment();

                for (Actor actor : movie.getActors()) {
                    budgetMovie += actor.getPayment();
                }
                System.out.println(budgetMovie);
            }
        }
    }


    private static void searchMovieFromRange() {
        System.out.println("Podaj datę od w formacie RRRR-MM-DD");
        Scanner sc = new Scanner(System.in);
        LocalDate start = LocalDate.parse(sc.nextLine());
        System.out.println("Podaj datę do w formacie RRRR-MM-DD");
        LocalDate end = LocalDate.parse(sc.nextLine());

        for (Movie movie : movieList) {
            if (movie.getPremierDate().isAfter(start) && movie.getPremierDate().isBefore(end) ||
            movie.getPremierDate().equals(start) || movie.getPremierDate().equals(end)) {
                System.out.println(movie.getTitle());
            }
        }
    }
}
