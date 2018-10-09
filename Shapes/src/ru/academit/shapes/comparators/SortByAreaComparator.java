package ru.academit.shapes.comparators;

import ru.academit.shapes.Shape;
import java.util.Comparator;

public class SortByAreaComparator implements Comparator<Shape> {
    public int compare(Shape a, Shape b) {
        return Double.compare(a.getArea(), b.getArea());
    }
}
