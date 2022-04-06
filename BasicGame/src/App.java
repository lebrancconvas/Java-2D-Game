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

        PaintBrush myBrush = new PaintBrush(g);

        myBrush.drawSky();
        myBrush.drawSun();
    }
}

class PaintBrush
{
    private Graphics g;

    // Set Color 
    Color skyblue = new Color(77, 237, 255);
    Color orangesun = new Color(255, 178, 44);

    public PaintBrush(Graphics graphics)
    {
        g = graphics;
    }

    public void drawSky()
    {
        g.setColor(skyblue);
        g.fillRect(0, 0, 800, 200);
    }

    public void drawSun()
    {
        int radius = 100;
        g.setColor(orangesun);
        g.fillOval(500, 70, radius, radius);
    }
}