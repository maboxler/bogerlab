package htwg.se.model;

import java.util.ArrayList;
import java.util.List;

import htwg.se.util.Point;

public class Knight extends Chesspiece {
	
	private Point p;
	private List<Point> validMovesList;

	public Knight(int x, int y, char color) {
		super(x, y, color);
		
		validMovesList = new ArrayList<Point>();
		p = getPosition();
	}

	@Override
	public Point[] validMove(int x, int y) {
		
		if (equalPosition(x, y) || outRange(x, y)) {
			return null;
		}

		whichDirection(x, y);

		return listToArray();
	}
	
	private boolean outRange(int x, int y) {
		if (x >= 8 || x < 0) {
			return true;
		} else if (y >= 8 || y < 0) {
			return true;
		}

		return false;
	}
	
	private void whichDirection(int x, int y) {
		if (x != p.getX() && y > p.getY()) {
			up(x, y);
		} else 
			down(x, y);
		
	}
	
	private void up(int x, int y) {
		if(x < p.getX())
			upLeft(x,y);
		else
			upRight(x,y);
		
	}
	
	private void upLeft(int x, int y) {
			validMovesList.add(new Point(x, y));
			validMovesList.add(new Point(x-2, y+1));
			validMovesList.add(new Point(x-1, y+2));
	}

	private void upRight(int x, int y) {
		validMovesList.add(new Point(x, y));
		validMovesList.add(new Point(x+2, y+1));
		validMovesList.add(new Point(x+1, y+2));	
	}

	private void down(int x, int y) {
		if(x < p.getX())
			downLeft(x,y);
		else
			downRight(x,y);
		
	}
	
	private void downLeft(int x, int y) {
		validMovesList.add(new Point(x, y));
		validMovesList.add(new Point(x-2, y-1));
		validMovesList.add(new Point(x-1, y-2));
		
	}

	private void downRight(int x, int y) {
		validMovesList.add(new Point(x, y));
		validMovesList.add(new Point(x+2, y-1));
		validMovesList.add(new Point(x+1, y-2));
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
	
	
	@Override
	public char toChar() {
		return 'H';
	}

}
