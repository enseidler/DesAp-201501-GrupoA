package ar.edu.desapp.groupa.model.repose;

public class Parcial extends Repose{
	
	private Integer hours;

	public Parcial(Integer hours){
		this.setHours(hours);
	}
	
	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

}
