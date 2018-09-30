package ru.academit.range.main;

import ru.academit.range.Range;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Range range = new Range(2, 9);
        Range rangeNew = new Range(5, 12);

        Range intersectionRange = range.getIntersectionRange(rangeNew);
        System.out.print("Intersection = [" + intersectionRange.getFrom() + ", " + intersectionRange.getTo() + "]");

        Range unionRange[] = range.getUnionRange(rangeNew);
        System.out.println(Arrays.toString(unionRange));

        // System.out.println("Difference = " + Arrays.toString(range.getDifferenceRange(range)));
    }
}

