/** Group7: Francis & Gustavo
 * File: Tree.java
 * Description: find the scale, trunk and branch
 * Lessons Learned: This will help us to create the colors, size , position or or branches and trunk of the tree
 *   
 * Instructor's Name: Jeff Light
 *
 * @author     Jeff Light, Jared Hogan
 * @since       05/3/2022
 */
package Draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Snowman extends LandscapeObject{
	//Attributes
	private String shape = "";

	private Color bodycolor; 				
	private Color eyescolor;
	private Color hatColor;
	private Color clothColor;

	private int bodywidth = 50;
	private int bodyheight = 50;		
	private String face = "";
	private String clothing ="";
	private String hat ="";
	//	private Color BROWN = Color.decode("A52A2A"); 
	// private BasicStroke snowmanStroke = new BasicStroke(1);	//Stroke of 1 pixel use to outline each shape of the tree.


	public Snowman(Graphics2D g2, int x, int y, double scale, String shape, String face, String clothing, String hat,
			String bodycolor, String eyescolor, String hatcolor, String clothColor) {
		super(g2, x, y, scale);

		this.bodycolor = new Color(Integer.parseInt(bodycolor,16));// 

		this.eyescolor = new Color(Integer.parseInt(eyescolor,16)); // 

		this.hatColor = new Color(Integer.parseInt(hatcolor,16)); //
		
		this.clothColor = new Color(Integer.parseInt(clothColor,16)); //
		
		this.shape = shape;
		this.face =face;
		this.clothing=clothing;
		this.hat=hat;
		
	}//end of Constructor Tree


	//Methods
	/**
	 * draw()
	 * Calls applyScale to apply the scale multiplier to all shape dimensions for the object.
	 * Calls drawTrunk to draw the trunk of the tree.
	 * Calls drawBranches to draw the branches of the tree.
	 * 
	 * @return	void. 
	 */
	public void draw() {
		applyScale();
		drawbody();
		drawface();
		drawcloth();
		drawhat();
	}//end of method draw()


	/**
	 * applyScale
	 * Applies the scale multiplier to all shape dimensions for the object.
	 * Called by draw()
	 * 
	 * @return	void. 
	 */
	public void applyScale() {
		switch (this.shape) {
		case "Small":
			bodywidth = (int)(bodywidth * 1);
			bodyheight = (int) (bodyheight * 1);
			break;

		case "Medium":
			bodywidth = (int)(bodywidth * 1.2);
			bodyheight = (int) (bodyheight * 1.2);
			break;

		case "Large":
			bodywidth = (int)(bodywidth * 1.4);
			bodyheight = (int) (bodyheight * 1.4);
			break;
		default:
			System.out.printf(shape);
		}


	}//end of method applyScale()

	private void drawbody() {
		// snowman's head circle
		g2.setColor(bodycolor) ;
		g2.fillOval((int)(currentX +bodywidth*1.1), (int) (currentY + bodyheight*0.4), (int) (bodywidth*1), (int) (bodywidth*1));


		// snowman's upper body circle
		g2.setColor(bodycolor) ;
		g2.fillOval((int)(currentX +bodywidth*0.85), (int)(currentY + bodyheight*1.2), (int) (bodywidth*1.5), (int) (bodywidth*1.5));

		// snowman's lower body circle
		g2.setColor(bodycolor) ;
		g2.fillOval((int)(currentX +bodywidth*0.65),(int) (currentY + bodyheight*2.2),  (int) (bodywidth*2), (int) (bodywidth*2));
		
		
	

	}

	private void drawface() {
		// snowman's right eye circle
		g2.setColor(eyescolor);
		g2.fillOval((int)(currentX+ bodywidth*1.45), (int) (currentY + bodyheight*0.65), (int) (bodywidth*.1), (int) (bodywidth*.2));
		// snowman's left eye circle
		g2.fillOval((int)(currentX+ bodywidth*1.65), (int) (currentY + bodyheight*0.65), (int) (bodywidth*.1), (int) (bodywidth*.2));
		switch(face) {
		case "SMILE":
			// snowman's mouth
			g2.setColor(Color.BLACK);
			g2.drawArc((int)(currentX+ bodywidth*1.35), (int) (currentY + bodyheight*0.8), (int) (bodywidth/2), (int) 12.25, (int) (bodywidth*-10.5), (int) (bodywidth*2.9));
			break;
		case "SURPRICED":
			g2.setColor(Color.BLACK);
			g2.drawArc((int)(currentX+ bodywidth*1.35), (int) (currentY + bodyheight*.9), (int) (bodywidth/2), (int) 12.25, (int) (bodywidth*2.9), (int) (bodywidth*-10.5));
			break;
		case "MOUSTACHE":
			g2.setColor(Color.BLACK);
			g2.fillArc((int)(currentX+ bodywidth*1.35), (int) (currentY + bodyheight*.9), (int) (bodywidth/2), (int) 15, (int) (bodywidth*10), (int) (bodywidth*3.2));
			break;
		default:
			System.out.printf(face);
		}

	}	
	private void	drawcloth()	{


		switch(clothing) {
		case "NAKED":
			g2.setColor(Color.BLACK);
			g2.fillOval((int)(currentX+ bodywidth*1.5), (int) (currentY + bodyheight*1.6),  (int) (bodywidth*.125), (int) (bodywidth*.125));
			g2.fillOval((int)(currentX+ bodywidth*1.5), (int) (currentY + bodyheight*1.9),  (int) (bodywidth*.125), (int) (bodywidth*.125));
			g2.fillOval((int)(currentX+ bodywidth*1.5), (int) (currentY + bodyheight*2.2),  (int) (bodywidth*.125), (int) (bodywidth*.125));

			break;
		case "CHRISTMASCloth1":
			g2.setColor(clothColor) ;
			g2.fillOval((int)(currentX +bodywidth*0.85), (int)(currentY + bodyheight*1.3), (int) (bodywidth*1.5), (int) (bodywidth*1.2));
			g2.setColor(Color.RED);
			g2.fillOval((int)(currentX+ bodywidth*1.55), (int) (currentY + bodyheight*1.6), (int) (bodywidth*.125), (int) (bodywidth*.125));
			g2.fillOval((int)(currentX+ bodywidth*1.55), (int) (currentY + bodyheight*1.9), (int) (bodywidth*.125), (int) (bodywidth*.125));
			g2.fillOval((int)(currentX+ bodywidth*1.55), (int) (currentY + bodyheight*2.2), (int) (bodywidth*.125), (int) (bodywidth*.125));
			break;
		case "CHRISTMASCloth2":
			g2.setColor(clothColor) ;
			g2.fillOval((int)(currentX +bodywidth*0.85), (int)(currentY + bodyheight*1.3), (int) (bodywidth*1.5), (int) (bodywidth*1.2));
			g2.setColor(Color.BLUE);
			g2.fillOval((int)(currentX+ bodywidth*1.55), (int) (currentY + bodyheight*1.6), (int) (bodywidth*.125), (int) (bodywidth*.125));
			g2.fillOval((int)(currentX+ bodywidth*1.55), (int) (currentY + bodyheight*1.9), (int) (bodywidth*.125), (int) (bodywidth*.125));
			g2.fillOval((int)(currentX+ bodywidth*1.55), (int) (currentY + bodyheight*2.2), (int) (bodywidth*.125), (int) (bodywidth*.125));
			break;
		default:
			System.out.printf(clothing);
		}
		// snowman's three buttons in the upper body circle

	}

	private void drawhat() {
		switch(hat) {
		case "Blackhat":
			// snowman's hat rectangle
			g2.setColor(hatColor);
			g2.fillRect((int)(currentX+ bodywidth*1.07), (int) (currentY + bodyheight*0.4), (int) (bodywidth*1.1), (int) (bodywidth*0.1));
			g2.fillRect((int)(currentX+ bodywidth*1.35), (int) (currentY + bodyheight*0.01), (int) (bodywidth*.5), (int) (bodywidth*.5));

			// yellow rectangle band in snowman's hat
			g2.setColor(Color.YELLOW);
			g2.fillRect((int)(currentX+ bodywidth*1.35), (int) (currentY + bodyheight*0.3), (int) (bodywidth*.5), (int) (bodywidth*.1));

			break;
		case "Bluehat":
			g2.setColor(hatColor);
			g2.fillRect((int)(currentX+ bodywidth*1.325), (int) (currentY + bodyheight*0.1), (int) (bodywidth*.5), (int) (bodywidth*.5));
			g2.fillOval((int)(currentX +bodywidth*0.8), (int)(currentY + bodyheight*0.25), (int) (bodywidth*1.6), (int) (bodywidth/2-5));//800, 50, 100, 200 //filled and make the form of oval vertical

			// orange rectangle band in snowman's hat
			g2.setColor(Color.YELLOW);		
			g2.fillRect((int)(currentX+ bodywidth*1.325), (int) (currentY + bodyheight*0.3), (int) (bodywidth*.5), (int) (bodywidth*.1));//blue
			break;

		case "Greenhat":
			Rectangle2D.Double hatpart1 = new Rectangle2D.Double((int)(currentX+ bodywidth*-.45), (int) (currentY + bodyheight*-2.20),  (int) (bodywidth*.09), (int) (bodywidth*1));
			Rectangle2D.Double hatpart2 = new Rectangle2D.Double((int)(currentX+ bodywidth*-.8), (int) (currentY + bodyheight*-2.20), (int) (int) (bodywidth*.4), (int) (bodywidth/2-5));	
			Rectangle2D.Double hatpart3 = new Rectangle2D.Double((int)(currentX+ bodywidth*-.55), (int) (currentY + bodyheight*-2.20),  (int) (bodywidth*.09), (int) (bodywidth*.45));
			
			g2.rotate(90, currentX, currentY);
			g2.setColor(hatColor);
			g2.fill(hatpart1);
			g2.fill(hatpart2);
			g2.setColor(Color.YELLOW);
			g2.fill(hatpart3);
			g2.rotate(-90, currentX, currentY);
			break;
			
			/*case "Redhat":
			// snowman's hat rectangle
			g2.setColor(hatColor);
			g2.fillRect((int)(currentX+ bodywidth*1.07), (int) (currentY + bodyheight*0.4), (int) (bodywidth*1.1), (int) (bodywidth*0.1));
			g2.fillRect((int)(currentX+ bodywidth*1.35), (int) (currentY + bodyheight*0.01), (int) (bodywidth*.5), (int) (bodywidth*.5));

			// yellow rectangle band in snowman's hat
			g2.setColor(Color.YELLOW);
			g2.fillRect((int)(currentX+ bodywidth*1.35), (int) (currentY + bodyheight*0.3), (int) (bodywidth*.5), (int) (bodywidth*.1));
			*/
		default:
			System.out.printf(hat);
		}
	}
}
