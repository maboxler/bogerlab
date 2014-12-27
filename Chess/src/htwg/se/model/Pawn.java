package htwg.se.model;

public class Pawn extends Chesspiece {

	boolean moved;
	
	public Pawn(int x, int y, char color) {
		super(x, y, color);
		moved = false;
	}
	
	@Override
	public Point[] validMove(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}


	public char toChar() {
		return 'P';
	}
	

}
