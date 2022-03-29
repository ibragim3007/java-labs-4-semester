package com.company;


public class ElementaryOperations {
    static public Complex ExponentCount (Complex z) {
        return new Complex(
                Math.exp(z.getRational())*Math.cos(z.getImaginary()),
                Math.exp(z.getImaginary())*Math.sin(z.getImaginary())
        );
    }

//    static public Complex sin (Complex z) {
//        return new Complex();
//    }
}
