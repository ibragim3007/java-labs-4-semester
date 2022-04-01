package com.company;


public class Passenger extends Car {

    private int numberOfPassengers;

    Passenger(String registerCode, String brand, ColorsCar color, Engine engine, int wheels) {
        super(registerCode, brand, color, engine, wheels);
    }

    Passenger(String brand, ColorsCar color, Engine engine, int wheels) {
        super(brand, color, engine, wheels);
    }

    public void print() {
        System.out.println("Количество пасажиров: " + this.numberOfPassengers);
        this.printDefault();
    }

    public void setNumberPassengers(int numberOfPassengers) { this.numberOfPassengers = numberOfPassengers; }
}

