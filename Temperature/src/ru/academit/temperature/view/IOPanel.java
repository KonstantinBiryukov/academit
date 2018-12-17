package ru.academit.temperature.view;

import javax.swing.*;
import java.awt.*;

public class IOPanel {
    private JPanel inputOutputPanel;
    private JLabel from;
    private JLabel to;
    private JTextField inputForm;
    private JLabel outputLabel;
    private JLabel inputLabel;

    public IOPanel() {
        JLabel inputTemperature = new JLabel("Input temperature");
        inputForm = new JTextField(10);
        inputLabel = new JLabel("INPUT");
        inputForm.addActionListener(e -> {
            inputForm.setText(inputForm.getText());
            inputLabel.setText(inputForm.getText());
        });
        outputLabel = new JLabel("OUTPUT");

        from = new JLabel("From...");
        to = new JLabel("To...");
        inputOutputPanel = new JPanel(new GridLayout(3, 2));
        inputOutputPanel.setOpaque(true);
        inputOutputPanel.setBackground(Color.CYAN);

        inputOutputPanel.add(inputTemperature);
        inputOutputPanel.add(inputForm);

        inputOutputPanel.add(from);
        inputOutputPanel.add(to);
        inputOutputPanel.add(inputLabel);
        inputOutputPanel.add(outputLabel);
    }

    public void setFrom(String text) {
        from.setText(text);
    }

    public void setTo(String text) {
        to.setText(text);
    }

    public JLabel getOutputLabel() {
        return outputLabel;
    }

    public JLabel getInputLabel() {
        return inputLabel;
    }

    public JTextField getInputForm() {
        return inputForm;
    }

    public JPanel getInputOutputPanel() {
        return inputOutputPanel;
    }
}
