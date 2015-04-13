package ar.edu.desapp.grupoa.user;

import java.util.List;

import ar.edu.desapp.grupoa.exeptions.NotFoundDiseaseException;
import ar.edu.desapp.grupoa.symptom.Symptom;
import ar.edu.desapp.grupoa.system.Hospital;

public class Patient extends User {

	private double wight; 
	private double height;

	public Patient(String name, String surname, Integer dni, String password, double wight, double height) {
		super(name, surname, dni, password);
		this.setWight(wight);
		this.setHeight(height);

	}

	public double getWight() {
		return this.wight;
	}

	public void setWight(double wight) {
		this.wight = wight;
	}

	public double getHeight() {
		return this.height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	////////////////////////////////////////////////////
	
	
	/*
	public void visitHospital(Hospital hospital, List<Symptom> symptoms) throws NotFoundDiseaseException{
		
		hospital.createNewMedicalConsultation(symptoms);
	}
	*/



	




}
