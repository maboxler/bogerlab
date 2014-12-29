package htwg.se.view;

import htwg.se.model.*;

public interface UI {
	/*
	 * Displays the current state of the Field
	 */
	public void update(Field[][] field);
	/*
	 * Resets the Game
	 */
	public void restart();
	/*
	 * tells the Controller, which Field has been selected
	 */
	public void pressed(int x, int y);
	
	/*
	 * Displays the given Message
	 */
	public void message(String text);
}
