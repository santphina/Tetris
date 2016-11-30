public class TetrisS1 extends TetrisPiece{
	
	/**
	 *  Constructor
	 */
	public TetrisS1(){
		super();
		filledSquares = new boolean [][][] { 
							{{ false, false, false, false }, { false, true, true, false } , { false, false, true, true }, { false, false, false, false }}, 
							{{ false, false, false, true }, { false, false, true, true } , { false, false, true, false }, { false, false, false, false }}, 
							{{ false, false, false, false }, { false, true, true, false } , { false, false, true, true }, { false, false, false, false }}, 
							{{ false, false, false, true }, { false, false, true, true } , { false, false, true, false }, { false, false, false, false }}, 
						};
	}
}