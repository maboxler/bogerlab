package htwg.se.model;

import htwg.se.util.*;

public abstract  class Chesspiece implements Piece{
	
	protected int x;// X-Cordinates of the piece
	protected int y;// Y-Cordinates of the Piece
	protected char color; //Black or White
	protected boolean moved;
	protected boolean alive;
	
	public Point getPosition() {
		return new Point(x,y);
	}
	
	public char getcolor() {
		return this.color;
	}
	
	public void setmovedTrue() {
		this.moved = true;
	}
	
	public void setPosition(Point p){//setter for x and y
		this.x = p.getX();
		this.y = p.getY();
	}

	public void kill() {
		this.alive = false;
		this.setPosition(new Point(-1,-1));
	}
	
	public Chesspiece(int x, int y, char color) {
		this.x = x;
		this.y = y;
		this.color = color;
		moved = false;
		alive = true;
	}
	
	
	public abstract Point[] validMove(int x,int y);
	
	/* returns a Char: 
	 * Pawn = P 
	 * Tower = T
	 * Knight = H(Horse)
	 * Bishop = B
	 * Queen = Q
	 * King = K
	 */
	public abstract char toChar();
}
