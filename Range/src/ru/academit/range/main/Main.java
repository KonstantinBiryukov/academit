package ru.academit.range.main;

import ru.academit.range.Range;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Range range = new Range(2, 9);
        Range rangeNew = new Range(7, 12);

        Range intersectionRange = range.getIntersectionRange(rangeNew);
        System.out.print("Intersection = [" + intersectionRange.getFrom() + ", " + intersectionRange.getTo() + "]; ");

        Range unionRange[] = range.getUnionRange(rangeNew);
        System.out.println("Union = [" + unionRange[0].getFrom() + ", " +
        unionRange[0].getTo() + "]; " + "[" + unionRange[1].getFrom() + ", " +
        unionRange[1].getTo() + "]; ");

        // System.out.println("Difference = " + Arrays.toString(range.getDifferenceRange(range)));
    }
}

