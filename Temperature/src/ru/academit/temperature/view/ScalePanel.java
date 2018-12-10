package ru.academit.temperature.view;

import ru.academit.temperature.model.FahrenheitScale;
import ru.academit.temperature.model.IScale;
import ru.academit.temperature.model.KelvinScale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class ScalePanel {
    private JPanel scalePanel;

    private JRadioButton celsiusInput;
    private JRadioButton kelvinInput;
    private JRadioButton fahrenheitInput;

    private JRadioButton celsiusOutput;
    private JRadioButton kelvinOutput;
    private JRadioButton fahrenheitOutput;

    private IScale iScale;
    private ArrayList<IScale> scales;

    public ScalePanel(IOPanel inputOutputPanel) {
        celsiusInput = new JRadioButton("From Celsius");
        kelvinInput = new JRadioButton("From Kelvin");
        fahrenheitInput = new JRadioButton("From Fahrenheit");
        ButtonGroup inputGroup = new ButtonGroup();
        inputGroup.add(celsiusInput);
        inputGroup.add(kelvinInput);
        inputGroup.add(fahrenheitInput);

        celsiusOutput = new JRadioButton("To Celsius");
        kelvinOutput = new JRadioButton("To Kelvin");
        fahrenheitOutput = new JRadioButton("To Fahrenheit");
        ButtonGroup outputGroup = new ButtonGroup();
        outputGroup.add(celsiusOutput);
        outputGroup.add(kelvinOutput);
        outputGroup.add(fahrenheitOutput);

        kelvinInput.addActionListener(new ScaleListener());
        kelvinOutput.addActionListener(new ScaleListener());
        fahrenheitInput.addActionListener(new ScaleListener());
        fahrenheitOutput.addActionListener(new ScaleListener());
        celsiusInput.addActionListener(new ScaleListener());
        celsiusOutput.addActionListener(new ScaleListener());

        celsiusInput.addActionListener(e -> inputOutputPanel.setFrom("From Celsius"));
        kelvinInput.addActionListener(e -> inputOutputPanel.setFrom("From Kelvin"));
        fahrenheitInput.addActionListener(e -> inputOutputPanel.setFrom("From Fahrenheit"));

        celsiusOutput.addActionListener(e -> inputOutputPanel.setTo("To Celsius"));
        kelvinOutput.addActionListener(e -> inputOutputPanel.setTo("To Kelvin"));
        fahrenheitOutput.addActionListener(e -> inputOutputPanel.setTo("To Fahrenheit"));

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

    public class ScaleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() != celsiusInput && e.getSource() != celsiusOutput) {
                scales = new ArrayList<>(Arrays.asList(new KelvinScale(), new FahrenheitScale()));
            }
            if (e.getSource() == kelvinInput || e.getSource() == kelvinOutput) {
                iScale = new KelvinScale();
            } else if (e.getSource() == fahrenheitInput || e.getSource() == fahrenheitOutput) {
                iScale = new FahrenheitScale();
            }
        }
    }

    public IScale getChosenScale() {
        return iScale;
    }

    public ArrayList<IScale> getScales() {
        return scales;
    }
}