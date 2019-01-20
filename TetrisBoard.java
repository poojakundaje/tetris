import java.util.Random;

/**
 * 
 */

/**
 * @author pooja kundaje 
 * TetrisBoard is a Model class which represents a board to play Tetris on. 
 * It maintains BlockMatrix and the current piece. 
 */
public class TetrisBoard extends java.lang.Object{
	
	private boolean [][] blockMatrix;
	private TetrisPiece currentPiece;
	
	// position of the current piece that is falling. 
	// currentPieceGridPostion[0] stores the current row and 
	//currentPieceGridPositon[1] stores the current column
	private int[] currentPieceGridPosition;
	
	public static final int NUM_COLS = 10;
	public static final int NUM_ROWS = 18;
	private static final int numCols =4;
	private static final int numRows=4;
	
	/**
	 * constructor- sets up the board
	 */
	public TetrisBoard() {
		
		initBoard();
		initCurrentGP();
		addNewPiece();
		
	}
	
	/**
	 * initializes an int type array of length 2. This keeps track of the 
	 * grid position of the current piece (row,col)
	 */
	private void initCurrentGP() {
		currentPieceGridPosition = new int [2];
		currentPieceGridPosition[0] = 0;
		currentPieceGridPosition[1] = 3;
	}

	/**
	 * Add new random Tetris piece to the board at grid position (0,3)
	 */
	 public void addNewPiece() {
		 Random randomGen= new Random();
		int ranPiece= randomGen.nextInt(7);
		 
		 if (ranPiece==0){
			 currentPiece = new TetrisL1();		 
		 }
		 else if (ranPiece==1){
			 currentPiece = new TetrisL2();
		 }
		 else if (ranPiece==2){
			 currentPiece = new TetrisS1();
		 }
		 else if (ranPiece==3){
			 currentPiece = new TetrisS2();		 
		 }
		 else if (ranPiece==4){
			 currentPiece = new TetrisSquare();
		 }
		 else if (ranPiece==5){
			 currentPiece = new TetrisStick();
		 }
		 else {
			 currentPiece = new TetrisT();
		 }
		 initCurrentGP();
	 }
	
	
	
	/**
	 * initializes the 2D board array to have all false values
	 */
	public void initBoard() {
		blockMatrix= new boolean [NUM_ROWS][NUM_COLS];
	}
	
	
	/**
	 * Update the board array to show the newly landed piece's filled square
	 * using the currentGridPositon values and the currentPiece's rotation value
	 */
	public void landPiece() {
		for (int i=0; i<4; i++){
			for (int j=0; j<4; j++){
				if (currentPiece.isFilled (currentPiece.getPieceRotation(),i,j)){
					blockMatrix [currentPieceGridPosition[0]+i] [currentPieceGridPosition[1]+j] = true;
				}
			}
		}         
		
		addNewPiece();
	}
	

