package ar.edu.desapp.grupoa.builders;

import ar.edu.desapp.grupoa.user.Doctor;

public class DoctorBuilder {
	
	private String name = "no name";
	private String surname = "no surname";
	private Integer dni = 0;
	private String password = "no password";
	private Integer enrollment = 0;

	public static DoctorBuilder aDoctor() {
		return new DoctorBuilder();
	}
	
	public Doctor build() {
		Doctor doctor = new Doctor(this.name,
										this.surname,
										this.dni,
										this.password, 
										this.enrollment);
		return doctor;
	}
	
	public DoctorBuilder withName(final String name) {
		this.name = name;
		return this;
	}
	
	public DoctorBuilder withSurname(final String surname) {
		this.surname = surname;
		return this;
	}
	
	public DoctorBuilder withDNI(final Integer dni) {
		this.dni = dni;
		return this;
	}

	public DoctorBuilder withPassword(final String password) {
		this.password = password;
		return this;
	}
	
	public DoctorBuilder withEnrollment(final Integer enrollment) {
		this.enrollment = enrollment;
		return this;
	}
	
}
