package htwg.se.model;

public class Queen extends Chesspiece {

	public Queen(int x, int y, char color) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Point[] validMove(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char toChar() {
		return 'Q';
	}

}
