package panels;

import main.ObservationManager;

import javax.swing.*;

public class Individuell extends AbstractCustomPanel
{

    public Individuell(ObservationManager m)
    {
        setLayout(null);

        JButton btnGesamteKlasse = new JButton("K allein");
        btnGesamteKlasse.setBounds(250, 40, 200, 40);
        btnGesamteKlasse.setActionCommand("all");
        btnGesamteKlasse.addActionListener(m);
        add(btnGesamteKlasse);

        JButton btnGruppenarbeit = new JButton("K spricht zu Erw");
        btnGruppenarbeit.setActionCommand("kl");
        btnGruppenarbeit.addActionListener(m);
        btnGruppenarbeit.setBounds(100, 130, 200, 40);
        add(btnGruppenarbeit);

/*        JButton btnKSprichtMit = new JButton("K spricht zu L2");
        btnKSprichtMit.setActionCommand("kl2");
        btnKSprichtMit.addActionListener(m);
        btnKSprichtMit.setBounds(100, 220, 200, 40);
        add(btnKSprichtMit);*/

        JButton kak = new JButton("K spricht zu aK");
        kak.setBounds(100, 310, 200, 40);
        kak.setActionCommand("kak");
        kak.addActionListener(m);
        add(kak);

        /**
         * zweite Spalte
         */

        JButton btnLSprichtMit_1 = new JButton("Erw spricht zu K");
        btnLSprichtMit_1.setBounds(400, 130, 200, 40);
        btnLSprichtMit_1.setActionCommand("lk");
        btnLSprichtMit_1.addActionListener(m);
        add(btnLSprichtMit_1);

/*        JButton btnLSprichtMit = new JButton("L2 spricht zu K");
        btnLSprichtMit.setBounds(400, 220, 200, 40);
        btnLSprichtMit.setActionCommand("l2k");
        btnLSprichtMit.addActionListener(m);
        add(btnLSprichtMit);*/

        JButton akk = new JButton("ak spricht zu K");
        akk.setBounds(400, 310, 200, 40);
        akk.setActionCommand("akk");
        akk.addActionListener(m);
        add(akk);

    }
}
