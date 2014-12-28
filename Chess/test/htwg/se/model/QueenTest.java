package htwg.se.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueenTest {
	
	Queen queen;

	@Before
	public void setUp() throws Exception {
		queen = new Queen(1,1,'w');
	}

	@Test
	public void test() {
		assertEquals(queen.toChar(), 'Q');
		assertNull(queen.validMove(1, 1));
	}

}
