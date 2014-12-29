package htwg.se.view;


import htwg.se.model.GameField;

import org.junit.Before;
import org.junit.Test;

public class TUITest {

	TUI tui;
	@Before
	public void setUp() throws Exception {
		tui = new TUI();
	}

	@Test
	public void test() {
		GameField gamefield = new GameField();
		tui.update(gamefield.getField());
	}

}
