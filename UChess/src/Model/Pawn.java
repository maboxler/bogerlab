package Model;

public class Pawn extends Chesspiece {

	public Pawn(int x, int y, char color) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
	}
	boolean moved;
	@Override
	boolean validMove(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
