package ru.academit.temperature.model;

public class KelvinScale {
    private final double ABSOLUTE_ZERO = -273.15;

    public double convertFromKelvinToCelsius(double k) {
        return k + ABSOLUTE_ZERO;
    }

    public double convertFromCelsiusToKelvin(double c) {
        return c - ABSOLUTE_ZERO;
    }
}
