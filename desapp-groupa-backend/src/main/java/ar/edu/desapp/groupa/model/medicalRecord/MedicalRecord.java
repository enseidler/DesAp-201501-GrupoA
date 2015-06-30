package ar.edu.desapp.groupa.model.medicalRecord;

import java.util.ArrayList;
import java.util.List;

import ar.edu.desapp.groupa.entity.Entity;
import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.medicalConsultation.MedicalConsultation;
import ar.edu.desapp.groupa.model.medicine.Drug;
import ar.edu.desapp.groupa.model.user.Patient;

public class MedicalRecord extends Entity {
	
	private static final long serialVersionUID = 355081580542374081L;
	
	private List<MedicalConsultation> consultations = new ArrayList<MedicalConsultation>();
	private List<Disease> diseases = new ArrayList<Disease>();
	private List<Drug> allergies = new ArrayList<Drug>();
	
	public MedicalRecord() {
		super();
	}
	
	public void setConsultations(List<MedicalConsultation> consultations) {
		this.consultations = consultations;
	}

	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}

	public void setAllergies(List<Drug> allergies) {
		this.allergies = allergies;
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

	public boolean sufferedDisease(Disease disease) {
		return this.getDiseases().contains(disease);
	}

	public void deleteAllergyById(Integer idAllergy) {
		for(Drug drug : this.getAllergies()) {
			if(drug.getId() == idAllergy) {
				this.getAllergies().remove(drug);
			}
		}
	}
	
}
