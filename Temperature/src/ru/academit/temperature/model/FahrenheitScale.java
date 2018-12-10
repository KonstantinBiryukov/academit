package ru.academit.temperature.model;

public class FahrenheitScale implements IScale {
    private final int FAHRENHEIT_VALUE = 32;

    @Override
    public double toCelsius(double from) {
        double x = (from - FAHRENHEIT_VALUE) * 5.0 / 9;
        return Math.round(x * 100.0) / 100.0;
    }

    @Override
    public double fromCelsius(double celsius) {
        double x = celsius * 9.0 / 5 + FAHRENHEIT_VALUE;
        return Math.round(x * 100.0) / 100.0;
    }
}
