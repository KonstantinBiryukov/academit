package ru.academit.range.main;

import ru.academit.range.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(2, 12);
        System.out.println("Intersection = " + Arrays.toString(range.getIntersectionRange(1, 3)));
        System.out.println("Union = " + Arrays.toString(range.getUnionRange(1, 3)));

    }
}
