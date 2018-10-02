package ru.academit.range;
//       Создать свой класс Range (числовой диапазон). В нём:
//        1. Объявить два вещественных поля from, to
//        2. Описать конструктор, при помощи которого заполняются поля from, to
//        3. Функция для вычисления длины интервала
//        4. Создать метод isInside, который принимает вещественное число
//        и возвращает boolean – результат проверки того, принадлежит ли число диапазону
//        • После этого написать небольшую программу с использованием этого класса

// AdvancedRange
// Написать методы:
//• Вычисление длины интервала
//• Получение интервала-пересечения двух интервалов. Если пересечения нет, выдать null.
// Если есть, то выдать новый диапазон с соответствующими концами
//• Получение объединения двух интервалов. Может получиться 1 или 2 отдельных куска
//• Получение разности двух интервалов. Может получиться 1 или 2 отдельных куска
//• Еще пояснения на следующем слайде
//• В операциях где может получиться 2 куска выдавайте массив объектов Range
//• Операции пересечения, объединения и разности – по смыслу такие же как для множеств,
// см. литературу по множествам
//• Разность нужна несимметричная – из первого интервала вычитаем второй

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

    public double getLength() {
        return to - from;
    }

    private boolean isInside(double x) {
        return x >= from && x <= to;
    }

    public Range getIntersection(Range rangeNew) {
        double from = this.from;
        double to = this.to;
        double fromNew = rangeNew.from;
        double toNew = rangeNew.to;

        if ((fromNew >= from && fromNew <= to) && (toNew >= from && toNew <= to)) {
            return rangeNew;
        } else if ((fromNew <= from && fromNew <= to) && (toNew >= from && toNew >= to)) {
            return this;
        } else if ((fromNew >= from && fromNew <= to) && !(toNew >= from && toNew <= to)) {
            return new Range(fromNew, to);
        } else if (!(fromNew >= from && fromNew <= to) && (toNew >= from && toNew <= to)) {
            return new Range(from, toNew);
        }
        return new Range(0, 0);
    }

    public Range[] getUnion(Range range) {
        double from = this.from;
        double to = this.to;
        double fromNew = range.from;
        double toNew = range.to;

        if (fromNew > to) {
            return new Range[]{new Range(from, to), new Range(fromNew, toNew)};
        } else if (from > toNew) {
            return new Range[]{new Range(fromNew, toNew), new Range(from, to)};
        } else {
            double min = Math.min(from, fromNew);
            double max = Math.max(to, toNew);
            return new Range[]{new Range(min, max)};
        }
    }

    public Range[] getDifference(Range range) {
        double from = this.from;
        double to = this.to;
        double fromNew = range.from;
        double toNew = range.to;

        if (from < fromNew && to > fromNew && toNew > to) { // partial difference
            return new Range[]{new Range(from, fromNew - 1), new Range(to + 1, toNew)};
        } else if (from > fromNew && to > fromNew && toNew < to && from < toNew) { // partial difference
            return new Range[]{new Range(fromNew, from - 1), new Range(toNew + 1, to)};
        } else if (from > toNew || to > toNew) { // full difference
            return new Range[]{this, range};
        } else if (from < fromNew && to > toNew && from > toNew && to < fromNew) { // full intersection
            return new Range[]{new Range(from, fromNew - 1), new Range(toNew + 1, to)};
        } else if (from > fromNew && to < toNew && from < toNew && to > fromNew) { // full intersection
            return new Range[]{new Range(fromNew, from - 1), new Range(to + 1, toNew)};
        }
        return new Range[]{new Range(0, 0)}; // no difference
    }
}