package com.company;


public class Complex {
    private double x;
    private double y;

    Complex (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getRational () { return this.x; }
    public double getImaginary () { return this.y; }

    static public Complex sumComplex(Complex a, Complex b) { return new Complex(a.x + b.x, b.x + b.y); }

    static public Complex subtractionComplex(Complex a, Complex b) { return new Complex(a.x - b.x, b.x - b.y); }

    static public Complex multipleComplex(Complex a, Complex b) {
        double tempNumberFirst = (a.x*b.x) - (a.y*b.y);
        double tempNumberSecond = (a.x*b.y) + (b.x*a.y);
        return new Complex(tempNumberFirst, tempNumberSecond);
    }


    static public Complex divisionComplex(Complex a, Complex b) {
        double divisionAn = (b.x)*(b.x) + (b.y)*(b.y);
        double tempNumberFirst = ((a.x*b.x) + (a.y*b.y)) / divisionAn;
        double tempNumberSecond = ((b.x*a.y) - (a.x*b.y)) /divisionAn;
        return new Complex(tempNumberFirst, tempNumberSecond);
    }

    public double getModuleComplex() { return Math.sqrt((this.x * this.x) + (this.y * this.y)); }

    public double getPhi() { return Math.atan(this.y / this.x); }

    public double moduleComplex() {
        System.out.println(getModuleComplex() + "*" + "(cos("+ Math.cos(getPhi()) + ") + i;" + "sin(" + getPhi() + "))");
        return this.getModuleComplex() * (Math.cos(getPhi()) + Math.sin(getPhi()));
    }

    public double allegedComplex () { return this.x - this.y; }

    public void print() { System.out.print("("+this.x+", i"+this.y+")"); }
}
