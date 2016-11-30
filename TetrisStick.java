public class TetrisStick extends TetrisPiece{
	
	/**
	 *  Constructor
	 */
	public TetrisStick(){
		super();
		filledSquares = new boolean [][][]{ 
							{{ false, false, false, false }, { true, true, true, true }, { false, false, false, false }, { false, false, false, false }}, 
							{{ false, true, false, false }, { false, true, false, false }, { false, true, false, false }, { false, true, false, false }}, 
							{{ false, false, false, false }, { true, true, true, true }, { false, false, false, false }, { false, false, false, false }}, 
							{{ false, true, false, false }, { false, true, false, false }, { false, true, false, false }, { false, true, false, false }}, 
						};
	}
}