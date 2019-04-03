/*
 * TCSS 305
 * Assignment 5 - Tetris
 */

package view;

import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * @author Steven Huang
 * @version 3/1/18
 */
public final class TetrisMain {

    /**
     * Default constructor.
     */
    private TetrisMain() {
        
    }
    
    /**
     * 
     * @param theArgs
     */
    public static void main(final String[] theArgs) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (final UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (final IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (final InstantiationException ex) {
            ex.printStackTrace();
        } catch (final ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new TetrisGUI().start();
            }
        });
    }
}
