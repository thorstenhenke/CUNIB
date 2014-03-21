package fragePanels;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import main.Fenster;

public class F_12_wennL1Geleitet extends AbstractBtnPanel {

	public F_12_wennL1Geleitet(int frageID, int vorgaenger,Fenster fenster) {
		super(frageID, vorgaenger, fenster);
	}

	public void bauePanel() {
		setLayout(null);
		
		
		JButton teil = new JButton("K Teil der Gruppe");
		teil.setBounds(225, 20, 250, 50);
		teil.setActionCommand("teil");
		teil.addActionListener(this);
		add(teil);
		
		/** 
		 * first column
		 */
		
		JButton btnGruppenarbeit = new JButton("K spricht zu aK");
		btnGruppenarbeit.setActionCommand("kak");
		btnGruppenarbeit.addActionListener(this);
		btnGruppenarbeit.setBounds(100, 130, 250, 50);
		add(btnGruppenarbeit);
		
		JButton btnKSprichtMit = new JButton("K spricht zu L1");
		btnKSprichtMit.setActionCommand("kl1");
		btnKSprichtMit.addActionListener(this);
		btnKSprichtMit.setBounds(100, 240, 250, 50);
		add(btnKSprichtMit);
		
		/**
		 * second column
		 */
		
		JButton btnLSprichtMit = new JButton("aK spricht zu K");
		btnLSprichtMit.setBounds(400, 130, 250, 50);
		btnLSprichtMit.setActionCommand("akk");
		btnLSprichtMit.addActionListener(this);
		add(btnLSprichtMit);
		
		JButton btnLSprichtMit_1 = new JButton("L1 spricht zu K");
		btnLSprichtMit_1.setBounds(400, 240, 250, 50);
		btnLSprichtMit_1.setActionCommand("l1k");
		btnLSprichtMit_1.addActionListener(this);
		add(btnLSprichtMit_1);
		
		/**
		 * bottom
		 */
		
		JButton btnKArbeitetNonverbal = new JButton("K arbeitet nonverbal mit aK");
		btnKArbeitetNonverbal.setBounds(100, 350, 250, 50);
		btnKArbeitetNonverbal.setActionCommand("knonak");
		btnKArbeitetNonverbal.addActionListener(this);
		add(btnKArbeitetNonverbal);
		
		JButton btnKAllein = new JButton("K allein");
		btnKAllein.setBounds(400, 350, 250, 50);
		btnKAllein.setActionCommand("allein");
		btnKAllein.addActionListener(this);
		add(btnKAllein);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("teil")){
			setAntwort(0);
			this.setVisible(false);
			fenster.letzteFrageWeiterschalten();
		}
		if(e.getActionCommand().equals("kl1")){
			setAntwort(1);
			this.setVisible(false);
			fenster.naechsteFrage(13);			
		}
		if(e.getActionCommand().equals("kak")){
			setAntwort(2);
			this.setVisible(false);
			fenster.naechsteFrage(13);			
		}
		if(e.getActionCommand().equals("l1k")){
			setAntwort(3);
			this.setVisible(false);
			fenster.naechsteFrage(13);			
		}
		if(e.getActionCommand().equals("akk")){
			setAntwort(4);
			this.setVisible(false);
			fenster.naechsteFrage(13);			
		}
		if(e.getActionCommand().equals("knonak")){
			setAntwort(5);
			this.setVisible(false);
			fenster.letzteFrageWeiterschalten();			
		}
		if(e.getActionCommand().equals("allein")){
			setAntwort(6);
			this.setVisible(false);
			fenster.letzteFrageWeiterschalten();			
		}
	}
}
