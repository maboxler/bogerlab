package htwg.se.model;

public class Bishop extends Chesspiece {

	public Bishop(int x, int y, char color) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validMove(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public char toChar() {
		return 'B';
	}

}
