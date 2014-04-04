package panels;

import javax.swing.JButton;

import main.Fenster;
import main.ObservationManager;

public class KindGeleitet extends AbstractCustomPanel {

	public KindGeleitet(ObservationManager m) {

		setLayout(null);

		JButton allein = new JButton("K allein");
		allein.setBounds(250, 20, 200, 50);
		allein.setActionCommand("all");
		allein.addActionListener(m);
		add(allein);

		JButton knonak = new JButton("K arbeitet nonverbal mit aK");
		knonak.setActionCommand("non");
		knonak.addActionListener(m);
		knonak.setBounds(250, 140, 200, 50);
		add(knonak);
		
		JButton kak = new JButton("K spricht zu aK");
		kak.setBounds(250, 260, 200, 50);
		kak.setActionCommand("kak");
		kak.addActionListener(m);
		add(kak);

		JButton akk = new JButton("aK spricht zu K");
		akk.setBounds(250, 380, 200, 50);
		akk.setActionCommand("akk");
		akk.addActionListener(m);
		add(akk);

	}

}
