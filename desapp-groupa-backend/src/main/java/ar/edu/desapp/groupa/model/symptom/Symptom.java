package ar.edu.desapp.groupa.model.symptom;

public class Symptom {
	
	private String description;
	
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
