package htwg.se.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import htwg.se.controller.ChessController;
import htwg.se.model.Field;
import htwg.se.util.ChessButton;
import htwg.se.util.Event;
import htwg.se.util.IObserver;
import htwg.se.util.Point;

public class GUI implements UI, IObserver, ActionListener {

	static final Logger log = Logger.getLogger(GUI.class.getName());
	ChessController controller;
	ChessButton buttons[][];
	JFrame meinFrame;
	JPanel panel;
	JPanel panelGameField;
	JPanel panelScore;
	Image img;
	boolean firstpressed;
	boolean colorSwap = false;
	Point first;
	JLabel whichTurn;
	JLabel from;
	JLabel target;
	public GUI(ChessController cc) {

		controller = cc;
		controller.addObserver(this);

		panel = new JPanel();
		panelGameField = new JPanel();
		panelScore = new JPanel(new BorderLayout());
		panel = new JPanel(new BorderLayout());
		panelGameField.setLayout(new GridLayout(8, 8));
		whichTurn = new JLabel();
		from = new JLabel();
		target = new JLabel();
		panelScore.add(whichTurn, BorderLayout.NORTH);
		panelScore.add(from, BorderLayout.WEST);
		panelScore.add(target, BorderLayout.EAST);
		panel.add(panelGameField, BorderLayout.CENTER);
		panel.add(panelScore, BorderLayout.NORTH);
		buttons = new ChessButton[8][8];
		meinFrame = new JFrame("Ultimate Chess");
		meinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		meinFrame.setSize(1000, 1100);
		meinFrame.add(panel);
		
		initField();
		drawField();
		meinFrame.setVisible(true);
		meinFrame.repaint();

	}

	private void initField() {
		for (int y = 7; y >= 0; y--) {
			for (int x = 0; x < 8; x++) {
				buttons[x][y] = new ChessButton();
				buttons[x][y].setFieldX(x);
				buttons[x][y].setFieldY(y);
				buttons[x][y].addActionListener(this);
				panelGameField.add(buttons[x][y]);
			}
		}
	}

	private void drawField() {
		Field field[][] = controller.getField();
		String figure = "";
		
		for (int y = 7; y >= 0; y--) {
			for (int x = 0; x < 8; x++) {
				
				setButtonColorField(y, x);
				if (field[x][y].getChessPiece() != null) {
					figure += field[x][y].getChessPiece().getcolor();
					figure += field[x][y].getChessPiece().toChar();
					figure += buttons[x][y].getFieldColor();
					figure += ".jpg";
					//System.out.println(figure);
					setButtonImage(y,x,figure);
					figure = "";
				} 
						
			}
		}
		
		
		message(controller.getStatusMessage());
	}

	private void setButtonColorField(int y, int x) {
		try {
			img = ImageIO.read(getClass().getResource(whichColorField(x, y)));
			buttons[x][y].setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setButtonImage(int y, int x, String chessPiece) {
		try {
			img = ImageIO.read(getClass().getResource(chessPiece));
			buttons[x][y].setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String whichColorField(int x, int y) {
		if (x == 0)
			swapColor();

		if (colorSwap) {
			buttons[x][y].setFieldColor("w");
			swapColor();
			return "whiteField.jpg";
		}
		swapColor();
		buttons[x][y].setFieldColor("b");
		return "blackField.jpg";
	}

	private void swapColor() {
		colorSwap = !colorSwap;
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		ChessButton cbutton = (ChessButton) o;	
		pressed(cbutton.getFieldX(), cbutton.getFieldY());
	}
	
	public void winner() {
		meinFrame.setTitle("GAME OVER");
		whichTurn.setText("SPIEL ZU ENDE");
		from.setText("");
		target.setText("");
		
		meinFrame.setEnabled(false);
		
	}

	public void message(String text) {
		whichTurn.setText(text);
	}


	@Override
	public void update(Event e) {
		drawField();
		if(controller.checkWin())
			winner();
	}

	@Override
	public void restart() {
		controller.reset();
		drawField();

	}

	@Override
	public void pressed(int x, int y) {
		if(firstpressed && new Point(x,y) != first) {
			from.setText("FROM x:"+x+" y: "+y);
			controller.move(first, new Point(x,y));
			firstpressed = false;
			return;
		}
		first = new Point(x,y);
		target.setText("TARGET x:"+x+" y: "+y);
		firstpressed = true;

	}

}