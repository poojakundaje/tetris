
/**
 * 
 * @author pooja kundaje 
 * TetrisSquare is a tetris square shaped piece
 */
public class TetrisSquare extends TetrisPiece{

	/**
	 * constructor
	 */
	public TetrisSquare() {
		//super();
		
		//0 degrees
		filledSquares[0][1][1]= true;
		filledSquares[0][1][2]= true;
		filledSquares[0][2][1]= true;
		filledSquares[0][2][2]= true;
		
		//90 degrees
		filledSquares[1][1][1]= true;
		filledSquares[1][1][2]= true;
		filledSquares[1][2][1]= true;
		filledSquares[1][2][2]= true;
		
		//180 degrees
		filledSquares[2][1][1]= true;
		filledSquares[2][1][2]= true;
		filledSquares[2][2][1]= true;
		filledSquares[2][2][2]= true;
		
		//270 degrees
		filledSquares[3][1][1]= true;
		filledSquares[3][1][2]= true;
		filledSquares[3][2][1]= true;
		filledSquares[3][2][2]= true;
		
		
	}
}
