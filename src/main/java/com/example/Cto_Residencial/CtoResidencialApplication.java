package com.example.Cto_Residencial;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CtoResidencialApplication {

	public static void main(String[] args) {
		LoadEnv();
		SpringApplication.run(CtoResidencialApplication.class, args);
	}

	private static void LoadEnv() {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_URL"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_URL"));
	}

}
