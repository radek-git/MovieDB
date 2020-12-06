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
            System.out.println(
                    "1. Dodaj Film\n" +
                            "2. Szukaj filmu po nazwie\n" +
                            "3. Wypisz filmy z zakresu dat\n" +
                            "4. Sprawdz w jakich filmach grał dany aktor\n" +
                            "5. Ile kosztowalo wyprodukowanie danego filmu");

            int selectMenu = scanner.nextInt();
            switch (selectMenu) {
                case 1:
                    break;
                case 2:
                    findMovieByTitle(movieList);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
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

        Actor tomCruiz = new Actor("Tom", "Cruiz", 1000);
        Actor juliaRoberts = new Actor("Juila", "Roberts", 1100);
        Actor stevenSigal = new Actor("Steven", "Sigal", 1200);

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
}
