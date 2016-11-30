public class TetrisL1 extends TetrisPiece{
	
	/**
	 *  Constructor
	 */
	public TetrisL1(){
		super();
		filledSquares = new boolean [][][]{ 
							{{ false, false, false, false }, { false, true, true, true } , { false, false, false, true }, { false, false, false, false }}, 
							{{ false, false, true, true }, { false, false, true, false } , { false, false, true, false }, { false, false, false, false }}, 
							{{ false, true, false, false }, { false, true, true, true } , { false, false, false, false }, { false, false, false, false }}, 
							{{ false, false, true, false }, { false, false, true, false } , { false, true, true, false }, { false, false, false, false }}, 
						};
	}
}