package htwg.se.controller;

import static org.junit.Assert.*;
import htwg.se.util.Point;
import htwg.se.model.GameField;

import org.junit.Before;
import org.junit.Test;

public class ChessControllerTest {

	ChessController cs;
	
	@Before
	public void setUp() throws Exception {
		cs = new ChessController(new GameField());
	}

	@Test
	public void test() {
		cs.move(new Point(0,0), new Point(0,0));
		assertNotNull(cs.getField());
		cs.reset();
	}
	
	@Test
	public void moveTest() {
		cs.move(new Point(1, 0),new Point(1,0));
		cs.move(new Point(1, 3),new Point(1,0));
		cs.move(new Point(1, 0),new Point(3,0));
		cs.move(new Point(3, 3),new Point(3,4));
		assertEquals("It's blacks turn", cs.getStatusMessage());
		assertEquals(cs.getField()[0][1].getChessPiece().toChar(),'P');
		cs.move(new Point(1, 7),new Point(0,5));
		assertEquals("It's whites turn", cs.getStatusMessage());
		assertNull(cs.getField()[1][7].getChessPiece());
		assertEquals(cs.getField()[0][5].getChessPiece().toChar(),'H');
		cs.move(new Point(1,0), new Point(0,2));
		assertNull(cs.getField()[1][0].getChessPiece());
		assertEquals(cs.getField()[0][2].getChessPiece().toChar(),'H');
	}

}
