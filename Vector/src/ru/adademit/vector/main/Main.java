package ru.adademit.vector.main;

import ru.adademit.vector.Vector;

public class Main {

    public static void main(String[] args) {
        // TEST_program
        int n = 10;
        double[] array = new double[]{2, 4, 6, 10, 2, 10};
        double[] array2 = new double[]{1, -1, -4, 9, 1, 1, 12};
        double[] array3 = new double[]{0, -3, -5, 12, 3};
        double[] array4 = new double[]{2, 7, 9, 12, 3};
        double[] array5 = new double[]{1, 2, 3};
        double[] array6 = new double[]{7, -5, 0};
        double[] array7 = new double[]{7, -5, 0, 1};
        double[] array8 = new double[]{7, -54, 2, -1};
        double[] array9 = new double[]{7, -23, 2};
        double[] array10 = new double[]{3, -21, 2};
        double[] array11 = new double[]{7, -5, 2, 17};

        Vector vTest = new Vector(n, array);
        Vector copyTest = new Vector(vTest);
        Vector copyTest2 = new Vector(vTest);
        System.out.println(vTest);
        System.out.println(copyTest);
        System.out.println(copyTest2);

        Vector nV = new Vector(n);
        Vector v = new Vector(array);
        Vector v2 = new Vector(array2);
        Vector v3 = new Vector(array3);
        Vector v4 = new Vector(array4);
        Vector v5 = new Vector(array5);
        Vector copyV = new Vector(v);
        Vector v6 = new Vector(array6);
        Vector v7 = new Vector(array7);
        Vector v8 = new Vector(array8);
        Vector v9 = new Vector(array9);
        Vector v10 = new Vector(array10);
        Vector v11 = new Vector(array11);

        System.out.println("LENGTH =  " + v.getLength());

        System.out.println(nV);
        System.out.println(v);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(copyV);

        System.out.println("#add vector " + v.addVector(v2));
        System.out.println("#subtract vector " + v3.subtractVector(v4));
        System.out.println("#multiplyScalar " + v.multiplyScalar(3));
        System.out.println("#getSize " + v.getSize());
        System.out.println("#reverse " + v5.reverse());
        v5.setComponent(0, 10);
        System.out.println("#setComponent " + v5);

        System.out.println("#equals " + v6.equals(v7));
        System.out.println("#equals " + v7.equals(v8));
        System.out.println("#hashcode " + v6.hashCode());
        System.out.println("#hashcode " + v7.hashCode());
        System.out.println("#hashcode " + v8.hashCode());

        System.out.println("#addVectors " + Vector.addVectors(v6, v7));
        System.out.println("#subtractVectors " + Vector.subtractVectors(v8, v9));
        System.out.println("getScalarMultiplicationVectors " + Vector.getScalarMultiplication(v10, v11));
    }
}