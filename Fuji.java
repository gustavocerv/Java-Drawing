 /** Group7: Francis & Gustavo
* File: Fuji.java
* Description: 
* Lessons Learned: 
*   
* Instructor's Name: Jeff Light
*
* @author     Jeff Light, Jared Hogan
* @since       05/3/2022
*/
package Draw;
import java.awt.*;

public class Fuji  extends LandscapeObject{

	//Attributes
	
	private String shape = "";																
	private int mountainWidth = 200;								
	private int mountainHeight = 250;	
	private Color FujiColor;
	private String season="";
	private String landscape="";

	
	
	//Constructor
	public Fuji(Graphics2D g2, int x, int y, double scale, String shape, String season, String landscape, String FujiColor) {
		super(g2, x, y, scale);
		this.shape = shape;
		this.FujiColor = new Color(Integer.parseInt(FujiColor,16));
		this.season = season;
		this.landscape = landscape;
	}
	
	//Methods
	public void draw() {
		applyScale();
		drawMountain();
	}

	public void applyScale() {
		switch(this.shape) {
		case "SMALL":
			mountainWidth = (int)(mountainWidth * 1);
			mountainHeight = (int)(mountainHeight * 1);			
			break;
		case "MEDIUM":
			mountainWidth = (int)(mountainWidth * 1.2);
			mountainHeight = (int)(mountainHeight * 1.2);			
			break;
		case "LARGE":
			mountainWidth = (int)(mountainWidth * 1.5);
			mountainHeight = (int)(mountainHeight * 1.5);
			break;
		default:
			System.out.printf("Internal Error: Invalid Mountain Shape: %s\n", shape);
		}//end of switch
	}
	
	public void drawMountain() {
	
		
		
		switch(landscape) {
		case " ":
			
			break;
		case"Lava":
			g2.setColor(Color.RED);
			g2.setStroke(new BasicStroke(10));
			g2.drawArc((int)(currentX+ mountainWidth*0.3), (int) (currentY + mountainWidth*-1.2), (int)( mountainWidth/2.5),  (int)( mountainWidth*1.4), 35, 180);
			break;
			
		case"WaterFall":
			g2.setColor(Color.BLUE);
			g2.setStroke(new BasicStroke(10));
			g2.drawArc((int)(currentX+ mountainWidth*0.28), (int) (currentY + mountainWidth*-1.2), (int)( mountainWidth/2.2),  (int)( mountainWidth*1.25), 12, 180);
			break;
		}
		g2.setColor(FujiColor);
		g2.setStroke(new BasicStroke(6));
		int [] x = {currentX, currentX + (mountainWidth/2), currentX + mountainWidth};
		int [] y = {currentY, currentY - mountainHeight, currentY};
		int [] x1 = {currentX, currentX + (mountainWidth/2), currentX + mountainWidth};
		int [] y2 = {currentY  , currentY  - mountainHeight+20, currentY};
		g2.setColor(FujiColor);
		g2.setStroke(new BasicStroke(6));
		int [] x2 = {currentX, currentX + (mountainWidth/2), currentX + mountainWidth};
		int [] y3 = {currentY  , currentY  - mountainHeight+40, currentY};
		int [] x3 = {currentX, currentX + (mountainWidth/2), currentX + mountainWidth};
		int [] y4 = {currentY  , currentY  - mountainHeight+60, currentY};
		int [] x4 = {currentX, currentX + (mountainWidth/2), currentX + mountainWidth};
		int [] y5 = {currentY  , currentY  - mountainHeight+80, currentY};
		g2.fillPolygon(x, y, 3);
			switch (season) {
			case "Normal":
				g2.setStroke(new BasicStroke(6));
				g2.setColor(Color.white);
				
				g2.drawPolygon(x, y, 3);
				g2.drawPolygon(x1,y2,3);
				g2.drawPolygon(x2,y3,3);
				g2.drawPolygon(x3,y4,3);
				break;
			case "NoSnow":
				
				
				g2.setStroke(new BasicStroke(6));
				g2.setColor(FujiColor);
				g2.drawPolygon(x, y, 3);
				g2.setStroke(new BasicStroke(2));
				g2.setColor(Color.BLACK);
				g2.drawPolygon(x1,y2,3);
				g2.drawPolygon(x2,y3,3);
				g2.drawPolygon(x3,y4,3);
				break;

			}
		
	}

}// end of Mountain