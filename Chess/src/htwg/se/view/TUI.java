package htwg.se.view;



import java.util.logging.Logger;

import htwg.se.model.Field;
import htwg.se.controller.*;
import htwg.util.Event;
import htwg.util.IObserver;
import htwg.util.Point;

public class TUI implements UI, IObserver {
	static final Logger log = Logger.getLogger(TUI.class.getName());
	
	Icontroller controller;
	boolean firstpressed;
	Point first;
	
	
	public TUI(Icontroller controller) {
		this.controller = controller;
		firstpressed = false;
		first = null;
		controller.addObserver(this);
	}

	
	private void printUI() {
		Field field[][] = controller.getField();
		String testAusgabe = "";
		String feld = "";
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
			
			
			feld += testAusgabe + "\n";
			testAusgabe = "";
		}
		message(feld);
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
		log.info("\n" + text);
		
	}

	@Override
	public void update(Event e) {
		printUI();
		if(controller.checkWin())
			message("GAME OVER");
	}

}
