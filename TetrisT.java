public class TetrisT extends TetrisPiece{
	
	/**
	 *  Constructor
	 */
	public TetrisT(){
		super();
		filledSquares = new boolean [][][]{ 
							{{ false, false ,false, false }, { false, true, true, true }, { false, false, true, false }, { false, false, false, false }}, 
							{{ false, false, true, false }, { false, false, true, true }, { false, false, true, false }, { false, false, false, false }}, 
							{{ false, false ,true, false }, { false, true, true, true }, { false, false, false, false }, { false, false, false, false }}, 
							{{ false, false, true, false }, { false, true, true, false }, { false, false, true, false }, { false, false, false, false }}, 
						};
	}
}