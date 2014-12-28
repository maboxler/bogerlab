package htwg.se.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KingTest {
	
	King king;

	@Before
	public void setUp() throws Exception {
		king = new King(1,1,'w');
	}

	@Test
	public void test() {
		assertEquals(king.toChar(), 'K');
		assertNull(king.validMove(1, 1));
	}

}
