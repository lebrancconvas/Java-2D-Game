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
        window.setVisible(true);
    }
}

class BasicGame extends JPanel
{
    public BasicGame()
    {
        this.setPreferredSize(new Dimension(800, 600));
    }
}