package htwg.se.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BishopTest {
	
	Bishop bishop;

	@Before
	public void setUp() throws Exception {
		bishop = new Bishop(1, 1, 'w');
	}

	@Test
	public void test() {
		assertEquals(bishop.toChar(), 'B');
		assertNull(bishop.validMove(1, 1));
	}

}
