import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PacManObject extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	PacManObject(int x, int y, int width, int height){
		super(x,y,width,height);
		speed = 5;
		
	}
	public void up() {
		if(y > 15) {
        y-=speed;
		}
    }
	public void down() {
		if(y < PacMan.HEIGHT-90) {
        y+=speed;
		}
    }
	public void left() {
		if(x > 15) {
        x-=speed;
		}
    }
	public void right() {
		if(x < PacMan.WIDTH-70) {
        x+=speed;
		}
    }
	public void update() {
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, width, height);
	}
}
