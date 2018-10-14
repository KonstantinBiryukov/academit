package ru.adademit.vector;

import java.util.Arrays;

public class Vector {
    private double[] vector;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        } else {
            double[] vector = new double[n];
            for (int i = 0; i < n; i++) {
                vector[i] = 0;
            }
            this.vector = vector;
        }
    }

    public Vector(Vector vectorContainer) {
        this.vector = vectorContainer.vector;
    }

    public Vector(double[] vector) {
        double[] vectorContainer = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            vectorContainer[i] = vector[i];
        }
        this.vector = vectorContainer;
    }

    public Vector(int n, double[] vector) {
        double[] vectorContainer = new double[n];
        for (int i = 0; i < n; i++) {
            if (i >= vector.length) {
                vectorContainer[i] = 0;
            } else {
                vectorContainer[i] = vector[i];
            }
        }
        this.vector = vectorContainer;
    }

    public double[] getVector() {
        return vector;
    }

    public int getSize() {
        return vector.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }

    public Vector addVector(Vector additionalVector) {
        int size1 = this.getSize();
        int size2 = additionalVector.getSize();
        int maxSize = Math.max(size1, size2);

        if (size2 > size1) {
            Vector vectorContainer = new Vector(size2, this.vector);
            this.vector = vectorContainer.vector;
        } else {
            Vector vectorContainer = new Vector(size1, additionalVector.vector);
            additionalVector.vector = vectorContainer.vector;
        }
        for (int i = 0; i < maxSize; i++) {
            this.vector[i] += additionalVector.vector[i];
        }
        return this;
    }

    public Vector subtractVector(Vector additionalVector) {
        int size1 = this.getSize();
        int size2 = additionalVector.getSize();
        int maxSize = Math.max(size1, size2);

        if (size2 > size1) {
            Vector vectorContainer = new Vector(size2, this.vector);
            this.vector = vectorContainer.vector;
        } else {
            Vector vectorContainer = new Vector(size1, additionalVector.vector);
            additionalVector.vector = vectorContainer.vector;
        }
        for (int i = 0; i < maxSize; i++) {
            this.vector[i] -= additionalVector.vector[i];
        }
        return this;
    }

    public Vector multiplyScalar(double scalar) {
        for (int i = 0; i < vector.length; i++) {
            this.vector[i] *= scalar;
        }
        return this;
    }

    public Vector reverseVector() {
        for (int i = 0; i < vector.length; i++) {
            this.vector[i] *= -1;
        }
        return this;
    }

    public double getLength() {
        double length = 0;

        for (double e : vector) {
            length += (Math.pow(e, 2));
        }
        return Math.abs(Math.sqrt(length));
    }

    public void setComponent(int index, double component) {
        if (index >= vector.length || index < 0) {
            System.out.println("index doesn't exist");
        } else {
            this.vector[index] = component;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Vector v = (Vector) o;
        if (this.getSize() == v.getSize()) {
            for (int i = 0; i < this.getSize(); i++) {
                if (this.vector[i] != v.vector[i]) {
                    return false;
                }
            }
            return true;
        }
        return vector == v.vector;
    }

    @Override
    public int hashCode() {
        final int prime = 16;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(vector);
        return hash;
    }

    public static Vector add2Vectors(Vector v1, Vector v2) {
        int size1 = v1.getSize();
        int size2 = v2.getSize();
        int maxSize = Math.max(size1, size2);

        if (size2 > size1) {
            Vector vectorContainer = new Vector(size2, v1.vector);
            v1.vector = vectorContainer.vector;
        } else {
            Vector vectorContainer = new Vector(size1, v2.vector);
            v2.vector = vectorContainer.vector;
        }
        double[] arrayV3 = new double[maxSize];
        Vector v3 = new Vector(arrayV3);
        for (int i = 0; i < maxSize; i++) {
            v3.vector[i] = v1.vector[i] + v2.vector[i];
        }
        return v3;
    }

    public static Vector subtract2Vectors(Vector v1, Vector v2) {
        int size1 = v1.getSize();
        int size2 = v2.getSize();
        int maxSize = Math.max(size1, size2);

        if (size2 > size1) {
            Vector vectorContainer = new Vector(size2, v1.vector);
            v1.vector = vectorContainer.vector;
        } else {
            Vector vectorContainer = new Vector(size1, v2.vector);
            v2.vector = vectorContainer.vector;
        }
        double[] arrayV3 = new double[maxSize];
        Vector v3 = new Vector(arrayV3);
        for (int i = 0; i < maxSize; i++) {
            v3.vector[i] = v1.vector[i] - v2.vector[i];
        }
        return v3;
    }

    public static double getScalarMultiplication2Vectors(Vector v1, Vector v2) {
        int size1 = v1.getSize();
        int size2 = v2.getSize();
        int maxSize = Math.max(size1, size2);

        if (size2 > size1) {
            Vector vectorContainer = new Vector(size2, v1.vector);
            v1.vector = vectorContainer.vector;
        } else {
            Vector vectorContainer = new Vector(size1, v2.vector);
            v2.vector = vectorContainer.vector;
        }
        double scalarMultiplication = 0;
        for (int i = 0; i < maxSize; i++) {
            scalarMultiplication += v1.vector[i] * v2.vector[i];
        }
        return scalarMultiplication;
    }
}