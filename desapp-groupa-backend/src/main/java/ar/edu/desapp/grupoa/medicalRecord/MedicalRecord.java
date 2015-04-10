package ar.edu.desapp.grupoa.medicalRecord;

import java.util.ArrayList;
import java.util.List;

import ar.edu.desapp.grupoa.medicalConsultation.MedicalConsultation;
import ar.edu.desapp.grupoa.user.Patient;

public class MedicalRecord {
	
	private Patient patient;
	private List<MedicalConsultation> consultations;
	
	public MedicalRecord(Patient patient){
		
		this.setPatient(patient); 
		this.consultations = new ArrayList<MedicalConsultation>();
	}

	public Patient getPatient() {
		
		return this.patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public List<MedicalConsultation> getConsultations() {

		return this.consultations;
	}
	
	
	////////////////////////////////////////////////////////////
	
	public void addConsultation(MedicalConsultation consultation) {
		
		this.getConsultations().add(consultation);		
	}
	
}
