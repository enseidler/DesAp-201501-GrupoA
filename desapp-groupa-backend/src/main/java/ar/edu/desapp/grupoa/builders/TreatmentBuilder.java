package ar.edu.desapp.grupoa.builders;

import java.util.ArrayList;
import java.util.List;

import ar.edu.desapp.grupoa.medicalPractice.MedicalPractice;
import ar.edu.desapp.grupoa.medicine.Medicine;
import ar.edu.desapp.grupoa.repose.Repose;
import ar.edu.desapp.grupoa.treatment.Treatment;


public class TreatmentBuilder {
	
	private Repose repose;
	private List<Medicine> medicines = new ArrayList<Medicine>();
	private List<MedicalPractice> medicalPractices = new ArrayList<MedicalPractice>();
	
	public static TreatmentBuilder aTreatment(Repose repose) {
		return new TreatmentBuilder(repose);
	}
	
	public TreatmentBuilder(Repose repose) {
		this.repose = repose;
	}
	
	public Treatment build() {
		Treatment treatmnet = new Treatment(this.repose);
		return treatmnet;
	}
	
	public TreatmentBuilder with(final Medicine medicine) {
		this.medicines.add(medicine);
		return this;
	}
	
	public TreatmentBuilder with(final MedicalPractice md) {
		this.medicalPractices.add(md);
		return this;
	}

}
