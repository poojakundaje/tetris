/**
 * 
 * @author pooja kundaje 
 * TetrisT is a tetris T shaped piece
 */
public class TetrisT extends TetrisPiece{

	/**
	 * constructor
	 */
	public TetrisT() {
		//super();
		
		//0 degrees
		filledSquares [0][1][1]= true;
		filledSquares [0][1][2]= true;
		filledSquares [0][1][3]= true;
		filledSquares [0][2][2]= true;

		//90 degrees
		filledSquares [1][0][2]= true;
		filledSquares [1][1][2]= true;
		filledSquares [1][2][2]= true;
		filledSquares [1][1][1]= true;

		//180 degrees
		filledSquares [0][1][1]= true;
		filledSquares [0][1][2]= true;
		filledSquares [0][1][3]= true;
		filledSquares [0][0][2]= true;

		//270 degrees
		filledSquares [1][1][0]= true;
		filledSquares [1][1][1]= true;
		filledSquares [1][1][2]= true;
		filledSquares [1][1][2]= true;

	}
}
