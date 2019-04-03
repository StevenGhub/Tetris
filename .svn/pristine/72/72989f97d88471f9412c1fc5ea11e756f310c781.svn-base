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
import javax.swing.JPanel;
import model.Block;
import model.Point;
import model.TetrisPiece;

/**
 * The panel displays the next piece of tetris.
 * @author Steven Huang
 * @version 3/8/18
 */
public class NextPiecePanel extends JPanel implements Observer {

    /**
     * The default serial version UID. 
     */
    private static final long serialVersionUID = -3254087614079880441L;
    
    /**
     * The size of one block is 20x20.
     */
    private static final int ONE_UNIT = 20;
    
    /**
     * The point array contains the location of next piece tetris.
     */
    private Point[] myPoints;
    
    /**
     * The next piece tetris.
     */
    private Block myBlock;
    
    /**
     * The width of the panel.
     */
    private int myWidth;
    
    /**
     * The height of the panel.
     */
    private int myHeight;
    
    /**
     * 
     * @param theX is the width of the game panel.
     * @param theY is the height of the game panel.
     */
    public NextPiecePanel(final int theX, final int theY) {
        myWidth = theX * ONE_UNIT;
        myHeight = (theY - 1) * ONE_UNIT / 2;
        myPoints = new Point[0];
        createNextPiecePanel();
    }
    /**
     * Create a panel to show up next piece.
     */
    private void createNextPiecePanel() {
        setPreferredSize(new Dimension(myWidth, myHeight));
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }
    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D nextPiece = (Graphics2D) theGraphics;
        
        nextPiece.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                         RenderingHints.VALUE_ANTIALIAS_ON);
        nextPiece.setPaint(Color.WHITE);
        for (Point p: myPoints) {
            if (myBlock == Block.I) {
                nextPiece.fill(new Rectangle2D.Double((myWidth / 2) - (p.x() - 1) * ONE_UNIT, 
                                                      (myHeight / 2) - (p.y() - 2) * ONE_UNIT, 
                                                      ONE_UNIT, ONE_UNIT));
            } else {
                nextPiece.fill(new Rectangle2D.Double((myWidth / 2) - (p.x() - 1) * ONE_UNIT, 
                                                      (myHeight / 2) - (p.y() - 1) * ONE_UNIT, 
                                                      ONE_UNIT, ONE_UNIT));
            }
        }
    }

    @Override
    public void update(final Observable theObser, final Object theArg) {
        if (theArg instanceof TetrisPiece) {
            myBlock = ((TetrisPiece) theArg).getBlock();
            myPoints = ((TetrisPiece) theArg).getPoints();
            repaint();
        }
        
    }

}
