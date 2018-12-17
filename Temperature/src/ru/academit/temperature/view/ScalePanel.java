package ru.academit.temperature.view;

import ru.academit.temperature.model.IScale;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScalePanel {
    private JPanel scalePanel;
    private ArrayList<IScale> scales;
    private JRadioButton[] inputButtons;
    private JRadioButton[] outputButtons;
    private ButtonGroup inputGroup;
    private ButtonGroup outputGroup;

    public ScalePanel(IOPanel inputOutputPanel, ArrayList<IScale> scales) {
        this.scales = scales;
        inputButtons = makeButton(scales);
        outputButtons = makeButton(scales);

        inputGroup = new ButtonGroup();
        fillButtonGroup(inputGroup, inputButtons);

        outputGroup = new ButtonGroup();
        fillButtonGroup(outputGroup, outputButtons);

        scalePanel = new JPanel(new GridLayout(3, 3));
        fillScalePanel(inputButtons, outputButtons);

        scalePanel.setOpaque(true);
        scalePanel.setBackground(Color.ORANGE);

        inputButtons[0].setSelected(true);
        outputButtons[1].setSelected(true);
        inputOutputPanel.setFrom("From " + scales.get(0).getName());
        inputOutputPanel.setTo("To " + scales.get(1).getName());

        addTextListener(inputOutputPanel, inputButtons, inputGroup);
        addTextListener(inputOutputPanel, outputButtons, outputGroup);
    }

    public JPanel getScalePanel() {
        return scalePanel;
    }

    public ArrayList<IScale> getScales() {
        return scales;
    }

    public JRadioButton[] getInputButtons() {
        return inputButtons;
    }

    public JRadioButton[] getOutputButtons() {
        return outputButtons;
    }

    private JRadioButton[] makeButton(ArrayList<IScale> scales) {
        JRadioButton[] buttons = new JRadioButton[scales.size()];
        for (int i = 0; i < scales.size(); i++) {
            String s = scales.get(i).getName();
            buttons[i] = new JRadioButton(s);
        }
        return buttons;
    }

    private void fillButtonGroup(ButtonGroup buttonGroup, JRadioButton[] buttonsArray) {
        for (JRadioButton button : buttonsArray) {
            buttonGroup.add(button);
        }
    }

    private void fillScalePanel(JRadioButton[] inputButtons, JRadioButton[] outputButtons) {
        for (int i = 0; i < inputButtons.length; i++) {
            scalePanel.add(inputButtons[i]);
            scalePanel.add(outputButtons[i]);
        }
    }

    public void addTextListener(IOPanel inputOutputPanel, JRadioButton[] buttonsArray, ButtonGroup buttonGroup) {
        for (int i = 0; i < buttonsArray.length; i++) {
            for (int j = 0; j < scales.size(); j++) {
                String s = buttonsArray[i].getText();
                if (buttonGroup == inputGroup) {
                    buttonsArray[i].addActionListener(e -> inputOutputPanel.setFrom("From " + s));
                } else {
                    buttonsArray[i].addActionListener(e -> inputOutputPanel.setTo("To " + s));
                }
            }
        }
    }
}