package ru.academit.temperature.view;

import ru.academit.temperature.model.IScale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainPanel {
    private JPanel mainPanel;
    private IOPanel inputOutputPanel;
    private ScalePanel scalePanel;

    public MainPanel() {
        mainPanel = new JPanel(new GridBagLayout());
        JButton conversionButton = new JButton("convert");

        conversionButton.setOpaque(true);
        conversionButton.setBackground(Color.RED);
        GridBagConstraints c = new GridBagConstraints();
        mainPanel.setBackground(Color.LIGHT_GRAY);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridy = 1;
        c.ipady = 30;
        conversionButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));

        mainPanel.add(conversionButton, c);

        inputOutputPanel = new IOPanel();
        scalePanel = new ScalePanel(inputOutputPanel);

        mainPanel.add(inputOutputPanel.getInputOutputPanel());
        mainPanel.add(scalePanel.getScalePanel());

        conversionButton.addActionListener(new ConversionButtonListener());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public class ConversionButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isNumber(inputOutputPanel.getInputForm().getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Only numbers are permitted");
            } else {
                String inputFormText = inputOutputPanel.getInputForm().getText();
                double inputToDouble = Double.parseDouble(inputFormText);

                IScale currentScale = scalePanel.getChosenScale();
                ArrayList<IScale> scales = scalePanel.getScales();

                if (scalePanel.getCelsiusInput().isSelected() && !scalePanel.getCelsiusOutput().isSelected()) {
                    double valueConverted = currentScale.fromCelsius(inputToDouble);
                    setResult(valueConverted);
                } else if (scalePanel.getCelsiusOutput().isSelected() && !scalePanel.getCelsiusInput().isSelected()) {
                    double valueConverted = currentScale.toCelsius(inputToDouble);
                    setResult(valueConverted);
                } else if (scalePanel.getKelvinInput().isSelected() && scalePanel.getFahrenheitOutput().isSelected()) {
                    double valueToCelsius = scales.get(0).toCelsius(inputToDouble);
                    double valueConverted = scales.get(1).fromCelsius(valueToCelsius);
                    setResult(valueConverted);
                } else if (scalePanel.getFahrenheitInput().isSelected() && scalePanel.getKelvinOutput().isSelected()) {
                    double valueToCelsius = scales.get(1).toCelsius(inputToDouble);
                    double valueConverted = scales.get(0).fromCelsius(valueToCelsius);
                    setResult(valueConverted);
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Choose the different buttons FROM and TO to make a conversion");
                }
            }
        }

        private void setResult(double valueConverted) {
            String valueToString = String.valueOf(valueConverted);
            inputOutputPanel.getOutputForm().setText(valueToString);
        }
    }

    private static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
