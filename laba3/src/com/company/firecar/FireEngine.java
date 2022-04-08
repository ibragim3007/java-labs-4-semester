package com.company.firecar;

import com.company.car.Car;
import com.company.engine.Engine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FireEngine extends Car {
    protected final String REGEX = "\\d[АВЕКМНО] \\d{2}[АВЕКМНО]{2} \\d{2} SPE";
    private double quantityWater;

    public FireEngine(String registerCode, String brand, ColorsCar color, Engine engine, int wheels) {
        super(registerCode, brand, color, engine, wheels);
    }

    FireEngine(String brand, ColorsCar color, Engine engine, int wheels) {
        super(brand, color, engine, wheels);
    }

    public void print() {
        System.out.println("\nRegister Code: " + this.registerCode);
        if (this.quantityWater > 0) System.out.println("Количество воды: " + this.quantityWater);
        this.printDefault();
    }

    public void setRegisterCode(String registerCode) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(registerCode);
        while (matcher.find()) {
            this.registerCode = registerCode;
            return;
        }
        System.out.println("Регистрационный номер не верен!");
    }

    public void setQuantityWater(double quantityWater) { this.quantityWater = quantityWater; }
}
