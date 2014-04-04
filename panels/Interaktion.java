package panels;

import javax.swing.JButton;

import main.Fenster;
import main.ObservationManager;

public class Interaktion extends AbstractCustomPanel {



	public Interaktion(ObservationManager m) {

		setLayout(null);

        JButton btnGesamteKlasse = new JButton("Interaktion lang");
		btnGesamteKlasse.setBounds(250, 130, 200, 50);
		btnGesamteKlasse.setActionCommand("lan");
		btnGesamteKlasse.addActionListener(m);
		add(btnGesamteKlasse);

        JButton btnGruppenarbeit = new JButton("Interaktion kurz");
		btnGruppenarbeit.setBounds(250, 260, 200, 50);
		btnGruppenarbeit.setActionCommand("kur");
		btnGruppenarbeit.addActionListener(m);
		add(btnGruppenarbeit);

	}
}
