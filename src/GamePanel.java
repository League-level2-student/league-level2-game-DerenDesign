import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener {
	 public static BufferedImage image;
	 public static boolean needImage = true;
	 public static boolean gotImage = false;	
	 final int MENU = 0;
     final int GAME = 1;
     final int END = 2;
	 int currentState = MENU;
	 Font titleFont;
	 Font titleFont2;
	 Font titleFont3;
	 Font titleFont4;
	GamePanel(){
	  titleFont = new Font("Arial", Font.PLAIN, 45);
  	  titleFont2 = new Font("Arial", Font.PLAIN, 30);
  	  titleFont3 = new Font("Arial", Font.PLAIN, 25);
  	  titleFont4 = new Font("Arial", Font.PLAIN, 55);
  	 if (needImage) {
	        loadImage("space.png");
	    }
	}
	void startGame() {
  	 
  }
  void loadImage(String imageFile) {
      if (needImage) {
          try {
              image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
  	    gotImage = true;
          } catch (Exception e) {
              
          }
          needImage = false;
      }
      
  }
  void drawMenuState(Graphics g) {
	  	g.setColor(Color.BLACK);
	    g.fillRect(0, 0, PacMan.WIDTH, PacMan.HEIGHT);
	    g.setFont(titleFont);
	    g.setColor(Color.WHITE);
	    g.drawString("PacMan", 260, 100);
	    g.setFont(titleFont2);
	    g.setColor(Color.WHITE);
	    g.drawString("Press ENTER to start", 190, 350);
	    g.setFont(titleFont3);
	    g.setColor(Color.WHITE);
	    g.drawString("Press SPACE for instructions", 160, 550);  
  }
  void drawGameState(Graphics g) { 
	  
  }
  void drawEndState(Graphics g)  { 
	  g.setColor(Color.RED);
	    g.fillRect(0, 0, PacMan.WIDTH, PacMan.HEIGHT);
	    g.setFont(titleFont4);
	    g.setColor(Color.WHITE);
	    g.drawString("GAME OVER",70, 150);
	    }  
  
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
