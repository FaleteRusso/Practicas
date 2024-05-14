package com.password.demo.dto;

import com.password.demo.model.Password;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordDTO {
    private int idPassword;

    @Size(min = 8,max = 16)
    private String contrasena;

    public Password castPassword(){
        Password p1 = new Password(0,null);
        p1.setIdPassword(idPassword);
        p1.setContrasena(contrasena);
        return p1;
    }
    public PasswordDTO castPasswordADto(Password p){
        idPassword=getIdPassword();
        contrasena=p.getContrasena();
        return this;
    }
}
