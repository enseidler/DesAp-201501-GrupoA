package ar.edu.desapp.grupoa.user;


public class Patient extends User {

	private double wight; 
	private double height; 
	
	public Patient(String name, String surname, Integer dni, String password, double i, double d) {
		super(name, surname, dni, password);
		this.setWight(i);
		this.setHeight(d);
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

}
