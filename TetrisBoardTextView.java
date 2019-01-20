          /**
 * 
 */

/**
 * @author pooja kundaje 
 *	TetrisBoardTextview creates a string view of a TetrisBoard
 */
public class TetrisBoardTextView extends java.lang.Object{

	private TetrisBoard board;
	
	/**
	 * Constructor- creates a string view of the TetrisBoard in the console
	 */
	public TetrisBoardTextView (TetrisBoard b) {
		this.board= b;
		getBoardString();
	}
	
	public java.lang.String getBoardString(){
		boolean [][] tetrisBoard = board.getBlockMatrix();

		
		
		// prints out the lines on the top of the board
		
		System.out.println ("Please enter a move (l,r,d,z,x) or type Quit to end.");
		System.out.println ("Number of Tetrises cleared: ");//+ this.game.getNumTetrises());
		System.out.println ("Number of lines cleared: ");//+ this.game.getNumLines());
		System.out.println("__________");

		String string = "";

		//goes through the TetrisBoard grid
		for (int rows=0; rows< tetrisBoard.length; rows++){

			for (int columns=0; columns <tetrisBoard[rows].length; columns++){
			
				if ( board.hasBlock (rows,columns)){
					string = string + "x";
				}
				// if the row and column is less than the position then the square is filled
				else  {
							string = string + " ";
						}
					
			}

				if (rows!=tetrisBoard.length-1){
			
			string = string + "\n";
		}
			}
			System.out.println (string);
			System.out.println("__________");
			return string;
		
	}
}
