package ar.edu.desapp.grupoa.user;

public class Doctor extends User {

	private Integer enrollment;

	public Doctor(String name, String surname, Integer dni, String password, int enrollment) {
		super(name, surname, dni, password);
		this.setEnrollment(enrollment);
	}

	public Integer getEnrollment() {
		return this.enrollment;
	}

	public void setEnrollment(int enrolment) {
		this.enrollment = enrolment;
	}


	////////////////////////////////////////////////
	
}

