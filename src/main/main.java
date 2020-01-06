package main;

import java.awt.*;

public class main
{

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try {
                    Fenster mainFrame = new Fenster();
                    new SessionManager(mainFrame);
                    mainFrame.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
