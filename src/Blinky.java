import java.awt.image.BufferedImage;

public class Blinky extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Blinky(int x, int y, int width, int height){
		super(x,y,width,height);
		
	}
}
