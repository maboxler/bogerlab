package htwg.se.model;

public abstract class Chesspiece {
	private int x;// X-Cordinates of the piece
	private int y;// Y-Cordinates of the Piece
	private char color; //Black or White
	
	public Point getPosition() {// getter for x
		return new Point(x,y);
	}
	
	public char getcolor() {
		return this.color;
	}
	
	public void setPosition(Point p){//setter for x
		this.x = p.getX();
		this.y = p.getY();
	}

	
	public Chesspiece(int x, int y, char color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	/* 	checks if the Move form the Current position to
	 	the new X and Y is valid or not. It won't check if there are 
		other pieces in the way Returns true, if the move
	 	is valid
	 */
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
