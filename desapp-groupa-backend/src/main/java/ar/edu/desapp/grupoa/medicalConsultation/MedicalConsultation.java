package ar.edu.desapp.grupoa.medicalConsultation;

import java.util.List;

import ar.edu.desapp.grupoa.disease.Disease;
import ar.edu.desapp.grupoa.symptom.Symptom;
import ar.edu.desapp.grupoa.treatment.Treatment;
import ar.edu.desapp.grupoa.user.Doctor;


public class MedicalConsultation {
	
	private Doctor doctor;
	private Disease dignoseDisease = null;
	private Treatment treatment = null;

	
	public MedicalConsultation(Doctor doctor){
		this.setDoctor(doctor);		
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public Disease getDignoseDisease() {
		return dignoseDisease;
	}
	
	public Treatment getTreatment() {
		return treatment;
	}
	
	///////////////////////////////////////////////////////
	
	public void addTreatment(Treatment treatament) {
		this.treatment = treatament;
	}
	
	public void addDignoseDisease(Disease dignoseDiase) {
		this.dignoseDisease = dignoseDiase;
	}
	
}