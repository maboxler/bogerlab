package htwg.se.chess;

import java.util.Scanner;

import com.google.inject.Guice;
import com.google.inject.Injector;

import htwg.se.controller.Icontroller;
import htwg.se.model.*;
import htwg.se.view.*;



public class Init {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		GameField gameField = new GameField();
		
		//ChessController cc = new ChessController(gameField);
		scanner = new Scanner(System.in);
		
		
		// Set up Google Guice Dependency Injector
		Injector injector = Guice.createInjector(new ChessModule());
		
		
		// Build up the application, resolving dependencies automatically by Guice
				Icontroller cc = injector.getInstance(Icontroller.class);
		
		@SuppressWarnings("unused")
		GUI gui = new GUI(cc);
		TUI tui = new TUI(cc);
		tui.update(null);
		while(!gameField.blackWon() && !gameField.whiteWon()) {
			tui.processInputLine(scanner.nextLine());
		}
		
	}

}
