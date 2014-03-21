package fragePanels;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import main.Fenster;

public class F_20_wennKindGeleitet extends AbstractBtnPanel {

	public F_20_wennKindGeleitet(int frageID, int vorgaenger,Fenster fenster) {
		super(frageID, vorgaenger, fenster);
	}

	public void bauePanel() {
		setLayout(null);
		
		JButton allein = new JButton("K allein");
		allein.setBounds(230, 20, 250, 50);
		allein.setActionCommand("allein");
		allein.addActionListener(this);
		add(allein);

		JButton nonverbal = new JButton("K arbeitet nonverbal mit aK");
		nonverbal.setActionCommand("knonak");
		nonverbal.addActionListener(this);
		nonverbal.setBounds(230, 125, 250, 50);
		add(nonverbal);

		JButton kak = new JButton("K spricht zu aK");
		kak.setBounds(230, 230, 250, 50);
		kak.setActionCommand("kak");
		kak.addActionListener(this);
		add(kak);

		JButton akk = new JButton("aK spricht zu K");
		akk.setBounds(230, 335, 250, 50);
		akk.setActionCommand("akk");
		akk.addActionListener(this);
		add(akk);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("kak")){
			setAntwort(0);
			this.setVisible(false);
			fenster.naechsteFrage(21);			
		}
		if(e.getActionCommand().equals("akk")){
			setAntwort(1);
			this.setVisible(false);
			fenster.naechsteFrage(21);			
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
