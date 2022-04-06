import javax.swing.*;
import java.awt.*;
import java.lang.*;

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
        // myBrush.drawMountain();
        myBrush.drawTree();
    }
}

class PaintBrush
{
    private Graphics g;

    // Set Color 
    private static final Color skyblue = new Color(77, 237, 255);
    private static final Color orangesun = new Color(255, 178, 44);

    // Init Paint Brush. 
    public PaintBrush(Graphics graphics)
    {
        g = graphics;
    }

    // Shape Brush. 
    public void brushPolygon(Color color, int x1, int y1, int x2, int y2, int x3, int y3)
    {
        g.setColor(color);
        
        Polygon polygon = new Polygon();

        polygon.addPoint(x1, y1);
        polygon.addPoint(x2, y2);
        polygon.addPoint(x3, y3);

        g.fillPolygon(polygon);
    }
    
    public void brushCircle(Color color, int xAxis, int yAxis, int radius)
    {
        g.setColor(color);
        g.fillOval(xAxis, yAxis, radius, radius);
    }

    public void brushSquare(Color color, int xAxis, int yAxis, int width)
    {
        g.setColor(color);
        g.fillRect(xAxis, yAxis, width, width); 
    }

    public void brushRect(Color color, int xAxis, int yAxis, int width, int height)
    {
        g.setColor(color);
        g.fillRect(xAxis, yAxis, width, height);
    }

    public void brushIsoTriangle(Color color, int xAxis, int yAxis, int base, int height)
    {
        brushPolygon(color, xAxis, yAxis, xAxis - base/2, yAxis + height, xAxis + base/2, yAxis + height);
    }

    public void brushEquiTriangle(Color color, int xAxis, int yAxis, int width)
    {
        int height = (int) Math.sqrt((width * width) - ((width / 2) * (width * 2)));
        brushPolygon(color, xAxis, yAxis, xAxis - width/2, yAxis + height, xAxis + width/2, yAxis + height);
    }

    // Drawing Stuff. 
    public void drawSky()
    {
        g.setColor(skyblue);
        g.fillRect(0, 0, 800, 200);
    }

    public void drawSun()
    {
        brushCircle(orangesun, 500, 70, 100);
    }

    public void drawMountain()
    {
        brushPolygon(Color.ORANGE, 10, 10, 5, 15, 100, 100);
    }

    public void drawTree()
    {
        final int leafX = 320, leafY = 300;
        final int rootX = 300, rootY = 450;

        final int rootWidth = (leafX - rootX) * 2;
        final int rootHeight = 70;

        final int leafWidth = 100;
        final int leafHeight = rootY - leafY;

        final boolean validRoot = (leafX > rootX) && (rootX > leafX - leafWidth/2);
        
        if(validRoot && (leafY < rootY))
        {
            brushRect(Color.RED, rootX, rootY, rootWidth, rootHeight); // Draw Root
            brushIsoTriangle(Color.GREEN, leafX, leafY, leafWidth, leafHeight); // Draw Leaf 
        }
    }
}