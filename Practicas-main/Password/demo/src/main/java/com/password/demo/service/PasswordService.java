package com.password.demo.service;

import com.password.demo.model.Password;
import com.password.demo.repository.IPasswordRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasswordService implements ICRUD<Password, Integer>{

    @Autowired
    private IPasswordRepositorio passwordRepository ;

    public String generatePassword(int length, boolean mayus, boolean num, boolean simbls) throws Exception {
        String generatedPassword = Password.generatePassword(length, mayus, num, simbls);
        Password password = new Password(0,null);
        password.setContrasena(generatedPassword);
        password = guardar(password); // Almacenar la contraseña generada en la base de datos
        return password.getContrasena(); // Devolver la contraseña generada
    }

    @Override
    public List<Password> consultarTodos() throws Exception {
        return null;
    }

    @Override
    public Password consultarUno(Integer integer) throws Exception {
        return null;
    }

    @Override
    public Password guardar(Password p) throws Exception {
        return passwordRepository.save(p);
    }

    @Override
    public Password modificar(Password password) throws Exception {
        return null;
    }

    @Override
    public void eliminar(Integer integer) throws Exception {

    }

    @Override
    public Password insertar(Password password) throws Exception {
        return null;
    }

    public Optional<Password> obtenerPorId(int id) {
        return passwordRepository.findById(id);
    }
}