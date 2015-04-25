package panels;

import main.ObservationManager;

import javax.swing.*;
import java.awt.*;

public class Erwachsener extends AbstractCustomPanel
{

    public Erwachsener(ObservationManager m)
    {

        setLayout(null);

        JLabel lblLernkontext = new JLabel("Der Erwachsene ist ...");
        lblLernkontext.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblLernkontext.setBounds(250, 11, 200, 30);
        lblLernkontext.setHorizontalAlignment(JLabel.CENTER);
        add(lblLernkontext);

        JButton btnIndividuell = new JButton("1. Lehrkraft");
        btnIndividuell.setBounds(250, 80, 200, 60);
        btnIndividuell.setActionCommand("l1");
        btnIndividuell.addActionListener(m);
        add(btnIndividuell);

        JButton btnGesamteKlasse = new JButton("2. Lehrkraft");
        btnGesamteKlasse.setBounds(250, 170, 200, 60);
        btnGesamteKlasse.setActionCommand("l2");
        btnGesamteKlasse.addActionListener(m);
        add(btnGesamteKlasse);

        JButton btnPartner = new JButton("Sonderpädagoge");
        btnPartner.setBounds(250, 260, 200, 60);
        btnPartner.setActionCommand("son");
        btnPartner.addActionListener(m);
        add(btnPartner);

        JButton btnGruppenarbeit = new JButton("Einzelfallhelfer");
        btnGruppenarbeit.setBounds(250, 350, 200, 60);
        btnGruppenarbeit.setActionCommand("ein");
        btnGruppenarbeit.addActionListener(m);
        add(btnGruppenarbeit);

    }
}
