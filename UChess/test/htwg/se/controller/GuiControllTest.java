package htwg.se.controller;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
public class GuiControllTest {

	GuiControll gc;
	
	@Before
	public void setUp()	throws Exception{
		gc = new GuiControll();
	}
	
	@Test
	public void CheckMoveTest() {
		assertEquals(false, gc.checkMove(1, 1, 2, 2));;
	}

}
