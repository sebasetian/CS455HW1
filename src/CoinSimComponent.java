// Name: LIN,SHIH YAO
// USC NetId: 7208835144
// CSCI 455 PA1
// Spring 2018
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

/**
 * CoinSimComponent class
 *  Extends JComponent.
 *  This class uses the CoinTossSimulator and Bar class.
 *
 *  CoinSimComponent class has a one-args constructor
 *  initializes CoinTossSimulator class,
 *  runs the simulation, and add twoHeadsNumbers, twoTailsNumbers,
 *  headTailsNumbers,trialsNumbers.
 *
 *  How to run : Call CoinSimComponent constructor, and call a
 *               Frame method "add(CoinSimComponent object)"
 *               to add the result to the screen.
 *               Call runSimulator(numTrials) to rerun CoinTossSimulator
 *               and resetSimulator() to reset CoinTossSimulator
 *
 *  CoinSimComponent class has the following name constants:
 *          HEAD_TAIL_COLOR : the color of head-tail toss
 *          TWO_HEAD_COLOR : the color of two-head toss
 *          TWO_TAIL_COLOR : the color of two-tail toss
 *          VERTICAL_BUFFER : the horizontal space between tallest bar and the top
 *          BAR_WIDTH : the width of bar
 *
 *  CoinSimComponent class has the following instance variable:
 *          twoHeadsNumbers : the number of two-head tosses trials
 *          twoTailsNumbers : the number of two-tail tosses trials
 *          headTailsNumbers : the number of one-head-one-tail tosses trials
 *          trialsNumbers : the total number of trials
 *
 *  CoinSimComponent class supports the following methods:
 *      private methods:
 *          void drawBar(g2,tossNumbers,tossColor,label,Pos)
 *          // draw bars and labels
 *          String tossPercentage(label,tossNumber)
 *          // calculate the percentage of different kinds outcomes of toss and return label
 *
 *      public methods:
 *          void runSimulator(numTrials) // run a simulation
 *          void resetSimulator() // reset the simulator
 *          void paintComponent(g) // overrides JComponent.paintComponent,
 *          calls drawBar method to draw bars
 *
 */
public class CoinSimComponent extends JComponent {


    //Name constants
    private static final Color HEAD_TAIL_COLOR = Color.GREEN;
    private static final Color TWO_HEAD_COLOR = Color.ORANGE;
    private static final Color TWO_TAIL_COLOR = Color.YELLOW;
    private static final int VERTICAL_BUFFER = 50;
    private static final int BAR_WIDTH = 100;


    //Instance variable
    private int twoHeadsNumbers;
    private int twoTailsNumbers;
    private int headTailsNumbers;
    private int trialsNumbers;
    private CoinTossSimulator Simulator;


    /**
     Creates a simulator. Give the total number of trials to run simulations.

     @param numTrials  the total number of trials
     */
    public CoinSimComponent(int numTrials){
        Simulator = new CoinTossSimulator();
        Simulator.run(numTrials);

        twoHeadsNumbers = Simulator.getTwoHeads();
        twoTailsNumbers = Simulator.getTwoTails();
        headTailsNumbers = Simulator.getHeadTails();
        trialsNumbers = Simulator.getNumTrials();
    }

    /**
     Calculates the percentage of different kinds outcomes of toss and return label.
     Math.round is used to round number off to 1 decimal place.

     @param label  the total number of trials
     @param tossNumber  the total number of trials
     */
    private String tossPercentage(String label,int tossNumber){
        double percentage = Math.round((double)tossNumber * 1000d
                / trialsNumbers)/10d;
        return label + " " + tossNumber + " (" + percentage + " %)";
    }

    /**
     Draws a labeled bar by calculating necessary data
     and call bar class.

     *This method calculates the following data:
        int heightOfLabel : the height of label, which is important
                            to calculate scale and baseBottom
        int barHeight : the height of the bar in application units, from 0 to 20,
        int width : the unit width between bars. The number depends on the screen size and Pos.
        int scale : the size of one application units of height of the bar.
                    The number depends on the screen size.
        int baseBottom : The y position of the bottom of the highest bar.
                         (it appears the top of the bar in the screen though)
                         Uses this data and barHeight to calculate the current bottom of the bars.

     *How to calculate x position of bars:
        if Pos == "left", which means the left bar,
        x position is the unit width.
        if Pos == "center", which means the center bar,
        x position is the unit width times 2 plus BAR_WIDTH.
        if Pos == "right", which means the right bar,
        x position is the unit width times 3 plus BAR_WIDTH times 2.
        After calculating the x position of bars, send it as "width" param of new bar class

     @param g2  awt.Graphics2D context. Used to draw bars
     @param tossNumbers  The numbers of outcomes of toss trials
     @param tossColor  The color of the bar.
     @param label  The label at the bottom of the bar.
     @param Pos  Determines where is the bar. Only accepts "left", "center" and "right" now.
     */
    private void drawBar(Graphics2D g2,int tossNumbers,Color tossColor, String label, String Pos){
        Font font = g2.getFont();
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D labelBounds = font.getStringBounds(label,context);

        // Instance variable
        int heightOfLabel = (int)labelBounds.getHeight();
        int barHeight = (int)((double)tossNumbers/ trialsNumbers * 20);
        int width = (getWidth() - BAR_WIDTH * 3) / 4;
        int scale = (getHeight() - heightOfLabel - VERTICAL_BUFFER * 2)/20;
        int baseBottom = getHeight() - heightOfLabel - VERTICAL_BUFFER;

        // please see "How to calculate x position of bars"
        switch(Pos){
            case "left":{
                break;
            }
            case "center":{
                width = width * 2 + BAR_WIDTH;
                break;
            }
            case "right":{
                width = width * 3 + BAR_WIDTH * 2;
                break;
            }
        }

        Bar NewBar = new Bar(baseBottom - barHeight * scale,width,
                BAR_WIDTH,barHeight,scale,tossColor,
                tossPercentage(label,tossNumbers));
        NewBar.draw(g2);
    }

    /**
     Give the total number of trials and rerun simulations.

     @param numTrials  the total number of trials
     */
    public void runSimulator(int numTrials){
        Simulator.run(numTrials);

        twoHeadsNumbers = Simulator.getTwoHeads();
        twoTailsNumbers = Simulator.getTwoTails();
        headTailsNumbers = Simulator.getHeadTails();
        trialsNumbers = Simulator.getNumTrials();

    }

    /**
     reset the simulator.
     */
    public void resetSimulator(){
        Simulator.reset();
        twoHeadsNumbers = Simulator.getTwoHeads();
        twoTailsNumbers = Simulator.getTwoTails();
        headTailsNumbers = Simulator.getHeadTails();
        trialsNumbers = Simulator.getNumTrials();
    }

    /**
     Give the total number of trials and rerun simulations.

     @param g  awt.Graphics context. Used to draw bars and label.
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        drawBar(g2,twoHeadsNumbers,TWO_HEAD_COLOR,"TWO HEAD","left");
        drawBar(g2,headTailsNumbers,HEAD_TAIL_COLOR,"HEAD TAIL","center");
        drawBar(g2,twoTailsNumbers,TWO_TAIL_COLOR,"TWO TAIL","right");
    }

}
