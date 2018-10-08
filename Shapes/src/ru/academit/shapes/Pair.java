package ru.academit.shapes;

public class Pair {
    private int first;
    private int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Pair p = (Pair) o;
        return first == p.first && second == p.second;
    }
}
