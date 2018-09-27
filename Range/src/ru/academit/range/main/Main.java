package ru.academit.range.main;

import ru.academit.range.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(3, 8);
        System.out.println("Intersection = " + Arrays.toString(range.getIntersectionRange(1, 5)));
        System.out.println("Union = " + Arrays.toString(range.getUnionRange(1, 5)));

    }
}
