package ru.academit.shapes;

public class Square implements Shapes {
    private double sideLength;
    private boolean isGetAreaCalled;

    public Square(double length) {
        this.sideLength = length;
    }

    public void setLength(double length) {
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
        isGetAreaCalled = true;
        return getLength() * getLength();
    }

    public double getPerimeter() {
        final int SIDES_NUMBER = 4;
        isGetAreaCalled = false;
        return SIDES_NUMBER * getLength();
    }

    @Override
    public String toString() {
        if (isGetAreaCalled) {
            return "MaxArea = " + getArea() + ", " + getClass();
        } else {
            return "2nd max Perimeter = " + getPerimeter() + ", " + getClass();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 35;
        int hash = 1;
        hash = prime * hash + Double.hashCode(sideLength);
        return hash;
    }
}

