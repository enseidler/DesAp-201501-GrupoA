package ar.edu.desapp.groupa.model.medicine;

import ar.edu.desapp.groupa.entity.Entity;

public class Drug extends Entity {
	
	private static final long serialVersionUID = 9153468903626333639L;
	
	private String name;

	public Drug() {
		super();
	}
	
	public Drug(String name){
		this.setName(name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
