package htwg.se.view;

import htwg.se.model.Field;
import htwg.se.util.Event;
import htwg.se.util.IObserver;
import htwg.se.controller.*;

public class TUI implements UI, IObserver {
	
	ChessController controller;
	
	public TUI(ChessController controller) {
		this.controller = controller;
	}

	
	private void printUI() {
		Field field[][] = controller.getField();
		String testAusgabe = "";
		for(int y = 7; y >= 0; --y) {
			testAusgabe += "|";
			for(int x = 0; x <= 7; ++x) {
				if (field[x][y].getChessPiece() != null) {
					testAusgabe += field[x][y].getChessPiece().toChar();
				} else {
					testAusgabe += " ";
				}
				testAusgabe += "|";
			}
			
			System.out.println(testAusgabe);
			testAusgabe = "";
		}
		
	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pressed(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void message(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Event e) {
		printUI();
		
	}

}
