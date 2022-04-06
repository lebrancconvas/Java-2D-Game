import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
	final int originalTileSize = 16;
	final int scale = 3;

	final int tileSize = originalTileSize * scale; 

	final int maxScreenCol = 16;
	final int maxScreenRow = 12;

	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;

	Thread gameThread;

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	// Game Loop 
	@Override
	public void run() {
		while(gameThread != null) {
			// Writing your game loop. 
			System.out.println("Hello World.");
		}
	}

	public void update() {

	}

	public void paintComponent(Graphics g) {
		
	}
}