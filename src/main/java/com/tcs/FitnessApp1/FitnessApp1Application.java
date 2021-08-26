package com.tcs.fitnessapp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
public class FitnessApp1Application {
	private static final Logger logger = LoggerFactory.getLogger(FitnessApp1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(FitnessApp1Application.class, args);
	}

	@PostMapping("/placeAppointment")
	public void placeAppointment(@RequestBody Appointment appointment) {
		logger.debug("Appointment Placed");
	}
}
