package com.password.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "passwords")
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPassword;
    @Column
    String contrasena;

        public static String generatePassword(int length, boolean mayus, boolean num, boolean simbols) {
            final String LOWER="abcdefghijklmnopqrstuvwxyz";
            final String UPPER="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            final String DIGITS="0123456789";
            final String SYMBOLS="!@#$%^&*().;:-_+=";
            StringBuilder password = new StringBuilder();
            String caracteres=LOWER;


            if (mayus) {
                caracteres+=UPPER;
            }
            if (num) {
                caracteres+=DIGITS;
            }
            if (simbols) {
                caracteres+=SYMBOLS;
            }
            for (int i=0; i<length; i++) {
                int index = (int) (Math.random() * caracteres.length());
                password.append(caracteres.charAt(index));
            }
                boolean exists = true;

                if (!exists) {
                    return password.toString();
            }
            return password.toString();
        }
    }

