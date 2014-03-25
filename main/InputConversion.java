package main;

import javax.swing.*;
import java.util.Enumeration;

public class InputConversion {
    public static String getSelectedItem(ButtonGroup g){
        for (Enumeration e = g.getElements();  e.hasMoreElements(); ) {
            AbstractButton b = (AbstractButton) e.nextElement();
            if (b.isSelected()) {
                return b.getText();
            }
        }
        return "";
    }
}
