package fragePanels;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import main.Fenster;

public class F_09_wennKindGeleitet extends AbstractBtnPanel {

	public F_09_wennKindGeleitet(int frageID, int vorgaenger,Fenster fenster) {
		super(frageID, vorgaenger, fenster);
	}

	/**
	 * Create the panel.
	 */
	public void bauePanel() {
		setLayout(null);
		

		JButton allein = new JButton("K allein");
		allein.setBounds(250, 20, 200, 50);
		allein.setActionCommand("allein");
		allein.addActionListener(this);
		add(allein);

		JButton knonak = new JButton("K arbeitet nonverbal mit aK");
		knonak.setActionCommand("knonak");
		knonak.addActionListener(this);
		knonak.setBounds(250, 140, 200, 50);
		add(knonak);
		
		JButton kak = new JButton("K spricht zu aK");
		kak.setBounds(250, 260, 200, 50);
		kak.setActionCommand("kak");
		kak.addActionListener(this);
		add(kak);

		JButton akk = new JButton("aK spricht zu K");
		akk.setBounds(250, 380, 200, 50);
		akk.setActionCommand("akk");
		akk.addActionListener(this);
		add(akk);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("kak")){
			setAntwort(0);
			this.setVisible(false);
			fenster.naechsteFrage(10);
		}
		if(e.getActionCommand().equals("akk")){
			setAntwort(1);
			this.setVisible(false);
			fenster.naechsteFrage(10);
		}		
		if(e.getActionCommand().equals("knonak")){
			setAntwort(2);
			this.setVisible(false);
			fenster.letzteFrageWeiterschalten();			
		}
		if(e.getActionCommand().equals("allein")){
			setAntwort(3);
			this.setVisible(false);
			fenster.letzteFrageWeiterschalten();			
		}

		
	}

}
