/**
 * 
 * @author pooja kundaje 
 * TetrisL1 is a tetris L shaped piece
 */
public class TetrisL1 extends TetrisPiece{
	

	/**
	 * constructor
	 */
	public TetrisL1() {
		//super();
		
		//0 degrees
		filledSquares[0][0][2]= true;
		filledSquares[0][1][2]= true;
		filledSquares[0][2][2]= true;
		filledSquares[0][2][3]= true;
		
		//90 degrees
		filledSquares[1][1][1]= true;
		filledSquares[1][1][2]= true;
		filledSquares[1][1][3]= true;
		filledSquares[1][2][1]= true;
		
		//180 degrees
		filledSquares[2][0][1]= true;
		filledSquares[2][0][2]= true;
		filledSquares[2][1][2]= true;
		filledSquares[2][2][2]= true;
		
		//270 degrees
		filledSquares[3][0][3]= true;
		filledSquares[3][1][1]= true;
		filledSquares[3][1][2]= true;
		filledSquares[3][1][3]= true;
	}
}
