package ru.academit.range.main;

import ru.academit.range.Range;

public class Main {
    public static void main(String[] args) {

        Range range = new Range(6, 10);
        Range rangeNew = new Range(6, 8);
        Range intersectionRange = range.getIntersection(rangeNew);
        if (intersectionRange == null) {
            System.out.println("null");
        } else {
            System.out.println("Intersection = [" + intersectionRange.getFrom() + ", " + intersectionRange.getTo() + "];");
        }

        Range unionRange[] = range.getUnion(rangeNew);
        System.out.print("Union = ");
        for (Range e : unionRange) {
            System.out.print("[" + e.getFrom() + ", " + e.getTo() + "]");
        }
        System.out.println(";");

        Range differenceRange[] = range.getDifference(rangeNew);
        System.out.print("Difference = ");
        for (Range e : differenceRange) {
            System.out.print("[" + e.getFrom() + ", " + e.getTo() + "]");
        }
    }
}