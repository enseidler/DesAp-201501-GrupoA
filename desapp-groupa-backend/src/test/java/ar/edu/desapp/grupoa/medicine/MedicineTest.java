package ar.edu.desapp.grupoa.medicine;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;


public class MedicineTest {
	
	private Medicine bayaspirina;
	private Drug aspirina;
	
	@Before
	public void setUp(){
		
		aspirina = mock(Drug.class);
		bayaspirina = new Medicine(aspirina, 100.0);
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

	
}
