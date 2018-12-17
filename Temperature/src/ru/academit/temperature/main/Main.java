// Сделать программу на Swing для перевода температуры из одной шкалы в другую.
// Необходимая функциональность:
//1.	Ввод температуры в поле ввода
//2.	Должна быть кнопка, которая переводит температуру из одной шкалы в другую
//3.	Результат перевода должен выводиться на форму, при этом быть не редактируемым
//4.	Можно задать из какой шкалы и в какую переводить
//5.	Доступные шкалы: цельсия, фаренгейта, кельвина
//6.	Если ввели не число, то нужно вывести ошибку
//7.	Обязательно использовать layout manager’ы
package ru.academit.temperature.main;

import ru.academit.temperature.model.CelsiusScale;
import ru.academit.temperature.model.FahrenheitScale;
import ru.academit.temperature.model.KelvinScale;
import ru.academit.temperature.view.View;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new View(new ArrayList<>(Arrays.asList(new CelsiusScale(), new KelvinScale(), new FahrenheitScale())));
            // Celsius is a base scale.
        });
    }
}