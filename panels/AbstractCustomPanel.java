package panels;

import javax.swing.*;
import java.awt.*;


public abstract class AbstractCustomPanel extends JPanel
{

    public AbstractCustomPanel()
    {
        this.setBounds(10, 20, 700, 460);
        this.setVisible(false);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    }

    public String getKennung()
    {
        String kennung = this.toString().substring(7, 10);
        return kennung.toUpperCase();
    }

    @Override
    public String toString()
    {
        return this.getClass().getName();
    }
}
