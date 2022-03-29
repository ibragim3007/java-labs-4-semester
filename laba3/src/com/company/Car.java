package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum ColorsCar {
    Red,
    Green,
    Blue,
    Yellow,
    Pink,
    White
}

enum KindTransport {
    Passenger,
    Freight,
    Bus,
}

public class Car {

    private final String REGEX = "^[^авекмнорстух]{3}( )\\d{3} [^авекмнорстух]{2} (\\d{3}|\\d{2}) RUS$";

    final private String brand;
    final private KindTransport kindTransport;
    final private int wheels;

    private String registerCode;
    private ColorsCar color;
    private Engine engine;

    Car (
            String registerCode,
            String brand,
            KindTransport kindTransport,
            ColorsCar color,
            Engine engine,
            int wheels
    ) {
        this.brand = brand;
        this.kindTransport = kindTransport;
        this.color = color;
        this.engine = engine;
        this.wheels = wheels;
        this.setRegisterCode(registerCode);
    }

    Car (
            String brand,
            KindTransport kindTransport,
            ColorsCar color,
            Engine engine,
            int wheels
    ) {
        this.brand = brand;
        this.kindTransport = kindTransport;
        this.color = color;
        this.engine = engine;
        this.wheels = wheels;
    }

    //getters
    public final String getRegisterCode () { return this.registerCode; }
    public final String getBrand () { return this.brand; }
    public final KindTransport getKindTransport () { return this.kindTransport; }
    public final ColorsCar getColor () { return this.color; }
    public final Engine getEngine () { return this.engine; }
    public final int getWheels () { return this.wheels; }

    //setters
    public final void setColor (ColorsCar color) { this.color = color; }
    public final void setEngine (Engine engine) { this.engine = engine; }
    public final void setRegisterCode (String registerCode) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(registerCode);
        while (matcher.find()){
            this.registerCode = registerCode;
            return;
        }
        System.out.print("Регистрационный номер не верен!");
    };
}
