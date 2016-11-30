public class TetrisSquare extends TetrisPiece{
	
	/**
	 *  Constructor
	 */
	public TetrisSquare(){
		super();
		filledSquares = new boolean [][][]{ 
							{{ false, false, false, false }, { false, true, true, false } , { false, true, true, false }, { false, false, false, false }}, 
							{{ false, false, false, false }, { false, true, true, false } , { false, true, true, false }, { false, false, false, false }}, 
							{{ false, false, false, false }, { false, true, true, false } , { false, true, true, false }, { false, false, false, false }}, 
							{{ false, false, false, false }, { false, true, true, false } , { false, true, true, false }, { false, false, false, false }}, 
						};
	}
}