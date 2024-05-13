package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Password {
    public class PasswordGenerator {
        private static final String LOWER="abcdefghijklmnopqrstuvwxyz";
        private static final String UPPER="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final String DIGITS="0123456789";
        private static final String SYMBOLS="!@#$%^&*().;:-_+=";

        public static String generatePassword(int length, boolean mayus, boolean num, boolean simbols) {
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
                int index=(int) (Math.random() * caracteres.length());
                password.append(caracteres.charAt(index));
            }
            return password.toString();
        }
    }
}