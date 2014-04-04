package panels;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.Fenster;
import main.ObservationManager;

public class Lernkontext extends AbstractCustomPanel {

	public Lernkontext(ObservationManager m) {

		setLayout(null);
		
		JLabel lblLernkontext = new JLabel("Lernkontext...");
		lblLernkontext.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLernkontext.setBounds(250, 11, 200, 30);
		lblLernkontext.setHorizontalAlignment(JLabel.CENTER);
		add(lblLernkontext);
		
		JButton btnIndividuell = new JButton("individuell");
		btnIndividuell.setBounds(250, 80, 200, 60);
		btnIndividuell.setActionCommand("ind");
		btnIndividuell.addActionListener(m);
		add(btnIndividuell);

		JButton btnGesamteKlasse = new JButton("gesamte Klasse");
		btnGesamteKlasse.setBounds(250, 170, 200, 60);
		btnGesamteKlasse.setActionCommand("ges");
		btnGesamteKlasse.addActionListener(m);
		add(btnGesamteKlasse);
		
		JButton btnPartner = new JButton("Partnerarbeit");
		btnPartner.setBounds(250, 260, 200, 60);
		btnPartner.setActionCommand("par");
		btnPartner.addActionListener(m);
		add(btnPartner);
		
		JButton btnGruppenarbeit = new JButton("Gruppenarbeit");
		btnGruppenarbeit.setBounds(250, 350, 200, 60);
		btnGruppenarbeit.setActionCommand("gru");
		btnGruppenarbeit.addActionListener(m);
		add(btnGruppenarbeit);

	}
}
