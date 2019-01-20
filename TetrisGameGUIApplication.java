import javax.swing.JFrame;

/**
 * 
 * @author Guest
 *Command line version of the GUI Tetris game.
 */

public class TetrisGameGUIApplication extends java.lang.Object{
	
	public TetrisGameGUIApplication(){
		JFrame tFrame = new JFrame ("TETRIS");
		tFrame.setSize(500,500);
		tFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tFrame.add(new TetrisGameGUIController());
		tFrame.setVisible(true);
	}
	
	/**
	 * main method starts the game 
	 */
	public static void main(java.lang.String[] args){
		new TetrisGameGUIApplication();
	}
	
}
