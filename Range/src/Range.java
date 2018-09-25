//       Создать свой класс Range (числовой диапазон). В нём:
//        1. Объявить два вещественных поля from, to
//        2. Описать конструктор, при помощи которого заполняются поля from, to
//        3. Функция для вычисления длины интервала
//        4. Создать метод isInside, который принимает вещественное число
//        и возвращает boolean – результат проверки того, принадлежит ли число диапазону
//        • После этого написать небольшую программу с использованием этого класса

public class Range {

    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getFrom() {
        return from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getTo() {
        return to;
    }

    public double getRange() {
        return to - from;
    }

    public boolean isInside(double x) {
        return x >= from && x <= to;
    }

    public static void main(String[] args) {
        Range range = new Range(5, 10);
        System.out.printf("%.1f, %.1f %n", range.getFrom(), range.getTo());
        System.out.println(range.getRange());
        System.out.println(range.isInside(9));
    }
}