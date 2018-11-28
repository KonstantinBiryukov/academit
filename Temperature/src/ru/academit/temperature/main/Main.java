// Сделать программу на SwiRng для перевода температуры из одной шкалы в другую.
// Необходимая функциональность:
//1.	Ввод температуры в поле ввода
//2.	Должна быть кнопка, которая переводит температуру из одной шкалы в другую
//3.	Результат перевода должен выводиться на форму, при этом быть не редактируемым
//4.	Можно задать из какой шкалы и в какую переводить
//5.	Доступные шкалы: цельсия, фаренгейта, кельвина
//6.	Если ввели не число, то нужно вывести ошибку
//7.	Обязательно использовать layout manager’ы
package ru.academit.temperature.main;

import ru.academit.temperature.model.Model;
import ru.academit.temperature.view.View;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            View view = new View();
            Model model = new Model();
        });
    }
}
