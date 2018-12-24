package ru.academit.temperature.model;

public class KelvinScale implements IScale {
    private final double ABSOLUTE_ZERO = -273.15;

    @Override
    public double toCelsius(double from) {
        return from + ABSOLUTE_ZERO;
    }

    @Override
    public double fromCelsius(double celsius) {
        return celsius - ABSOLUTE_ZERO;
    }

    @Override
    public String getName() {
        return "Kelvin";
    }
}
