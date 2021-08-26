package com.tcs.FitnessApp1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
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

	public Integer getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(Integer appointment_id) {
		this.appointment_id = appointment_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public long getUser_mobno() {
		return user_mobno;
	}

	public void setUser_mobno(long user_mobno) {
		this.user_mobno = user_mobno;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getTrainerpreference() {
		return trainerpreference;
	}

	public void setTrainerpreference(String trainerpreference) {
		this.trainerpreference = trainerpreference;
	}

	public Integer getNoofweeks() {
		return noofweeks;
	}

	public void setNoofweeks(Integer noofweeks) {
		this.noofweeks = noofweeks;
	}

	public Integer getPacakageselected() {
		return pacakageselected;
	}

	public void setPacakageselected(Integer pacakageselected) {
		this.pacakageselected = pacakageselected;
	}

	public String isPhysiorequired() {
		return physiorequired;
	}

	public void setPhysiorequired(String physiorequired) {
		this.physiorequired = physiorequired;
	}

	public String getPhysiorequired() {
		return physiorequired;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentID=" + appointment_id + ", trainerpreference=" + trainerpreference
				+ ", physioRequired=" + physiorequired + ", packageName=" + pacakageselected + ", username=" + user_name
				+ ", user_Email=" + user_email + "]";
	}
}