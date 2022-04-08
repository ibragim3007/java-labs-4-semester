package com.company.truck;

import com.company.car.Car;
import com.company.engine.Engine;

public class Truck extends Car {

    private int capacity;

    public Truck(String registerCode, String brand, ColorsCar color, Engine engine, int wheels) {
        super(registerCode, brand, color, engine, wheels);
    }

    Truck(String brand, ColorsCar color, Engine engine, int wheels) {
        super(brand, color, engine, wheels);
    }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    public void print() {
        System.out.println("Грузоподемность: " + this.capacity);
        this.printDefault();
    }
}
