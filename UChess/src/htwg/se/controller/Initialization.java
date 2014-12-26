package htwg.se.controller;

import htwg.se.model.Field;
import htwg.se.model.GameField;

public class Initialization {

	public static void main(String[] args) {
		GameField gameField = new GameField();
		Field[][] field = gameField.getField();
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

}