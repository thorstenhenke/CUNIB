package panels;

import main.ObservationManager;

import javax.swing.*;

public class Partnerarbeit extends AbstractCustomPanel
{

    public Partnerarbeit(ObservationManager m)
    {

        setLayout(null);

        JButton btnLSprichtMit = new JButton("Kind geleitet");
        btnLSprichtMit.setActionCommand("kil");
        btnLSprichtMit.addActionListener(m);
        btnLSprichtMit.setBounds(250, 70, 200, 50);
        add(btnLSprichtMit);

        JButton btnLSprichtMit_1 = new JButton("L1 geleitet");
        btnLSprichtMit_1.setBounds(250, 210, 200, 50);
        btnLSprichtMit_1.setActionCommand("l1l");
        btnLSprichtMit_1.addActionListener(m);
        add(btnLSprichtMit_1);

        JButton btnLGeleitet = new JButton("L2 geleitet");
        btnLGeleitet.setBounds(250, 350, 200, 50);
        btnLGeleitet.setActionCommand("l2l");
        btnLGeleitet.addActionListener(m);
        add(btnLGeleitet);
    }
}
