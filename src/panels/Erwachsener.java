package panels;

import main.ObservationManager;

import javax.swing.*;
import java.awt.*;

public class Erwachsener extends AbstractCustomPanel
{

    public Erwachsener(ObservationManager m)
    {

        setLayout(null);

        // Header
        JLabel lblLernkontext = new JLabel("Der Erwachsene ist ...");
        lblLernkontext.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblLernkontext.setBounds(250, 11, 200, 30);
        lblLernkontext.setHorizontalAlignment(JLabel.CENTER);
        add(lblLernkontext);

        // Erste Spalte
        JButton btnIndividuell = new JButton("1. Lehrkraft");
        btnIndividuell.setBounds(100, 100, 200, 60);
        btnIndividuell.setActionCommand("l1");
        btnIndividuell.addActionListener(m);
        add(btnIndividuell);

        JButton btnGesamteKlasse = new JButton("2. Lehrkraft");
        btnGesamteKlasse.setBounds(400, 100, 200, 60);
        btnGesamteKlasse.setActionCommand("l2");
        btnGesamteKlasse.addActionListener(m);
        add(btnGesamteKlasse);

        // Zweite Spalte
        JButton btnPartner = new JButton("Sonderpädagoge");
        btnPartner.setBounds(100, 220, 200, 60);
        btnPartner.setActionCommand("son");
        btnPartner.addActionListener(m);
        add(btnPartner);

        JButton btnEinzelfall = new JButton("Einzelfallhelfer");
        btnEinzelfall.setBounds(400, 220, 200, 60);
        btnEinzelfall.setActionCommand("ein");
        btnEinzelfall.addActionListener(m);
        add(btnEinzelfall);

        // Footer
        JButton btnSonstiger = new JButton("Andere Person");
        btnSonstiger.setBounds(250, 340, 200, 60);
        btnSonstiger.setActionCommand("and");
        btnSonstiger.addActionListener(m);
        add(btnSonstiger);

    }
}
