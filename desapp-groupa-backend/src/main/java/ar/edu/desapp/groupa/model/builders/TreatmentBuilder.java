package ar.edu.desapp.groupa.model.builders;

import java.util.ArrayList;
import java.util.List;

import ar.edu.desapp.groupa.model.medicalPractice.MedicalPractice;
import ar.edu.desapp.groupa.model.medicine.Medicine;
import ar.edu.desapp.groupa.model.repose.Repose;
import ar.edu.desapp.groupa.model.treatment.Treatment;


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
		Treatment treatment = new Treatment(this.repose);
		treatment.setMedicalPractices(this.medicalPractices);
		treatment.setMedicines(this.medicines);
		return treatment;
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
