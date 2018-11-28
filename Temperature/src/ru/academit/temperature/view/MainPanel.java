package ru.academit.temperature.view;


import ru.academit.temperature.model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel {
    private JPanel panel;
    private JButton conversionButton;
    private IOPanel IOPanel;
    private ScalePanel scalePanel;
    private Model model;

    public MainPanel() {
        panel = new JPanel(new GridBagLayout());

        conversionButton = new JButton("convert");

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

//        else if (scalePanel.getCelsiusInput().isSelected() && scalePanel.getCelsiusOutput().isSelected()) {
//            conversionButton.addActionListener(new conversionButtonListener2());
//        }

//        conversionButton.addActionListener(e -> {
//            if (scalePanel.getCelsiusInput().isSelected() && scalePanel.getKelvinOutput().isSelected()) {
//                model = new Model();
//                String inputFormText = IOPanel.getInputForm().getText();
//                double sToDouble = Double.parseDouble(inputFormText);
//                double sConvert = model.convertFromCelsiusToKelvin(sToDouble);
//                String sToString = String.valueOf(sConvert);
//                IOPanel.getOutputForm().setText(sToString);
//            }
//        });


//        if (scalePanel.getCelsiusInput().isSelected() && scalePanel.getKelvinOutput().isSelected()) {
//           // conversionButton.addActionListener(new conversionButtonListener());
//            model = new Model();
//            IOPanel = new IOPanel();
//            String inputFormText = IOPanel.getInputForm().getText();
//            double sToDouble = Double.parseDouble(inputFormText);
//            double sConvert = model.convertFromCelsiusToKelvin(sToDouble);
//            String sToString = String.valueOf(sConvert);
//            IOPanel.getOutputForm().setText(sToString);
//
//        }
//        if (scalePanel.getCelsiusInput().isSelected() && scalePanel.getKelvinOutput().isSelected()) {
//            Model model = new Model();
//            String inputFormText = IOPanel.getInputForm().getText();
//            double sToDouble = Double.parseDouble(inputFormText);
//            double sConvert = model.convertFromCelsiusToKelvin(sToDouble);
//            String sToString = String.valueOf(sConvert);
//            IOPanel.getOutputForm().setText(sToString);
//        } else if (scalePanel.getCelsiusInput().isSelected() && scalePanel.getFahrenheitOutput().isSelected()) {
//            Model model = new Model();
//            String inputFormText = IOPanel.getInputForm().getText();
//            double sToDouble = Double.parseDouble(inputFormText);
//            double sConvert = model.convertFromCelsiusToFahrenheit(sToDouble);
//            String sToString = String.valueOf(sConvert);
//            IOPanel.getOutputForm().setText(sToString);
//        }


//        Events event = new Events();
//        conversionButton.addActionListener(event.convertListener());


//    public ActionListener convertListener() {
//        return e -> {
//            Model model = new Model();
//            IOPanel IOPanel = new IOPanel();
//            String inputFormText = IOPanel.getInputForm().getText();
//            // double sToDouble = getInputNumber();
//            double sToDouble = Double.parseDouble(inputFormText);
//            double sConvert = model.convertFromCelsiusToKelvin(sToDouble);
//            String sToString = String.valueOf(sConvert);
//            IOPanel.getOutputForm().setText(sToString);
//        };
//    }
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getConversionButton() {
        return conversionButton;
    }

    public class conversionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String inputFormText = IOPanel.getInputForm().getText();
            double inputToDouble = Double.parseDouble(inputFormText);

            if (scalePanel.getCelsiusInput().isSelected() && scalePanel.getCelsiusOutput().isSelected() ||
                    scalePanel.getKelvinInput().isSelected() && scalePanel.getKelvinOutput().isSelected() ||
                    scalePanel.getFahrenheitInput().isSelected() && scalePanel.getFahrenheitOutput().isSelected()) {
                model = new Model();
                IOPanel.getOutputForm().setText(inputFormText);
            } else if (scalePanel.getCelsiusInput().isSelected() && scalePanel.getKelvinOutput().isSelected()) {
                model = new Model();
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
            }
        }
    }
}

