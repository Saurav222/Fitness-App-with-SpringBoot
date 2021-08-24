package com.tcs.FitnessApp1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {
	@Autowired
	private AppointmentRepository appointmentRepository;

	@PostMapping("/placeAppointment")
	private void placeAppointment(@RequestBody Appointment appointment) {
		appointmentRepository.save(appointment);
	}

	@GetMapping("/getAllAppointments")
	private List<Appointment> getAllAppointments() {
		return (List<Appointment>) appointmentRepository.findAll();

	}

	@GetMapping("getAppointment/{id}")
	private Optional<Appointment> getAppointmentById(@PathVariable int id) {
		return appointmentRepository.findById(id);
	}

}