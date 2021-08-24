package com.tcs.FitnessApp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
public class FitnessApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(FitnessApp1Application.class, args);
	}

	@PostMapping("/placeAppointment")
	public void placeAppointment(@RequestBody Appointment appointment) {
		System.out.println("Appointment Placed");
	}
}
