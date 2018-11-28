package ru.academit.temperature.view;

import javax.swing.*;
import java.awt.*;

public class ScalePanel {
    private JPanel scalePanel;
    private IOPanel IOPanel;

    private JRadioButton celsiusInput;
    private JRadioButton kelvinInput;
    private JRadioButton fahrenheitInput;
    private ButtonGroup inputGroup;

    private JRadioButton celsiusOutput;
    private JRadioButton kelvinOutput;
    private JRadioButton fahrenheitOutput;
    private ButtonGroup outputGroup;

    public ScalePanel(IOPanel IOPanel) {
        this.IOPanel = IOPanel;
        celsiusInput = new JRadioButton("From Celsius");
        kelvinInput = new JRadioButton("From Kelvin");
        fahrenheitInput = new JRadioButton("From Fahrenheit");
        inputGroup = new ButtonGroup();
        inputGroup.add(celsiusInput);
        inputGroup.add(kelvinInput);
        inputGroup.add(fahrenheitInput);

        celsiusOutput = new JRadioButton("To Celsius");
        kelvinOutput = new JRadioButton("To Kelvin");
        fahrenheitOutput = new JRadioButton("To Fahrenheit");
        outputGroup = new ButtonGroup();
        outputGroup.add(celsiusOutput);
        outputGroup.add(kelvinOutput);
        outputGroup.add(fahrenheitOutput);

        celsiusInput.addActionListener(e -> IOPanel.setFrom("From Celsius"));
        kelvinInput.addActionListener(e -> IOPanel.setFrom("From Kelvin"));
        fahrenheitInput.addActionListener(e -> IOPanel.setFrom("From Fahrenheit"));

        celsiusOutput.addActionListener(e -> IOPanel.setTo("To Celsius"));
        kelvinOutput.addActionListener(e -> IOPanel.setTo("To Kelvin"));
        fahrenheitOutput.addActionListener(e -> IOPanel.setTo("To Fahrenheit"));

        scalePanel = new JPanel(new GridLayout(3, 3));
        scalePanel.add(celsiusInput);
        scalePanel.add(celsiusOutput);
        scalePanel.add(kelvinInput);
        scalePanel.add(kelvinOutput);
        scalePanel.add(fahrenheitInput);
        scalePanel.add(fahrenheitOutput);
        scalePanel.setOpaque(true);
        scalePanel.setBackground(Color.ORANGE);
    }

    public JPanel getScalePanel() {
        return scalePanel;
    }

    public JRadioButton getCelsiusInput() {
        return celsiusInput;
    }

    public JRadioButton getFahrenheitInput() {
        return fahrenheitInput;
    }

    public JRadioButton getKelvinInput() {
        return kelvinInput;
    }

    public JRadioButton getCelsiusOutput() {
        return celsiusOutput;
    }

    public JRadioButton getFahrenheitOutput() {
        return fahrenheitOutput;
    }

    public JRadioButton getKelvinOutput() {
        return kelvinOutput;
    }
}