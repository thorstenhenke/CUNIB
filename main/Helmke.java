package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Helmke extends Abstract_AllgemeinesPanel {

	private JLabel schuelerBesonderheite;
	private Fenster fenster;

	public Helmke(Fenster fenster) {
		this.fenster = fenster;
		
		setLayout(null);
		schuelerBesonderheite = new JLabel(
				"<html><body><center>" +
				"Der erste Durchgang der Schülerbeobachtung ist <br>" +
				"abgeschlossen. Rufe nun das Programm zur <br>" +
				"allgemeinen Unterrichtsqualität auf." +
				"</center></body></html>"
						);
		schuelerBesonderheite.setFont(new Font("Tahoma", Font.BOLD, 17));
		schuelerBesonderheite.setBounds(130, 30, 500, 100);
		this.add(schuelerBesonderheite);
		
		JButton startBtn = new JButton("Weiter");
		startBtn.setBounds(250, 230, 200, 50);
	    startBtn.setActionCommand("weiter");
	    startBtn.addActionListener(this);
		this.add(startBtn);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().endsWith("weiter")){
			fenster.weiterschalten();		
		}
	}

}
