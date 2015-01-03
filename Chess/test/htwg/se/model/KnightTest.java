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
	
	@Test
	public void outRangeTest() {	
		assertNull(knight.validMove(-1, 1));
		assertNull(knight.validMove(8, 1));
		assertNull(knight.validMove(1, -1));
		assertNull(knight.validMove(1, 8));	
	}
		
	@Test
	public void equalPositionTest() {
		knight = new Knight(2,3,'w');
//		assertNotNull(knight.validMove(2, 3));
		assertNull(knight.validMove(2, 3));
//		assertNotNull(knight.validMove(3, 4));
//		assertNotNull(knight.validMove(3, 3));
	}
	
	@Test
	public void validMoveTest() {
		assertNull(knight.validMove(1, 1));
	}
    	
	
//	@Test
//	public void diagonalTest() {			    	
//    	knight = new Knight(2,3,'w');
//    	//assertNull(knight.validMove(2,3));
//    	
//    	assertNotNull(knight.validMove(0,5));
//    	assertNotNull(knight.validMove(3,4));
//    	assertNotNull(knight.validMove(1,2));
//    	assertNotNull(knight.validMove(3,2));
//    	assertNotNull(knight.validMove(0,5));
//    	
//    	knight = new Knight(2,3,'w');
//    	assertNotNull(knight.validMove(0,7));
//    	
//    	
//    	
//	}
	
//	@Test
//	public void horizontalTest() {
//		knight = new Knight(2,3,'w');
//		assertNotNull(knight.validMove(4,3));
//		assertNotNull(knight.validMove(1,3));
//	}
//	
//	@Test
//	public void verticalTest() {
//		knight = new Knight(2,3,'w');
//		assertNotNull(knight.validMove(2,4));
//		assertNotNull(knight.validMove(2,1));
//	}


	@Test
	public void test() {
		//assertEquals(knight.toChar(), 'K');
		//assertNull(knight.validMove(1, 1));
	}

}
