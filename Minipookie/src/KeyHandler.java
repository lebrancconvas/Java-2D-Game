import java.awt.*;
import java.awt.event.*;

public class KeyHandler implements KeyListener {
	public boolean upKey, downKey, leftKey, rightKey;

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		if(code == KeyEvent.VK_W) {
			upKey = true;
		}
		if(code == KeyEvent.VK_S) {
			downKey = true;
		}
		if(code == KeyEvent.VK_A) {
			leftKey = true;
		}
		if(code == KeyEvent.VK_D) {
			rightKey = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

		if(code == KeyEvent.VK_W) {
			upKey = false;
		}
		if(code == KeyEvent.VK_S) {
			downKey = false;
		}
		if(code == KeyEvent.VK_A) {
			leftKey = false;
		}
		if(code == KeyEvent.VK_D) {
			rightKey = false;
		}
	}
}
