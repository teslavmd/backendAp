package com.backend.backendAp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BackendApApplication {



	public static void main(String[] args) {
		SpringApplication.run(BackendApApplication.class, args);

		System.out.println(new BCryptPasswordEncoder().encode("matias"));
	}

}
