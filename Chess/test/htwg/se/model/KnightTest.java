package htwg.se.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KnightTest {
	
	Knight knight;

	@Before
	public void setUp() throws Exception {
		knight = new Knight(1,1,'w');
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		assertEquals(knight.toChar(), 'H');
		assertEquals(knight.validMove(1, 1), null);
	}

}
