package htwg.se.model;

import java.util.ArrayList;
import java.util.List;

import htwg.se.util.Point;

public class Pawn extends Chesspiece {

	boolean moved;
	private Point p;
	private List<Point> validMovesList;

	public Pawn(int x, int y, char color) {
		super(x, y, color);
		moved = false;
		validMovesList = new ArrayList<Point>();
		p = getPosition();
	}

	@Override
	public Point[] validMove(int x, int y) {

		
		
		if (equalPosition(x, y) || outRange(x, y) || possibleMove(x,y)) {
			return null;
		}
		
		whichDirection(x, y);

		moved = true;
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
		if (x == p.getX() && y > p.getY()) {
			vertical(x, y);
		} else
			diagonal(x, y);
	}

	private void diagonal(int x, int y) {
		if(x < p.getX()) 
			leftUpDiagonal(x);
		 else 
			rightUpDiagonal(x);
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

	private boolean equalPosition(int x, int y) {
		if (p.getX() == x && p.getY() == y)
			return true;

		return false;
	}

	private boolean possibleMove(int x, int y) {		
		List<Point> allMoveList = new ArrayList<Point>();
		Point move = new Point(x,y);
		
		allMoveList.add(new Point(p.getX(), p.getY()+1));
		allMoveList.add(new Point(p.getX()+1, p.getY()+1));
		allMoveList.add(new Point(p.getX()-1, p.getY()+1));
		
		if(moved == false) {
			allMoveList.add(new Point(p.getX(), p.getY()+2));
		}
		
		for (Point point : allMoveList) {
			if(move.equals(point))
				return false;
		}

		return true;
		
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

	private void vertical(int x, int y) {
		for (int i = p.getY(); i <= y; i++) {
			validMovesList.add(new Point(x, i));
		}
	}

	public char toChar() {
		return 'P';
	}

}
