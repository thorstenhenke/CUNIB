package panels;

import javax.swing.JButton;

import main.Fenster;

public class LehrerGeleitet extends AbstractFragePanel {

	public LehrerGeleitet(Fenster fenster) {
		super(fenster);
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
}
