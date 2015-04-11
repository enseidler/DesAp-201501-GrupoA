package ar.edu.desapp.grupoa.repose;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.*;

public class ReposeTest {
	
	private Parcial reposeParcial;
	
	@Before
	public void setUp(){
		reposeParcial = new Parcial(72);
	}

	@Test
	public void reposeParcialHoursTest(){
		Integer expected = 72;
		assertEquals(expected, reposeParcial.getHours());
	}
}
