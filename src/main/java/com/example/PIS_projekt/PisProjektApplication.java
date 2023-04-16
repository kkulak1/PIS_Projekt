package com.example.PIS_projekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@EnableDiscoveryClient
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
