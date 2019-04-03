/*
 * TCSS 305
 * Assignment 5 - Tetris
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Block;

/**
 * The panel displays the tetris game.
 * @author Steven Huang
 * @version 3/8/18
 */
public class GamePanel extends JPanel implements Observer {
    
    
    /**
     * Default generate serial version UID.
     */
    private static final long serialVersionUID = 1860979716621182121L;
    
    /**
     * 
     */
    private static final int ONE_UNIT = 20;
    /**
     * The high of tetris board.
     */
    private static final int HEIGHT = 20;
    /**
     * The width of tetris board.
     */
    private static final int WIDTH = 10;
    
    /**
     * The x coordinate of block.
     */
    private int myX;
    /**
     * The y coordinate of block.
     */
    private int myY;
    /**
     * The block array that stores the entire tetris board.
     */
    private Block[][] myBlock;
    
    /**
     * 
     */
    public GamePanel() {
        createGamePanel();
        myX = 0;
        myY = (HEIGHT - 1) * ONE_UNIT;
        myBlock = new Block[0][0];
    }
    
    /**
     * 
     */
    private void createGamePanel() {
        
        setPreferredSize(new Dimension(WIDTH * ONE_UNIT, HEIGHT * ONE_UNIT));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.ORANGE);   
    }
    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D tetris = (Graphics2D) theGraphics;
        tetris.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                RenderingHints.VALUE_ANTIALIAS_ON);
        tetris.setPaint(Color.BLUE);
        
        
        if (myY <= ONE_UNIT) {
            myY = (HEIGHT - 1) * ONE_UNIT;
        }
        for (Block[] row : myBlock) {
            myX = 0;
            for (Block b : row) {   
                if (b != null) {
                    tetris.fill(new Rectangle2D.Double(myX, myY, ONE_UNIT, ONE_UNIT));
                    myX += ONE_UNIT;
                } else {
                    myX += ONE_UNIT;
                }
            }
            myY -= ONE_UNIT;
        }
        
    }
    
    


    @Override
    public void update(final Observable theObs, final Object theEvent) {

        if (theEvent instanceof Block[][]) {
            myBlock = (Block[][]) theEvent;
            repaint();        
        } else if (theEvent instanceof Boolean) {
            JOptionPane.showMessageDialog(new JFrame(), "Game over!", 
                                          "GG", JOptionPane.INFORMATION_MESSAGE);
                
            
        }
    
    }
}
