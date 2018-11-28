//package ru.academit.temperature.model;
//
//import ru.academit.temperature.view.IOPanel;
//import ru.academit.temperature.view.ScalePanel;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class ConversionButtonListener implements ActionListener {
//    private IOPanel IOPanel;
//    private ScalePanel scalePanel;
//
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (scalePanel.getCelsiusInput().isSelected() && scalePanel.getKelvinOutput().isSelected()) {
//            String inputFormText = IOPanel.getInputForm().getText();
//            double sToDouble = Double.parseDouble(inputFormText);
//            Model model = new Model();
//            double sConvert = model.convertFromCelsiusToKelvin(sToDouble);
//            String sToString = String.valueOf(sConvert);
//            IOPanel.getOutputForm().setText(sToString);
//        } else if (scalePanel.getCelsiusInput().isSelected() && scalePanel.getCelsiusOutput().isSelected()) {
//            String inputFormText = IOPanel.getInputForm().getText();
//            double sToDouble = Double.parseDouble(inputFormText);
//            Model model = new Model();
//            double sConvert = model.convertFromCelsiusToCelsius(sToDouble);
//            String sToString = String.valueOf(sConvert);
//            IOPanel.getOutputForm().setText(sToString);
//        }
//    }
//}