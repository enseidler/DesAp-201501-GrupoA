package ar.edu.desapp.grupoa.medicine;

public class Medicine {
	
	private Drug drug;
	private double concentration;
	
	public Medicine(Drug drug, double concentration){
		this.setConcentration(concentration);
		this.setDrug(drug);
	}
	
	public Drug getDrug() {
		return drug;
	}
	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	public double getConcentration() {
		return concentration;
	}
	public void setConcentration(double concentration) {
		this.concentration = concentration;
	}

}
