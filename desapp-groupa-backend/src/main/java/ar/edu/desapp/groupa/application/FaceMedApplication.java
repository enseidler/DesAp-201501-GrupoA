package ar.edu.desapp.groupa.application;



import ar.edu.desapp.groupa.model.disease.Disease;
import ar.edu.desapp.groupa.model.medicalConsultation.MedicalConsultation;
import ar.edu.desapp.groupa.model.medicalPractice.MedicalPractice;
import ar.edu.desapp.groupa.model.medicine.Drug;
import ar.edu.desapp.groupa.model.medicine.Medicine;
import ar.edu.desapp.groupa.model.repose.Parcial;
import ar.edu.desapp.groupa.model.repose.Total;
import ar.edu.desapp.groupa.model.treatment.Treatment;
import ar.edu.desapp.groupa.model.user.Patient;
import static ar.edu.desapp.groupa.model.builders.DiseaseBuilder.*;
import static ar.edu.desapp.groupa.model.builders.MedicalPracticeBuilder.*;
import static ar.edu.desapp.groupa.model.builders.TreatmentBuilder.*;
import static ar.edu.desapp.groupa.model.builders.MedicalConsultationBuilder.*;
import static ar.edu.desapp.groupa.model.builders.PatientBuilder.*;

public class FaceMedApplication {
	
	public static Patient patient() {
		Disease varicela = aDisease("Varicela").build();
		Disease faringitis = aDisease("Faringitis").build();
		Disease zarampion = aDisease("Zarampion").build();
		
		Drug d1 = new Drug("Lorataina");
		Drug d2 = new Drug("Ibuprofeno");
		Drug d3 = new Drug("Aspirina");
		
		Medicine m1 = new Medicine(d3, 400);
		Medicine m2 = new Medicine(d2, 600);
		
		MedicalPractice p1 = aMedicalPractice().withName("Practice 1").build();
		MedicalPractice p2 = aMedicalPractice().withName("Practice 2").build();
		MedicalPractice p3 = aMedicalPractice().withName("Practice 3").build();
		
		Treatment t1 = aTreatment(new Parcial(24)).with(p1).with(p2).with(m1).build();
		Treatment t2 = aTreatment(new Total()).with(p1).with(p3).with(m2).build();
		
		MedicalConsultation mc1 = aMedicalConsultation().with(varicela).with(t1).build();
		MedicalConsultation mc2 = aMedicalConsultation().with(faringitis).with(t2).build();
		
		Patient patient = aPatient().withName("Ezequiel").withSurname("Seidler").withDNI(36396386).withPassword("password").withHeight(1.8).withWight(74.5).build();
		patient.getMedicalRecord().addConsultation(mc1);
		patient.getMedicalRecord().addConsultation(mc2);
		patient.getMedicalRecord().addAllergy(d1);
		patient.getMedicalRecord().addDisease(zarampion);
		patient.getMedicalRecord().addDisease(varicela);
		
		return patient;
	}
	
	public static void main(String[] args) {
		/**
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring-context.xml");
		GeneralService gs = (GeneralService) context.getBean("services.general");
		MedicalRecordService ps = gs.getMedicalRecordService();
		MedicalRecord p = ps.findById(1);
		System.out.println(p.getConsultations().get(0).getTreatment());
		*/
	}

}
