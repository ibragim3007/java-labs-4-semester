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

	    Car tayota = new Car(
                "АМО 223 ХУ 424 RUS",
                "tayota",
                KindTransport.Passenger,
                ColorsCar.Red,
                mx250,
                4
        );

         tayota.getEngine().print();

        Complex number1 = new Complex(2, 4);
        Complex number2 = new Complex(3, 9);
        final Complex number3 =  ExponentCount(number1);

        number3.print();


    }
}
