package CONTROLLER;
import Model.*;



public class GuiControll {
	private Chesspiece gamefield[][];
	
	public GuiControll() {
		gamefield = new Chesspiece[8][8];
		initGameField();
		
	}
	
	public static void main(String[] args) {
		initGameField();
	}
	
	private static void initGameField() {
		initPawns();
		initTowers();
		initKnights();
		initBishops();
		intiKings();
		initQueens();
	}
	
	private static void initPawns(){
		
	}
	
	private static void initTowers(){
		
	}
	
	private static void initKnights(){
		
	}
	
	private static void initBishops(){
		
	}
	
	private static void initQueens(){
		
	}
	
	private static void intiKings(){
		
	}
	
	public boolean checkMove(int x1,int y1,int x2,int y2) {
		return false;
	}
}
