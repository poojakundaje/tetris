/**
 * 
 */

/**
 * @author pooja kundaje 
 * TetrisGam maintains the tetris game 
 */
public class TetrisGame extends java.lang.Object {

	public static final int RIGHT = 1;
	public static final int LEFT = 2;
	public static final int CW = 3;
	public static final int CCW = 4;
	public static final int DOWN = 5;
	private int numLines;
	private int numTetrises;
	private TetrisBoard tetrisBoard;
	
	/**
	 * constructor 
	 */
	public TetrisGame() {
		tetrisBoard = new TetrisBoard();
	}
	
	/**
	 * try to move the current piece with RIGHT, LEFT, DOWN, CW, CCW
	 */
	public void attemptMove (int moveType) {
		if (moveType ==RIGHT){
			tetrisBoard.moveRight();
		}
		else if (moveType == LEFT){
			tetrisBoard.moveLeft();
		}
		else if (moveType == CW){
			tetrisBoard.rotateCW();
		}
		else if (moveType == CCW){
			tetrisBoard.rotateCCW();
		}
		else if (moveType == DOWN){
			tetrisBoard.moveDown();                                     
		}
	}
	
	/**
	 * performed with a piece can't move down anymore. Ends the round 
	 * by checking for newly formed lines and adding a new piece
	 */
	public void endRound() {
		tetrisBoard.landPiece();
		tetrisBoard.numberOfFormedLines();
		tetrisBoard.addNewPiece();
	}      
	
	/**
	 * @return the numLines
	 */
	public int getNumLines() {
		return numLines;
		
	}
	
	/**
	 * @return numTetrises
	 */
	public int getNumTetrises() {
		return numTetrises;
	}
	
	/**
	 * @return tetrisBoard
	 */
	public TetrisBoard getTetrisBoard() {
		return tetrisBoard;
	}
}
