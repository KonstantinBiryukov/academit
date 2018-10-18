package ru.adademit.vector;

import java.util.Arrays;

public class Vector {
    private double[] vectorComponents;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        this.vectorComponents = new double[n];
    }

    public Vector(Vector vectorContainer) {
        int n = vectorContainer.vectorComponents.length;
        double[] arrayTemp = vectorContainer.vectorComponents;
        double[] arrayTemp2 = new double[n];
        System.arraycopy(arrayTemp, 0, arrayTemp2, 0, n);
        this.vectorComponents = arrayTemp2;
    }

    public Vector(double[] vector) {
        double[] vectorContainer = new double[vector.length];
        if (vector.length <= 0) {
            throw new IllegalArgumentException("array's length must be greater than 0");
        }

        System.arraycopy(vector, 0, vectorContainer, 0, vector.length);
        this.vectorComponents = vectorContainer;
    }

    public Vector(int n, double[] vector) {
        double[] vectorContainer = new double[n];
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }

        for (int i = 0; i < n; i++) {
            if (i >= vector.length) {
                vectorContainer[i] = 0;
            } else {
                vectorContainer[i] = vector[i];
            }
        }
        this.vectorComponents = vectorContainer;
    }

    public double getComponentByIndex(int n) {
        return this.vectorComponents[n];
    }

    public int getSize() {
        return vectorComponents.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i = 0; i < getSize(); i++) {
            sb.append(vectorComponents[i] + ", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append("}");
        return sb.toString();
    }

    public Vector addVector(Vector additionalVector) {
        int size1 = this.getSize();
        int size2 = additionalVector.getSize();

        if (size2 > size1) {
            for (int i = 0; i < size1; i++) {
                additionalVector.vectorComponents[i] += this.vectorComponents[i];
            }
            return additionalVector;
        } else {
            for (int i = 0; i < size2; i++) {
                this.vectorComponents[i] += additionalVector.vectorComponents[i];
            }
            return this;
        }
    }

    public Vector subtractVector(Vector additionalVector) {
        int size1 = this.getSize();
        int size2 = additionalVector.getSize();

        if (size2 > size1) {
            for (int i = 0; i < size1; i++) {
                this.vectorComponents[i] -= additionalVector.vectorComponents[i];
                additionalVector.vectorComponents[i] = this.vectorComponents[i];
            }
            for (int j = size1; j < size2; j++) {
                additionalVector.vectorComponents[j] *= -1;
            }
            return additionalVector;
        } else {
            for (int i = 0; i < size2; i++) {
                this.vectorComponents[i] -= additionalVector.vectorComponents[i];
            }
            return this;
        }
    }

    public Vector multiplyScalar(double scalar) {
        for (int i = 0; i < vectorComponents.length; i++) {
            this.vectorComponents[i] *= scalar;
        }
        return this;
    }

    public Vector reverse() {
        multiplyScalar(-1);
        return this;
    }

    public double getLength() {
        double length = 0;

        for (double e : vectorComponents) {
            length += (Math.pow(e, 2));
        }
        return (Math.sqrt(length));
    }

    public void setComponent(int index, double component) {
        if (index >= vectorComponents.length || index < 0) {
            throw new IllegalArgumentException("index should be less than the vector's length and greater than 0");
        }
        this.vectorComponents[index] = component;

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
                if (this.vectorComponents[i] != v.vectorComponents[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash + Arrays.hashCode(vectorComponents);
        return hash;
    }

    public static Vector addVectors(Vector v1, Vector v2) {
        return v1.addVector(v2);
    }

    public static Vector subtractVectors(Vector v1, Vector v2) {
        return v1.subtractVector(v2);
    }

    public static double getScalarMultiplication(Vector v1, Vector v2) {
        int size1 = v1.getSize();
        int size2 = v2.getSize();
        int minSize = Math.min(size1, size2);
        double scalarMultiplication = 0;

        for (int i = 0; i < minSize; i++) {
            scalarMultiplication += v1.vectorComponents[i] * v2.vectorComponents[i];
        }
        return scalarMultiplication;
    }
}