package com.tcs.fitnessapp1;

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
	private Integer appointmentId;

	@NotBlank(message = "Username name cannot be blank")
	private String userName;
	
	private long userMobNo;

	@NotBlank(message = "Email cannot be blank")
	@Email(message = "enter valid email")
	private String userEmail;

	@NotBlank(message = "trainerpreference cannot be blank")
	private String trainerPreference;

	private Integer noOfWeeks;

	private Integer pacakageSelected;

	private String physioRequired;

	@Override
	public String toString() {
		return "Appointment [appointmentID=" + appointmentId + ", trainerpreference=" + trainerPreference
				+ ", physioRequired=" + physioRequired + ", packageName=" + pacakageSelected + ", username=" + userName
				+ ", user_Email=" + userEmail + "]";
	}
}