package ru.academit.range.main;

import ru.academit.range.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(5, 10);
        System.out.printf("%.1f, %.1f %n", range.getFrom(), range.getTo());
        System.out.println(range.getLength());
        System.out.println(range.isInside(9));
    }
}
