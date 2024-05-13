package com.password.demo.service;

import model.Password;




public class PasswordService {

    public String generatePassword(int length, boolean mayus, boolean num, boolean simbls) {
        return Password.PasswordGenerator.generatePassword(length, mayus, num, simbls);
    }
}
