package ar.edu.desapp.grupoa.treatment;

import java.util.ArrayList;
import java.util.List;

import ar.edu.desapp.grupoa.medicalPractice.MedicalPractice;
import ar.edu.desapp.grupoa.medicine.Medicine;
import ar.edu.desapp.grupoa.repose.Repose;

public class Treatment {
	
	private Repose repose;
	private List<Medicine> medicines;
	private List<MedicalPractice> medicalPractices;

	public Treatment(Repose repose){
		this.medicalPractices = new ArrayList<MedicalPractice>();
		this.medicines = new ArrayList<Medicine>();
		this.setRepose(repose);
		
	}

	public Repose getRepose() {
		return repose;
	}

	public void setRepose(Repose repose) {
		this.repose = repose;
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
