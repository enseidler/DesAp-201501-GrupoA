package ar.edu.desapp.grupoa.medicine;

import java.util.ArrayList;
import java.util.List;

import ar.edu.desapp.grupoa.disease.Disease;

public class Medicine {
	
	private Drug drug;
	private double concentration;
	private List<Disease> theCureFor = new ArrayList<Disease>();  
	
	public Medicine(Drug drug, double concentration){
		this.concentration = concentration;
		this.drug = drug;
		this.theCureFor = new ArrayList<Disease>();  
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

	public List<Disease> getTheCureFor() {
		return theCureFor;
	}

	public void setTheCureFor(List<Disease> theCureFor) {
		this.theCureFor = theCureFor;
	}

}
