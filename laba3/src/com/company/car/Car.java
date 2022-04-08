package com.company.car;

import com.company.engine.Engine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Car {

    private final String REGEX = "[АВЕКМНОПРСТУХ] \\d{3} [АВЕКМНОПРСТУХ]{2} (\\d{3}|\\d{2}) RUS";

    final private String brand;
    final private int wheels;

    protected String registerCode;
    private ColorsCar color;
    private Engine engine;

    protected Car(
            String registerCode,
            String brand,
            ColorsCar color,
            Engine engine,
            int wheels
    ) {
        this.brand = brand;
        this.color = color;
        this.engine = engine;
        this.wheels = wheels;
        this.setRegisterCode(registerCode);
    }

    protected Car(
            String brand,
            ColorsCar color,
            Engine engine,
            int wheels
    ) {
        this.brand = brand;
        this.color = color;
        this.engine = engine;
        this.wheels = wheels;
    }

    //getters
    public final String getRegisterCode() {
        return this.registerCode;
    }
    public final String getBrand() {
        return this.brand;
    }
    public final ColorsCar getColor() {
        return this.color;
    }
    public final Engine getEngine() {
        return this.engine;
    }
    public final int getWheels() {
        return this.wheels;
    }

    //setters
    public void setColor(ColorsCar color) {
        this.color = color;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public void setRegisterCode(String registerCode) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(registerCode);
        while (matcher.find()) {
            this.registerCode = registerCode;
            return;
        }
        System.out.print("Регистрационный номер не верен!");
    }

    ;

    protected void printDefault() {
        if (this.registerCode != null) {
            System.out.println("Регистрационный номер:" + this.registerCode);
        }
        System.out.println("Бренд: " + this.brand);
        System.out.println("Цвет: " + this.color);
        System.out.println("Количество колес: " + this.wheels);

        System.out.println("Двигатель:");
        this.engine.print();
    }

    public void print() {
        this.printDefault();
    }

    public enum ColorsCar {
        Red,
        Green,
        Blue,
        Yellow,
        Pink,
        White
    }
}
