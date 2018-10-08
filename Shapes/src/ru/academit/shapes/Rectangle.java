package ru.academit.shapes;

public class Rectangle implements Shapes {
    private double width;
    private double height;
    private boolean isGetAreaCalled;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getArea() {
        isGetAreaCalled = true;
        return getWidth() * getHeight();
    }

    public double getPerimeter() {
        isGetAreaCalled = false;
        return (getWidth() + getHeight()) * 2;
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
        hash = prime * hash + Double.hashCode(width);
        hash = prime * hash + Double.hashCode(height);
        return hash;
    }
}

