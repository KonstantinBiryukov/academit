package ru.academit.shapes;

public class Circle implements Shapes {
    private double radius;
    private boolean isGetAreaCalled;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getWidth() {
        return 2 * radius;
    }

    public double getHeight() {
        return 2 * radius;
    }

    public double getArea() {
        isGetAreaCalled = true;
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        isGetAreaCalled = false;
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        if (isGetAreaCalled) {
            return "MaxArea = " + getArea() + ", " + getClass();
        } else {
            return "2nd max Perimeter = "  + getPerimeter() + ", " + getClass();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 35;
        int hash = 1;
        hash = prime * hash + Double.hashCode(radius);
        return hash;
    }
}
