package ru.academit.temperature.view;

import ru.academit.temperature.model.Conversion;
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
    private ArrayList<IScale> chosenScales;
    private String inputFormText;
    private Conversion conversion = new Conversion();

    public MainPanel(ArrayList<IScale> scales) {
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
        scalePanel = new ScalePanel(inputOutputPanel, scales);

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
                inputOutputPanel.getInputForm().setText(null);
            } else {
                chooseScale();
                String temperature = conversion.convertTemperature(chosenScales, inputFormText);
                inputOutputPanel.getOutputLabel().setText(temperature);
            }
        }
    }

    private void chooseScale() {
        chosenScales = new ArrayList<>(2);
        for (int i = 0; i < scalePanel.getInputButtons().length; i++) {
            if (scalePanel.getInputButtons()[i].isSelected()) {
                chosenScales.add(scalePanel.getScales().get(i));
                inputFormText = inputOutputPanel.getInputForm().getText();
                inputOutputPanel.getInputLabel().setText(inputFormText);
            }

            for (int j = 0; j < scalePanel.getOutputButtons().length; j++) {
                if (scalePanel.getInputButtons()[i].isSelected() && scalePanel.getOutputButtons()[j].isSelected()) {
                    chosenScales.add(scalePanel.getScales().get(j));
                }
            }
        }
    }

    public String getTemperature() {
        return inputFormText;
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