package ar.edu.desapp.grupoa.user;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Matchers;

import ar.edu.desapp.grupoa.disease.Disease;
import ar.edu.desapp.grupoa.medicine.Drug;


public class Patient extends User {

	private double wight; 
	private double height;
	private List<Drug> allergies;
	private List<Disease> diseases;
	
	public Patient(String name, String surname, Integer dni, String password, double i, double d) {
		super(name, surname, dni, password);
		this.setWight(i);
		this.setHeight(d);
		this.allergies = new ArrayList<Drug>();
		this.diseases = new ArrayList<Disease>();
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

	public List<Disease> getDiseases() {
		return this.diseases;
	}

	/*
	////////////////////////////////////////
	 */

	public void addAllergie(Drug drug) {
		this.getAllergies().add(drug);
	}

	public void addDisease(Disease disease) {
		this.getDiseases().add(disease);
	}


}
