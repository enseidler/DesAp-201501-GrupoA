package ar.edu.desapp.groupa.model.medicine;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import ar.edu.desapp.groupa.model.disease.Disease;
import static junit.framework.Assert.*;


public class MedicineTest {
	
	private Medicine bayaspirina;
	private Drug aspirina;
	private Disease resfrio;
	private Disease migraña;
	
	@Before
	public void setUp(){
		resfrio = mock(Disease.class);
		aspirina = mock(Drug.class);
		bayaspirina = new Medicine(aspirina, 100.0);
		bayaspirina.addCuredDisease(resfrio);
	}
	
	@Test
	public void medicineDataDrugTest(){
		Drug expected = aspirina;
		assertEquals(expected, bayaspirina.getDrug());
		
	}
	
	@Test
	public void medicineDataConcentrationTest(){
		double expected = 100.0;
		assertEquals(expected, bayaspirina.getConcentration());
		
	}

	@Test
	public void isTheCureTest() {
		Boolean condition = bayaspirina.cure(resfrio);
		assertTrue(condition);
	}

	@Test
	public void isNotTheCureTest() {
		Boolean condition = bayaspirina.cure(migraña);
		assertFalse(condition);
	}
	
}
