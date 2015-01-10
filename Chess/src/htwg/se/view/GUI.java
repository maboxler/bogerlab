package htwg.se.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import htwg.se.controller.ChessController;
import htwg.se.model.Field;
import htwg.se.util.ChessButton;
import htwg.se.util.Event;
import htwg.se.util.IObserver;
import htwg.se.util.Point;



public class GUI implements UI, IObserver, ActionListener  {

	static final Logger log = Logger.getLogger( GUI.class.getName() );
	ChessController controller;
	ChessButton buttons[][];
	JFrame meinFrame;
	JPanel panel;
	JPanel panelGameField;
	JPanel panelScore;
	Image img;
	boolean firstpressed;
	boolean colorSwap = false;
	
	public GUI(ChessController cc) {
			
			controller = cc;
		
			panel = new JPanel();
			panelGameField = new JPanel();
			panelScore = new JPanel();
			panel = new JPanel(new BorderLayout());
			panelGameField.setLayout(new GridLayout(8, 8));
			panelScore.add(new JTextField("Schwarz     test DIsco"));
			panel.add(panelGameField, BorderLayout.CENTER);
			panel.add(panelScore, BorderLayout.EAST);
			
			buttons = new ChessButton[8][8];
			meinFrame = new JFrame("Ultimate Chess");   
			meinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        meinFrame.setSize(1000, 800);
	        initField();
	        drawField();
	        meinFrame.add(panel);
	        meinFrame.setVisible(true);
	        meinFrame.repaint();
		
	}

	private void initField() {
		for(int y=7;y>=0;y--) {
			for(int x=0;x < 8; x++) {
				buttons[x][y] = new ChessButton();
				buttons[x][y].setFieldX(x);
				buttons[x][y].setFieldY(y);
				buttons[x][y].addActionListener(this); 
				setButtonImage(y, x);
				//buttons[x][y].setText("x: "+x+" y:"+y);
				panelGameField.add(buttons[x][y]);
			}
		}
		log.info( "Initialize Field succes" );
	}

	private void setButtonImage(int y, int x) {
		try {
			img = ImageIO.read(getClass().getResource(whichColorField(x)));
			buttons[x][y].setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private String whichColorField(int x) {
		if(x==0)
			swapColor();
		
		if(colorSwap) {
			swapColor();
			return "whiteField.jpg";
		}
		swapColor();
		return "blackField.jpg";
	}

	private void swapColor() {
		colorSwap = !colorSwap;
	}

	public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			ChessButton cbutton = (ChessButton) o;
	            System.out.println("x: "+cbutton.getFieldX()+" y: "+cbutton.getFieldY());
	} 

	private void drawField() {
		
		
	}

	@Override
	public void update(Event e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pressed(int x, int y) {
		// TODO Auto-generated method stub
		
	}


}
