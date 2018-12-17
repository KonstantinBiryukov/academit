package ru.academit.temperature.model;

public interface IScale {

    double toCelsius(double from);
    double fromCelsius(double celsius);
    String getName();
}
