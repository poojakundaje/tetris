                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            /**
 * 
 */

/**
 * @author pooja kundaje 
 * TetrisPeice is an abstract class that manages a piece made of 4 
 * TetrisBlocks which is a 4x4 grid with certain squares filled
 * to create the shape. It maintains 0, 90, 180 and 270 degree rotations 
 */

public abstract class TetrisPiece extends java.lang.Object{

	//3D array which maintains the squares that are filled. 
	//first dimension: rotation (index: 0: 0 degrees, 1: 90 degrees, 
	//2: 180 degrees, 3: 270 degrees.
	//second and third dimensions create the 4x4 grid in which true values
	//indicates filled squares. 
	protected boolean [][][] filledSquares;
	
	//maintains the current rotation,
	//0: 0 degrees, 1: 90 degrees, 2:180 degrees, 3: 270 degrees 
	protected int pieceRotation;
	
	/**
	 * constructor- sets initial rotation at 0
	 */
	public TetrisPiece() {
		pieceRotation=0;
		filledSquares = new boolean[4][4][4];
	}
	
	/**
	 * Rotates the piece clockwise by 90 degrees
	 */
	public void rotateCW() {
		if (pieceRotation ==3){
			pieceRotation =0;
		}
		else {
			pieceRotation = pieceRotation +1;
		}
	}
	
	/**
	 * rotates the piece anti-clockwise by 90 degrees
	 */
	public void rotateCCW() {
		if (pieceRotation ==0){
			pieceRotation =3;
			
		}
		else{
			pieceRotation = pieceRotation -1;
		}
	}
	
	/**
	 * get the rotation of the current piece
	 * @return 0, 90, 180 or 270 degrees
	 */
	public int getPieceRotation() {
		return pieceRotation;
	}
	
	/**
	 * checks if the position (row,col) for the rotation rot is 
	 * occupied by another TetrisBlock 
	 * rot= 0,90,180,270 degrees 
	 * @param rot: rotation value of tetrisPiece (0, 90, 180, or 270)
	 * @param row: row within TetrisPiece 4x4 grid
	 * @param col: column within TetrisPiece 4x4 grid
	 * @return true if there is a block in the position for that rotation
	 */
	public boolean isFilled (int rot, int row, int col) {
		if (filledSquares[rot][row][col]==true){
			return true;
		}
		return false;
	}
}

