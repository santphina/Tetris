public class TetrisBoard {

/**
 * Constant Field Values
 */
public final int NUM_COLS = 10;
/**
 * Constant Field Values
 */
public final int NUM_ROWS = 18;
/**
 * matrix of the board
 */
private boolean[][] boardMatrix;
/**
 * current(falling) piece
 */
private TetrisPiece currentPiece;
/**
 * position of current (falling) piece; {row, column}
 * currentPieceGridPosition[0] stores the current row
 * currentPieceGridPosition[1] stores the current column 
 */
private int[] currentPieceGridPosition;

/** 
 * Constructor: sets up the board and the initial position of the input piece
 */
public TetrisBoard() {
	boardMatrix = new boolean[NUM_ROWS][NUM_COLS];
	initBoard();
	initCurrentGP();
	addNewPiece();
}

/**
 * Initialize an integer array of length two to keep track of the grid position 
 * of the current tetris piece (row, col)
 */

private void initCurrentGP(){
	currentPieceGridPosition = new int [2];
	currentPieceGridPosition[0] = 0;
	currentPieceGridPosition[1] = 3;
}

/**
 * Initiate the Board with all false values  
 */
private void initBoard(){
	for (int i = 0; i < NUM_ROWS; i++){
		for (int j = 0; j < NUM_COLS; j++){
		boardMatrix[i][j] = false;
		}
	}
}
/** 
 * Update the board array to reflect the newly landed piece's filled squares 
 * using the currentGridPosition values and the currentPiece's rotation value.
 */
 
public void landPiece(){
	
	for (int i=0; i<4; i++) {
		for (int j=0; j<4; j++){
			if (currentPiece.isFilled(currentPiece.getPieceRotation(), i, j)) {
				boardMatrix[currentPieceGridPosition[0]+i][currentPieceGridPosition[1]+j]=true;
			}
		}
	}
}

/**
 * key input: l; Check if moving left is plausible. If so, move the current piece left.
 * @return true if validMove is true
 */
public boolean moveLeft(){
	boolean check;
	
	if(currentPiece==null){return false;}
	
	check = validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0], currentPieceGridPosition[1]-1);
	if (check == true) {
		currentPieceGridPosition[1] = currentPieceGridPosition[1]-1;;
		return true;
	}
	else {return false;}
}
/**
 * key input: r; Check if moving right is plausible. If so, move the current piece right.
 * @return true if validMove is true
 */
public boolean moveRight(){
	boolean check;
	
	if(currentPiece==null){return false;}
	
	check = validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0], currentPieceGridPosition[1]+1);
	if (check == true) {
		currentPieceGridPosition[1] = currentPieceGridPosition[1] + 1;
		return true;
	}
	else {return false;}
}
/**
 * key input: d; Check if moving right is plausible. If so, move the current piece right.
 * @return true if validMove is true
 */
public boolean moveDown(){
	boolean check;
	
	if(currentPiece==null){return false;}
	
	check = validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0]+1, currentPieceGridPosition[1]);
	if (check == true) {
		currentPieceGridPosition[0] = currentPieceGridPosition[0] + 1;
		return true;
	}
	else {return false;}
}
/**
 * key input: z; Check if rotating clockwise is plausible. If so, rotate the current piece clockwise by 90 degrees.
 * @return true if validMove is true
 */
public boolean rotateCW(){
	boolean check;
	if(currentPiece==null){return false;}
	
	currentPiece.rotateCW();

	check = validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0], currentPieceGridPosition[1]);
	if (check == true) {
		return true;
	}
	else {
		currentPiece.rotateCCW();
		return false;}
}
/**
 * key: x; Check if rotating clockwise is plausible. If so, rotate the current piece clockwise by 90 degrees.
 * @return true if validMove is true
 */
public boolean rotateCCW(){
	boolean check;
	if(currentPiece==null){return false;}
	
	currentPiece.rotateCCW();

	check = validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0], currentPieceGridPosition[1]);
	if (check == true) {
		return true;
	}
	else {
		currentPiece.rotateCW();
		return false;}
}

/**
 * Checks if placing the piece at grid position (row, col) with the rotation rot (values can be 0, 90, 180, 270) 
 * would cause a collision (i.e., if there would be a block on an already-filled grid square).
 * @param piece Tetris Block
 * @param rot Rotation number of the Tetris Block
 * @param gridRow
 * @param gridCol
 * @return true if there will be a collision with the attempt move
 */
private boolean detectCollision(TetrisPiece piece, int rot, int gridRow, int gridCol){
	for (int i=0; i<4; i++){
		for (int j=0; j<4; j++){
			if (currentPiece.isFilled(rot, i, j)){
				if(boardMatrix[gridRow+i][gridCol+j]){
					return true;
				}
			}
		}
	}
	return false;
}

/**
 * Checks if placing the piece at grid position (row, col) with the rotation rot (values can be 0, 90, 180, 270) 
 * would cause an out of bounds condition (i.e., if there would be a block falling off the board).
 * @param piece Tetris Block
 * @param rot Rotation number of the Tetris Block
 * @param gridRow
 * @param gridCol
 * @return true if the piece will be out of the board with the attempt move
 */
