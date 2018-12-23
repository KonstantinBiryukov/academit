package ru.academit.temperature.model;

import java.util.ArrayList;

public class Conversion {

    public String convertTemperature(ArrayList<IScale> scales, String temperature) {
        double inputToDouble = Double.parseDouble(temperature);
        double valueToBase = scales.get(0).toCelsius(inputToDouble);
        double valueFromBase = scales.get(1).fromCelsius(valueToBase);
        return String.valueOf(valueFromBase);
    }
}