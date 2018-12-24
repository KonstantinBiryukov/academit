package ru.academit.temperature.model;

public class Conversion {
    public double convertTemperature(IScale inputScale, IScale outputScale, double temperature) {
        double valueToBase = inputScale.toCelsius(temperature);
        return outputScale.fromCelsius(valueToBase); // value from base
    }
}