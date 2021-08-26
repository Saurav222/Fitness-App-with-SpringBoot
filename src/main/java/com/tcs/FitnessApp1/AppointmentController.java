package com.tcs.fitnessapp1;

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
	public IAppointmentRepository appointmentRepository;

	@PostMapping("/placeAppointment")
	public void placeAppointment(@RequestBody @Valid Appointment appointment) {
		appointmentRepository.save(appointment);
	}

	@GetMapping("/getAllAppointments")
	public List<Appointment> getAllAppointments() {
		return (List<Appointment>) appointmentRepository.findAll();

	}

	@GetMapping("getAppointment/{id}")
	public Optional<Appointment> getAppointmentById(@PathVariable int id) {
		return appointmentRepository.findById(id);
	}
	
	@DeleteMapping("delete/{id}")
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
		if(StringUtils.hasText(app.getTrainerPreference())) {
			appFromDb.setTrainerPreference(app.getTrainerPreference());
		}
		if(StringUtils.hasText(app.getUserEmail())) {
			appFromDb.setUserEmail(app.getUserEmail());
		}
		if(StringUtils.hasText(app.getPhysioRequired())) {
			appFromDb.setPhysioRequired(app.getPhysioRequired());
		}
		if(StringUtils.hasLength(String.valueOf(app.getUserMobNo()))){
			appFromDb.setUserMobNo(app.getUserMobNo());
		}
		if(StringUtils.hasText(app.getNoOfWeeks().toString())) {
			appFromDb.setNoOfWeeks(app.getNoOfWeeks());
		}
		if(StringUtils.hasText(app.getPacakageSelected().toString())) {
			appFromDb.setPacakageSelected(app.getPacakageSelected());
		}
		if(StringUtils.hasText(app.getUserName())) {
			appFromDb.setUserName(app.getUserName());
		}
		appointmentRepository.save(appFromDb);
	}	
	 
	@ExceptionHandler(value = {AppointmentNotFoundException.class,EmptyResultDataAccessException.class})
	public ResponseEntity<Appointment> exception(RuntimeException runtimeException) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}