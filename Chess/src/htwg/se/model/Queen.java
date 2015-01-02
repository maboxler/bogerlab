package htwg.se.model;

import java.util.ArrayList;
import htwg.se.util.Point;
import java.util.List;

public class Queen extends Chesspiece {

	private Point p;
	private List<Point> validMovesList;
	
	public Queen(int x, int y, char color) {
		super(x, y, color);
		validMovesList = new ArrayList<Point>();
		p = getPosition();
	}

	@Override
	public Point[] validMove(int x, int y) {

		if (equalPosition(x, y) || outRange(x,y)) {
			return null;
		}
		
		whichDirection(x, y);

		return listToArray();

	}
	
	private boolean outRange(int x, int y) {
		if(x >= 8 || x < 0) {
			return true;
		}
		else if(y >= 8 || y < 0) {
			return true;
		}
		
		return false;
	}
		
	private void whichDirection(int x, int y) {
		if (x != p.getX() && y == p.getY()) {
			horizontal(x, y);
		} else if (x == p.getX() && y != p.getY()) {
			vertical(x, y);
		} else 
			diagonal(x, y);
	}

	private boolean equalPosition(int x, int y) {
		if (p.getX() == x && p.getY() == y)
			return true;

		return false;
	}

	private Point[] listToArray() {
		Point pointField[] = new Point[validMovesList.size()];
		int i = 0;
		for (Point point : validMovesList) {
			pointField[i] = point;
			i++;
		}
		validMovesList.clear();

		return pointField;
	}

	private void horizontal(int x, int y) {
		if (p.getX() < x) {
			rightHorizontal(x, y);
		} else
			leftHorizontal(x, y);

	}

	private void leftHorizontal(int x, int y) {
		for (int i = p.getX(); i >= x; i--) {
			validMovesList.add(new Point(i, y));
		}
	}

	private void rightHorizontal(int x, int y) {
		for (int i = p.getX(); i <= x; i++) { 
			validMovesList.add(new Point(i, y));
		}
	}

	private void vertical(int x, int y) {
		if (p.getY() < y) {
			upVertical(x, y);
		} else {
			downVertical(x, y);
		}
	}

	private void upVertical(int x, int y) {
		for (int i = p.getY(); i <= y; i++) {
			validMovesList.add(new Point(x, i));
		}
	}

	private void downVertical(int x, int y) {
		for (int i = p.getY(); i >= y; i--) {
			validMovesList.add(new Point(x, i));
		}
	}

	private void diagonal(int x, int y) {
		if (p.getY() < y) {
			upDiagonal(x, y);
		} else {
			downDiagonal(x, y);
		}

	}

	private void upDiagonal(int x, int y) {
		if(x < p.getX()) {
			leftUpDiagonal(x);
		} else {
			rightUpDiagonal(x);
		}
		
		

	}

	private void leftUpDiagonal(int x) {
		int n = 0;
		for (int i = x; i >= x; i--) {
			validMovesList.add(new Point(p.getX() - n, p.getY() + n));
			n++;
		}
		
	}

	private void rightUpDiagonal(int x) {
		int n = 0;
		for (int i = p.getX(); i <= x; i++) {
			validMovesList.add(new Point(p.getX() + n, p.getY() + n));
			n++;
		}
	}

	private void downDiagonal(int x, int y) {
		if(x<p.getX()) {
			leftDownDiagonal(y);
		} else {
			rightDownDiagonal(x);
		}

	}
	
	private void leftDownDiagonal(int x) {
		int n = 0;
		for (int i = p.getX(); i >= x; i--) {
			validMovesList.add(new Point(p.getX() - n, p.getY() - n));
			n++;
		}
		
	}
	
	private void rightDownDiagonal(int x) {
		int n = 0;
		for (int i = p.getX(); i <= x; i++) {
			validMovesList.add(new Point(p.getX() + n, p.getY() - n));
			n++;
		}
		
	}

	@Override
	public char toChar() {
		return 'Q';
	}

}
