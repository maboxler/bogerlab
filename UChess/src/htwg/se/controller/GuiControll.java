package htwg.se.controller;

import htwg.se.model.*;




public class GuiControll {
	

	
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
	
	
	
	public boolean checkMove(int x1,int y1,int x2,int y2) {
		return false;
	}
}
