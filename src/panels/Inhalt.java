package panels;

import main.ObservationManager;

import javax.swing.*;
import java.awt.*;

public class Inhalt extends AbstractCustomPanel
{

    public Inhalt(ObservationManager m)
    {

        setLayout(null);

        JLabel warnhinweis = new JLabel("Erste Frage ! ");
        warnhinweis.setFont(new Font("Tahoma", Font.BOLD, 20));
        warnhinweis.setBounds(250, 11, 200, 30);
        warnhinweis.setForeground(Color.green);
        warnhinweis.setHorizontalAlignment(JLabel.CENTER);
        add(warnhinweis);

        JLabel lblInhalt = new JLabel("Inhalt...");
        lblInhalt.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblInhalt.setBounds(250, 70, 200, 30);
        lblInhalt.setHorizontalAlignment(JLabel.CENTER);
        add(lblInhalt);

        JButton btnAufgabenbezogen = new JButton("aufgabenbezogen");
        btnAufgabenbezogen.setBounds(250, 140, 200, 59);
        btnAufgabenbezogen.setActionCommand("auf");
        btnAufgabenbezogen.addActionListener(m);
        add(btnAufgabenbezogen);

        JButton btnNichtAufgabenbezogen = new JButton("nicht aufgabenbezogen");
        btnNichtAufgabenbezogen.setBounds(250, 240, 200, 59);
        btnNichtAufgabenbezogen.setActionCommand("nau");
        btnNichtAufgabenbezogen.addActionListener(m);
        add(btnNichtAufgabenbezogen);

        JButton btnSchuelerAbwesend = new JButton("Schüler ist nicht im Raum");
        btnSchuelerAbwesend.setBounds(250, 380, 200, 59);
        btnSchuelerAbwesend.setActionCommand("LEER");
        btnSchuelerAbwesend.addActionListener(m);
        add(btnSchuelerAbwesend);
    }
}
