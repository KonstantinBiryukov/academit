package ru.academit.shapes.main;

import ru.academit.shapes.*;
import ru.academit.shapes.comparators.SortByAreaComparator;
import ru.academit.shapes.comparators.SortByPerimeterComparator;
import ru.academit.shapes.shapes.Circle;
import ru.academit.shapes.shapes.Rectangle;
import ru.academit.shapes.shapes.Square;
import ru.academit.shapes.shapes.Triangle;
import java.util.Arrays;

public class Main {

    private static Shape getMaxArea(Shape[] arrayShapes) {
        Arrays.sort(arrayShapes, new SortByAreaComparator());
        return arrayShapes[arrayShapes.length - 1];
    }

    private static Shape getMax2Perimeter(Shape[] arrayShapes) {
        Arrays.sort(arrayShapes, new SortByPerimeterComparator());
        return arrayShapes[arrayShapes.length - 2];
    }

    public static void main(String[] args) {

        Triangle t1 = new Triangle(1, 4, 3, 4, 4, 6);
        Triangle t2 = new Triangle(1, 4, 3, 4, 4, 6);
        Rectangle r1 = new Rectangle(3, 5);
        Rectangle r2 = new Rectangle(34, 5);
        Circle c1 = new Circle(2);
        Square s1 = new Square(10);
        Square s2 = new Square(5);

        Shape[] arrayShapes = new Shape[]{t1, r1, c1, s1, s2};

        System.out.println(r1.equals(r2));
        System.out.println(t1.equals(t2));
        System.out.println(t1);

        System.out.println("Max area = " + getMaxArea(arrayShapes));
        System.out.println("2nd max perimeter = " + getMax2Perimeter(arrayShapes));

        System.out.println(t1.hashCode());
        System.out.println(t2.hashCode());
    }
}