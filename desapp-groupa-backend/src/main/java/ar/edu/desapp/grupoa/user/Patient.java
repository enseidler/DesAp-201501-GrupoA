package ar.edu.desapp.grupoa.user;

public class Patient extends User {

	private double wight; 
	private double height;

	public Patient(String name, String surname, Integer dni, String password, double wight, double height) {
		super(name, surname, dni, password);
		this.setWight(wight);
		this.setHeight(height);

	}

	public double getWight() {
		return this.wight;
	}

	public void setWight(double wight) {
		this.wight = wight;
	}

	public double getHeight() {
		return this.height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	



	




}
