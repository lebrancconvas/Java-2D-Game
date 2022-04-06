import javax.swing.JFrame;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        JFrame window = new JFrame();

        String windowTitle = "Special Unit Magician"; 

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle(windowTitle); 

        // Add Game to Screen. 
        Minipookie minipookie = new Minipookie();
        window.add(minipookie);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
} 