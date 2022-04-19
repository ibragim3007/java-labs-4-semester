package com.company.Graph;

import java.util.List;

abstract class Graph {
    private String color = "green";
    void draw(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}


class Grid extends Graph {
    private double scaleX = 1;
    private double scaleY = 1;

    public Grid(double scaleX, double scaleY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    public Grid() {}

    public void setScaleX(double scaleX) { this.scaleX = scaleX; }
    public void setScaleY(double scaleY) { this.scaleY = scaleY; }

    @Override
    void draw() {
        System.out.println("ScaleX: " + this.scaleX + ", ScaleY: " + this.scaleY);
    }
}


class Dot extends Graph {
    private final double x;
    private final double y;

    public Dot(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    @Override
    void draw() { System.out.println("(" + this.x + ", " + this.y + ")"); }
}


class Axi extends Graph {

    private final Dot A;
    private final Dot B;

    public Axi (Dot A, Dot B) {
        this.A = A;
        this.B = B;
    }

    @Override
    void draw() {
        System.out.println("Точки: ");
        A.draw(); B.draw();
    }
}


class Curve extends Graph {

    private final Dot[] dots;

    public Curve (Dot[] dots) { this.dots = dots; }

    @Override
    void draw() { for (Dot dot : this.dots)  System.out.print(dot.getX() + " : " + dot.getY()); }
}


class Comment extends Graph {

    private String comment;

    public Comment(String comment) { this.comment = comment; }

    public void printComment () {
        System.out.println(comment);
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void draw() { System.out.println(this.comment); }
}


class Window {
    private final int width = 640;
    private final int height = 480;

    private List<Curve> curves;
    private List<Axi> axis;
    private List<Comment> comments;
    private final Grid grid;

    public Window(int AxisQuantity) { this.grid = new Grid(); }

    public Window(List<Curve> curves, List<Axi> axis, Grid grid) {
        this.curves = curves;
        this.axis = axis;
        this.grid = grid;
    }

    public void addAxi (int x1, int y1, int x2, int y2) {
        Axi newAxi = new Axi(new Dot(x1, y1), new Dot(x2, y2));
        axis.add(newAxi);
    }

    public void addCurves (Dot[] dots, String comment) {
        Curve newCurve = new Curve(dots);
        curves.add(newCurve);
    }

    public void addComment (String comment) { this.comments.add(new Comment(comment)); }

    public void changeScale (double ScaleX, double ScaleY) {
        this.grid.setScaleX(ScaleX);
        this.grid.setScaleY(ScaleY);
    }

    public void drawPlane () {
        this.grid.draw();
        for (Axi axi : this.axis) axi.draw();
    }

    public void drawFunctions () {
        for (Curve curve : this.curves) curve.draw();
        for (Comment comment : this.comments) comment.draw();
    }

}




