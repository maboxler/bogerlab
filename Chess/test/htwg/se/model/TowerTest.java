package htwg.se.model;

import static org.junit.Assert.*;
import htwg.se.util.Point;

import org.junit.Before;
import org.junit.Test;

public class TowerTest {

	Tower testtower;
	
	@Before
	public void setUp() throws Exception {
		testtower = new Tower(1,1,'w');	
	}

	
	@Test
	public void outRangeTest() {	
		
		assertNull(testtower.validMove(-1, 1));
		assertNull(testtower.validMove(8, 1));
		assertNull(testtower.validMove(1, -1));
		assertNull(testtower.validMove(1, 8));
		assertNotNull(testtower.validMove(1, 4));
	
	}
	
	@Test
	public void equalPositionTest() {
		assertNull(testtower.validMove(1, 1));
	}
    	
	
	@Test
	public void verticalTest() {			
		assertNotNull(testtower.validMove(2,1));
		Point[] array = testtower.validMove(2, 1);
		for (Point point : array) {
			System.out.println(point.getX() + "x " + point.getY() + "y");
		}
		
    	assertNotNull(testtower.validMove(1,0)); //1
    	
    	testtower = new Tower(4,4,'w');
    	assertNotNull(testtower.validMove(2,5));
    	assertNotNull(testtower.validMove(2,4));
    	assertNotNull(testtower.validMove(4,5));
    	assertNull(testtower.validMove(4,4));
    	assertNull(testtower.validMove(4,4));
    	
    	assertNotNull(testtower.validMove(4,5));
    	assertNotNull(testtower.validMove(4,3));
    	
    	assertNotNull(testtower.validMove(5,5));
    	assertNotNull(testtower.validMove(3,5));
	}
	
	@Test
	public void horizontalTest() {
		
	}
	
	@Test
	public void testtoChar() {
		assertEquals(testtower.toChar(), 'T');
	}
	
}
