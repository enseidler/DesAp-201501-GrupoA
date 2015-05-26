package ar.edu.desapp.groupa.model.disease;

import java.util.List;

import ar.edu.desapp.groupa.entity.Entity;
import ar.edu.desapp.groupa.model.symptom.Symptom;

public class Disease extends Entity{

	private static final long serialVersionUID = 20440081772455115L;
	
	private String name;
	private List<Symptom> symptoms;

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

	public boolean hasASymptom(List<Symptom> symptomss) {
		Boolean has = false;
		for (Symptom symptom : symptomss) {
			has = has || this.getSymptoms().contains(symptom);
		}
		return has;
	}
}
