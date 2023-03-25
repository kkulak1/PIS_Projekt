package com.example.PIS_projekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PisProjektApplication {
	public static void main(String[] args) {
		SpringApplication.run(PisProjektApplication.class, args);
	}

	@GetMapping("/")
	public String firstTest() {
		return "First test";
	}
}
