import javax.swing.JPanel;
import java.awt.*;

public class Minipookie extends JPanel implements Runnable {
	final int originalTileSize = 16;
	final int scale = 3;

	final int tileSize = originalTileSize * scale; 

	final int maxScreenCol = 16;
	final int maxScreenRow = 12;

	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;

	// Framerate 
	int FPS = 60;

	Thread gameThread;
	KeyHandler keyH = new KeyHandler();

	// Player default position. 
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 5;

	public Minipookie() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	// Game Loop 
	@Override
	public void run() {
		double drawInterval = 1000000000 / FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;

		while(gameThread != null) {
			// Writing your game loop. 
			update();

			repaint();

			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;

				if(remainingTime < 0) {
					remainingTime = 0;
				}

				Thread.sleep((long) remainingTime); 

 				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				e.printStackTrace(); 
			}
		}
	}

	public void update() {
		if(keyH.upKey == true) {
			playerY -= playerSpeed;
		} else if(keyH.downKey == true) {
			playerY += playerSpeed;
		} else if(keyH.leftKey == true) {
			playerX -= playerSpeed;
		} else if(keyH.rightKey == true) {
			playerX += playerSpeed; 
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		g2.dispose();
	}
}