import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author pooja kundaje
 *TetrisGameTextController prints each move of the tetris game on the command line.
 */
public class TetrisGameTextController extends java.lang.Object{


	protected TetrisGame game;
	private TetrisBoardTextView view;

	/**
	 * constructor 
	 */
	public TetrisGameTextController(){
		game= new TetrisGame();
		view= new TetrisBoardTextView(game.getTetrisBoard());
		readInput();

	}

	/**
	 * gets the user's input and keeps looping the game until the player 
	 * types "Quit"
	 */
	private void readInput() {
		String line;
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );

		try {

			line = in.readLine();

			while (!line.equals("Quit")){
				moveEntered (line);
				refreshDisplay(); {


					line = in.readLine();
				}
			}
		}

		catch (IOException ioe){
			ioe.printStackTrace();
		}
	}



	/**
	 * after every more, it prints the text view of the game onto the console. 
	 * 1. print number of tetrises cleared
	 * 2. print the number of lines cleared 
	 * 3. print the tetris board
	 */
	private void refreshDisplay() {

		view.getBoardString();
	}

	/**
	 * moves the piece according to what has been entered
	 * r: right, l: left, z: cw, x: ccw
	 */
	private void moveEntered(String move) {

		if (move.equals("r")){
			game.attemptMove(TetrisGame.RIGHT);
		}
		else if (move.equals("l")){
			game.attemptMove(TetrisGame.LEFT);		
			}
		else if (move.equals("z")){
			game.attemptMove(TetrisGame.CCW);		
			}
		else if (move.equals("x")){
			game.attemptMove(TetrisGame.CW);	
			}
		else if (move.equals("d")){
			game.attemptMove(TetrisGame.DOWN);	
			}

	}

}
