package htwg.se.controller;

import htwg.se.model.*;
import htwg.se.view.*;



public class Init {
	
	

	public static void main(String[] args) {
		GameField gameField = new GameField();
		TUI tui = new TUI();
		ChessController cc = new ChessController(tui, gameField);
		cc.ControllFlow();
	}

}
