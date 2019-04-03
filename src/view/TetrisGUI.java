/*
 * TCSS 305
 * Assignment 5 - Tetris
 */

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import model.Board;

/**
 * The main JFrame contains the game board, next piece panel, text area, and key actions.
 * @author Steve Huang
 * @version 3/1/18
 */
public class TetrisGUI extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 3565967896122405751L;
    
    /**
     * The speed of timer.
     */
    private static final int TIMER_FREQUENCY = 1000;
    
    /**
     * The high of tetris board.
     */
    private static final int HEIGHT = 20;
    /**
     * The width of tetris board.
     */
    private static final int WIDTH = 10;
    
    /**
     * The observable classs.
     */
    private Board myTetrisBoard;
    
    /**
     * The tetris game board.
     */
    private GamePanel myGamePanel;
    
    /**
     * The menu bar.
     */
    private MenuBar myMenuBar;
    
    /**
     * The panel contain next piece tetris.
     */
    private NextPiecePanel myNextPiecePanel;
    
    /**
     * The timer for the game.
     */
    private Timer myTimer;
    
    /**
     * The map store all key action.
     */
    private Map<Integer, Runnable> myKeyActions;
    
    /**
     * Switch start and pause.
     */
    private boolean myPauseToggle;
    
    /**
     * 
     */
    private ScorePanel myScorePanel;
    

    /**
     * The constructor.
     */
    public TetrisGUI() {
        super("305 Tetris Game");
        myTetrisBoard = new Board();
        myGamePanel = new GamePanel();
        myTimer = new Timer(TIMER_FREQUENCY, this::handleTimer);
        myMenuBar = new MenuBar(myTetrisBoard, myTimer);
        myNextPiecePanel = new NextPiecePanel(WIDTH, HEIGHT);
        myKeyActions = new HashMap<Integer, Runnable>();
        myScorePanel = new ScorePanel();
        myPauseToggle = false;
    }
    
    /**
     * Create all the Jpanel.
     */
    public void start() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        myTetrisBoard.addObserver(myGamePanel);
        myTetrisBoard.addObserver(myMenuBar);
        setJMenuBar(myMenuBar);
        add(myGamePanel, BorderLayout.WEST);
        add(createPanelEast(), BorderLayout.EAST);
        createKeyAction();
        
        pack();
        setResizable(false);
        setVisible(true);
    }
    
    /**
     * The panel contains next piece panel, text area, and scre panel.
     * @return JPanel.
     */
    private JPanel createPanelEast() {
        final JPanel panelEast = new JPanel(new BorderLayout());
        myTetrisBoard.addObserver(myNextPiecePanel);
        panelEast.add(myNextPiecePanel, BorderLayout.NORTH);
        myTetrisBoard.addObserver(myScorePanel);
        panelEast.add(myScorePanel, BorderLayout.CENTER);
        panelEast.add(textAreaPanel(), BorderLayout.SOUTH);
        return panelEast;
    }
    
    /**
     * The text area contains all the key constructions.
     * @return JTextArea.
     */
    private JTextArea textAreaPanel() {
        final JTextArea textArea = new JTextArea();
        textArea.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        textArea.setBackground(Color.YELLOW);
        textArea.append("Move Left : \u2190 or A or a \n"
                        + "Move Right : \u2192 or D or d \n"
                        + "Rotate CW: \u2191 or W or w \n"
                        + "Rotate CCW : ctrl\n"
                        + "Move Down : \u2193 S or s \n"
                        + "Drop : Space \n"
                        + "Pause : P or p ");
        textArea.setEditable(false);
        textArea.setFocusable(false);
        return textArea;
    }
    
    /**
     * Create all key Action.
     */
    private void createKeyAction() {
        
        myKeyActions.put(KeyEvent.VK_D, myTetrisBoard::right);
        myKeyActions.put(KeyEvent.VK_RIGHT, myTetrisBoard::right);
        
        myKeyActions.put(KeyEvent.VK_A, myTetrisBoard::left);
        myKeyActions.put(KeyEvent.VK_LEFT, myTetrisBoard::left);
         
        myKeyActions.put(KeyEvent.VK_S, myTetrisBoard::down);
        myKeyActions.put(KeyEvent.VK_DOWN, myTetrisBoard::down);
        
        myKeyActions.put(KeyEvent.VK_W, myTetrisBoard::rotateCW);
        myKeyActions.put(KeyEvent.VK_UP, myTetrisBoard::rotateCW);
        
        myKeyActions.put(KeyEvent.VK_P, this::pauseTimer);
        
        myKeyActions.put(KeyEvent.VK_CONTROL, myTetrisBoard::rotateCCW);
        
        myKeyActions.put(KeyEvent.VK_SPACE, myTetrisBoard::drop);
        
        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(final KeyEvent theEvent) {
                super.keyPressed(theEvent);
                if (myPauseToggle && theEvent.getKeyCode() == KeyEvent.VK_P) {
                    pauseTimer();
                } else if (myPauseToggle) {
                    return;
                } else if (myKeyActions.containsKey(theEvent.getKeyCode())) {
                    myKeyActions.get(theEvent.getKeyCode()).run();
                }
            }
        });


    }
    
    /**
     * Shift the board down by 1.
     * @param theEvent to call the action.
     */
    private void handleTimer(final ActionEvent theEvent) {
        myTetrisBoard.step();
    }
    
    /**
     * Shift the board down by 1.
     */
    private void pauseTimer() {
        myPauseToggle = !myPauseToggle;
        System.out.print("pause");
        if (myPauseToggle) {
            myTimer.stop();      
        } else {
            myTimer.restart();
        }
    }

}
