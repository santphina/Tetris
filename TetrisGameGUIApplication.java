import javax.swing.JFrame;

public class TetrisGameGUIApplication
{
	/**
	 * Sets the width of the frame to 530 pixels
	 */
    public static int FRAME_WIDTH = 530;
	
	/**
	 * Sets the height of the frame to 1000 pixels
	 */
    public static int FRAME_HEIGHT = 1000;

	/**
	 * Creates and draws the frame for the tetris
	 * main method. Starts game by calling controller constructor
	 * @param args not used here
	 */

    public static void main(String[] args)
    {
    	TetrisGUIController controller = new TetrisGUIController();
    	controller.setupTimer();
		JFrame circleFrame = new JFrame("Tetris");
		circleFrame.add(controller);
		circleFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		circleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		circleFrame.setVisible(true);

    }
	

}