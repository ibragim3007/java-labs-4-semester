package com.company;

public class Bus extends Car {
    private double length; //Длина автобуса

    Bus(String registerCode, String brand, ColorsCar color, Engine engine, int wheels, double length) {
        super(registerCode, brand, color, engine, wheels);
        this.length = length;
    }

    Bus(String brand, ColorsCar color, Engine engine, int wheels, double length) {
        super(brand, color, engine, wheels);
        this.length = length;
    }

    public double getLength() { return length; }

    public void setLength(double length) { this.length = length; }
}
