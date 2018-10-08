package ru.academit.shapes;


import java.util.Comparator;

public class SortByPerimeter implements Comparator<Shapes> {
    public int compare(Shapes a, Shapes b) {
        if (a.getPerimeter() < b.getPerimeter()) {
            return -1;
        } else if (a.getPerimeter() == b.getPerimeter()) {
            return 0;
        } else {
            return 1;
        }
    }
}