	/**
	 * Checks if placing the piece at grid position (row, col) with the rotation rot
	 *  (values can be 0, 90, 180, 270) would cause a collision (i.e., if there 
	 *  would be a block on an already-filled grid square).
	 * @param piece
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 * @return true if there would be a collision
	 */
	private boolean detectCollision (TetrisPiece piece, int rot, int gridRow, int gridCol) {
		
		for (int i=0; i<4; i++){
			for (int j=0; j<4; j++){
				if (piece.isFilled(rot, i, j)){
					if (blockMatrix [gridRow +i] [gridCol+j]== true){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks if placing the piece at grid position (row, col) with the rotation rot
	 *  (values can be 0, 90, 180, 270) would cause be out of bounds (i.e., if there 
	 *  would be a block falling out of the board).
	 * @param piece
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 * @return true if there would be a bounding error
	 */
	private boolean detectOutOfBounds (TetrisPiece piece, int rot, int gridRow, int gridCol) {
		
		if (gridCol<0){
			return true;
		}
		for (int i=0; i<4; i++){
			for (int j=0; j<4; j++){
				if (piece.isFilled(rot, i, j)){
					if ((gridCol+j)>= numCols || (gridRow+i)>= numRows){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * checks if placing the piece at grid position (row, col) with rotation rot (values can 
	 * be 0,90,180,270) is a valid move
	 * @param piece
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 * @return true if there is no collision or bounding error 
	 */
	private boolean validMove(TetrisPiece piece, int rot, int gridRow, int gridCol) {
		if (!detectOutOfBounds (piece, rot, gridRow, gridCol) && !detectCollision (piece, rot, gridRow, gridCol)){
			return true;
		}
		return false;
	}
	
	
	/**
	 * check if here is a block in the row and column 
	 * @param row
	 * @param col 
	 * @return true if there is a block
	 */
	public boolean hasBlock(int rows, int columns) {
		for (int i=0; i<numRows; i++){
			for (int j=0; j<numCols; j++){
				int x= (currentPieceGridPosition[0] + i);
				int y= (currentPieceGridPosition[1] + j);	
				
				if (currentPiece.isFilled(currentPiece.getPieceRotation(), i, j) && x==rows && y==columns){
					return true;
				}		
			}
		}

		return blockMatrix[rows][columns];
	}



	/**
	 * check if moving left is valid (if its still on board and position on
	 * grid is empty then its valid). If so, move the current piece left
	 * @return true if valid move was performed
	 */
	public boolean moveLeft(){
		if (currentPiece!= null){
			
		
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0], currentPieceGridPosition[1]-1)) {
			
			currentPieceGridPosition[1] = currentPieceGridPosition [1] -1;
			return true;
		}
		}
			return false;
			
	}




	/**
	 * check if moving right is valid (if its still on board and position on
	 * grid is empty then its valid). If so, move the current piece right
	 * @return true if valid move was performed
	 */
	public boolean moveRight() {
		if (currentPiece!= null){
		
		
	if (validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0], currentPieceGridPosition[1]+1)) {
		
		currentPieceGridPosition[1] = currentPieceGridPosition [1]+1;
		return true;
	}
		}
		return false;
		
		
}

	/**
	 * check if moving down is valid (if its still on board and position on
	 * grid is empty then its valid). If so, move the current piece down
	 * true if valid move was performed
	 */
	public boolean moveDown() {
		if (! validMove (currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0] +1, currentPieceGridPosition[1])){
		landPiece();
		}
		else{
		currentPieceGridPosition[0] = currentPieceGridPosition [0] +1;
		return true;
		}
		return false;
	}
	
	/**
	 * check if rotating clockwise is valid (if its still on board and position on
	 * grid is empty then its valid). If so, rotate the current piece clockwise by 
	 * 90 degrees
	 * @return true if valid move was performed
	 */
	public boolean rotateCW() {
//		if (currentPiece == null){
//			return false;
//		}
		boolean Valid;
		Valid= validMove (currentPiece, currentPiece.getPieceRotation()+1, currentPieceGridPosition[0], currentPieceGridPosition[1]);
		if (Valid==true){
			 currentPiece.rotateCW();
		}
		return Valid;
	}
	
	/**
	 * check if rotating anti-clockwise is valid (if its still on board and position on
	 * grid is empty then its valid). If so, rotate the current piece anti-clockwise by 90 
	 * degrees
	 * @return true if valid move was performed
	 */
	public boolean rotateCCW() {
//		if (currentPiece == null){
//			return false;
//		}
		boolean Valid;
		Valid= validMove (currentPiece, currentPiece.getPieceRotation()-1, currentPieceGridPosition[0], currentPieceGridPosition[1]);
		if (Valid==true){
			 currentPiece.rotateCCW();
		}
		return Valid;
	}
	
	 /**
	  * detects and removes any lines formed
	  * @return the total number of lines found 
	  */
	 public int numberOfFormedLines() {
		 int formedLines = 0;
		 for (int i=0; i< numRows; i++){
			 boolean isFormed= true;
			 for ( int j =0; j< numCols; j++){
				 if (blockMatrix [i][j] ==false){
					 isFormed = false;
				 }
				 else if (fullLine (i)){
				 formedLines++;
				 removeLine(i);
			 }
			 }
		 }
		 return formedLines;
			 
	 }
		 
	 
	 /**
	  * checks if there is a full line in the row 
	  * @param row
	  * @return state of the row
	  */
	 private boolean fullLine (int row) {
		 boolean rowEmpty= true;
		 for (int j=0; j< numCols; j++){
			 if (blockMatrix [row][j]==false){
				 rowEmpty= false;
			 }
		 }
		 return rowEmpty;
	 }
	 
	 /**
	  * removes a row in the model. Shifts all the values for rows at a lower 
	  * index to be at one row higher. Make row 0 full of false values 
	  * @param row
	  */
	 private void removeLine (int row) {
		 for (int i= row; i>0 ; i--){
			 for (int j=0; j < numCols; j++){
				 blockMatrix[i][j] = blockMatrix [i-1][j];
			 }
		 }
		 
		 for (int j=0; j< numCols; j++){
			 blockMatrix [0][j]= false;
		 }
		 
	 }
	 
	 /**
	  * @return the block matrix (the grid of blocks)
	  */
	 public boolean [][] getBlockMatrix(){
		 return blockMatrix;
	 }
	 
	 /**
	  * @return the current piece 
	  */
	 public TetrisPiece getCurrentPiece() {
		 return currentPiece;
	 }
	 
	 /**
	  * @return the currentPieceGridPosition
	  */
	 public int[] getCurrentGridPosition() {
		 return currentPieceGridPosition;
	 }
	 
	 /**
	  * @ return the numCols in the block matrix
	  */
	 public int getNumCols() {
		return numCols; 
	 }
	 
	 /**
	  * @return the numRows in the block matrix
	  */
	 public int getNumRows() {
		 return numRows;
	 }
}	
