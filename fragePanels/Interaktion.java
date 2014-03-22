package fragePanels;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import main.Fenster;
import fragePanels.AbstractBtnPanel;

public class Interaktion extends AbstractBtnPanel {

	private JButton btnGesamteKlasse;
	private JButton btnGruppenarbeit;

	
	public Interaktion(int frageID, int vorgaenger,Fenster fenster) {
		super(frageID, vorgaenger, fenster);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals( "Interaktion lang")){
			setAntwort(0);
			this.setVisible(false);
			fenster.naechsteFrage(frageID + 1 );	
		}
		if(e.getActionCommand().equals("Interaktion kurz")){
			setAntwort(1);
			this.setVisible(false);
			fenster.naechsteFrage( frageID + 1 );	
		}		
	}
}
