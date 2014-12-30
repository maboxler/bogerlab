package htwg.se.controller;

import htwg.se.model.*;
import htwg.se.view.*;



public class Init {
	
	

	public static void main(String[] args) {
		GameField gameField = new GameField();
		
		ChessController cc = new ChessController(gameField);
		@SuppressWarnings("unused")
		TUI tui = new TUI(cc);
	}

}
