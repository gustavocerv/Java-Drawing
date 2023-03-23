/** Group7: Francis & Gustavo
* File: DrawPanel.java
* Description: Draw
* Lessons Learned: this lab help us to create shapes, like circle, rectangle, triangle by adjusting the values of height and width.
*   
* Instructor's Name: Jeff Light
*
* @author     Jeff Light, Jared Hogan
* @since       05/3/2022
*/
package Draw12a;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Stroke;
import javax.swing.JPanel;
import java.awt.geom.*;

/**
 * Class used to create a DrawPanel where shapes will be drawn by the programmer (via code).
 * 
 * @author Jared N. Plumb
 * @version 1.0
 * @since 2019-11-26
 * @Minor modifications by Jeff Light
 * @since 2019-12-01
 */
public class DrawPanel extends JPanel {
	//Attributes
	private static final long serialVersionUID = 6311020027600344213L;

	public DrawPanel() {
		this.setPreferredSize(new Dimension(1600, 900));	//Sets the dimensions of the DrawPanel.  Change this if your screen doesn't support this size.
		this.setOpaque(true);
		this.setBackground(Color.WHITE);			//Sets the background of the DrawPanel LIGHT_GRAY.  You may change this if desired.
	}
	
	
	/**
	 * Overrides the JComponent.paintComponent method.
	 * EVERYTHING that gets drawn to the Component (which sits on the content frame of the JFrame) is drawn in this method.
	 * Draw12a
	 * Draw all your objects in the paintComponent method.
	 * Automatically called by the event handler whenever the screen needs to be redrawn.
	 * DO NOT CALL THIS METHOD MANUALLY
	 * 
	 * @param	g	//All drawing in Java must go through a Graphics object
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;			//Allows us to draw using both the Graphics class methods and the Graphics2D class methods

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);	//Makes drawn shapes and fonts clearer
		
		//Draw Rectangles 
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(1));       //1
		g2.drawRect(50, 50, 200, 100); //lines
		g2.fillRect(300, 50, 100, 200); //filled
		
		//Draw Ovals
		g2.setColor(Color.GREEN);
		g2.setStroke(new BasicStroke(2));       //2
		g2.drawOval(500, 50, 200, 100); //lines and make the form of oval horizontal
		g2.fillOval(800, 50, 100, 200); //filled and make the form of oval vertical
		
		//Draw an Empty Triangle
		g2.setColor(Color.BLUE);
		g2.setStroke(new BasicStroke(3));         //4
		int[] xPoints1 = {1000, 1100, 1200}; //Define the x cords for each point
		int[] yPoints1 = {250, 50, 250}; //Define the y cords for each point
		g2.drawPolygon(xPoints1, yPoints1, 3);
		int[] xPoints2 = {1300, 1300, 1500};
		int[] yPoints2 = {50, 250, 150};
		g2.fillPolygon(xPoints2, yPoints2, 3); 		//Draw a Filled Triangle
 
		//Draw an Empty Round Rectangle
		g2.setColor(Color.decode("#008A2F"));//green color 
		g2.setStroke(new BasicStroke(4));          // 4
		RoundRectangle2D.Double myRec = new RoundRectangle2D.Double(50, 350, 200, 100, 30, 30);// position, size , round or curve
		g2.draw(myRec);
		
		//Draw a Filled Round Rectangle
		RoundRectangle2D.Double myRec2 = new RoundRectangle2D.Double(250, 400, 200, 100, 30, 30);// position, size , round or curve
		Double centerX = myRec2.getCenterX();
		Double centerY = myRec2.getCenterY();
		g2.rotate(90, centerX, centerY);
		g2.fill(myRec2);
		
		g2.rotate(-90, centerX, centerY); // the rotate (/)
		
		// Draw Circles
		g2.setColor(Color.decode("#87CEFA"));// light sky blue color
		g2.setStroke(new BasicStroke(5));       // 5
		g2.drawOval(550, 350, 150, 150); // lines position and size x=x
		g2.fillOval(750, 350, 150, 150); //Filled position and size x=x
		
		
		//Draw Octagons
		g2.setColor(Color.decode("#CE8540")); // light brown color
		g2.setStroke(new BasicStroke(6));         //6
		int[] x3 = {1000, 1070, 1140, 1210, 1210, 1140, 1070, 1000};  // size right or left 
		int[] y3 = {400, 330, 330, 400, 470, 540, 540, 470}; // size top or bottom
		g2.drawPolygon(x3, y3, 8); // empty 8 sides of octagon
		int[] x4 = {1300, 1370, 1440, 1510, 1510, 1440, 1370, 1300}; // size right or left
		int[] y4 = {400, 330, 330, 400, 470, 540, 540, 470};  // size top or bottom
		g2.fillPolygon(x4, y4, 8); //filled 8 sides of octagon

		/*
		 * Use this section to write your code.
		 * DrawShapes
		 * Draw at least 6 shapes in BOTH draw and fill formats using methods found in the Graphics class and/or the Graphics2D class.
		 * In other words, if you draw an empty rectangle, you should also draw a filled rectangle.  That counts as one (1) shape.
		 * The empty and filled versions of the shape should be at different orientations.
		 * One of the shapes MUST be a triangle.
		 * Each shape should be a different color.  An empty and a filled rectangle may be the same color, but they must be a different color from an empty and filled triangle.
		 * At least one of the colors should NOT be a standard color from the COLOR palette.
		 * Each empty shape should have a different stroke size.
		 * Be sure all shapes are located such that they can all be seen.
		 */
		

		
	}//end of method paintComponent(Graphics)

}//end of class DrawPanel