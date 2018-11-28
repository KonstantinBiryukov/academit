package ru.academit.temperature.view;

import ru.academit.temperature.model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel {
    private JPanel panel;
    private IOPanel IOPanel;
    private ScalePanel scalePanel;

    public MainPanel() {
        panel = new JPanel(new GridBagLayout());
        JButton conversionButton = new JButton("convert");

        conversionButton.setOpaque(true);
        conversionButton.setBackground(Color.RED);
        GridBagConstraints c = new GridBagConstraints();
        panel.setBackground(Color.LIGHT_GRAY);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridy = 1;
        c.ipady = 30;
        conversionButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));

        panel.add(conversionButton, c);

        IOPanel = new IOPanel();
        scalePanel = new ScalePanel(IOPanel);

        panel.add(IOPanel.getIOPanel());
        panel.add(scalePanel.getScalePanel());

        conversionButton.addActionListener(new conversionButtonListener());
    }

    public JPanel getPanel() {
        return panel;
    }

    public class conversionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (!isInteger(IOPanel.getInputForm().getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Only numbers are permitted");
            } else {
                String inputFormText = IOPanel.getInputForm().getText();
                double inputToDouble = Double.parseDouble(inputFormText);
                Model model = new Model();

                if (scalePanel.getCelsiusInput().isSelected() && scalePanel.getCelsiusOutput().isSelected() ||
                        scalePanel.getKelvinInput().isSelected() && scalePanel.getKelvinOutput().isSelected() ||
                        scalePanel.getFahrenheitInput().isSelected() && scalePanel.getFahrenheitOutput().isSelected()) {
                    IOPanel.getOutputForm().setText(inputFormText);
                } else if (scalePanel.getCelsiusInput().isSelected() && scalePanel.getKelvinOutput().isSelected()) {
                    double sConvert = model.convertFromCelsiusToKelvin(inputToDouble);
                    String sToString = String.valueOf(sConvert);
                    IOPanel.getOutputForm().setText(sToString);
                } else if (scalePanel.getCelsiusInput().isSelected() && scalePanel.getFahrenheitOutput().isSelected()) {
                    double sConvert = model.convertFromCelsiusToFahrenheit(inputToDouble);
                    String sToString = String.valueOf(sConvert);
                    IOPanel.getOutputForm().setText(sToString);
                } else if (scalePanel.getKelvinInput().isSelected() && scalePanel.getCelsiusOutput().isSelected()) {
                    double sConvert = model.convertFromKelvinToCelsius(inputToDouble);
                    String sToString = String.valueOf(sConvert);
                    IOPanel.getOutputForm().setText(sToString);
                } else if (scalePanel.getKelvinInput().isSelected() && scalePanel.getFahrenheitOutput().isSelected()) {
                    double sConvert = model.convertFromKelvinToFahrenheit(inputToDouble);
                    String sToString = String.valueOf(sConvert);
                    IOPanel.getOutputForm().setText(sToString);
                } else if (scalePanel.getFahrenheitInput().isSelected() && scalePanel.getCelsiusOutput().isSelected()) {
                    double sConvert = model.convertFromFahrenheitToCelsius(inputToDouble);
                    String sToString = String.valueOf(sConvert);
                    IOPanel.getOutputForm().setText(sToString);
                } else if (scalePanel.getFahrenheitInput().isSelected() && scalePanel.getKelvinOutput().isSelected()) {
                    double sConvert = model.convertFromFahrenheitToKelvin(inputToDouble);
                    String sToString = String.valueOf(sConvert);
                    IOPanel.getOutputForm().setText(sToString);
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Choose the button FROM and TO to make a conversion");
                }
            }
        }
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}