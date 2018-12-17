package ru.academit.temperature.model;

public class KelvinScale implements IScale {
    private final double ABSOLUTE_ZERO = -273.15;

    @Override
    public double toCelsius(double from) {
        double x = from + ABSOLUTE_ZERO;
        return Math.round(x * 100.0) / 100.0;
    }

    @Override
    public double fromCelsius(double celsius) {
        double x = celsius - ABSOLUTE_ZERO;
        return Math.round(x * 100.0) / 100.0;
    }

    @Override
    public String getName() {
        return "Kelvin";
    }
}
