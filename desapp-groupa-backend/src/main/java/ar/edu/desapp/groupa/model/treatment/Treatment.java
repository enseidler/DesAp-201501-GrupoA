package ar.edu.desapp.groupa.model.treatment;

import java.util.ArrayList;
import java.util.List;

import ar.edu.desapp.groupa.entity.Entity;
import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.medicalPractice.MedicalPractice;
import ar.edu.desapp.groupa.model.medicalRecord.MedicalRecord;
import ar.edu.desapp.groupa.model.medicine.Medicine;
import ar.edu.desapp.groupa.model.repose.Repose;

public class Treatment extends Entity {
	
	private static final long serialVersionUID = -9037222945532473485L;
	
	private Repose repose;
	private List<Medicine> medicines;
	private List<MedicalPractice> medicalPractices;

	public Treatment() {
		super();
		this.medicalPractices = new ArrayList<MedicalPractice>();
		this.medicines = new ArrayList<Medicine>();
	}

	public Treatment(Repose repose){
		this.medicalPractices = new ArrayList<MedicalPractice>();
		this.medicines = new ArrayList<Medicine>();
		this.repose = repose;	
	}
	




	public void setRepose(Repose repose) {
		this.repose = repose;
	}

	public Repose getRepose() {
		return repose;
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}
	
	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}

	public void setMedicalPractices(List<MedicalPractice> medicalPractices) {
		this.medicalPractices = medicalPractices;
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

	public boolean availableFor(MedicalRecord medicalRecord) {
		Boolean available = false;
		for(Medicine medicine : this.getMedicines()) {
			available = available || !medicalRecord.canConsume(medicine);
		}
		return available;
	}
	
}
