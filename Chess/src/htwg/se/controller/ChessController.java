package htwg.se.controller;

import htwg.se.model.GameField;
import htwg.se.view.*;

import java.util.List;

public class ChessController {
	private List<UI> uis;
	private GameField gamefield;
	
	public ChessController(TUI tui, GameField gamefield) {
		uis.add(tui);
		this.gamefield = gamefield;
	}
	
	public void ControllFlow() {
		while(!gamefield.blackWon() && !gamefield.whiteWon()) {
			
		}
	}
}
