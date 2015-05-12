package ar.edu.desapp.groupa.model.builders;

import ar.edu.desapp.groupa.model.user.Patient;

public class PatientBuilder {
	
	private String name = "no name";
	private String surname = "no surname";
	private Integer dni = 0;
	private String password = "no password";
	private double wight = 0; 
	private double height = 0;
	
	public static PatientBuilder aPatient() {
		return new PatientBuilder();
	}
	
	public Patient build() {
		Patient patient = new Patient(this.name,
										this.surname,
										this.dni,
										this.password,
										this.wight,
										this.height);
		return patient;
	}
	
	public PatientBuilder withName(final String name) {
		this.name = name;
		return this;
	}
	
	public PatientBuilder withSurname(final String surname) {
		this.surname = surname;
		return this;
	}
	
	public PatientBuilder withDNI(final Integer dni) {
		this.dni = dni;
		return this;
	}

	public PatientBuilder withPassword(final String password) {
		this.password = password;
		return this;
	}
	
	public PatientBuilder withHeight(final double height) {
		this.height = height;
		return this;
	}
	
	public PatientBuilder withWight(final double wight) {
		this.wight = wight;
		return this;
	}

}
