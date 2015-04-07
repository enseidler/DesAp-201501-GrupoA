package ar.edu.desapp.grupoa.user;

import java.util.ArrayList;
import java.util.List;

import ar.edu.desapp.grupoa.medicine.Drug;


public class Patient extends User {

	private double wight; 
	private double height;
	private List<Drug> allergies;
	
	public Patient(String name, String surname, Integer dni, String password, double i, double d) {
		super(name, surname, dni, password);
		this.setWight(i);
		this.setHeight(d);
		this.allergies = new ArrayList<Drug>();
	}

	public double getWight() {
		return wight;
	}

	public void setWight(double wight) {
		this.wight = wight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public List<Drug> getAllergies() {
		return allergies;
	}

	/*
	////////////////////////////////////////
	 */

	public void addAllergie(Drug drug) {
		this.getAllergies().add(drug);
	}

}
