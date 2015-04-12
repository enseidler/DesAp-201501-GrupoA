package ar.edu.desapp.grupoa.medicalRecord;

import java.util.ArrayList;
import java.util.List;

import ar.edu.desapp.grupoa.disease.Disease;
import ar.edu.desapp.grupoa.medicalConsultation.MedicalConsultation;
import ar.edu.desapp.grupoa.medicine.Drug;
import ar.edu.desapp.grupoa.user.Patient;

public class MedicalRecord {
	
	private Patient patient;
	private List<MedicalConsultation> consultations;
	private List<Disease> diseases;
	private List<Drug> allergies;
	
	public MedicalRecord(Patient patient){
		
		this.setPatient(patient); 
		this.consultations = new ArrayList<MedicalConsultation>();
		this.diseases = new ArrayList<Disease>();
		this.allergies = new ArrayList<Drug>();

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
	
	public List<Disease> getDiseases() {
		return diseases;
	}
	
	public List<Drug> getAllergies() {
		return allergies;
	}
	
	////////////////////////////////////////////////////////////
	
	public void addConsultation(MedicalConsultation consultation) {
		
		this.getConsultations().add(consultation);		
	}

	public void addDisease(Disease disease) {
		this.getDiseases().add(disease);
	}

	public void addAllergy(Drug allergy) {
		this.getAllergies().add(allergy);
	}
	
}
