package panels;

import main.ObservationManager;

import javax.swing.*;

public class GemeinsameArbeit extends AbstractCustomPanel
{

    public GemeinsameArbeit(ObservationManager m)
    {

        setLayout(null);

        JButton teil = new JButton("K Teil der Gruppe");
        teil.setBounds(225, 20, 250, 50);
        teil.setActionCommand("tei");
        teil.addActionListener(m);
        add(teil);

        /**
         * first column
         */

        JButton btnGruppenarbeit = new JButton("K spricht zu aK");
        btnGruppenarbeit.setActionCommand("kak");
        btnGruppenarbeit.addActionListener(m);
        btnGruppenarbeit.setBounds(100, 130, 250, 50);
        add(btnGruppenarbeit);

        JButton btnKSprichtMit = new JButton("K spricht zu Erw");
        btnKSprichtMit.setActionCommand("kl");
        btnKSprichtMit.addActionListener(m);
        btnKSprichtMit.setBounds(100, 240, 250, 50);
        add(btnKSprichtMit);

        /**
         * second column
         */

        JButton btnLSprichtMit = new JButton("aK spricht zu K");
        btnLSprichtMit.setBounds(400, 130, 250, 50);
        btnLSprichtMit.setActionCommand("akk");
        btnLSprichtMit.addActionListener(m);
        add(btnLSprichtMit);

        JButton btnLSprichtMit_1 = new JButton("Erw spricht zu K");
        btnLSprichtMit_1.setBounds(400, 240, 250, 50);
        btnLSprichtMit_1.setActionCommand("lk");
        btnLSprichtMit_1.addActionListener(m);
        add(btnLSprichtMit_1);

        /**
         * bottom
         */

        JButton btnKArbeitetNonverbal = new JButton("K arbeitet nonverbal mit aK");
        btnKArbeitetNonverbal.setBounds(100, 350, 250, 50);
        btnKArbeitetNonverbal.setActionCommand("non");
        btnKArbeitetNonverbal.addActionListener(m);
        add(btnKArbeitetNonverbal);

        JButton btnKAllein = new JButton("K allein");
        btnKAllein.setBounds(400, 350, 250, 50);
        btnKAllein.setActionCommand("all");
        btnKAllein.addActionListener(m);
        add(btnKAllein);
    }
}
