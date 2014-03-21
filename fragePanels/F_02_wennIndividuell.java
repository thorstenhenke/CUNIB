package fragePanels;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.Fenster;

public class F_02_wennIndividuell extends AbstractBtnPanel {

	public F_02_wennIndividuell(int frageID, int vorgaenger,Fenster fenster) {
		super(frageID, vorgaenger, fenster);
	}

	public void bauePanel() {
		setLayout(null);
		
		JButton btnGesamteKlasse = new JButton("K allein");
		btnGesamteKlasse.setBounds(250, 40, 200, 40);
		btnGesamteKlasse.setActionCommand("allein");
		btnGesamteKlasse.addActionListener(this);
		add(btnGesamteKlasse);

		JButton btnGruppenarbeit = new JButton("K spricht zu L1");
		btnGruppenarbeit.setActionCommand("kzul1");
		btnGruppenarbeit.addActionListener(this);
		btnGruppenarbeit.setBounds(100, 130, 200, 40);
		add(btnGruppenarbeit);

		JButton btnKSprichtMit = new JButton("K spricht zu L2");
		btnKSprichtMit.setActionCommand("kzul2");
		btnKSprichtMit.addActionListener(this);
		btnKSprichtMit.setBounds(100, 220, 200, 40);
		add(btnKSprichtMit);

		JButton kak = new JButton("K spricht zu aK");
		kak.setBounds(100, 310, 200, 40);
		kak.setActionCommand("kak");
		kak.addActionListener(this);
		add(kak);

		/**
		 * zweite Spalte
		 */

		JButton btnLSprichtMit_1 = new JButton("L1 spricht zu K");
		btnLSprichtMit_1.setBounds(400, 130, 200, 40);
		btnLSprichtMit_1.setActionCommand("l1zuk");
		btnLSprichtMit_1.addActionListener(this);
		add(btnLSprichtMit_1);

		JButton btnLSprichtMit = new JButton("L2 spricht zu K");
		btnLSprichtMit.setBounds(400, 220, 200, 40);
		btnLSprichtMit.setActionCommand("l2zuk");
		btnLSprichtMit.addActionListener(this);
		add(btnLSprichtMit);

		JButton akk = new JButton("ak spricht zu K");
		akk.setBounds(400, 310, 200, 40);
		akk.setActionCommand("akk");
		akk.addActionListener(this);
		add(akk);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("allein")){
			setAntwort(0);
			this.setVisible(false);
			fenster.letzteFrageWeiterschalten();	
		}
		if(e.getActionCommand().equals("kzul1")){
			setAntwort(1);
			this.setVisible(false);
			fenster.naechsteFrage(3);
		}
		if(e.getActionCommand().equals("kzul2")){
			setAntwort(2);
			this.setVisible(false);
			fenster.naechsteFrage(3);			
		}
		if(e.getActionCommand().equals("kak")){
			setAntwort(3);
			this.setVisible(false);
			fenster.naechsteFrage(3);	
		}
		if(e.getActionCommand().equals("l1zuk")){
			setAntwort(4);
			this.setVisible(false);
			fenster.naechsteFrage(3);			
		}
		if(e.getActionCommand().equals("l2zuk")){
			setAntwort(5);
			this.setVisible(false);
			fenster.naechsteFrage(3);			
		}
		if(e.getActionCommand().equals("akk")){
			setAntwort(6);
			this.setVisible(false);
			fenster.naechsteFrage(3);			
		}	
	}
}
