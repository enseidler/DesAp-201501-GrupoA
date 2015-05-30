package ar.edu.desapp.groupa.model.medicalPractice;

import java.util.ArrayList;
import java.util.List;

import ar.edu.desapp.groupa.entity.Entity;
import ar.edu.desapp.groupa.model.disease.Disease;

public class MedicalPractice extends Entity {


	private static final long serialVersionUID = -5020581813122419076L;
	
	private String name;
	private String description;
	private List<Disease> theCureFor = new ArrayList<Disease>();
	
	public MedicalPractice() {
		super();
	}
	
	public MedicalPractice(String name, String description){
		this.setName(name);
		this.setDescription(description);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Disease> getTheCureFor() {
		return theCureFor;
	}

	public void setTheCureFor(List<Disease> theCureFor) {
		this.theCureFor = theCureFor;
	}

	public Boolean cure(Disease disease) {
		return this.getTheCureFor().contains(disease);
	}
	
	
}
