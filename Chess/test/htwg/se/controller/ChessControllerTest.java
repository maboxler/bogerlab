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
	}

}
