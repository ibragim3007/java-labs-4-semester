package com.company.passenger;


import com.company.car.Car;
import com.company.engine.Engine;

public class Passenger extends Car {

    private int numberOfPassengers;

    public Passenger(String registerCode, String brand, ColorsCar color, Engine engine, int wheels) {
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

