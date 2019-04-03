/*
 * TCSS 305
 * Assignment 5 - Tetris
 */

package view;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.TetrisPiece;

/**
 * The score panel displays the score, and level.
 * @author Steven Huang
 * @version 3/8/18
 */
public class ScorePanel extends JPanel implements Observer {

    
    /**
     * The default serial version UID.
     */
    private static final long serialVersionUID = 7790700994635768911L;
    
    /**
     * The starting score.
     */
    private static final int START_SCORE = 4;
    
    /**
     * Clear 5 lines to reach next level.
     */
    private static final int NEXT_LEVEL = 5;
    
    /**
     * The score for level 1.
     */
    private static final int LEVEL1_SCORE = 40;
    
    /**
     * The score for level 2.
     */
    private static final int LEVEL2_SCORE = 100;
    
    /**
     * The score for level 3.
     */
    private static final int LEVEL3_SCORE = 200;
    
    /**
     * The score for level 4.
     */
    private static final int LEVEL4_SCORE = 1200;
    
    /**
     * The current score.
     */
    private int myScore;
    
    /**
     * Store the highest scoe.
     */
    private int myHighestScore;
    
    /**
     * The current level.
     */
    private int myLevel;
    
    /**
     * The total cleared lines.
     */
    private int myClearLines;
    
    /**
     * The label to display the current score and highest score.
     */
    private JLabel myScoreLabel;
    
    /**
     * The label to displays the level.
     */
    private JLabel myLevelLabel;
    
    /**
     * The label to display how many lines to reach the next level.
     */
    private JLabel myCountLevelLabel;
    
    /**
     * The map store the level and corresponding point.
     */
    private Map<Integer, Integer> myCountScore;
    
    /**
     * The constructor.
     */
    public ScorePanel() {
        super(new BorderLayout());
        myScore = START_SCORE;
        myHighestScore = 0;
        myClearLines = 0;
        myLevel = myClearLines / NEXT_LEVEL + 1;
        myCountLevelLabel = new JLabel();
        createScorePanel();
        createLevelPanel();
        createCountLevelPanel();
        createCountScore();
    }
    
    /**
     * Create a panel contains a score label.
     */
    private void createScorePanel() {
        myScoreLabel = new JLabel();
        final JPanel scorePanel = new JPanel();
        scorePanel.add(myScoreLabel);
        add(scorePanel, BorderLayout.NORTH);
    }
    /**
     * Create a panel contains a current level label.
     */
    private void createLevelPanel() {
        myLevelLabel = new JLabel();
        final JPanel levelPanel = new JPanel();
        levelPanel.add(myLevelLabel);
        add(levelPanel, BorderLayout.CENTER);
    }
    
    /**
     * Create a panel contains a reach next level label.
     */
    private void createCountLevelPanel() {
        final JPanel countLevenPanel = new JPanel();
        countLevenPanel.add(myCountLevelLabel);
        add(countLevenPanel, BorderLayout.SOUTH);

    }
    /**
     * Change the display text on score label.
     * @param theScore is the current score.
     * @return the string display the score and highest score.
     */
    private String updateScore(final int theScore) {
        if (theScore > myHighestScore) {
            myHighestScore = theScore;
        }
        return "Score: " + theScore + " Highest Score: " + myHighestScore;
    }
    /**
     * Update the current level and cleared lines.
     * @param theClearLines is the total cleared lines.
     * @return the level and cleared lines.
     */
    private String updateLevel(final int theClearLines) {
        myLevel = theClearLines / NEXT_LEVEL + 1;
        return "Level : " + myLevel + " Cleared Lines: " + theClearLines;
    }
    
    /**
     * Store the level and corresponding score.
     */
    private void createCountScore() {
        myCountScore = new HashMap<Integer, Integer>();
        myCountScore.put(1, LEVEL1_SCORE);
        myCountScore.put(2, LEVEL2_SCORE);
        myCountScore.put(2 + 1, LEVEL3_SCORE);
        myCountScore.put(2 * 2, LEVEL4_SCORE);
    }
    
    /**
     * Update how many lines needs to be clear to reach next level.
     * @param theClearLines is the current cleared lines.
     * @return How many lines needs to be clear to reach next level.
     */
    private String updateCountLevel(final int theClearLines) {
        return  "Clear " +  (NEXT_LEVEL - (theClearLines % NEXT_LEVEL)) 
                     + "\n lines to reach next level.";
    }
    
    
    @Override
    public void update(final Observable theObser, final Object theEvent) {
        if (theEvent instanceof TetrisPiece) {
            myScore += START_SCORE;
            myScoreLabel.setText(updateScore(myScore));
            myLevelLabel.setText(updateLevel(myClearLines));
            myCountLevelLabel.setText(updateCountLevel(myClearLines));
        } else if (theEvent instanceof Integer[]) {
            myClearLines += ((Integer[]) theEvent).length;
            for (Integer i: myCountScore.keySet()) {
                if (i == ((Integer[]) theEvent).length) {
                    myScore += myCountScore.get(i) * myLevel;
                }
            }
            myScoreLabel.setText(updateScore(myScore));
            myLevelLabel.setText(updateLevel(myClearLines));
            myCountLevelLabel.setText(updateCountLevel(myClearLines));

        } else if (theEvent instanceof Boolean) {
            myScore = START_SCORE * 2;
        }
        
    }

}
