package ru.academit.temperature.model;

public class CelsiusScale implements IScale {
    @Override
    public double toCelsius(double from) {
        return from;
    }

    @Override
    public double fromCelsius(double celsius) {
        return celsius;
    }

    @Override
    public String getName() {
        return "Celsius";
    }
}
