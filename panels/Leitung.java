package panels;

import main.ObservationManager;

import javax.swing.*;

public class Leitung extends AbstractCustomPanel
{

    public Leitung(ObservationManager m)
    {

        setLayout(null);

        JButton btnLSprichtMit = new JButton("Kind geleitet");
        btnLSprichtMit.setActionCommand("kgl");
        btnLSprichtMit.addActionListener(m);
        btnLSprichtMit.setBounds(250, 70, 200, 50);
        add(btnLSprichtMit);

        JButton btnLSprichtMit_1 = new JButton("Erw geleitet");
        btnLSprichtMit_1.setBounds(250, 210, 200, 50);
        btnLSprichtMit_1.setActionCommand("lgl");
        btnLSprichtMit_1.addActionListener(m);
        add(btnLSprichtMit_1);

/*        JButton btnLGeleitet = new JButton("L2 geleitet");
        btnLGeleitet.setBounds(250, 350, 200, 50);
        btnLGeleitet.setActionCommand("l2l");
        btnLGeleitet.addActionListener(m);
        add(btnLGeleitet);*/
    }
}
