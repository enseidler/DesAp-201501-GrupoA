package ar.edu.desapp.grupoa.user;

public abstract class User {

	private String name;
	private String surname;
	private Integer dni;
	private String password;
		
	public User(String name, String surname, Integer dni, String password) {
		this.setName(name);
		this.setSurname(surname);
		this.setDni(dni);
		this.setPassword(password);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getDni() {
		return this.dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//////////////////////////////////////////////////////////

	
	
}
