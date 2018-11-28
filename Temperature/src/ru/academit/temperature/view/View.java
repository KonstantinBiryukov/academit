package ru.academit.temperature.view;

import ru.academit.temperature.model.Model;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame;
    //    private int width;
//    private int height;
//    private JLabel from;
//    private JLabel to;
    private Model model;
//    private JTextField inputForm;
//    private JLabel outputForm;
    private JPanel panel;

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

//    private double getInputNumber() {
//        String inputFormText = inputForm.getText();
//        return Double.parseDouble(inputFormText);
//    }

    public View() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Frame frame = new Frame();
        this.frame = frame.getFrame();

//        frame = new JFrame("Temperature Conversion");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        width = (int) (screenSize.width * 0.5);
//        height = (int) (screenSize.height * 0.5);
//        frame.setSize(width, height);

        // JPanel with all buttons
      //  JPanel panel = new JPanel(new GridBagLayout());

        // conversionButton
//        JButton conversionButton = new JButton("convert");
//
//        conversionButton.setOpaque(true);
//        conversionButton.setBackground(Color.RED);
//        GridBagConstraints c = new GridBagConstraints();
//        panel.setBackground(Color.LIGHT_GRAY);
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.gridwidth = 3;
//        c.gridy = 1;
//        c.ipady = 30;
//        conversionButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
//
//        panel.add(conversionButton, c);
       // frame.add(panel);

        // text fields InputTemperature
//        inputForm = new JTextField("Input Temperature", 10);
//        String s = inputForm.getText();
//        inputForm.addActionListener(e -> inputForm.setText(inputForm.getText()));
//        outputForm = new JLabel("OUTPUT");
//
//        from = new JLabel("From Celsius");
//        to = new JLabel("To Kelvin");

//        JRadioButton celsiusInput = new JRadioButton("From Celsius");
//        JRadioButton kelvinInput = new JRadioButton("From Kelvin");
//        JRadioButton fahrenheitInput = new JRadioButton("From Fahrenheit");
//        ButtonGroup inputGroup = new ButtonGroup();
//        inputGroup.add(celsiusInput);
//        inputGroup.add(kelvinInput);
//        inputGroup.add(fahrenheitInput);
//
//        JRadioButton celsiusOutput = new JRadioButton("To Celsius");
//        JRadioButton kelvinOutput = new JRadioButton("To Kelvin");
//        JRadioButton fahrenheitOutput = new JRadioButton("To Fahrenheit");
//        ButtonGroup outputGroup = new ButtonGroup();
//        outputGroup.add(celsiusOutput);
//        outputGroup.add(kelvinOutput);
//        outputGroup.add(fahrenheitOutput);

        JPanel scalePanel = new JPanel(new GridLayout(3, 3));

//        scalePanel.add(celsiusInput);
//        scalePanel.add(celsiusOutput);
//        scalePanel.add(kelvinInput);
//        scalePanel.add(kelvinOutput);
//        scalePanel.add(fahrenheitInput);
//        scalePanel.add(fahrenheitOutput);
//        scalePanel.setOpaque(true);
//        scalePanel.setBackground(Color.ORANGE);

//        celsiusInput.addActionListener(e -> from.setText("From Celsius"));
//        kelvinInput.addActionListener(e -> from.setText("From Kelvin"));
//        fahrenheitInput.addActionListener(e -> from.setText("From Fahrenheit"));
//
//        celsiusOutput.addActionListener(e -> to.setText("To Celsius"));
//        kelvinOutput.addActionListener(e -> to.setText("To Kelvin"));
//        fahrenheitOutput.addActionListener(e -> to.setText("To Fahrenheit"));
//
        Model model = new Model();

//        conversionButton.addActionListener(e -> {
//            if (celsiusInput.isSelected() && kelvinOutput.isSelected()) {
//                double sToDouble = getInputNumber();
//                double sConvert = model.convertFromCelsiusToKelvin(sToDouble);
//                String sToString = String.valueOf(sConvert);
//                outputForm.setText(sToString);
//            } else if (kelvinInput.isSelected() && fahrenheitOutput.isSelected()) {
//                double sToDouble = getInputNumber();
//                double sConvert = model.convertFromKelvinToFahrenheit(sToDouble);
//                String sToString = String.valueOf(sConvert);
//                outputForm.setText(sToString);
//            }
//        });

//        JPanel IOPanel = new JPanel(new GridLayout(2, 2));
//        IOPanel.setOpaque(true);
//        IOPanel.setBackground(Color.CYAN);
//        IOPanel.add(from);
//        IOPanel.add(to);
//        IOPanel.add(inputForm);
//        IOPanel.add(outputForm);

//        panel.add(IOPanel);
//        panel.add(scalePanel);
    }



    public JPanel getPanel() {
        return panel;
    }
}
