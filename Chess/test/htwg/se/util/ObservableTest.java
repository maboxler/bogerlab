package htwg.se.util;


import htwg.se.controller.ChessController;
import htwg.se.model.GameField;
import htwg.se.view.TUI;

import org.junit.Before;
import org.junit.Test;

public class ObservableTest {

	Observable observ;
	@Before
	public void setUp() throws Exception {
		observ = new Observable();
	}

	@Test
	public void test() {
		TUI tui = new TUI(new ChessController(new GameField()));
		observ.addObserver(tui);
		
		observ.notifyObservers(null);
		observ.removeObserver(tui);
		observ.removeAllObservers();
		observ.notifyObservers(null);
	}

}
