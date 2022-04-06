import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.io.*;
import java.awt.image.*;

class BasicGame extends JPanel
{
    private final int SCREEN_WIDTH = 800;
    private final int SCREEN_HEIGHT = 600;

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
        myBrush.drawGrass();
        myBrush.drawSun();
        myBrush.drawTree();
        myBrush.drawImage("Cycling", 200, 500); 
        myBrush.drawImage("Cycling", 500, 500); 
    }
}
