package fragePanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.Fenster;

public class Inhalt extends AbstractBtnPanel {

	public Inhalt(int frageID, int vorgaenger, Fenster fenster) {
		super(frageID, vorgaenger, fenster);
	}

	/**
	 * Create the panel.
	 */
	public void bauePanel() {
		setLayout(null);
		
		JLabel warnhinweis = new JLabel("Erste Frage ! ");
		warnhinweis.setFont(new Font("Tahoma", Font.BOLD, 20));
		warnhinweis.setBounds(250, 11, 200, 30);
		warnhinweis.setForeground(Color.green);
		warnhinweis.setHorizontalAlignment(JLabel.CENTER);
		add(warnhinweis);
		
		JLabel lblLernkontext = new JLabel("Inhalt...");
		lblLernkontext.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLernkontext.setBounds(250, 70, 200, 30);
		lblLernkontext.setHorizontalAlignment(JLabel.CENTER);
		add(lblLernkontext);
		
		JButton btnGesamteKlasse = new JButton("aufgabenbezogen");
		btnGesamteKlasse.setBounds(250, 170, 200, 59);
		btnGesamteKlasse.setActionCommand("aufgabenbezogen");
		btnGesamteKlasse.addActionListener(this);
		add(btnGesamteKlasse);
		
		JButton btnGruppenarbeit = new JButton("nicht aufgabenbezogen");
		btnGruppenarbeit.setBounds(250, 290, 200, 59);
		btnGruppenarbeit.setActionCommand("nicht aufgabenbezogen");
		btnGruppenarbeit.addActionListener(this);
		add(btnGruppenarbeit);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("aufgabenbezogen")){
			setAntwort(0);
			this.setVisible(false);
			fenster.naechsteFrage(1);
		}
		if(e.getActionCommand().equals("nicht aufgabenbezogen")){
			setAntwort(1);
			this.setVisible(false);
			fenster.naechsteFrage(1);
		}
	}

}
