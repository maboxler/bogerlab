package Model;

public abstract class Chesspiece {
	int x;// X-Cordinates of the piece
	int y;// Y-Cordinates of the Piece
	char color; //Black or White
	
	public int getX() {// getter for x
		return this.x;
	}
	public int getY() {// getter for y
		return this.y;
	}
	
	public void setX(int x){//setter for x
		this.x = x;
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
	abstract boolean validMove(int x,int y);
}
