public class TetrisL2 extends TetrisPiece{
	
	/**
	 *  Constructor
	 */
	
	public TetrisL2(){
		super();
		filledSquares = new boolean [][][]{ 
							{{ false, false, false, false }, { false, true, true, true } , { false, true, false, false }, { false, false, false, false }}, 
							{{ false, false, true, false }, { false, false, true, false } , { false, false, true, true }, { false, false, false, false }}, 
							{{ false, false, false, true }, { false, true, true, true } , { false, false, false, false }, { false, false, false, false }}, 
							{{ false, true, true, false }, { false, false, true, false } , { false, false, true, false }, { false, false, false, false }}, 
						};
	}
}