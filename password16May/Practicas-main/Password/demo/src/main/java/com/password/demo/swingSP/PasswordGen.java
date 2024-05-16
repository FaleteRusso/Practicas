package com.password.demo.swingSP;
import com.password.demo.model.Password;
import javax.swing.*;

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


    public static void main(String[] args) {
        JFrame frame = new JFrame("PasswordGen");
        frame.setContentPane(new PasswordGen().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(700,500);
        frame.setVisible(true);
    }
}
