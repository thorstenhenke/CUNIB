package panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.Fenster;
import main.ObservationManager;

public class Inhalt extends AbstractCustomPanel {

	public Inhalt(ObservationManager m) {

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
		btnGesamteKlasse.setActionCommand("auf");
		btnGesamteKlasse.addActionListener(m);
		add(btnGesamteKlasse);
		
		JButton btnGruppenarbeit = new JButton("nicht aufgabenbezogen");
		btnGruppenarbeit.setBounds(250, 290, 200, 59);
		btnGruppenarbeit.setActionCommand("nau");
		btnGruppenarbeit.addActionListener(m);
		add(btnGruppenarbeit);
	}
}
