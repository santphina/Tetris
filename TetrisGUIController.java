import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.*;

/**
 * Creates a panel have the Tetris Game
 */

public class TetrisGUIController extends JPanel implements KeyListener {


private TetrisGame game;
private TetrisGUIView view;
private JLabel tetrisesLable1;
private JLabel tetrisesLable2;
private Timer gameTimer;
public final int DROP_RATE = 1000;

/**
 * Constructor: Set the layout to be border-style S
 * Set up the keyListener
 * Set up Initial Conditions
 */
	public TetrisGUIController() {
		super(new BorderLayout());
		
		setFocusable(true);
		addKeyListener(this);
		
		game = new TetrisGame();
		createView();
		//setupTimer();
		refreshDisplay(); 
		
	}
	
	/**
	 * set up and initialize the timer
	 */	
	public void setupTimer () {
		
		ActionListener taskPerformed = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				game.attemptMove(TetrisGame.DOWN);
				refreshDisplay();
				
			}
		};
	
		
		gameTimer = new Timer(DROP_RATE, taskPerformed);
		
		gameTimer.start();
	}
	
	/**
	 * set up and initialize the panel that holds the tetris and labels for scores
	 */	
	private void createView(){
		tetrisesLable1 = new JLabel("Number of lines cleared               0");
	    tetrisesLable2 = new JLabel ("Number of Tetrises cleared           0"); 
	    
	    JPanel panel = new JPanel();
		
	    panel.add(tetrisesLable1);
	    panel.add(tetrisesLable2);
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    
	    add(panel, BorderLayout.NORTH);
		view = new TetrisGUIView(game.getTetrisBoard());
		// Display the Tetris Board in the center of the panel
		this.add(view, BorderLayout.CENTER);
		
	}
	
	/**
	 * Repaint the display and update the number of lines/tetrises cleared
	 */
	public void refreshDisplay() {
		tetrisesLable1.setText("Number of lines cleared               " + game.getNumLines());
	    tetrisesLable2.setText("Number of Tetrises cleared           " + game.getNumTetrises());
	    repaint();
		
	}
	
	/**
	 * Different Response to the keyPressed event
	 */	
	public void keyPressed (KeyEvent e) {
        int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_RIGHT){	
			game.attemptMove (0);
			refreshDisplay();
		}
		else if (code == KeyEvent.VK_LEFT){
			game.attemptMove (1);
			refreshDisplay();
		}
		else if (code == KeyEvent.VK_DOWN){
			game.attemptMove (2);
			refreshDisplay();
		}
		else if (code == KeyEvent.VK_Z ){
			game.attemptMove (3);
			refreshDisplay();
		}
		else if (code == KeyEvent.VK_X){
			game.attemptMove (4);
			refreshDisplay();
		}
		
	}
	

	/**
	 * Function for the interface keyListener
	 */
	public void keyTyped (KeyEvent e) {}
	
	/**
	 * Function for the interface keyListener
	 */
	public void keyReleased (KeyEvent e) {}
	
}
