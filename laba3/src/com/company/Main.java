package com.company;

import com.company.car.Car;
import com.company.carbase.CarBase;
import com.company.engine.Engine;
import com.company.firecar.FireEngine;
import com.company.passenger.Passenger;
import com.company.truck.Truck;

public class Main {

    public static void main(String[] args) {

        Engine mx250 = new Engine(
                250,
                "x02c023",
                42,
                4,
                "Hith octan",
                8
        );

        Passenger alex = new Passenger(
                "А 256 ЕЕ 211 RUS",
                "tayota", Car.ColorsCar.Red, mx250, 4
        );

        Truck kamaz = new Truck("А 512 АЕ 21 RUS", "Blaze", Car.ColorsCar.Green, mx250, 6);
        kamaz.print();

        FireEngine mashinka = new FireEngine("2Е 53КМ 21 SPE","fireCar", Car.ColorsCar.Blue, mx250, 6);
        mashinka.setRegisterCode("2Е 53КМ 21 SPE");
        mashinka.setQuantityWater(52.2d);


        CarBase autoBase = new CarBase(5);
        autoBase.add(kamaz);
        autoBase.add(alex);
        autoBase.add(mashinka);

        autoBase.toFlight("А 512 АЕ 21 RUS");

        autoBase.printOnFlight();


        autoBase.printOnBase();


//        Complex z1 = new Complex(5, 4);
//        z1.printAlgebraic();
//        Complex z2 = new Complex(5, 0);
//        z2.printAlgebraic();
//        Complex z3 = new Complex(-5, -18);
//        z3.printAlgebraic();
//
//        z1 = Complex.add(z1, z2);
//        z1.printAlgebraic();
//        z1 = Complex.add(z1, 5);
//        z1.printAlgebraic();
//        z1 = Complex.multiply(z1, z3);
//        z1.printAlgebraic();
//        z1.printTrigonometric();


    }
}
