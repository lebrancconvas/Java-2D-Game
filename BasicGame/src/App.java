import javax.swing.*;
import java.awt.*;

public class App
{
    public static void main(String[] args)
    {
        String screenTitle = "Just a basic game";
        JFrame window = new JFrame(screenTitle);
        
        // Settings. 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Game
        BasicGame basicgame = new BasicGame();
        window.add(basicgame);

        // Fit the window size around the component. 
        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}

class BasicGame extends JPanel
{
    final int SCREEN_WIDTH = 800;
    final int SCREEN_HEIGHT = 600;

    public BasicGame()
    {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK); 
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(100, 100, 100, 100);

        g.setColor(new Color(100, 0, 255));
        g.fillOval(500, 100, 200, 200);
    }
}