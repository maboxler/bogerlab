package htwg.se.view;


import htwg.se.controller.ChessController;
import htwg.se.model.GameField;

import org.junit.Before;
import org.junit.Test;

public class TUITest {

	TUI tui;
	@Before
	public void setUp() throws Exception {
		GameField gf = new GameField();
		ChessController cs = new ChessController(gf);
		tui = new TUI(cs);
	}

	@Test
	public void test() {
		tui.update(null);
	}

}
