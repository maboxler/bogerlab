package htwg.se.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TowerTest {

	Tower testtower;
	@Before
	public void setUp() throws Exception {
		testtower = new Tower(1,1,'w');
	}

	@Test
	public void test() {
		assertEquals(testtower.toChar(), 'T');
		//assertNull(testtower.validMove(1, 1));
	}

}
