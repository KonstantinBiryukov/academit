package ru.academit.range.main;

import ru.academit.range.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(2, 9);
        Range newRange = new Range(5, 12);

        System.out.println("Intersection = " + Arrays.toString(range.getIntersectionRange(newRange)));
        System.out.println("Union = " + Arrays.toString(range.getUnionRange(newRange)));

       // System.out.println("Difference = " + Arrays.toString(range.getDifferenceRange(range)));
    }
}

