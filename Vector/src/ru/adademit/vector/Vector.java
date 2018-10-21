package ru.adademit.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        this.components = new double[n];
    }

    public Vector(Vector vectorContainer) {
        this.components = Arrays.copyOf(vectorContainer.components, vectorContainer.components.length);
    }

    public Vector(double[] vector) {
        if (vector.length <= 0) {
            throw new IllegalArgumentException("array's length must be greater than 0");
        }
        this.components = Arrays.copyOf(vector, vector.length);
    }

    public Vector(int n, double[] vector) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        this.components = Arrays.copyOf(vector, n);
    }

    public void setComponent(int index, double component) {
        if (index >= components.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("index should be less than the vector's length and greater than 0");
        }
        this.components[index] = component;
    }

    public double getComponentByIndex(int n) {
        return this.components[n];
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i = 0; i < getSize(); i++) {
            sb.append(components[i]).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append("}");
        return sb.toString();
    }

    public Vector addVector(Vector additionalVector) {
        int size1 = this.getSize();
        int size2 = additionalVector.getSize();

        if (size2 > size1) {
            this.components = Arrays.copyOf(this.components, size2);
        }

        for (int i = 0; i < size2; i++) {
            this.components[i] += additionalVector.components[i];
        }
        return this;
    }

    public Vector subtractVector(Vector additionalVector) {
        int size1 = this.getSize();
        int size2 = additionalVector.getSize();

        if (size2 > size1) {
            this.components = Arrays.copyOf(this.components, size2);
        }

        for (int i = 0; i < size2; i++) {
            this.components[i] -= additionalVector.components[i];
        }
        return this;
    }

    public Vector multiplyScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            this.components[i] *= scalar;
        }
        return this;
    }

    public Vector reverse() {
        multiplyScalar(-1);
        return this;
    }

    public double getLength() {
        double length = 0;

        for (double e : components) {
            length += (Math.pow(e, 2));
        }
        return Math.sqrt(length);
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
            for (int i = 0; i < getSize(); i++) {
                if (this.components[i] != v.components[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    public static Vector addVectors(Vector v1, Vector v2) {
        Vector copyV1 = new Vector(v1);
        return copyV1.addVector(v2);
    }

    public static Vector subtractVectors(Vector v1, Vector v2) {
        Vector copyV1 = new Vector(v1);
        return copyV1.subtractVector(v2);
    }

    public static double getScalarMultiplication(Vector v1, Vector v2) {
        int size1 = v1.getSize();
        int size2 = v2.getSize();
        int minSize = Math.min(size1, size2);
        double scalarMultiplication = 0;

        for (int i = 0; i < minSize; i++) {
            scalarMultiplication += v1.components[i] * v2.components[i];
        }
        return scalarMultiplication;
    }
}