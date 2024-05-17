package com.password.demo.swingSP;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

public class PasswordGen {
    private JPanel MainPanel;
    private JComboBox<Integer> SelLongitud;
    private JTextField indicioInicio;
    private JCheckBox Mayus;
    private JCheckBox Numeros;
    private JCheckBox Simbols;
    private JTextField indicioFinal;
    private JButton ButGenPassword;
    private JFormattedTextField Password;

    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*().;:-_+=^`]}{[";

    public PasswordGen() {
        // Crear un DefaultComboBoxModel<Integer> para asegurar que los valores son enteros
        DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>();
        for (int i = 8; i <= 20; i++) {
            model.addElement(i);
        }
        SelLongitud.setModel(model);

        // Añadir ActionListener al botón de generar contraseña
        ButGenPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePassword();
            }
        });
    }

    private void generatePassword() {
        StringBuilder charPool = new StringBuilder(LOWER);
        if (Mayus.isSelected()) {
            charPool.append(UPPER);
        }
        if (Numeros.isSelected()) {
            charPool.append(DIGITS);
        }
        if (Simbols.isSelected()) {
            charPool.append(SYMBOLS);
        }

        // Obtener la longitud seleccionada asegurándose de que es un Integer
        Integer length = (Integer) SelLongitud.getSelectedItem();
        if (length == null) {
            // Manejo del error si no se ha seleccionado una longitud válida
            throw new IllegalArgumentException("No se ha seleccionado una longitud válida");
        }

        String inicio = indicioInicio.getText();
        String fin = indicioFinal.getText();
        String generatedPassword = inicio + generateRandomString(charPool.toString(), length - inicio.length() - fin.length()) + fin;
        Password.setText(generatedPassword);
    }

    private String generateRandomString(String charPool, int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            result.append(charPool.charAt(random.nextInt(charPool.length())));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PasswordGen");
        frame.setContentPane(new PasswordGen().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(700, 500);
        frame.setVisible(true);
    }
}
