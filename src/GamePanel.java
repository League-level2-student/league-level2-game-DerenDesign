import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener,KeyListener {
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
	 Timer frameDraw;
	 PacManObject pacMan = new PacManObject(550,490,30,30);
	 ObjectManager objectmanager = new ObjectManager(pacMan);
	GamePanel(){
	  frameDraw = new Timer(1000/60,this);
   	  frameDraw.start();
	  titleFont = new Font("Arial", Font.PLAIN, 45);
  	  titleFont2 = new Font("Arial", Font.PLAIN, 30);
  	  titleFont3 = new Font("Arial", Font.PLAIN, 25);
  	  titleFont4 = new Font("Arial", Font.PLAIN, 55);
  	 if (needImage) {
	        loadImage("pixil-frame-0.png");
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
	  g.drawImage(image, 0, 0, PacMan.WIDTH, PacMan.HEIGHT, null);
	  pacMan.draw(g);
  }
  void drawEndState(Graphics g)  { 
	  g.setColor(Color.RED);
	    g.fillRect(0, 0, PacMan.WIDTH, PacMan.HEIGHT);
	    g.setFont(titleFont4);
	    g.setColor(Color.WHITE);
	    g.drawString("GAME OVER",200, PacMan.HEIGHT/2);
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
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			pacMan.up();
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			pacMan.down();
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			pacMan.left();
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			pacMan.right();
		}
		else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			//objectmanager.addProjectile(pacMan.getProjectile());
		}
		else if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(currentState == END) {
				pacMan = new PacManObject(550,490,50,50);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			JOptionPane.showMessageDialog(null,"INSTRUCTIONS");
		}
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    }
		
		    else if (currentState == MENU) {
		    	
			    currentState = GAME;
			    startGame();
		    
		    } else {
		        currentState++;
		    }
		   
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		 //   updateMenuState();
		    
		   // System.out.println("Action");
		    
		}else if(currentState == GAME){
		  //  updateGameState();
		    //System.out.println("Action");
		    repaint();
		}else if(currentState == END){
		   // updateEndState();
		    
		}
		repaint();
		
	}
}
