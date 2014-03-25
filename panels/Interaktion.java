package panels;

import javax.swing.JButton;

import main.Fenster;

public class Interaktion extends AbstractFragePanel {

	private JButton btnGesamteKlasse;
	private JButton btnGruppenarbeit;


	public Interaktion(Fenster fenster) {
		super(fenster);
	}

	/**
	 * Create the panel.
	 */
	public void bauePanel() {
		setLayout(null);
		
		btnGesamteKlasse = new JButton("Interaktion lang");
		btnGesamteKlasse.setBounds(250, 130, 200, 50);
		btnGesamteKlasse.setActionCommand("Interaktion lang");
		btnGesamteKlasse.addActionListener(this);
		add(btnGesamteKlasse);
		
		btnGruppenarbeit = new JButton("Interaktion kurz");
		btnGruppenarbeit.setBounds(250, 260, 200, 50);
		btnGruppenarbeit.setActionCommand("Interaktion kurz");
		btnGruppenarbeit.addActionListener(this);
		add(btnGruppenarbeit);

	}
}
