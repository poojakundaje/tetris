import java.awt.event.KeyEvent;
import java.lang.Object;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Guest
 *
 */
public class TetrisGameGUIController extends javax.swing.JPanel implements java.awt.event.KeyListener{

	
	public static final int DEFAULT_DROP_RATE = 0;
	private TetrisGame game;
	private TetrisBoardGUIView view;
	private javax.swing.JLabel linesLabel;
	private javax.swing.JLabel tetrisesLabel;
	private javax.swing.Timer gameTimer;
	private int dropRate;
	
	
	/**
	 * 
	 */
	public TetrisGameGUIController(){
		super(new BorderLayout());
		game = new TetrisGame();
		view = new TetrisBoardGUIView(game.getTetrisBoard());
		
		
		
		createView();
	}
	
	/**
	 * 
	 */
	private void setupTimer(){

	}

	/**
	 * 
	 */
	private void createView(){
		add(view, BorderLayout.CENTER);
	}

	/**
	 * 
	 */
	private void createScore(){
		
	}

	/**
	 * 
	 */
	public void refreshDisplay(){
		
	}
	
	/**
	 * Handle the key typed event,
	 */
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
