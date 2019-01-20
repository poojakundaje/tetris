import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Pooja Kundaje
 *
 */
public class TetrisBoardGUIView extends JComponent {
	
	private TetrisBoard board;
		
	public TetrisBoardGUIView(TetrisBoard b){
		
		board = b;
		super.setLayout(new BorderLayout());
		repaint();
		JPanel Panel = new JPanel();
//		Panel.add(new b());
	}
	
	/**
	 * paints the different pieces of the tetris game 
	 */
	public void paint(Graphics g){
		paintBoardOutline(g,computeBlockSize());
		
	}
	
	/**
	 * 
	 */
	private void paintBoardOutline(Graphics g, int blockSize){
		 
	g.drawRect(0, 0, blockSize*board.getNumCols(), blockSize*board.getNumRows());
	}
	
	/**
	 * Paints the blocks at gridRow and gridCol to draw the shape
	 */
	private void paintBlock(Graphics g, int row, int col, int blockSize){
		for (int i=0; i<board.NUM_ROWS; i++){
			for (int j=0; j<board.NUM_COLS; j++){
				if (board.hasBlock(i,j)){
					g.setColor(Color.ORANGE);
					
				}
			}
		}
	}
	
	/**
	 * compute the best blocksize for the current width and height
	 * @return the size of a square block in pixels
	 */
	private int computeBlockSize(){
		return 0;
	}
}
