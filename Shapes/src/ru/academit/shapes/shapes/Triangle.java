package ru.academit.shapes.shapes;

import ru.academit.shapes.Shape;

public class Triangle implements Shape {
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;

    public Triangle(double x1, double x2, double x3, double y1, double y2, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getX3() {
        return x3;
    }

    public double getY1() {
        return y1;
    }

    public double getY2() {
        return y2;
    }

    public double getY3() {
        return y3;
    }

    private static double max(double x1, double x2, double x3) {
        double maxNumber1 = Math.max(x1, x2);
        return Math.max(maxNumber1, x3);
    }

    private static double min(double y1, double y2, double y3) {
        double maxNumber1 = Math.min(y1, y2);
        return Math.min(maxNumber1, y3);
    }

    public double getWidth() {
        return (Triangle.max(x1, x2, x3) - Triangle.min(x1, x2, x3));
    }

    public double getHeight() {
        return (Triangle.max(y1, y2, y3) - Triangle.min(y1, y2, y3));
    }

    public double getArea() {
        return (getHeight() * getWidth()) / 2;
    }

    private double getSideLength(double point1_1, double point1_2, double point2_1, double point2_2) {
        return Math.sqrt(Math.pow(point1_2 - point1_1, 2) + Math.pow(point2_2 - point2_1, 2));
    }

    private double getSideAB() {
        return getSideLength(x1, x2, y1, y2);
    }

    private double getSideAC() {
        return getSideLength(x1, x3, y1, y3);
    }

    private double getSideBC() {
        return getSideLength(x2, x3, y2, y3);
    }

    public double getPerimeter() {
        return getSideAB() + getSideAC() + getSideBC();
    }

    @Override
    public String toString() {
        return (x1 + ", " + x2 + ", " + x3 + "; " + y1 + ", " + y2 + ", " + y3);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Triangle t = (Triangle) o;
        return x1 == t.x1 && x2 == t.x2 && x3 == t.x3 && y1 == t.y1 && y2 == t.y2 && y3 == t.y3;
    }

    @Override
    public int hashCode() {
        final int prime = 35;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(y3);
        return hash;
    }
}