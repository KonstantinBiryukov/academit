package ru.adademit.vector.main;

import ru.adademit.vector.Vector;

public class Main {

    public static void main(String[] args) {
        // TEST_program
        int n = 10;
        double[] array = new double[]{2, 4, 6, 12, -5};
        double[] array2 = new double[]{2, -1, -4, 9};
        double[] array3 = new double[]{0, -3, -5};
        double[] array4 = new double[]{2, 7, 9};
        double[] array5 = new double[]{1, 2, 3};
        double[] array6 = new double[]{7, -5, 0};
        double[] array7 = new double[]{7, -5, 0};
        double[] array8 = new double[]{7, -54, 2};

        Vector nV = new Vector(n);
        Vector v = new Vector(array);
        Vector v2 = new Vector(array2);
        Vector v3 = new Vector(3, array3);
        Vector v4 = new Vector(3, array4);
        Vector v5 = new Vector(array5);
        Vector copyV = new Vector(v);
        Vector v6 = new Vector(array6);
        Vector v7 = new Vector(array7);
        Vector v8 = new Vector(array8);

        System.out.println(nV);
        System.out.println(v);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(copyV);

        System.out.println(v.addVector(v2));
        System.out.println(v3.subtractVector(v4));
        System.out.println(v.multiplyScalar(3));
        System.out.println(v.getSize());
        System.out.println(v5.reverseVector());
        v5.setComponent(0, 10);
        System.out.println(v5);

        System.out.println(v6.equals(v7));
        System.out.println(v7.equals(v8));
        System.out.println(v6.hashCode());
        System.out.println(v7.hashCode());
        System.out.println(v8.hashCode());

        System.out.println(Vector.add2Vectors(v6, v7));
        System.out.println(Vector.subtract2Vectors(v7, v8));
        System.out.println(Vector.getScalarMultiplication2Vectors(v6, v8));
    }
}