package ar.edu.desapp.grupoa.systemTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;



import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.*;
import static junit.framework.Assert.*;
import ar.edu.desapp.grupoa.disease.Disease;
import ar.edu.desapp.grupoa.exeptions.NotFoundDiseaseException;
import ar.edu.desapp.grupoa.symptom.Symptom;
import ar.edu.desapp.grupoa.system.Hospital;

public class HospitalTest {
	
	private Hospital hospital;
	private Symptom dolorDeCabeza;
	private Symptom dolorDeGarganta;
	private Disease migraña;
	private Disease resfrio;
	List<Symptom> symptoms = new ArrayList<Symptom>();
	List<Symptom> symptoms2 = new ArrayList<Symptom>();

	
	@Before
	public void setUp(){
		
		dolorDeCabeza = new Symptom("Dolor De Cabeza");
		symptoms.add(dolorDeCabeza);
		
		migraña = new Disease("Migraña", symptoms);
		
		dolorDeGarganta = new Symptom("Dolor De Garganta");
		symptoms2.add(dolorDeGarganta);
		symptoms2.add(dolorDeCabeza);
		
		resfrio = new Disease("Resfrio", symptoms2);
		
		
		hospital = new Hospital();
		hospital.addDiseases(resfrio);
	
		
	}
	
	@Test
	public void compareSymptomsResfrioTest() throws NotFoundDiseaseException{
		Disease expected = hospital.compareSymptoms(symptoms2);
		assertEquals(expected, resfrio);
			
	}

	@Test(expected = NotFoundDiseaseException.class)
	public void compareSymptomsExeptionTest() throws NotFoundDiseaseException{
		
		 Disease expected = hospital.compareSymptoms(symptoms);
		 expected.getName();
			
	}
	
	

}
