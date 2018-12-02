package ru.academit.temperature.model;

public class FahrenheitScale {
    private final int FAHRENHEIT_VALUE = 32;

    public double convertFromFahrenheitToCelsius(double f) {
        double x = (f - FAHRENHEIT_VALUE) * 5.0 / 9;
        return Math.round(x * 100.0) / 100.0;
    }

    public double convertFromCelsiusToFahrenheit(double c) {
        double x = c * 9.0 / 5 + FAHRENHEIT_VALUE;
        return Math.round(x * 100.0) / 100.0;
    }
}
