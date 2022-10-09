import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Coins extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Coins(int x, int y, int width, int height){
		super(x,y,width,height);
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillOval(x,y,width,height);
	}
	
}

