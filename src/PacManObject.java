import java.awt.image.BufferedImage;

public class PacManObject extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	PacManObject(int x, int y, int width, int height){
		super(x,y,width,height);
		if(needImage) {
			//loadImage("INSERTIMAGE.PNG");
		}
		
	}
}
