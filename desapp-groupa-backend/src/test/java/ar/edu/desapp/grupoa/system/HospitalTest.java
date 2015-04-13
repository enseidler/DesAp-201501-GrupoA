package ar.edu.desapp.grupoa.system;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static junit.framework.Assert.*;
import ar.edu.desapp.grupoa.disease.Disease;
import ar.edu.desapp.grupoa.exeptions.NotFoundDiseaseException;
import ar.edu.desapp.grupoa.symptom.Symptom;
import ar.edu.desapp.grupoa.system.Hospital;
import static ar.edu.desapp.grupoa.builders.DiseaseBuilder.*;

public class HospitalTest {
	
	private Hospital hospital1;
	private Hospital hospital2;
	private Symptom dolorDeCabeza;
	private Symptom dolorDeGarganta;
	private Symptom dolorDeEstomago;
	private Disease migraña;
	private Disease resfrio;
	
	@Before
	public void setUp(){
		dolorDeCabeza = mock(Symptom.class);
		dolorDeGarganta = mock(Symptom.class);
		dolorDeEstomago = mock(Symptom.class);
		
		migraña = aDisease("Migraña")
					.with(dolorDeCabeza)
					.build();
		resfrio = aDisease("Resfrio")
					.with(dolorDeCabeza)
					.with(dolorDeGarganta)
					.build();
		
		hospital1 = new Hospital();
		hospital1.addDiseases(resfrio);
		
		hospital2 = new Hospital();
		hospital2.addDiseases(resfrio);
		hospital2.addDiseases(migraña);
	}
	
	@Test
	public void compareSymptomsResfrioTest() throws NotFoundDiseaseException {
		ArrayList<Symptom> symptoms = new ArrayList<Symptom>();
		symptoms.add(dolorDeCabeza);
		symptoms.add(dolorDeGarganta);
		Disease actual = hospital1.compareSymptoms(symptoms);
		Disease expected = resfrio;
		assertEquals(expected, actual);
			
	}

	@Test(expected = NotFoundDiseaseException.class)
	public void compareSymptomsExeptionTest() throws NotFoundDiseaseException {
		ArrayList<Symptom> symptoms = new ArrayList<Symptom>();
		symptoms.add(dolorDeEstomago);
		Disease expected = hospital1.compareSymptoms(symptoms);
	}
	
	
	///////
	
	
	@Test
	public void possibleDiseasesTest() {		
		ArrayList<Symptom> symptoms = new ArrayList<Symptom>();
		symptoms.add(dolorDeCabeza);
		symptoms.add(dolorDeGarganta);
		List<Disease> actual = hospital2.possibleDiseases(symptoms);
		List<Disease> expected = hospital2.getDiseases();
		assertEquals(expected,actual);
	}

}
