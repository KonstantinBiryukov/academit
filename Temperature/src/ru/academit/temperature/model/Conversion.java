package ru.academit.temperature.model;


public class Conversion {

    public double convertTemperature(IScale inputScale, IScale outputScale, String temperature) {
        double inputToDouble = Double.parseDouble(temperature);
        double valueToBase = inputScale.toCelsius(inputToDouble);
        return outputScale.fromCelsius(valueToBase); // value from base
    }
}