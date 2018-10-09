package ru.academit.shapes.shapes;

import ru.academit.shapes.Shape;

public class Square implements Shape {
    private double sideLength;

    public Square(double length) {
        this.sideLength = length;
    }

    private double getLength() {
        return sideLength;
    }

    public double getWidth() {
        return sideLength;
    }

    public double getHeight() {
        return sideLength;
    }

    public double getArea() {
        return sideLength * sideLength;
    }

    public double getPerimeter() {
        final int SIDES_NUMBER = 4;
        return SIDES_NUMBER * sideLength;
    }

    @Override
    public String toString() {
        return "" + sideLength;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Square s = (Square) o;
        return sideLength == s.sideLength;
    }

    @Override
    public int hashCode() {
        final int prime = 35;
        int hash = 1;
        hash = prime * hash + Double.hashCode(sideLength);
        return hash;
    }
}

