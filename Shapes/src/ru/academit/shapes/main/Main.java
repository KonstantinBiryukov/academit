package ru.academit.shapes.main;

import ru.academit.shapes.*;

import java.util.Arrays;

public class Main {

    private static Shapes getMaxArea(Shapes[] arrayShapes) {
        Arrays.sort(arrayShapes, new SortByArea());
        return arrayShapes[arrayShapes.length - 1];
    }

    private static Shapes getMax2Perimeter(Shapes[] arrayShapes) {
        Arrays.sort(arrayShapes, new SortByPerimeter());
        return arrayShapes[arrayShapes.length - 2];
    }

    public static void main(String[] args) {
        Triangle t1 = new Triangle(1, 4, 3, 4, 4, 6);
        Rectangle r1 = new Rectangle(3, 5);
        Circle c1 = new Circle(2);
        Square s1 = new Square(10);
        Square s2 = new Square(5);
        Shapes[] arrayShapes = new Shapes[]{t1, r1, c1, s1, s2};

        System.out.println(getMaxArea(arrayShapes));
        System.out.println(getMax2Perimeter(arrayShapes));

        Rectangle r2 = new Rectangle(3, 5);
        System.out.println(r1.hashCode());
        System.out.println(r2.hashCode());
    }
}
