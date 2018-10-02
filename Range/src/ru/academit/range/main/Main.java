package ru.academit.range.main;

import ru.academit.range.Range;


public class Main {
    public static void main(String[] args) {
        Range range = new Range(2, 5);
        Range rangeNew = new Range(1, 10);

        Range intersectionRange = range.getIntersection(rangeNew);
        System.out.println("Intersection = [" + intersectionRange.getFrom() + ", " + intersectionRange.getTo() + "];");

        Range unionRange[] = range.getUnion(rangeNew);
        System.out.print("Union = ");
        for (int i = 0; i < unionRange.length; i++) {
            System.out.print("[" + unionRange[i].getFrom() + ", " + unionRange[i].getTo() + "]");
        }
        System.out.print(";");
        System.out.println();
        Range differenceRange[] = range.getDifference(rangeNew);
        System.out.print("Difference = ");
        for (int i = 0; i < differenceRange.length; i++) {
            System.out.print("[" + differenceRange[i].getFrom() + ", " + differenceRange[i].getTo() + "]");
        }
        System.out.print(";");

    }
}

