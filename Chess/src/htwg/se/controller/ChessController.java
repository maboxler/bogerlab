package htwg.se.controller;

import htwg.se.util.*;
import htwg.se.model.*;




public class ChessController extends Observable{
	private GameField gamefield;
	
	public ChessController( GameField gamefield) {
		this.gamefield = gamefield;
	}
	
	public Field[][] getField() {
		return gamefield.getField();
	}
	
	public void ControllFlow() {
		while(!gamefield.blackWon() && !gamefield.whiteWon()) {
			
		}
	}
}
