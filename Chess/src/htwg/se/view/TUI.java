package htwg.se.view;

import htwg.se.model.Field;
import htwg.se.util.Point;

import htwg.se.util.Event;
import htwg.se.util.IObserver;
import htwg.se.controller.*;

public class TUI implements UI, IObserver {
	
	ChessController controller;
	boolean firstpressed;
	Point first;
	
	public TUI(ChessController controller) {
		this.controller = controller;
		firstpressed = false;
		first = null;
		controller.addObserver(this);
	}

	
	private void printUI() {
		Field field[][] = controller.getField();
		String testAusgabe = "";
		for(int y = 7; y >= 0; --y) {
			testAusgabe += "|";
			for(int x = 0; x <= 7; ++x) {
				if (field[x][y].getChessPiece() != null) {
					testAusgabe += field[x][y].getChessPiece().getcolor();
					testAusgabe += field[x][y].getChessPiece().toChar();
				} else {
					testAusgabe += "  ";
				}
				testAusgabe += "|";
			}
			
			message(testAusgabe);
			testAusgabe = "";
		}
		message(controller.getStatusMessage());
		
	}

	@Override
	public void restart() {
		controller.reset();
	}

	public boolean processInputLine(String line) {
		if(line.matches("[0-7][0-7] [0-7][0-7]")) {
			pressed((int)line.charAt(0) - 48,(int)line.charAt(1) - 48);
			pressed((int)line.charAt(3) - 48,(int)line.charAt(4) - 48);
			return true;
		}
		return false;
	}
	
	
	@Override
	public void pressed(int x, int y) {
		if(firstpressed) {
			controller.move(first, new Point(x,y));
			firstpressed = false;
			return;
		}
		first = new Point(x,y);
		firstpressed = true;
		

	}

	public void message(String text) {
		System.out.println(text);
		
	}

	@Override
	public void update(Event e) {
		printUI();
		if(controller.checkWin())
			message("GAME OVER");
	}

}
