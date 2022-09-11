import java.awt.image.BufferedImage;

public class Plinky extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Plinky(int x, int y, int width, int height){
		super(x,y,width,height);
		
	}
}
