package ar.edu.desapp.grupoa.user;

import java.util.List;

import ar.edu.desapp.grupoa.disease.Disease;
import ar.edu.desapp.grupoa.medicalConsultation.MedicalConsultation;
import ar.edu.desapp.grupoa.symptom.Symptom;


public class Doctor extends User {

	private Integer enrollment;

	public Doctor(String name, String surname, Integer dni, String password, int enrollment) {
		super(name, surname, dni, password);
		this.setEnrollment(enrollment);
	}

	public Integer getEnrollment() {
		return this.enrollment;
	}

	public void setEnrollment(int enrolment) {
		this.enrollment = enrolment;
	}


	////////////////////////////////////////////////
	
	

	public void addDignoseDisease(MedicalConsultation newMedicalConsultation, Disease disease) {
		newMedicalConsultation.addDignoseDisease(disease);
	}

	public void addTreatment(MedicalConsultation newMedicalConsultation) {
		
	}
}

