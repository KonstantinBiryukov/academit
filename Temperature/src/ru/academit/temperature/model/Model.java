package ru.academit.temperature.model;

import ru.academit.temperature.view.View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Model {
    private String temperatureConversion;
    private final double ABSOLUTE_ZERO = -273.15;
    private View view;

    public double convertFromCelsiusToKelvin(double C) {
        return C - ABSOLUTE_ZERO;
    }

    public double convertFromCelsiusToCelsius(double C) {
        return C;
    }

    public double convertFromCelsiusToFahrenheit(double C) {
        return C * (9 / 5) + 32;
    }

    public double convertFromKelvinToKelvin(double K) {
        return K;
    }

    public double convertFromKelvinToCelsius(double K) {
        return K + ABSOLUTE_ZERO;
    }

    public double convertFromKelvinToFahrenheit(double K) {
        return 1.8 * (K + ABSOLUTE_ZERO) + 32;
    }

    public double convertFromFahrenheitToKelvin(double F) {
        return 5 * (F - 32) / 9 - ABSOLUTE_ZERO;
    }

    public double convertFromFahrenheitToCelsius(double F) {
        return (F - 32) * (5 / 9);
    }

    public double convertFromFahrenheitToFahrenheit(double F) {
        return F;
    }


}
