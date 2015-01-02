package htwg.se.model;

import java.util.ArrayList;
import java.util.List;

public class Tower extends Chesspiece {

	private Point p;
	private List<Point> validMovesList;

	public Tower(int x, int y, char color) {
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
		}
		if (x == p.getX() && y != p.getY())
			vertical(x, y);
		
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

	

	@Override
	public char toChar() {
		return 'T';
	}

}
