package com;

import java.time.LocalDate;
import java.util.*;

public class MovieDB {
    static List<Movie> movieList = new ArrayList<>();
//    static List<Director> directorList = new ArrayList<>();
//    static List<Actor> actorList = new ArrayList<>();

    static List<Stuff> stuffList = new ArrayList<>();


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
                    addMovie();
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
        Stuff stevenSpilberg = new Director("Steven", "Spilberg", 2000);
        Stuff jamesCameron = new Director("James", "Cameron", 3000);

        Stuff tomCruiz = new Actor("Tom", "Cruize", 1000);
        Stuff juliaRoberts = new Actor("Juila", "Roberts", 1100);
        Stuff stevenSigal = new Actor("Steven", "Seagal", 1200);

        Movie titanic = new Movie("Titanic",
                LocalDate.of(2020, 12, 1), Arrays.asList(tomCruiz, juliaRoberts, stevenSpilberg), MovieType.action);
        Movie rambo = new Movie("Rambo",
                LocalDate.of(2018, 12, 1), Arrays.asList(tomCruiz, stevenSigal, jamesCameron), MovieType.horror);
//        movieList.add(titanic);
//        movieList.add(rambo);

        Collections.addAll(movieList, titanic, rambo);
//        Collections.addAll(actorList, tomCruiz, juliaRoberts, stevenSigal);
//        Collections.addAll(directorList, jamesCameron, stevenSpilberg);

        Collections.addAll(stuffList, tomCruiz, juliaRoberts, stevenSigal, jamesCameron, stevenSigal);
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


    private static void addMovie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj tytuł filmu");
        String title = sc.nextLine();
        System.out.println("Podaj typ: comedy, horror, action");
        String type = sc.nextLine();
        System.out.println("Podaj imię lub nazwisko reżysera");
        String directorName = sc.nextLine();
        System.out.println("Podaj datę premiery w formacie RRRR-MM_DD");
        LocalDate premiereDate = LocalDate.parse(sc.nextLine());
        System.out.println("Podaj ilość aktorów w filmie");
        int actorsCount = sc.nextInt();
        sc.nextLine();

        Stuff director = null;
        List<Stuff> newMovieActorList = new ArrayList<>();

        for (Stuff stuff : stuffList) {
            if (stuff.getFirstName().equals(directorName)) {
                director = stuff;
            } else if (stuff.getLastName().equals(directorName)) {
                director = stuff;
            }
        }

        for (int i = 1; i <= actorsCount; i++) {
            System.out.println("Podaj imię " + i + " aktora");
            String firstOrLastName = sc.nextLine();
            for (Stuff stuff : stuffList) {
                if (stuff.getFirstName().equals(firstOrLastName)) {
                    newMovieActorList.add(stuff);
                } else if (stuff.getLastName().equals(firstOrLastName)) {
                    newMovieActorList.add(stuff);
                }
            }
        }

        Movie movie = new Movie(title, premiereDate, newMovieActorList, MovieType.valueOf(type));

        movieList.add(movie);

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
            for (Stuff stuff : movie.getStuffList()) {
                if (stuff.getFirstName().equals(firstOrLastName)) {
                    if (stuff instanceof Actor)
                    System.out.println(movie.getTitle());
                } else if (stuff.getLastName().equals(firstOrLastName)) {
                    if (stuff instanceof Actor)
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

                for (Stuff stuff : movie.getStuffList()) {
                    budgetMovie += stuff.getPayment();
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
