package hw04;
//Written by Diem Dao
//Oct12, 2018
//section 03

import java.applet.*; // needed to create the window 
import java.awt.*; //needed for drawing
import java.util.*;
public class TrianglesFractals extends Applet{ //When it extends applet it creates a window and called certain methods
	private Image display; //used as the first image
	private Graphics drawingArea; //Used to draw item in the image it initializes all of the instance variable
	//think of this as a variation of a constuctor, but called by another hidden piece of code
	
	public void init()
	{
		//get the height and width from the applet
		int height = getSize().height;
		int width = getSize().width;
		//create an image using the height and width in the applet
		display = createImage(width,height);
		//set up  the drawing area for the image above to be drawn on 
		drawingArea = display.getGraphics();
		//this drawn random fractal
		drawGasket(0,0,width,drawingArea);
	}
	
	//This updates every frame and draws the image in the applet
	//This is also called by the applet as it is an overridden method
	public void paint(Graphics g) {
		g.drawImage(display, 0,0, null);
	}
	
	public static void drawGasket(int x, int y, int side, Graphics g) {
		//divide each side by 2. Since it's a triangle and in each midpoint we create a new triangle
		int sub = side/2;
		
		//draw the middle triangle
		int[] sideX = {x,x+side/2, x+side,x};
		int[] sideY = {y+side, y, y+side, y+side};
		//make the lines color black
		g.setColor(Color.BLACK);
		g.drawPolygon(sideX, sideY, sideX.length);
		
		//recursive
		if(sub >= 3) {
			drawGasket(x+sub/2, y, sub, g);
			drawGasket(x, y+sub, sub, g);
			drawGasket(x+sub, y+sub, sub,g);
		}
	}
}















