package ru.academit.range.main;

import ru.academit.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(2, 9);
        Range rangeNew = new Range(5, 12);

        range.getIntersectionRange(rangeNew);
     //   range.getUnionRange(rangeNew);

       // System.out.println("Difference = " + Arrays.toString(range.getDifferenceRange(range)));
    }
}

