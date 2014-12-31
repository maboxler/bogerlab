package htwg.se.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TowerTest {

	Tower testtower;

	Point pointfullvertikal[];
	Point pointfullhorizontal[];
	
	
	@Before
	public void setUp() throws Exception {
		testtower = new Tower(1,1,'w');	
		pointfullhorizontal = new Point[3];
		pointfullvertikal = new Point[3];
		
		
		pointfullhorizontal[0] = new Point(1,1);
		pointfullhorizontal[1] = new Point(2,1);
		pointfullhorizontal[2] = new Point(3,1);
		
		pointfullvertikal[0] = new Point(1,1);
		pointfullvertikal[1] = new Point(1,2);
		pointfullvertikal[2] = new Point(1,3);
	}

	
	@Test
	public void testvalidMove() {	
		
		assertNull(testtower.validMove(1, 1));		

		assertNotNull(testtower.validMove(2,1));
		assertNotNull(testtower.validMove(1,2)); //2 3
		assertNotNull(testtower.validMove(2,2)); //1
    	assertNotNull(testtower.validMove(1, 6));
    	assertNotNull(testtower.validMove(1,0)); //1
    	assertNotNull(testtower.validMove(0,0)); //1
    	assertNotNull(testtower.validMove(5,5)); //1
    	assertNotNull(testtower.validMove(3,1)); //1
    	
    	testtower = new Tower(3,1,'w');
    	assertNotNull(testtower.validMove(4,2));
    	
    	testtower = new Tower(3,1,'w');
    	assertNotNull(testtower.validMove(4,0));
    	
    	testtower = new Tower(3,1,'w');
    	assertNotNull(testtower.validMove(4,2));
    	
    	testtower = new Tower(3,3,'w');
    	assertNotNull(testtower.validMove(3,0));
    	testtower = new Tower(2,4,'w');
    	assertNotNull(testtower.validMove(0,4));
    	assertNotNull(testtower.validMove(4,4));
    	

    	testtower = new Tower(2,4,'w');
    	assertNotNull(testtower.validMove(2,5));
    	assertNotNull(testtower.validMove(2,3));
    	assertNotNull(testtower.validMove(4,5));
    	assertNotNull(testtower.validMove(3,4));



		
		//assertArrayEquals(point, testtower.validMove(1, 1));
		//assertArrayEquals(pointfullhorizontal, testtower.validMove(3, 1));
		
		/*assertArrayEquals(pointfullvertikal, testtower.validMove(1, 3));*/
	}
	
	@Test
	public void testtoChar() {
		assertEquals(testtower.toChar(), 'T');
	}
	
}
