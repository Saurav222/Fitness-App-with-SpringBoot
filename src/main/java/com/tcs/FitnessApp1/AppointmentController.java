package com.tcs.FitnessApp1;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {
	@Autowired
	private IAppointmentRepository appointmentRepository;

	@PostMapping("/placeAppointment")
	private void placeAppointment(@RequestBody @Valid Appointment appointment) {
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
	
	@DeleteMapping("/{id}")
	public void deleteAppointmentById(@PathVariable int id) {
		appointmentRepository.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	public void updateAppointment(@PathVariable("id") Integer id,@RequestBody @Valid Appointment app) {
		Optional<Appointment> appointment = appointmentRepository.findById(id);
		Appointment appFromDb = new Appointment();
		if(appointment.isPresent()) {
			appFromDb = appointment.get();
		}
		if(StringUtils.hasText(app.getTrainerpreference())) {
			appFromDb.setTrainerpreference(app.getTrainerpreference());
		}
		if(StringUtils.hasText(app.getUser_email())) {
			appFromDb.setUser_email(app.getUser_email());
		}
		if(StringUtils.hasText(app.getPhysiorequired())) {
			appFromDb.setPhysiorequired(app.getPhysiorequired());
		}
		if(StringUtils.hasLength(String.valueOf(app.getUser_mobno()))){
			appFromDb.setUser_mobno(app.getUser_mobno());
		}
		if(StringUtils.hasText(app.getNoofweeks().toString())) {
			appFromDb.setNoofweeks(app.getNoofweeks());
		}
		if(StringUtils.hasText(app.getPacakageselected().toString())) {
			appFromDb.setPacakageselected(app.getPacakageselected());
		}
		if(StringUtils.hasText(app.getUser_name())) {
			appFromDb.setUser_name(app.getUser_name());
		}
		appointmentRepository.save(appFromDb);
	}	
	 
	@ExceptionHandler(value = {AppointmentNotFoundException.class,EmptyResultDataAccessException.class})
	public ResponseEntity<Appointment> exception(RuntimeException runtimeException) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}