package ar.edu.desapp.groupa.model.builders;

import ar.edu.desapp.groupa.model.symptom.Symptom;

public class SymptomBuilder {
	
	private String description = "no description ";
	
	public static SymptomBuilder aSymptom() {
		return new SymptomBuilder();
	}
	
	public Symptom build() {
		Symptom s = new Symptom(this.description);
		return s;
	}	
	
	public SymptomBuilder withDescription(final String description) {
		this.description = description;
		return this;
	}

}
