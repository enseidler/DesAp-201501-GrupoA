package ar.edu.desapp.groupa.model.user;

public class Patient extends User {

	private static final long serialVersionUID = 2664034775371830171L;
	
	private double weight; 
	private double height;

	public Patient() {
		super();
	}
	
	public Patient(String name, String surname, Integer dni, String password, double weight, double height) {
		super(name, surname, dni, password);
		this.setWeight(weight);
		this.setHeight(height);

	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return this.height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	



	




}
