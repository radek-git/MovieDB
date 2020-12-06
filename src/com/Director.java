package com;

public class Director extends Stuff{


    public Director(String firstName, String lastName, double payment) {
        super(firstName, lastName, payment * 3);
    }
}
