package panels;

import main.SessionManager;
import main.Speichern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Ende extends AbstractCustomPanel implements ActionListener
{

    public Ende(SessionManager session)
    {

        this.setLayout(null);

        JLabel frage = new JLabel("Ende des Fragebogens.");
        frage.setFont(new Font("Tahoma", Font.BOLD, 17));
        frage.setForeground(Color.RED);
        frage.setBounds(10, 100, 680, 80);
        frage.setHorizontalAlignment(JLabel.CENTER);
        this.add(frage);

        JButton beenden = new JButton("Beenden");
        beenden.setBounds(250, 300, 200, 80);
        beenden.setActionCommand("beenden");
        beenden.addActionListener(this);
        this.add(beenden);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("beenden")) {
            Speichern.signWithMD5();
            System.exit(0);
        }
    }
}
