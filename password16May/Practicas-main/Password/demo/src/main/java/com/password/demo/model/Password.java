package com.password.demo.model;
import com.password.demo.model.Password;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.Random;

@Data
@AllArgsConstructor

public class Password {
    public class PasswordGenerator {
        private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
        private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final String DIGITS = "0123456789";
        private static final String SYMBOLS = "!@#$%^&*().;:-_+=^`]}{[";

        public String generatePassword(int length, boolean mayus, boolean num, boolean simbols, char specificChar, char specificCharEnd) {
            StringBuilder password = new StringBuilder();
            String caracteres = "abcdefghijklmnopqrstuvwxyz";

            if (mayus) {
                caracteres += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            }
            if (num) {
                caracteres += "0123456789";
            }
            if (simbols) {
                caracteres += "!@#$%^&*().;:-_+=^`]}{[";
            }

            java.util.Random random = new java.util.Random();

            if (specificChar != '\0') {
                password.append(specificChar);
            }

            for (int i = (specificChar != '\0') ? 1 : 0; i < length - 1; i++) {
                int index = random.nextInt(caracteres.length());
                password.append(caracteres.charAt(index));
            }

            if (specificCharEnd != '\0') {
                password.append(specificCharEnd);
            }

            return password.toString();
        }
    }
}