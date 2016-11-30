public class TetrisS2 extends TetrisPiece{
	
	/**
	 *  Constructor
	 */
	public TetrisS2(){
		super();
		filledSquares = new boolean [][][]{ 
							{{ false, false, false, false }, { false, false, true, true } , { false, true, true, false }, { false, false, false, false }}, 
							{{ false, false, true, false }, { false, false, true, true } , { false, false, false, true }, { false, false, false, false }}, 
							{{ false, false, false, false }, { false, false, true, true } , { false, true, true, false }, { false, false, false, false }}, 
							{{ false, false, true, false }, { false, false, true, true } , { false, false, false, true }, { false, false, false, false }}, 
						};
	}
}