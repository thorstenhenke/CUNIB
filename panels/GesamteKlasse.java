package panels;

import javax.swing.JButton;

import main.Fenster;

public class GesamteKlasse extends AbstractFragePanel {

	public GesamteKlasse(Fenster fenster) {
		super(fenster);
	}

	public void bauePanel() {
		setLayout(null);

		
		JButton btnGruppenarbeit = new JButton("K spricht vor Plenum");
		btnGruppenarbeit.setActionCommand("kvor");
		btnGruppenarbeit.addActionListener(this);
		btnGruppenarbeit.setBounds(100, 30, 200, 50);
		add(btnGruppenarbeit);
		
		JButton btnKSprichtMit = new JButton("K spricht zu L1");
		btnKSprichtMit.setActionCommand("kl1");
		btnKSprichtMit.addActionListener(this);
		btnKSprichtMit.setBounds(100, 140, 200, 50);
		add(btnKSprichtMit);
		
		JButton btnLSprichtMit = new JButton("K spricht zu L2");
		btnLSprichtMit.setBounds(100, 250, 200, 50);
		btnLSprichtMit.setActionCommand("kl2");
		btnLSprichtMit.addActionListener(this);
		add(btnLSprichtMit);
		
		JButton kak = new JButton("K spricht zu aK");
		kak.setBounds(100, 360, 200, 50);
		kak.setActionCommand("kak");
		kak.addActionListener(this);
		add(kak);
		
		/**
		 * zweite Spalte
		 */
		
		
		JButton btnGesamteKlasse = new JButton("K Teil des Plenums");
		btnGesamteKlasse.setBounds(400, 30, 200, 50);
		btnGesamteKlasse.setActionCommand("kteil");
		btnGesamteKlasse.addActionListener(this);
		add(btnGesamteKlasse);
		
		JButton btnLSprichtMit_1 = new JButton("L1 spricht zu K");
		btnLSprichtMit_1.setBounds(400, 140, 200, 50);
		btnLSprichtMit_1.setActionCommand("l1k");
		btnLSprichtMit_1.addActionListener(this);
		add(btnLSprichtMit_1);
		
		JButton button = new JButton("L2 spricht zu K");
		button.setBounds(400, 250, 200, 50);
		button.setActionCommand("l2k");
		button.addActionListener(this);
		add(button);
		
		JButton akk = new JButton("ak spricht zu K");
		akk.setBounds(400, 360, 200, 50);
		akk.setActionCommand("akk");
		akk.addActionListener(this);
		add(akk);

	}
}
