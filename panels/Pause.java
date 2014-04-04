package panels;

import main.Fenster;
import main.SessionManager;
import model.Einstellungen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Pause extends AbstractCustomPanel {


	public Pause(SessionManager session) {
		setLayout(null);
		JLabel disclaimer = new JLabel(
				"<html><body><center>" +
				"Der erste Durchgang der Schülerbeobachtung ist <br>" +
				"abgeschlossen. Rufe nun das Programm zur <br>" +
				"allgemeinen Unterrichtsqualität auf." +
				"</center></body></html>"
		);
		disclaimer.setFont(new Font("Tahoma", Font.BOLD, 17));
		disclaimer.setBounds(130, 30, 500, 100);
		this.add(disclaimer);
		
		JButton startBtn = new JButton("Weiter");
		startBtn.setBounds(250, 230, 200, 50);
	    startBtn.setActionCommand("Pause::Weiter");
	    startBtn.addActionListener(session);
		this.add(startBtn);	
	}
    /**
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
        }
        // starte Timer
    }
    */

}
