package ru.academit.temperature.model;

public class KelvinScale {
    private final double ABSOLUTE_ZERO = -273.15;

    public double convertFromKelvinToCelsius(double k) {
        double x = k + ABSOLUTE_ZERO;
        return Math.round(x * 100.0) / 100.0;
    }

    public double convertFromCelsiusToKelvin(double c) {
        double x = c - ABSOLUTE_ZERO;
        return Math.round(x * 100.0) / 100.0;
    }
}
