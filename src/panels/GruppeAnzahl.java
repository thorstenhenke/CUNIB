package panels;

import main.ObservationManager;

import javax.swing.*;
import java.awt.*;

public class GruppeAnzahl extends AbstractCustomPanel
{
    
    public GruppeAnzahl(ObservationManager m)
    {
        setLayout(null);

        /*linke Spalte*/

        JButton btnAnzahl1 = new JButton("Anzahl 1");
        btnAnzahl1.setActionCommand("1");
        btnAnzahl1.addActionListener(m);
        btnAnzahl1.setBounds(100, 30, 200, 50);
        add(btnAnzahl1);

        JButton btnAnzahl2 = new JButton("Anzahl 2");
        btnAnzahl2.setActionCommand("2");
        btnAnzahl2.addActionListener(m);
        btnAnzahl2.setBounds(100, 100, 200, 50);
        add(btnAnzahl2);

        JButton btnAnzahl3 = new JButton("Anzahl 3");
        btnAnzahl3.setActionCommand("3");
        btnAnzahl3.addActionListener(m);
        btnAnzahl3.setBounds(100, 170, 200, 50);
        add(btnAnzahl3);

        JButton btnAnzahl4 = new JButton("Anzahl 4");
        btnAnzahl4.setActionCommand("4");
        btnAnzahl4.addActionListener(m);
        btnAnzahl4.setBounds(100, 240, 200, 50);
        add(btnAnzahl4);

        JButton btnAnzahl5 = new JButton("Anzahl 5");
        btnAnzahl5.setActionCommand("5");
        btnAnzahl5.addActionListener(m);
        btnAnzahl5.setBounds(100, 310, 200, 50);
        add(btnAnzahl5);
        
        /*rechte spalte*/

        JButton btnAnzahl6 = new JButton("Anzahl 6");
        btnAnzahl6.setActionCommand("6");
        btnAnzahl6.addActionListener(m);
        btnAnzahl6.setBounds(400, 30, 200, 50);
        add(btnAnzahl6);

        JButton btnAnzahl7 = new JButton("Anzahl 7");
        btnAnzahl7.setActionCommand("7");
        btnAnzahl7.addActionListener(m);
        btnAnzahl7.setBounds(400, 100, 200, 50);
        add(btnAnzahl7);

        JButton btnAnzahl8 = new JButton("Anzahl 8");
        btnAnzahl8.setActionCommand("8");
        btnAnzahl8.addActionListener(m);
        btnAnzahl8.setBounds(400, 170, 200, 50);
        add(btnAnzahl8);

        JButton btnAnzahl9 = new JButton("Anzahl 9");
        btnAnzahl9.setActionCommand("9");
        btnAnzahl9.addActionListener(m);
        btnAnzahl9.setBounds(400, 240, 200, 50);
        add(btnAnzahl9);

        JButton btnAnzahl10 = new JButton("Anzahl >9");
        btnAnzahl10.setActionCommand(">9");
        btnAnzahl10.addActionListener(m);
        btnAnzahl10.setBounds(400, 310, 200, 50);
        add(btnAnzahl10);
    }
}
