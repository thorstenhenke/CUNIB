package main;

import java.awt.*;

public class main {

    public static void main(String[] args) {

        Fenster mainFrame = new Fenster();
        SessionManager sessionManager = new SessionManager(mainFrame);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Fenster window = new Fenster();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
