package htwg.se.chess;

import java.util.Scanner;

import htwg.se.controller.ChessController;
import htwg.se.model.*;
import htwg.se.view.*;



public class Init {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		GameField gameField = new GameField();
		
		ChessController cc = new ChessController(gameField);
		scanner = new Scanner(System.in);
		TUI tui = new TUI(cc);
		while(!gameField.blackWon() && !gameField.whiteWon()) {
			tui.processInputLine(scanner.nextLine());
		}
	}

}
