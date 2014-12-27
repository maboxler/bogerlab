package htwg.se.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PawnTest {
	
	Pawn testpawn;

	@Before
	public void setUp() throws Exception {
		testpawn = new Pawn(1,1,'w');
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		assertEquals(testpawn.moved, false);
		assertEquals(testpawn.toChar(), 'P');
		assertEquals(testpawn.validMove(1, 1), null);
	}

}
