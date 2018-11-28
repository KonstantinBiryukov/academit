package ru.academit.temperature.view;

import javax.swing.*;
import java.awt.*;

public class IOPanel {
    private JPanel IOPanel;
    private JLabel from;
    private JLabel to;
    private JTextField inputForm;
    private JLabel outputForm;

    public IOPanel() {
        inputForm = new JTextField("Input Temperature", 10);
        inputForm.addActionListener(e -> inputForm.setText(inputForm.getText()));
        outputForm = new JLabel("OUTPUT");

        from = new JLabel("From...");
        to = new JLabel("To...");
        IOPanel = new JPanel(new GridLayout(2, 2));
        IOPanel.setOpaque(true);
        IOPanel.setBackground(Color.CYAN);
        IOPanel.add(from);
        IOPanel.add(to);
        IOPanel.add(inputForm);
        IOPanel.add(outputForm);
    }

    public void setFrom(String text) {
        from.setText(text);
    }

    public void setTo(String text) {
        to.setText(text);
    }

    public JLabel getOutputForm() {
        return outputForm;
    }

    public JTextField getInputForm() {
        return inputForm;
    }

    public JPanel getIOPanel() {
        return IOPanel;
    }
}
