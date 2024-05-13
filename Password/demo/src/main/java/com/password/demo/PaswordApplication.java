package com.password.demo;

import com.password.demo.service.PasswordService;
import model.Password;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PaswordApplication {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);


		System.out.println("Longitud de la contraseña:");
		int length=scanner.nextInt();
		if (length>=8) {

			System.out.println("Incluir letras mayúsculas? (true/false):");
			boolean mayus = scanner.nextBoolean();

			System.out.println("Incluir dígitos? (true/false):");
			boolean num = scanner.nextBoolean();

			System.out.println("Incluir símbolos? (true/false):");
			boolean simbls = scanner.nextBoolean();
			PasswordService passwordService=new PasswordService();
			String password = passwordService.generatePassword(length, mayus,num,simbls);

			System.out.println("Contraseña generada: "+password);

		}else System.out.println("Introduce 8 caracteres minimo");

	}
}