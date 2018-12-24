package ru.academit.temperature.model;

public class FahrenheitScale implements IScale {
    private final int FAHRENHEIT_VALUE = 32;

    @Override
    public double toCelsius(double from) {
        return (from - FAHRENHEIT_VALUE) * 5.0 / 9;
    }

    @Override
    public double fromCelsius(double celsius) {
        return celsius * 9.0 / 5 + FAHRENHEIT_VALUE;
    }

    @Override
    public String getName() {
        return "Fahrenheit";
    }
}