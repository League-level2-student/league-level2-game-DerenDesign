import javax.swing.JFrame;

public class PacMan {
	
	JFrame frame;
	GamePanel panel;
	public static final int WIDTH = 700;
	public static final int HEIGHT = 700;
	PacMan(){
		frame = new JFrame();
		panel = new GamePanel();
		frame.setVisible(true);
		frame.setTitle("PacMan");
	}
	public void setup() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
		frame.addMouseMotionListener(panel);
		frame.addMouseListener(panel);
		
	}
	public static void main(String[] args) {
		new PacMan().setup();
	}

}
