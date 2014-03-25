package panels;

import main.Fenster;
import main.SessionManager;

import java.awt.*;
import javax.swing.*;


public abstract class AbstractCustomPanel extends JPanel {

    public AbstractCustomPanel() {
        this.bauePanel();

        this.setBounds(10, 20, 700, 460);
        this.setVisible(false);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    }

    public String getKennung() {
        String kennung =  this.toString().substring(0,3);
        return kennung.toUpperCase();
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    abstract void bauePanel();

}
