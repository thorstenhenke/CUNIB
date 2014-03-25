package panels;

import javax.swing.JButton;

import main.Fenster;

public class KindGeleitet extends AbstractFragePanel {

	public KindGeleitet(Fenster fenster) {
		super(fenster);
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

}
