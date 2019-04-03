/*
 * TCSS 305
 * Assignment 5 - Tetris
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;
import model.Board;


/**
 * The menu bar contains button to start a new game and end a game.
 * @author Steven Huang
 * @version 3/8/18
 */
public class MenuBar extends JMenuBar implements ActionListener, Observer {

    /**
     * Default serial version UID.
     */
    private static final long serialVersionUID = -111659266189879540L; 
    
    /**
     * The speed of timer.
     */
    private static final int TIMER_FREQUENCY = 1000;
    
    
    /**
     * The observable classs.
     */
    private Board myTetrisBoard;
    
    /**
     * The  new game menu item.
     */
    private JMenuItem myNewGame;
    
    /**
     * The end game menu item.
     */
    private JMenuItem myEndGame;
    
    /**
     * The timer for the tetris game.
     */
    private Timer myTimer;
    
    /**
     * The toggle for switch the new game and end game menu item.
     */
    private boolean myToggle;
    
    /**
     * Default constructor.
     * @param theBoard is the game board.
     * @param theTimer the timer for the game.
     */
    public MenuBar(final Board theBoard, final Timer theTimer) {
        myTetrisBoard = theBoard;
        myTimer = theTimer;
        myToggle = false;
        createMenuBar();  
    }
    
    /**
     * Build menu bar.
     */
    private void createMenuBar() {
        final JMenu game = new JMenu("Game");
        myNewGame = new JMenuItem("New Game");
        myEndGame = new JMenuItem("End Game");
        final JMenuItem exitGame = new JMenuItem("Exit");
        
        myEndGame.setEnabled(myToggle);
        myEndGame.addActionListener(this);
        myNewGame.addActionListener(this);
        exitGame.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                System.exit(WindowEvent.WINDOW_CLOSING);
                
            }
        });
        
        game.add(myNewGame);
        game.add(myEndGame);
        game.add(exitGame);
        add(game);
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myToggle = !myToggle;        
        myNewGame.setEnabled(!myToggle);
        myEndGame.setEnabled(myToggle);
        
        if (theEvent.getActionCommand().equals(myEndGame.getText())) {
            myTimer.stop();
        } else {
            myTetrisBoard.newGame();
            myTimer.start();
            myTimer.setDelay(TIMER_FREQUENCY / 2);
        }
    }

    @Override
    public void update(final Observable theObser, final Object theArg) {
        if (theArg instanceof Boolean) {
            myToggle = !myToggle;
            myNewGame.setEnabled(!myToggle);
            myEndGame.setEnabled(myToggle);
        }
    }
    
}
