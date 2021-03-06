package ar.edu.desapp.groupa.model.builders;

import java.util.ArrayList;
import java.util.List;

import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.symptom.Symptom;

public class DiseaseBuilder {
	
	private String name = "no name";
	private List<Symptom> symptoms = new ArrayList<Symptom>();
	
	public static DiseaseBuilder aDisease(String name) {
		return new DiseaseBuilder(name);
	}
	
	public DiseaseBuilder(String name) {
		this.name = name;
	}
	
	public Disease build() {
		Disease disease = new Disease(this.name, this.symptoms);
		return disease;
	}
		
	public DiseaseBuilder with(final Symptom symptom) {
		this.symptoms.add(symptom);
		return this;
	}

}
