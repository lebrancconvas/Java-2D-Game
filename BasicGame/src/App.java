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

class PaintBrush
{
    private Graphics g;

    // Set Color 
    private static final Color skyblue = new Color(77, 237, 255);
    private static final Color orangesun = new Color(255, 178, 44);
    private static final Color greenmint = new Color(99, 224, 159);
    private static final Color goldensun = new Color(255, 152, 34);
    private static final Color ALIZARIN_CRIMSON = new Color(78, 21, 0);
    private static final Color BRIGHT_RED = new Color(219, 0, 0);
    private static final Color CADMIUM_YELLOW = new Color(255, 236, 0);
    private static final Color DARK_SIENNA = new Color(95, 46, 31);
    private static final Color INDIAN_YELLOW = new Color(255, 184, 0);
    private static final Color MIDNIGHT_BLACK = new Color(0, 0, 0);
    private static final Color PHTHALO_BLUE = new Color(12, 0, 64);
    private static final Color PHTHALO_GREEN = new Color(16, 46, 60);
    private static final Color PRUSSIAN_BLUE = new Color(2, 30, 68);
    private static final Color SAP_GREEN = new Color(10, 52, 16);
    private static final Color TITANIUM_WHITE = new Color(255, 255, 255);
    private static final Color VAN_DYKE_BROWN = new Color(34, 27, 21);
    private static final Color YELLOW_OCHRE = new Color(199, 155, 0);

    // Init Paint Brush. 
    public PaintBrush(Graphics graphics)
    {
        g = graphics;
    }

    // Color Algorithm.
    private Color blend(Color c1, Color c2, float ratio) 
    {
        if ( ratio > 1f ) ratio = 1f;
        else if ( ratio < 0f ) ratio = 0f;
        float iRatio = 1.0f - ratio;
    
        int i1 = c1.getRGB();
        int i2 = c2.getRGB();
    
        int a1 = (i1 >> 24 & 0xff);
        int r1 = ((i1 & 0xff0000) >> 16);
        int g1 = ((i1 & 0xff00) >> 8);
        int b1 = (i1 & 0xff);
    
        int a2 = (i2 >> 24 & 0xff);
        int r2 = ((i2 & 0xff0000) >> 16);
        int g2 = ((i2 & 0xff00) >> 8);
        int b2 = (i2 & 0xff);
    
        int a = (int)((a1 * iRatio) + (a2 * ratio));
        int r = (int)((r1 * iRatio) + (r2 * ratio));
        int g = (int)((g1 * iRatio) + (g2 * ratio));
        int b = (int)((b1 * iRatio) + (b2 * ratio));
    
        return new Color( a << 24 | r << 16 | g << 8 | b );
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
        Color skyFarMix = blend(PHTHALO_BLUE, skyblue, 0.5f);
        Color skyNearMix = blend(skyblue, TITANIUM_WHITE, 0.16f);

        GradientPaint grassMix = new GradientPaint(0, 0, skyFarMix, 0, 300, skyNearMix);

        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(grassMix);
        g2.fillRect(0, 0, 800, 200);
    }

    public void drawFloor()
    {
        brushRect(greenmint, 0, 200, 800, 400);
    }

    public void drawSun()
    {
        brushCircle(orangesun, 480, 35, 140);
        brushCircle(goldensun, 500, 55, 100);
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

    public void drawGrass()
    {
        Color grassFarMix = blend(SAP_GREEN, PHTHALO_GREEN, 0.5f);
        Color grassNearMix = blend(SAP_GREEN, TITANIUM_WHITE, 0.16f);

        GradientPaint grassMix = new GradientPaint(0, 0, grassFarMix, 0, 700, grassNearMix);  

        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(grassMix);
        g2.fillRect(0, 200, 800, 400);
    }

    public void drawImage(String fileName, int xAxis, int yAxis)
    {
        try
        {
            BufferedImage image = ImageIO.read(new File("assets/image/" + fileName + ".png"));
            g.drawImage(image, xAxis, yAxis, null); 
        }
        catch(IOException e)
        {
            System.out.println("Error opening image file: " + e.getMessage());
        }
    }
}