package com.company;

import static com.company.ElementaryOperations.ExponentCount;

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
                "tayota", Car.ColorsCar.Red, mx250, 4
        );

        Truck kamaz = new Truck("Blaze", Car.ColorsCar.Green, mx250, 6);
        kamaz.print();

        FireEngine mashinka = new FireEngine("2Е 53КМ 21 SPE","fireCar", Car.ColorsCar.Blue, mx250, 6);
//        mashinka.setRegisterCode("2Е 53КМ 21 SPE");
        mashinka.setQuantityWater(52.2d);
        mashinka.print();


        Complex number1 = new Complex(2, 4);
        Complex number2 = new Complex(3, 9);
        final Complex number3 =  ExponentCount(number1);

        CarBase a = new CarBase(5);
        a.addCar(mashinka);
        a.addCar(kamaz);
        a.printCurentCars();

        a.deleteCar(kamaz);

        a.printCurentCars();

//        number3.print();


    }
}
