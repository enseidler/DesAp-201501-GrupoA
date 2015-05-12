package ar.edu.desapp.groupa.model.treatment;

import java.util.ArrayList;
import java.util.List;

import ar.edu.desapp.groupa.model.medicalPractice.MedicalPractice;
import ar.edu.desapp.groupa.model.medicine.Medicine;
import ar.edu.desapp.groupa.model.repose.Repose;

public class Treatment {
	
	private Repose repose;
	private List<Medicine> medicines;
	private List<MedicalPractice> medicalPractices;

	public Treatment(Repose repose){
		this.medicalPractices = new ArrayList<MedicalPractice>();
		this.medicines = new ArrayList<Medicine>();
		this.repose = repose;	
	}
	
	public Treatment() {
		this.medicalPractices = new ArrayList<MedicalPractice>();
		this.medicines = new ArrayList<Medicine>();
	}

	public Repose getRepose() {
		return repose;
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}
	
	public List<MedicalPractice> getMedicalPractices() {
		return medicalPractices;
	}
	
	//////////////////////////////////////////////
	
	public void addMedicine(Medicine medicines) {
		this.getMedicines().add(medicines);
	}

	public void addMedicalPractices(MedicalPractice medicalPractices) {
		this.getMedicalPractices().add(medicalPractices);
	}
	
}
