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

    private boolean isInside(double x) {
        return x >= from && x <= to;
    }

    public double[] getIntersectionRange(double fromNew, double toNew) {
        if (isInside(fromNew) && isInside(toNew)) {
            return new double[]{fromNew, toNew};
        } else if (isInside(fromNew) && !isInside(toNew)) {
            return new double[]{fromNew, to};
        } else if (!isInside(fromNew) && isInside(toNew)) {
            return new double[]{from, toNew};
        }
        return null;
    }

    public double[] getUnionRange(double fromNew, double toNew) {
        if (fromNew - to > 0) {
            return new double[]{from, to, fromNew, toNew};
        } else if (from - toNew > 0) {
            return new double[]{fromNew, toNew, from, to};
        } else {
            double min, max;
            if (from < fromNew) {
                min = from;
            } else {
                min = fromNew;
            }
            if (to > toNew) {
                max = to;
            } else {
                max = toNew;
            }
            return new double[]{min, max};
        }
    }

    public double[] getDifferenceRange(double fromNew, double toNew) {
        getIntersectionRange(fromNew, toNew);

    }
}
