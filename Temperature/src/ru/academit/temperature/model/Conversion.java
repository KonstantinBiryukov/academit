package ru.academit.temperature.model;

import ru.academit.temperature.view.IOPanel;
import ru.academit.temperature.view.ScalePanel;

public class Conversion {
    private IOPanel inputOutputPanel;

    public void convertTemperature(IOPanel inputOutputPanel, ScalePanel scalePanel) {
        this.inputOutputPanel = inputOutputPanel;
        double valueToBase = 0;
        for (int i = 0; i < scalePanel.getInputButtons().length; i++) {
            if (scalePanel.getInputButtons()[i].isSelected()) {
                String inputFormText = inputOutputPanel.getInputForm().getText();
                inputOutputPanel.getInputLabel().setText(inputFormText);
                double inputToDouble = Double.parseDouble(inputFormText);
                valueToBase = scalePanel.getScales().get(i).toCelsius(inputToDouble);
            }

            for (int j = 0; j < scalePanel.getOutputButtons().length; j++) {
                if (scalePanel.getInputButtons()[i].isSelected() && scalePanel.getOutputButtons()[j].isSelected()) {
                    double valueFromBase = scalePanel.getScales().get(j).fromCelsius(valueToBase);
                    setResult(valueFromBase);
                }
            }
        }
    }

    private void setResult(double valueFromBase) {
        String valueToString = String.valueOf(valueFromBase);
        inputOutputPanel.getOutputLabel().setText(valueToString);
    }
}