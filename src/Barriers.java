import java.awt.Color;
import java.awt.Graphics;

public class Barriers extends GameObject {
Barriers(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
public void draw(Graphics g) {
	Color myColor = Color.decode("#ddddff");
	g.setColor(myColor);
	g.fillRect(x,y,width,height);
}
}
