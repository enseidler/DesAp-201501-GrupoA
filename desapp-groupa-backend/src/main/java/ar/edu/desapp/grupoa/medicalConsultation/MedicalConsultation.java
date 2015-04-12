package ar.edu.desapp.grupoa.medicalConsultation;

import java.util.ArrayList;
import java.util.List;

import ar.edu.desapp.grupoa.disease.Disease;
import ar.edu.desapp.grupoa.medicine.Drug;
import ar.edu.desapp.grupoa.symptom.Symptom;
import ar.edu.desapp.grupoa.treatment.Treatment;
import ar.edu.desapp.grupoa.user.Doctor;


public class MedicalConsultation {
	
	private Doctor doctor;
	private List<Symptom> symptoms;
	private Disease dignoseDisease = null;
	private Treatment treatment = null;
	
	public MedicalConsultation(Doctor doctor){
		this.setDoctor(doctor);
		this.symptoms = new ArrayList<Symptom>();
		
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public List<Symptom> getSymptoms() {
		return symptoms;
	}
	
	public Disease getDignoseDisease() {
		return dignoseDisease;
	}
	
	public Treatment getTreatment() {
		return treatment;
	}
	
	
	
	///////////////////////////////////////////////////////
	
	public void addSymptom(Symptom symptom){
		this.getSymptoms().add(symptom);
	}
	
	public void addTreatment(Treatment treatament) {
		this.treatment = treatament;
	}
	
	public void addDignoseDisease(Disease dignoseDiase) {
		this.dignoseDisease = dignoseDiase;
	}
	
}
