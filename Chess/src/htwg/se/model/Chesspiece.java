package htwg.se.model;

public abstract  class Chesspiece implements Piece{
	private int x;// X-Cordinates of the piece
	private int y;// Y-Cordinates of the Piece
	private char color; //Black or White
	protected boolean moved;
	
	public Point getPosition() {
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
		moved = false;
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
