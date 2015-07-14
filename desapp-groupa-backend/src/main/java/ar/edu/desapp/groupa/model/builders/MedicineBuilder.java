package ar.edu.desapp.groupa.model.builders;

import ar.edu.desapp.groupa.model.medicine.Drug;
import ar.edu.desapp.groupa.model.medicine.Medicine;


public class MedicineBuilder {
	
	private Drug drug = new Drug("no name");
	private double concentration = 0;
	
	public static MedicineBuilder aMedicine() {
		return new MedicineBuilder();
	}
	
	public Medicine build() {
		Medicine medicine = new Medicine(drug, concentration);
		return medicine;
	}
	
	public MedicineBuilder with(final Drug drug) {
		this.drug = drug;
		return this;
	}
	
	public MedicineBuilder with(final double concentration) {
		this.concentration = concentration;
		return this;
	}

}
