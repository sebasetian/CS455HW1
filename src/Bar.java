// Name: LIN,SHIH YAO
// USC NetId: 7208835144
// CSCI 455 PA1
// Spring 2018
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 *
 * How to run : Call Bar constructor to initializes necessary data
 *              and call Bar.draw(g) method to draw bars
 *
 * Bar class has the following instance variable:
 *      int barBottom : location of the bottom of the label
 *      int barLeft : location of the left side of the bar
 *      int barWidth : width of the bar (in pixels)
 *      int heightOfBar : height of the bar in application units(0~20)
 *      int barScale : how many pixels per application unit
 *      Color barColor : the color of the bar
 *      String barLabel : the label at the bottom of the bar
 *
 * Bar class supports the following methods:
 *      public methods:
 *              void draw(g2)
 */
public class Bar {


    //Instance variable
    private int barBottom;
    private int barLeft;
    private int barWidth;
    private int heightOfBar;
    private int barScale;
    private Color barColor;
    private String barLabel;

   /**
      Creates a labeled bar. Give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale). 
  
      @param bottom  location of the bottom of the label
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param barHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label at the bottom of the bar
   */
   public Bar(int bottom, int left, int width, int barHeight,
              int scale, Color color, String label) {
        barBottom = bottom;
        barLeft = left;
        barWidth = width;
        heightOfBar = barHeight;
        barScale = scale;
        barColor = color;
        barLabel = label;
   }
   
   /**
      Draw the labeled bar.

      @param g2  the graphics context
   */
   public void draw(Graphics2D g2) {
       Font font = g2.getFont();
       FontRenderContext context = g2.getFontRenderContext();
       Rectangle2D labelBounds = font.getStringBounds(barLabel,context);
       double widthOfLabel = labelBounds.getWidth();
       double heightOfLabel = labelBounds.getHeight();

       Rectangle LongBar = new Rectangle(barLeft,barBottom,barWidth,heightOfBar * barScale);
       g2.setColor(barColor);
       g2.fill(LongBar);
       g2.draw(LongBar);

       g2.setColor(Color.BLACK);
       g2.drawString(barLabel,barLeft + barWidth/2 - (int)widthOfLabel/2,
               barBottom + heightOfBar * barScale + (int)heightOfLabel);
   }
}
