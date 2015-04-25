package panels;

import main.ObservationManager;

import javax.swing.*;

public class Gruppenarbeit extends AbstractCustomPanel
{

    public Gruppenarbeit(ObservationManager m)
    {

        setLayout(null);

        JButton btnLSprichtMit = new JButton("Kind geleitet");
        btnLSprichtMit.setActionCommand("kil");
        btnLSprichtMit.addActionListener(m);
        btnLSprichtMit.setBounds(250, 80, 200, 50);
        add(btnLSprichtMit);

        JButton btnLSprichtMit_1 = new JButton("L1 geleitet");
        btnLSprichtMit_1.setBounds(250, 180, 200, 50);
        btnLSprichtMit_1.setActionCommand("l1l");
        btnLSprichtMit_1.addActionListener(m);
        add(btnLSprichtMit_1);

        JButton btnLGeleitet = new JButton("L2 geleitet");
        btnLGeleitet.setBounds(250, 280, 200, 50);
        btnLGeleitet.setActionCommand("l2l");
        btnLGeleitet.addActionListener(m);
        add(btnLGeleitet);
    }
}