private boolean detectOutOfBounds(TetrisPiece piece, int rot, int gridRow, int gridCol){

	for (int i=0; i<4; i++){
		for (int j=0; j<4; j++){
			if (piece.isFilled(rot,i,j)){
				//check if it is out of bounds
				if(gridRow+i>17 || gridCol+j>9 || gridCol+j<0){
					return true;
				}
			}
		}
	}

	return false;
}

		

/**
 * Checks if placing the piece at grid position (row, col) 
 * with the rotation rot (values can be 0, 90, 180, 270) is a valid move.
 * @param piece Tetris Block
 * @param rot Rotation number of the Tetris Block
 * @param gridRow
 * @param gridCol
 * @return true if no collision or bounding error
 */
private boolean validMove(TetrisPiece piece, int rot, int gridRow, int gridCol){
	
	if (detectOutOfBounds(piece, rot, gridRow, gridCol) == false){
		if (detectCollision(piece, rot, gridRow, gridCol) == false){ 
			return true;
		} 
	}
	
	return false;
}

/**
 * Check if there is a block or an input piece in the row and column
 * @param row the row position of the grid  
 * @param col the column position of the grid 
 * @return return true if both board and the piece have value of true
 */

public boolean hasBlock(int row, int col){
	int xCoord = currentPieceGridPosition[0];
	int yCoord = currentPieceGridPosition[1];
	boolean filledCheck;
	
	if (currentPiece == null){return false;}
	
	for (int i =0; i < 4; i++) {
		for (int j =0; j < 4; j++) {
			//Check if there is a piece on this position of the board
			filledCheck = currentPiece.isFilled(currentPiece.getPieceRotation(), i, j);
			if (filledCheck == true && xCoord + i == row && yCoord + j == col) {
				return true;
			}
		}
	}

	return boardMatrix[row][col];
}

/**
 *  Add a new random Tetris piece to the board at grid position (0, 3);Not update the board
 */
public void addNewPiece(){
	// Generate a random number
	int choiceNum = (int) (Math.random() * 7);
	// Choose a type of block according to this random number
	
	switch (choiceNum){
		case 1:	currentPiece = new TetrisL1(); 
				break;
		case 2: currentPiece = new TetrisL2(); 
				break;
		case 3: currentPiece = new TetrisS1(); 
				break;
		case 4: currentPiece = new TetrisS2(); 
				break;
		case 5: currentPiece = new TetrisSquare(); 
				break;
		case 6: currentPiece = new TetrisStick(); 
				break;
		case 7: currentPiece = new TetrisT(); 
				break;
	}
	// Add new piece at grid position (0, 3)
	initCurrentGP();
	}
/**
 *  Detect and remove any lines formed as well as return number of formed lines
 * @return formedLines number of full lines
 */
public int numberOfFormedLines(){
	int formedLines=0;

	for (int i=NUM_ROWS-1; i>=0; i--){
		if (checkFullLine(i) == true){
			formedLines++;
			removeFullLine(i);
			// After removing the line, reset the function
			// So that when there are two lines to be deleted, the function knows where to go
			i = i + 1;
		}
	}

	return formedLines;
}

/**
 * Check if there is a full line at the row
 * @return true if a line is full
 */
private boolean checkFullLine(int row){
	int trueNum = 0;

	for (int j=0; j<NUM_COLS; j++){
		if (boardMatrix[row][j]){
			trueNum ++;}
	}
	
	if(trueNum == NUM_COLS){
		return true;}
	else {return false;}
}

/** Remove the full line at row in the model. 
 * Shift all values for rows at a lower index to be at one row higher. 
 * @param row Make row 0 full of false values.
 */
private void removeFullLine (int row)
{
	for (int i=0; i<NUM_COLS; i++)
	{
		boardMatrix[row][i]=false;
	}
	while (row>0)
	{
		for (int j=0; j<10; j++)
		{
			boardMatrix[row][j]=boardMatrix[row-1][j];
		}
		row--;
	}
	
	for (int m=0; m<NUM_COLS; m++)
	{
		boardMatrix[0][m]=false;
	}
}

/**
 * @return boardMatrix the board matrix of the game
 */
public boolean[][] getBoardMatrix(){
	return boardMatrix;
}

/** 
 * @return the current piece in motion on the board
 */
public TetrisPiece getCurrentPiece(){
	return currentPiece;
}

/** 
 * @return currentPieceGridPosition The left upper corner x,y coordinate of the piece in motion
 */
public int[] getCurrentPieceGridPosition(){
	return currentPieceGridPosition;
}

/**
 *@return NUM_COLS the numCols in the block matrix
 */
public int getNumCols(){
	return NUM_COLS;
}

/**
 *@return NUM_ROWS the numRows in the block matrix
 */
public int getNumRows(){
	return NUM_ROWS;
}

}