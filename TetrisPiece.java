public class TetrisPiece {
	//3 dimensional array maintaining which squares are filled third dimension is rotation (index 0: 0 degrees, index 1: 90 degrees, 
	//index 2: 180 degrees, index 3: 270 degrees) first and second dimensions create 4x4 grid with true values indicating filled squares
	protected boolean[][][] filledSquares;
	//Maintains the current rotation. 0: 0 degrees, 1: 90 degrees, 2: 180 degrees, 3: 270 degrees.
	protected int pieceRotation;

	/**
	 * Initiate pieceRotation
	 */
	public TetrisPiece(){
		pieceRotation = 0;
	}

	/**
	 * Rotate the piece clockwise by 90 degrees; set pieceRotation for this scenario
	 */
	public void rotateCW(){
		pieceRotation = pieceRotation + 1;
		if (pieceRotation > 3){
			pieceRotation = 0;
		}
	}

	/**
	 * Rotate the piece counter-clockwise by 90 degrees; set pieceRotation for this scenario
	 */
	public void rotateCCW(){
		pieceRotation = pieceRotation - 1;
		if (pieceRotation < 0){
			pieceRotation = 3;
		}
	}

	/**
	 * Get current rotation number of the piece
	 * @return pieceRotation 0 for 0 degree, 1 for 90 degrees , 2 for 180 degrees, 3 for 270 degrees
	 */
	public int getPieceRotation(){
		return pieceRotation;
	}

	/** 
	 * Checks if there is a TetrisBlock at the (row, col) position for the rotation rot, where rot is 0, 90, 180 or 270 degrees
	 *@param rot the TetrisPiece rotation value (should be 0, 90, 180, or 270)
	 *@param row the row within the TetrisPiece 4x4 grid
	 *@param col the column within the TetrisPiece 4x4 grid
	 *@return true if the space is filled in the TetrisPiece 4x4 grid 
	 */

	public boolean isFilled(int rot, int row, int col){
		if (filledSquares[rot][row][col]==true){
			return true;
		}
		else {return false;}
	}
}