/** Group7: Francis & Gustavo
* File: House.java
* Description: 
* Lessons Learned: 
*   
* Instructor's Name: Jeff Light
*
* @author     Jeff Light, Jared Hogan
* @since       05/3/2022
*/
package Draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class House extends LandscapeObject {

	//Attributes
	private String light = "";
	private String shape = "";
	private String door = "";
	private Color houseColor1;
	private Color houseColor2;
	private Color roofColor;
	private Color doorColor;
	private Color chimmneyColor;
	private int houseWidth = 80;
	private int houseHeight = 80;
	private int roofWidth = 120;
	private int roofHeight = 80;
	private int doorWidth = 20;
	private int doorHeight = 30;
	private int windowWidth = 12;
	private int windowHeight = 15;
	private int chimmneyWidth =13;
	private int chimmneyHeight =35;
	private BasicStroke houseStroke = new BasicStroke(10);
	private BasicStroke Stroke = new BasicStroke(3);
	
	//Constructor
	public House(Graphics2D g2, int x, int y, double scale, String shape, String light, String door,
			 String s_houseColor1, String s_houseColor2, String s_roofColor, String s_doorColor, String s_chimColor) {
		super(g2, x, y, scale);
		this.shape = shape;
		this.light = light;
		this.door = door;
		this.houseColor1 = new Color(Integer.parseInt(s_houseColor1,16));
		this.houseColor2 = new Color(Integer.parseInt(s_houseColor2,16));
		this.roofColor = new Color(Integer.parseInt(s_roofColor,16));
		this.doorColor = new Color(Integer.parseInt(s_doorColor,16));
		this.chimmneyColor = new Color(Integer.parseInt(s_chimColor,16));
		
	}// end of House(Graphics2D g2, int x, int y, double scale)

	
	//Methods
	@Override
	public void draw() {
		applyScale();
		drawchimmney();
		drawHouse();
		drawRoof();
		drawWindow();//switch light on and light off
		drawDoor();//switch open door and close door
		
	}// end of draw()

	


	@Override
	public void applyScale() {
		
		switch(this.shape) {
		case "SMALL":
			houseWidth = (int)(houseWidth * 1);
			houseHeight = (int)(houseHeight * 1);
			roofWidth = (int)(roofWidth * 1);
			roofHeight = (int)(roofHeight * 1);
			doorWidth = (int)(doorWidth * 1);
			doorHeight = (int)(doorHeight * 1);
			windowWidth = (int)(windowWidth * 1);
			windowHeight = (int)(windowHeight * 1);
			chimmneyWidth = (int)(chimmneyWidth * 1);
			chimmneyHeight = (int)(chimmneyHeight * 1);
			break;
		case "MEDIUM":
			houseWidth = (int)(houseWidth * 1.7);
			houseHeight = (int)(houseHeight * 1.7);
			roofWidth = (int)(roofWidth * 1.7);
			roofHeight = (int)(roofHeight * 1.7);
			doorWidth = (int)(doorWidth * 1.7);
			doorHeight = (int)(doorHeight * 1.7);
			windowWidth = (int)(windowWidth * 1.7);
			windowHeight = (int)(windowHeight * 1.7);
			chimmneyWidth = (int)(chimmneyWidth * 1.7);
			chimmneyHeight = (int)(chimmneyHeight * 1.9);
			break;
		case "LARGE":
			houseWidth = (int)(houseWidth * 2);
			houseHeight = (int)(houseHeight * 2);
			roofWidth = (int)(roofWidth * 2.5);
			roofHeight = (int)(roofHeight * 2.5);
			doorWidth = (int)(doorWidth * 2.5);
			doorHeight = (int)(doorHeight * 2.5);
			windowWidth = (int)(windowWidth * 2.5);
			windowHeight = (int)(windowHeight * 2.5);
			chimmneyWidth = (int)(chimmneyWidth * 2.5);
			chimmneyHeight = (int)(chimmneyHeight * 2.5);
			break;
		default:
			System.out.printf("Internal Error: Invalid House Shape: %s\n", shape);
		}//end of switch
	}// end of applyScale()
	private void drawchimmney() {
		g2.setStroke(Stroke);
		g2.setColor(chimmneyColor);
		//g2.fillRect(currentX + (houseWidth-118) , currentY + (houseHeight-168), chimmneyWidth, chimmneyHeight);
		g2.fillRect(currentX - (houseWidth/20) , currentY - (houseHeight/2), chimmneyWidth, chimmneyHeight);
		
	}
	
	private void drawHouse() {
		g2.setColor(houseColor1);	
		int[] x1 = {currentX, currentX + (houseWidth/2), currentX + houseWidth, currentX + houseWidth, currentX};
		int[] y1 = {currentY, currentY - (houseHeight/2), currentY, currentY + (houseHeight/2), currentY + (houseHeight/2)};
		g2.fillPolygon(x1, y1, 5);
		
		g2.setColor(houseColor2);	
		int[] x2 = {currentX + (houseWidth/20), currentX + (houseWidth/2), currentX + houseWidth - (houseWidth/20), currentX + houseWidth - (houseWidth/20), currentX + (houseWidth/20)};
		int[] y2 = {currentY + (houseHeight/25), currentY - (houseHeight/2) + (houseHeight/12), currentY + (houseHeight/25), currentY + (houseHeight/2) - (houseHeight/20), currentY + (houseHeight/2) - (houseHeight/20)};
		g2.fillPolygon(x2, y2, 5);
	}// end of drawHouse()
	
	
	private void drawRoof() {
		g2.setColor(roofColor);
		g2.setStroke(houseStroke);
		g2.drawLine(currentX - (houseWidth/20), currentY + (houseHeight/20), currentX + (houseWidth/2) + (houseWidth/20), currentY - (houseHeight/2) - (houseHeight/20));
		g2.drawLine(currentX + (houseWidth/2) - (houseWidth/20), currentY - (houseHeight/2) - (houseHeight/20), currentX + houseWidth + (houseWidth/20), currentY + (houseHeight/20));
	}// end of drawRoof()
	
	private void drawDoor() {//switch door open and door close
		switch (door) {
		case "CLOSE" :
			g2.setColor(doorColor);
			g2.fillRect(currentX + (houseWidth/2) - (houseWidth/8), currentY + (houseHeight/13), doorWidth, doorHeight);
			
			//Draw lines for door
			g2.setStroke(Stroke);
			g2.setColor(Color.DARK_GRAY);
			g2.drawLine(currentX + (houseWidth/2) - (houseWidth/8), currentY + (houseHeight/13), currentX + (houseWidth/2) + (houseWidth/8), currentY + (houseHeight/13));
			g2.drawLine(currentX + (houseWidth/2) + (houseWidth/8), currentY + (houseHeight/13), currentX + (houseWidth/2) + (houseWidth/8), currentY + (houseHeight/2) - (houseHeight/15));
			g2.drawLine(currentX + (houseWidth/2) + (houseWidth/8), currentY + (houseHeight/2) - (houseHeight/15), currentX + (houseWidth/2) - (houseWidth/8), currentY + (houseHeight/2) - (houseHeight/15));
			g2.drawLine(currentX + (houseWidth/2) - (houseWidth/8), currentY + (houseHeight/2) - (houseHeight/15), currentX + (houseWidth/2) - (houseWidth/8), currentY + (houseHeight/13));
			g2.drawLine(currentX + (houseWidth/4) + (houseWidth/4), currentY + (houseHeight/13), currentX + (houseWidth/4) + (houseWidth/4), currentY + (houseHeight/2) - (houseHeight/15));

			// Draw Knobs
			g2.setColor(Color.DARK_GRAY);
			g2.fillOval(currentX + (houseWidth/4) + (houseWidth/5), currentY + (houseHeight/4), doorWidth/10, doorHeight/10);
			g2.fillOval(currentX + (houseWidth/2) + (houseWidth/20), currentY + (houseHeight/4), doorWidth/10, doorHeight/10);
			break;
			
		case "OPEN" :
			g2.setColor(Color.decode("#f5d731"));
			g2.fillRect(currentX + (houseWidth/4) + (houseWidth/9), currentY + (houseHeight/13), doorWidth, doorHeight);
			
			// Draw Doors
			g2.setColor(Color.DARK_GRAY);
			int [] x1 = {currentX + (houseWidth/2) + (houseWidth/10), currentX + (houseWidth/2) + (houseWidth/6), currentX + (houseWidth/2) + (houseWidth/6), currentX + (houseWidth/2) + (houseWidth/10)};
			int [] y1 = {currentY + (houseHeight/14), currentY + (houseHeight/10), currentY + (houseHeight/2), currentY + (houseHeight/2) - (houseHeight/20)};
			g2.fillPolygon(x1, y1, 4);

			int [] x2 = {currentX + (houseWidth/4) + (houseWidth/9), currentX + (houseWidth/2) - (houseWidth/5), currentX + (houseWidth/2) - (houseWidth/5), currentX + (houseWidth/4) + (houseWidth/9)};
			int [] y2 = {currentY + (houseHeight/14), currentY + (houseHeight/10), currentY + (houseHeight/2), currentY + (houseHeight/2) - (houseHeight/20)};
			g2.fillPolygon(x2, y2, 4);
			
			// Draw lines for door
			g2.setStroke(Stroke);
			g2.setColor(Color.black);
			g2.drawLine(currentX + (houseWidth/2) + (houseWidth/10), currentY + (houseHeight/14), currentX + (houseWidth/2) + (houseWidth/6), currentY + (houseHeight/10));		
			g2.drawLine(currentX + (houseWidth/2) + (houseWidth/6), currentY + (houseHeight/10), currentX + (houseWidth/2) + (houseWidth/6), currentY + (houseHeight/2));		
			g2.drawLine(currentX + (houseWidth/2) + (houseWidth/6), currentY + (houseHeight/2), currentX + (houseWidth/2) + (houseWidth/10), currentY + (houseHeight/2) - (houseHeight/20));
			g2.drawLine(currentX + (houseWidth/2) + (houseWidth/10), currentY + (houseHeight/2) - (houseHeight/20), currentX + (houseWidth/2) + (houseWidth/10), currentY + (houseHeight/14));
			
			g2.drawLine(currentX + (houseWidth/2) + (houseWidth/10), currentY + (houseHeight/14), currentX + (houseWidth/4) + (houseWidth/9), currentY + (houseHeight/14));
			g2.drawLine(currentX + (houseWidth/2) + (houseWidth/10), currentY + (houseHeight/2) - (houseHeight/20), currentX + (houseWidth/4) + (houseWidth/9), currentY + (houseHeight/2) - (houseHeight/20));
		
			g2.drawLine(currentX + (houseWidth/4) + (houseWidth/9), currentY + (houseHeight/14), currentX + (houseWidth/2) - (houseWidth/5), currentY + (houseHeight/10));
			g2.drawLine(currentX + (houseWidth/2) - (houseWidth/5), currentY + (houseHeight/10), currentX + (houseWidth/2) - (houseWidth/5), currentY + (houseHeight/2));
			g2.drawLine(currentX + (houseWidth/2) - (houseWidth/5), currentY + (houseHeight/2), currentX + (houseWidth/4) + (houseWidth/9), currentY + (houseHeight/2) - (houseHeight/20));
			g2.drawLine(currentX + (houseWidth/4) + (houseWidth/9), currentY + (houseHeight/2) - (houseHeight/20), currentX + (houseWidth/4) + (houseWidth/9), currentY + (houseHeight/14));
			break;
		}// end of switch
		
	}// end of drawDoor()
	

	private void drawWindow() {//switch light on and light off
		switch (light){
		case "ON" :
			g2.setColor(Color.decode("#9eedf0"));
			g2.fillRect(currentX + (houseWidth/10), currentY + (houseHeight/14), windowWidth, windowHeight);
			g2.fillRect((int) (currentX + (houseWidth/2) + (houseWidth*0.23)), currentY + (houseHeight/14), windowWidth, windowHeight);
			break;
		case "OFF" :
			g2.setColor(Color.decode("#8c825d"));
			g2.fillRect(currentX + (houseWidth/10), currentY + (houseHeight/14), windowWidth, windowHeight);
			g2.fillRect((int) (currentX + (houseWidth/2) + (houseWidth*0.23)), currentY + (houseHeight/14), windowWidth, windowHeight);
			break;
		}// end of switch
		
		//Left Window
		g2.setStroke(Stroke);
		g2.setColor(Color.BLACK);
		// Left Window Outlines
		g2.drawLine(currentX + (houseWidth/10), currentY + (houseHeight/14), (int) (currentX + (houseWidth*0.25)), currentY + (houseHeight/14));
		g2.drawLine((int) (currentX + (houseWidth*0.25)), currentY + (houseHeight/14), (int) (currentX + (houseWidth*0.25)), currentY + (houseHeight/4));
		g2.drawLine((int) (currentX + (houseWidth*0.25)), currentY + (houseHeight/4), currentX + (houseWidth/10), currentY + (houseHeight/4));
		g2.drawLine(currentX + (houseWidth/10), currentY + (houseHeight/4), currentX + (houseWidth/10), currentY + (houseHeight/14));
		// Left Window inLines
		g2.drawLine((int) (currentX + (houseWidth*0.18)), currentY + (houseHeight/14), (int) (currentX + (houseWidth*0.18)), currentY + (houseHeight/4));
		g2.drawLine(currentX + (houseWidth/10), currentY + (houseHeight/6), (int) (currentX + (houseWidth*0.25)), currentY + (houseHeight/6));

		
		// Right Window
		g2.setStroke(Stroke);
		// Right Window Outlines
		g2.drawLine((int) (currentX + (houseWidth/2) + (houseWidth*0.23)), currentY + (houseHeight/14), (int) (currentX + (houseWidth/2) + (houseWidth*0.38)), currentY + (houseHeight/14));
		g2.drawLine((int) (currentX + (houseWidth/2) + (houseWidth*0.38)), currentY + (houseHeight/14), (int) (currentX + (houseWidth/2) + (houseWidth*0.38)), currentY + (houseHeight/4));
		g2.drawLine((int) (currentX + (houseWidth/2) + (houseWidth*0.38)), currentY + (houseHeight/4), (int) (currentX + (houseWidth/2) + (houseWidth*0.23)), currentY + (houseHeight/4));
		g2.drawLine((int) (currentX + (houseWidth/2) + (houseWidth*0.23)), currentY + (houseHeight/4), (int) (currentX + (houseWidth/2) + (houseWidth*0.23)), currentY + (houseHeight/14));
		// Right Window inLines	
		g2.drawLine((int) (currentX + (houseWidth/2) + (houseWidth*0.3)), currentY + (houseHeight/14), (int) (currentX + (houseWidth/2) + (houseWidth*0.3)), currentY + (houseHeight/4));
		g2.drawLine((int) (currentX + (houseWidth/2) + (houseWidth*0.23)), currentY + (houseHeight/6), (int) (currentX + (houseWidth/2) + (houseWidth*0.38)), currentY + (houseHeight/6));
	
	   
		
	}// end of drawWindow()

}// end of class House
