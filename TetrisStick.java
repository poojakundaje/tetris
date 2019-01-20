
/**
 * 
 * @author pooja kundaje 
 * TetrisStick is a tetris Stick shaped piece
 */
public class TetrisStick extends TetrisPiece{

	/**
	 * constructor
	 */
	public TetrisStick() {
		//super();
		
		//0 degrees
		filledSquares [0][0][1]= true;
		filledSquares [0][1][1]= true;
		filledSquares [0][2][1]= true;
		filledSquares [0][3][1]= true;

		//90 degrees
		filledSquares [1][1][0]= true;
		filledSquares [1][1][1]= true;
		filledSquares [1][1][2]= true;
		filledSquares [1][1][3]= true;

		//180 degrees
		filledSquares [0][0][1]= true;
		filledSquares [0][1][1]= true;
		filledSquares [0][2][1]= true;
		filledSquares [0][3][1]= true;

		//270 degrees
		filledSquares [1][1][0]= true;
		filledSquares [1][1][1]= true;
		filledSquares [1][1][2]= true;
		filledSquares [1][1][3]= true;
	}
}
