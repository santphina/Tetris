public class TetrisGame {
	public final int RIGHT = 0;
	public final int LEFT = 1;
	public static final int DOWN = 2;
	public final int CW = 3;
	public final int CWW = 4;
	private int numLines;
	private int numTetrises;
	private TetrisBoard tetrisBoard;
	
	private boolean checkGameOver;

	/**
	 * Constructor: Set up the variables 
	 */
	public TetrisGame(){
		checkGameOver= false;
		numLines = 0;
		numTetrises = 0;
		tetrisBoard = new TetrisBoard();
	}

	/**
	 *  Try to move the current piece with RIGHT, LEFT, DOWN, CW, CCW
	 * @param moveType moveRight/Left/Down/rotateCW/rotateCCW
	 */
	public void attemptMove (int moveType){
		switch (moveType){
			case 0:	tetrisBoard.moveRight();
					break;
			case 1: tetrisBoard.moveLeft();
					break;
			case 2: if (tetrisBoard.moveDown()== false ){
						endRound();
						checkGameOver= true;
					}
					break;
			case 3: tetrisBoard.rotateCW();
					break;
			case 4: tetrisBoard.rotateCCW();
					break;
		}
	}

	/**
	 *  Performed when a piece cannot move down anymore. 
	 */
	private void endRound(){
		//update the board
		tetrisBoard.landPiece();
		
		//numLines = tetrisBoard.numberOfFormedLines();
		int fullLineNum = tetrisBoard.numberOfFormedLines();
			numLines = numLines + fullLineNum;
			
			if (fullLineNum != 0 && fullLineNum % 4 == 0){
				numTetrises = numTetrises + 1;
			}
			
		//new piece
		tetrisBoard.addNewPiece();
	}
	
	/** 
	 *@return numLines number of full lines
	 */
	public int getNumLines(){
		return numLines;
	}
	
	/**
	 *@return numTetrises number of four full lines
	 */
	public int getNumTetrises(){
		return numTetrises;
	}

	/**
	 *@return tetrisBoard current TetrisBoard
	 */
	public TetrisBoard getTetrisBoard(){
		return tetrisBoard;
	}
	
}