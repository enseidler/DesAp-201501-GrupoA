package ar.edu.desapp.grupoa.builders;

import ar.edu.desapp.grupoa.medicalPractice.MedicalPractice;


public class MedicalPracticeBuilder {
	
	private String name = "no name";
	private String description = "no description";
	
	public static MedicalPracticeBuilder aMedicalPractice() {
		return new MedicalPracticeBuilder();
	}
	
	public MedicalPractice build() {
		MedicalPractice mp = new MedicalPractice(this.name, this.description);
		return mp;
	}
	
	public MedicalPracticeBuilder withName(final String name) {
		this.name = name;
		return this;
	}
	
	public MedicalPracticeBuilder withDescription(final String description) {
		this.description = description;
		return this;
	}

}
