package ru.academit.temperature.model;
public class Model {
    private final double ABSOLUTE_ZERO = -273.15;
    private final int FAHRENHEIT_VALUE = 32;

    public double convertFromCelsiusToKelvin(double C) {
        return C - ABSOLUTE_ZERO;
    }

    public double convertFromCelsiusToFahrenheit(double C) {
        return C * (9 / 5) + FAHRENHEIT_VALUE;
    }

    public double convertFromKelvinToCelsius(double K) {
        return K + ABSOLUTE_ZERO;
    }

    public double convertFromKelvinToFahrenheit(double K) {
        return 1.8 * (K + ABSOLUTE_ZERO) + FAHRENHEIT_VALUE;
    }

    public double convertFromFahrenheitToKelvin(double F) {
        return 5 * (F - FAHRENHEIT_VALUE) / 9 - ABSOLUTE_ZERO;
    }

    public double convertFromFahrenheitToCelsius(double F) {
        return (F - FAHRENHEIT_VALUE) * (5 / 9);
    }
}

