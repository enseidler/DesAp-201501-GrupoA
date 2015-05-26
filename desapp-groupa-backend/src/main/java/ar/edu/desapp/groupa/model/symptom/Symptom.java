package ar.edu.desapp.groupa.model.symptom;

import ar.edu.desapp.groupa.entity.Entity;

public class Symptom extends Entity {
	
	private static final long serialVersionUID = -4883017277745212759L;
	
	private String description;

	public Symptom() {
		super();
	}
	
	public Symptom(String description){
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
