import javax.swing.*;

public class App
{
    private static void initWindow()
    {
        String windowTitle = "Mech Meow";
        JFrame window = new JFrame(windowTitle);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MechMeow mechmeow = new MechMeow();
        window.add(mechmeow);

        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    initWindow();
                }
            }
        );
    }
}