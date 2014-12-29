package htwg.se.view;

import htwg.se.model.Field;

public class TUI implements UI {

	@Override
	public void update(Field[][] field) {
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

}
