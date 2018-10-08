package ru.academit.shapes;

public class Triangle implements Shapes {
    private boolean isGetAreaCalled;
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

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public void setY3(double y3) {
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
        double maxNumber = (x1 >= x2) ? x1 : x2;
        if (maxNumber == x1) {
            return (x1 >= x3) ? x1 : x3;
        } else {
            return (x2 >= x3) ? x2 : x3;
        }
    }

    private static double min(double y1, double y2, double y3) {
        double minNumber = (y1 <= y2) ? y1 : y3;
        if (minNumber == y1) {
            return (y1 <= y3) ? y1 : y3;
        } else {
            return (y2 <= y3) ? y2 : y3;
        }
    }

    public double getWidth() {
        return (Triangle.max(x1, x2, x3) - Triangle.min(x1, x2, x3));
    }

    public double getHeight() {
        return (Triangle.max(y1, y2, y3) - Triangle.min(y1, y2, y3));
    }

    public double getArea() {
        isGetAreaCalled = true;
        return (getHeight() * getWidth()) / 2;
    }

    private double getSideAB() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private double getSideAC() {
        return Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
    }

    private double getSideBC() {
        return Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
    }

    public double getPerimeter() {
        isGetAreaCalled = false;
        return getSideAB() + getSideAC() + getSideBC();
    }

    @Override
    public String toString() {
        if (isGetAreaCalled) {
            return "MaxArea = " + getArea() + ", " + getClass();
        } else {
            return "2nd max Perimeter = "  + getPerimeter() + ", " + getClass();
        }
    }

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
