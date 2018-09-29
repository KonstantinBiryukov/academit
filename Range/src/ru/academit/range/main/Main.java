package ru.academit.range.main;

import ru.academit.range.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(1, 4);
        System.out.println("Intersection = " + Arrays.toString(range.getIntersectionRange(3, 7)));
        System.out.println("Union = " + Arrays.toString(range.getUnionRange(3, 7)));
        System.out.println("Difference = " + Arrays.toString(range.getDifferenceRange(3, 7)));
    }
}
