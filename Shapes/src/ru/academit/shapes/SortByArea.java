package ru.academit.shapes;

import java.util.Comparator;

public class SortByArea implements Comparator<Shapes> {
    public int compare(Shapes a, Shapes b) {
        if (a.getArea() < b.getArea()) {
            return -1;
        } else if (a.getArea() == b.getArea()) {
            return 0;
        } else {
            return 1;
        }
    }


}
