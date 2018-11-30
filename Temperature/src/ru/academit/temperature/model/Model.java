package ru.academit.temperature.model;

public class Model {
    private final double ABSOLUTE_ZERO = -273.15;
    private final int FAHRENHEIT_VALUE = 32;

    public double convertFromCelsiusToKelvin(double c) {
        return c - ABSOLUTE_ZERO;
    }

    public double convertFromCelsiusToFahrenheit(double c) {
        return c * 9 / 5 + FAHRENHEIT_VALUE;
    }

    public double convertFromKelvinToCelsius(double k) {
        return k + ABSOLUTE_ZERO;
    }

    public double convertFromKelvinToFahrenheit(double k) {
        return 1.8 * (k + ABSOLUTE_ZERO) + FAHRENHEIT_VALUE;
    }

    public double convertFromFahrenheitToKelvin(double f) {
        double x = 5 * (f - FAHRENHEIT_VALUE) / 9 - ABSOLUTE_ZERO;
        return Math.round(x * 100.0) / 100.0;
    }

    public double convertFromFahrenheitToCelsius(double f) {
        double x = (f - FAHRENHEIT_VALUE) * 5 / 9;
        return Math.round(x * 100.0) / 100.0;
    }
}
