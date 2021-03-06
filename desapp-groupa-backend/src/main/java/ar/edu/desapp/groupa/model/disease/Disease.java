package ar.edu.desapp.groupa.model.disease;

import java.util.List;

import ar.edu.desapp.groupa.entity.Entity;
import ar.edu.desapp.groupa.model.medicalRecord.MedicalRecord;
import ar.edu.desapp.groupa.model.symptom.Symptom;
import ar.edu.desapp.groupa.model.treatment.Treatment;

public class Disease extends Entity {

	private static final long serialVersionUID = 20440081772455115L;
	
	private String name;
	private List<Symptom> symptoms;
	private List<Treatment> treatments;

	public Disease() {
		super();
	}
	
	public Disease(String name, List<Symptom> symptoms) {
		this.setName(name);
		this.setSymptoms(symptoms);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Symptom> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<Symptom> symptoms) {
		this.symptoms = symptoms;
	}

	public List<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}

	public boolean hasASymptom(List<Symptom> symptomss) {
		Boolean has = false;
		for(Symptom symptom : symptomss) {
			has = has || (this.hasSymptomWithDescription(symptom.getDescription()));
		}
		return has;
	}
	
	public boolean hasSymptomWithDescription(String description) {
		Boolean has = false;
		for(Symptom symptom : this.getSymptoms()) {
			has = has || (symptom.getDescription() == description);
		}
		return has;
	}

	public boolean haveATreatment(MedicalRecord medicalRecord) {
		Boolean have = false;
		for(Treatment treatment : this.getTreatments()) {
			have = have || treatment.availableFor(medicalRecord);
		}
		return have;
	}
	
}
