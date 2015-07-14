package ar.edu.desapp.groupa.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ar.edu.desapp.groupa.helpers.DiagnoseHelper;
import ar.edu.desapp.groupa.helpers.TreatmentHelper;
import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.medicalPractice.MedicalPractice;
import ar.edu.desapp.groupa.model.medicalRecord.MedicalRecord;
import ar.edu.desapp.groupa.model.medicine.Medicine;
import ar.edu.desapp.groupa.model.symptom.Symptom;
import ar.edu.desapp.groupa.model.treatment.Treatment;
import ar.edu.desapp.groupa.model.utils.FaceMedUtils;
import ar.edu.desapp.groupa.services.DiseaseService;
import ar.edu.desapp.groupa.services.MedicalPracticeService;
import ar.edu.desapp.groupa.services.MedicalRecordService;
import ar.edu.desapp.groupa.services.MedicineService;
import ar.edu.desapp.groupa.services.SymptomService;

@Path("/diagnose")
public class DiagnoseRest {
	
	private DiseaseService diseaseService; 
	private SymptomService symptomService; 
	private MedicalRecordService medicalRecordService; 
	private MedicineService medicineService; 
	private MedicalPracticeService medicalPracticeService; 
	
	public void setDiseaseService(final DiseaseService diseaseService) {
		this.diseaseService = diseaseService;
	}

	public void setSymptomService(final SymptomService symptomService) {
		this.symptomService = symptomService;
	}

	public void setMedicalRecordService(final MedicalRecordService medicalRecordService) {
		this.medicalRecordService = medicalRecordService;
	}

	public void setMedicineService(MedicineService medicineService) {
		this.medicineService = medicineService;
	}

	public void setMedicalPracticeService(
			MedicalPracticeService medicalPracticeService) {
		this.medicalPracticeService = medicalPracticeService;
	}

	@GET
    @Path("/diagnosedDiseases{idsSymptoms : (/idsSymptoms)?}")
	@Consumes("application/json")
    @Produces("application/json")
    public List<Disease> getDiagnosedDiseases(@PathParam("idsSymptoms") String idsSymptoms) {
        List<Disease> diseases = diseaseService.retriveAll();
        List<Integer> ids = FaceMedUtils.getIntsFromString(idsSymptoms);
        List<Symptom> currentSymptoms = symptomService.retriveAllById(ids);
		List<Disease> diagnosedDiseases = DiagnoseHelper.diagnose(diseases, currentSymptoms);
		return diagnosedDiseases;
	}

	@GET
	@Path("/{patientId}/makeTreatment/{diseaseId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Treatment getDiagnosedTreatment(@PathParam("patientId") Integer patientId, @PathParam("diseaseId") Integer diseaseId) {
		MedicalRecord medicalRecord = medicalRecordService.findById(patientId);
		Disease diagnosedDisease = diseaseService.findById(diseaseId);
		List<Medicine> medicines = medicineService.retriveAll();
		List<MedicalPractice> medicalPractices = medicalPracticeService.retriveAll();
		Treatment diagnosedTreatment = TreatmentHelper.diagnose(medicalRecord, diagnosedDisease, medicines, medicalPractices);
		return diagnosedTreatment;
	}
	
	
	
}