package htwg.se.controller;

import htwg.se.util.*;
import htwg.se.model.*;




public class ChessController extends Observable{
	private GameField gamefield;
	private boolean blackturn;
	
	public ChessController( GameField gamefield) {
		this.gamefield = gamefield;
		blackturn = true;
	}
	
	public Field[][] getField() {
		return gamefield.getField();
	}
	
	public void move(Point start, Point goal) {
		if (checkTurn(start)) {
			if (gamefield.moveCheck(start, goal)) {
				gamefield.moveAfterCheck(start, goal);
			}
		}
		blackturn = !blackturn;
		notifyObservers();
		
	}
	
	private boolean checkTurn(Point start) {
		Field field[][] = gamefield.getField();
		Chesspiece piece = field[start.getX()][start.getY()].getChessPiece();
		if(piece == null) {
			return false;
		} 
		
		return colorCheck(piece);
	}
	
	public void reset() {
		gamefield = new GameField();
		blackturn = true;
		notifyObservers();
	}
	
	private boolean colorCheck(Chesspiece piece) {
		if(blackturn) {
			return piece.getcolor() == 'b';
		}
		return piece.getcolor() == 'w';
	}
}
