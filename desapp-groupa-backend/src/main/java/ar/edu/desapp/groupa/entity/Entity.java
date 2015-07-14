package ar.edu.desapp.groupa.entity;

import java.io.Serializable;

public abstract class Entity implements Serializable {

	private static final long serialVersionUID = 7395832399241140608L;
	
	private int id;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(final int id) {
		this.id = id;
	}

	public Boolean sameId(Entity element2) {
		return this.getId() == element2.getId();
	}
	
}
