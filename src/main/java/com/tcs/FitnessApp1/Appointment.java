package com.tcs.FitnessApp1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointment_id;

	@NotBlank(message = "Username name cannot be blank")
	private String user_name;
	
	private long user_mobno;

	@NotBlank(message = "Email cannot be blank")
	@Email(message = "enter valid email")
	private String user_email;

	@NotBlank(message = "trainerpreference cannot be blank")
	private String trainerpreference;

	private Integer noofweeks;

	private Integer pacakageselected;

	private String physiorequired;

	@Override
	public String toString() {
		return "Appointment [appointmentID=" + appointment_id + ", trainerpreference=" + trainerpreference
				+ ", physioRequired=" + physiorequired + ", packageName=" + pacakageselected + ", username=" + user_name
				+ ", user_Email=" + user_email + "]";
	}
}