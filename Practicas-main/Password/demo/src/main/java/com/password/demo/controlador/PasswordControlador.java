package com.password.demo.controlador;


import com.password.demo.dto.PasswordDTO;
import com.password.demo.model.Password;
import com.password.demo.service.PasswordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passwords")
@CrossOrigin(origins = "http://localhost:4200")
public class PasswordControlador {

    @Autowired
    private PasswordService passwordService;




    @GetMapping("/{id}")
    public ResponseEntity<PasswordDTO> consultarPasswordPorId(@PathVariable("id") int id) {
        Optional<Password> passwordOptional = passwordService.obtenerPorId(id);
        if (passwordOptional.isPresent()) {
            Password password = passwordOptional.get();
            PasswordDTO passwordDTO = new PasswordDTO();
            passwordDTO.setIdPassword(password.getIdPassword());
            passwordDTO.setContrasena(password.getContrasena());
            return new ResponseEntity<>(passwordDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<PasswordDTO> crearPassword() throws Exception {
        int length = 12; // Longitud predeterminada para la contraseña generada
        boolean mayus = true; // Incluir caracteres en mayúsculas
        boolean num = true; // Incluir números
        boolean simbols = true; // Incluir símbolos

        String generatedPassword = passwordService.generatePassword(length, mayus, num, simbols);

        Password password = new Password(0,null);
        password.setContrasena(generatedPassword);
        password = passwordService.guardar(password);

        PasswordDTO passwordDTO = new PasswordDTO();
        passwordDTO.setIdPassword(password.getIdPassword());
        passwordDTO.setContrasena(password.getContrasena());

        return new ResponseEntity<>(passwordDTO, HttpStatus.CREATED);
    }


}