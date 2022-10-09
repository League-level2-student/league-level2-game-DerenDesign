import java.awt.Graphics;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JOptionPane;

public class ObjectManager {
PacManObject PacMan;
int score = 0;
int CoinsTotal = 0;
ArrayList<Coins> coins = new ArrayList<Coins>();
ArrayList<Barriers> barriers = new ArrayList<Barriers>();
ObjectManager(PacManObject PacMan){
	this.PacMan = PacMan;
	createBarriers();
	addCoins();
	
}
public void addCoins() {
	for(int x = 0; x < 47; x++) {
		for(int y = 0; y < 47; y++) {
		Coins coin = new Coins(x*20,y*20,20,20);
		boolean coinColides = false;
		for(int z = 0; z < barriers.size(); z++) {
			if(coin.collisionBox.intersects(barriers.get(z).collisionBox)){
				coinColides = true;
				break;
			}
		}
		if(!coinColides) {
			coins.add(coin);
			
		}
		
}
	}
	

	CoinsTotal = coins.size();
	
}

public void update() {
	purgeObjects();
	checkCollision();
	
	
}
public void purgeObjects(){
	for(int b = coins.size()-1; b >= 0 ; b--) {
		if(!coins.get(b).isActive) {
			coins.remove(b);
			score++;
		}
	}
		}
		
	public void checkCollision() {	
	for(int d = 0; d < coins.size(); d++) {
if(coins.get(d).collisionBox.intersects(PacMan.collisionBox)) {
	coins.get(d).isActive = false;
}
	}
	for(int e = 0; e < barriers.size(); e++) {
if(barriers.get(e).collisionBox.intersects(PacMan.collisionBox)) {
	PacMan.isActive = false;
	JOptionPane.showMessageDialog(null,"You collected "+ score + " "+"coins.");

}
	}
	}
	


public void createBarriers() {
	
	barriers.add(new Barriers(200,72,63,63));
	barriers.add(new Barriers(87,61,65,20));
	barriers.add(new Barriers(392,78,209,20));
	barriers.add(new Barriers(33,34,17,390));
	barriers.add(new Barriers(52,401,200,20));
	barriers.add(new Barriers(237,416,20,120));
	barriers.add(new Barriers(31,545,20,120));
	barriers.add(new Barriers(35,525,220,20));
	barriers.add(new Barriers(105,590,110,40));
	barriers.add(new Barriers(490,545,199,15));
	barriers.add(new Barriers(591,595,199,15));
	barriers.add(new Barriers(408,259,199,15));
	barriers.add(new Barriers(405,259,15,230));
	barriers.add(new Barriers(600,259,15,120));
	barriers.add(new Barriers(499,369,105,12));
	barriers.add(new Barriers(499,369,12,105));
	barriers.add(new Barriers(104,175,12,150));
	barriers.add(new Barriers(104,315,190,18));
	barriers.add(new Barriers(294,175,12,150));
	
}

	

public void draw(Graphics g) {
	for(int i = 0; i < coins.size(); i++) {
		Coins coin = coins.get(i);
		coin.draw(g);
	}
	for(int a = 0; a < barriers.size(); a++) {
		Barriers barrier = barriers.get(a);
		barrier.draw(g);
		
	}
	
	 PacMan.draw(g);
}



}











