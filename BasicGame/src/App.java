import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.awt.image.*;

public class App
{
    public static void main(String[] args)
    {
        String screenTitle = "Just a Basic Game";
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