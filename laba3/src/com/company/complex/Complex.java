package com.company.complex;
public class Complex {
    private double real = 0;
    private double image = 0;

    public Complex(double r) {
        real = r;
        image = 0;
    }
    public Complex(double r, double i) {
        real = r;
        image = i;
    }

    public double getReal() {
        return real;
    }
    public double getImage() {
        return image;
    }

    static Complex add(Complex z1, Complex z2) {
        return new Complex(z1.real + z2.real, z1.image + z2.image);
    }
    static Complex add(Complex z1, double real) {
        return new Complex(z1.real + real, z1.image);
    }

    static Complex substract(Complex z1, Complex z2) {
        return new Complex(z1.real - z2.real, z1.image - z2.image);
    }
    static Complex substract(Complex z1, double real) {
        return new Complex(z1.real - real, z1.image);
    }

    static Complex multiply(Complex z1, Complex z2) {
        double real = z1.real*z2.real - z1.image*z2.image;
        double image = z1.real*z2.image + z1.image*z2.real;
        return new Complex(real, image);
    }
    static Complex divide(Complex z1, Complex z2) {
        double delim = Math.pow(z2.real, 2) + Math.pow(z2.image, 3);
        double real = (z1.real*z2.real + z1.image*z2.image) / delim;
        double image = (z2.real*z1.image - z1.real*z2.image) / delim;
        return new Complex(real, image);
    }

    static Complex getLinked(Complex z1) {
        return new Complex(z1.real, -z1.image);
    }

    static boolean isEqual(Complex z1, Complex z2) {
        if(z1.real == z2.real && z1.image == z2.image) return true;
        return false;
    }

    public void printAlgebraic() {
        if(image == 0) {
            System.out.printf("z = %.1f\n", real);
        } else if(image > 0) {
            System.out.printf("z = %.1f+%.1fi\n", real, image);
        } else {
            System.out.printf("z = %.1f%.1fi\n", real, image);
        }
    }
    public void printTrigonometric() {
        double r = Math.sqrt(real*real + image*image);
        double phi = Math.toDegrees(Math.atan(image / real));

        if(phi == 0) System.out.println("z = " + 0);
        else if(phi < 0) System.out.printf("z = %.1f*(cos(%.0f)-sin(%.0f))\n", r, Math.abs(phi), Math.abs(phi));
        else System.out.printf("z = %.1f*(cos(%.0f)+sin(%.0f))\n", r, Math.abs(phi), phi);
    }
}

class HyperbolicCalc {
    private static Complex exp(Complex z) {
        double real = Math.exp(z.getReal()) * Math.cos(z.getImage());
        double image = Math.exp(z.getReal()) * Math.sin(z.getImage());
        return new Complex(real, image);
    }

    public static Complex sin(Complex z) {
        Complex a = HyperbolicCalc.exp(Complex.multiply(new Complex(0, 1), z)); // e^iz
        Complex b = HyperbolicCalc.exp(Complex.multiply(new Complex(0, -1), z)); // e^-iz
        Complex dividend = Complex.substract(a, b);
        Complex divider = new Complex(0, 2); // 2i
        return Complex.divide(dividend, divider);
    }
    public static Complex cos(Complex z) {
        Complex a = HyperbolicCalc.exp(Complex.multiply(new Complex(0, 1), z)); // e^iz
        Complex b = HyperbolicCalc.exp(Complex.multiply(new Complex(0, -1), z)); // e^-iz
        Complex dividend = Complex.add(a, b);
        Complex divider = new Complex(2);
        return Complex.divide(dividend, divider);
    }

    public static Complex tan(Complex z) {
        return Complex.divide(HyperbolicCalc.sin(z), HyperbolicCalc.cos(z));
    }
    public static Complex arctan(Complex z) {
        return Complex.divide(HyperbolicCalc.cos(z), HyperbolicCalc.sin(z));
    }

    public static Complex sh(Complex z) {
        Complex a = HyperbolicCalc.exp(z); // e^z
        Complex b = HyperbolicCalc.exp(Complex.multiply(new Complex(-1), z)); // e^-z
        Complex dividend = Complex.substract(a, b);
        Complex divider = new Complex(2);
        return Complex.divide(dividend, divider);
    }
    public static Complex ch(Complex z) {
        Complex a = HyperbolicCalc.exp(z); // e^z
        Complex b = HyperbolicCalc.exp(Complex.multiply(new Complex(-1), z)); // e^-z
        Complex dividend = Complex.add(a, b);
        Complex divider = new Complex(2);
        return Complex.divide(dividend, divider);
    }

    public static Complex th(Complex z) {
        return Complex.divide(HyperbolicCalc.sh(z), HyperbolicCalc.ch(z));
    }
    public static Complex cth(Complex z) {
        return Complex.divide(HyperbolicCalc.ch(z), HyperbolicCalc.sh(z));
    }
}
