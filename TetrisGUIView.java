import java.awt.*;
import javax.swing.*;

/** 
 * Draws Tetris on a screen
 */
public class TetrisGUIView extends JPanel {
	TetrisBoard board;
	
	/**
	 * Constructor: Initiate the default settings
	 * @param b TetrisBoard
	 */
	public TetrisGUIView(TetrisBoard b) {
		board = b;
	}

	/**
	 * @param g Graphics object to draw on
	 * Creates a panel to draw Tetrises in 
	 */
	public void paint(Graphics g) {
		
		paintBoardOutline(g);
		
		for (int i = 0; i < board.getNumRows(); i++) {
			for (int j = 0; j <board.getNumCols(); j ++) {
				if (board.hasBlock(i,j) == true) {
					paintBlock(g, i, j, computeBlockSize());
				}
			}
		}
	}

	/**
	 * Set up the default board outline
	 */
	private void paintBoardOutline(Graphics g) {
		//  big rectangular
		g.setColor(Color.black);
		g.drawRect(0, 0, board.getNumCols()*computeBlockSize(), board.getNumRows()*computeBlockSize());

		}

	/**
	 * Paint a block at the desired location with a fixed size
	 * @param g Graphics object to draw on
	 * @param row Upper left y coordinate of the to-be-drawn block
	 * @param col Upper left x coordinate of the to-be-drawn block
	 * @param blockSize size of the block
	 */
	private void paintBlock (Graphics g, int row, int col, int blockSize) {
	
		
		// Set the color of the inside of the circle
		g.setColor(Color.green);
		// Draw the inside of the circle 
		g.fillRect(col*blockSize, row*blockSize, blockSize, blockSize);
		// Draw outline of the blocks
		g.setColor(Color.black);
		g.drawRect(col*blockSize, row*blockSize, blockSize, blockSize);
		
	
		}

	/**
	 * @return return the size of each block
	 */
	private int computeBlockSize() {
		
		return 50;
	}
	
}

