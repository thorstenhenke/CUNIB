package panels;

import javax.swing.JButton;

import main.Fenster;

public class Qualitaet extends AbstractFragePanel {
	
	public Qualitaet(Fenster fenster) {
		super(fenster);
	}

	/**
	 * Create the panel.
	 */
	public void bauePanel() {
		setLayout(null);

        JButton btnKSprichtMit = new JButton("nicht einsch\u00E4tzbar");
		btnKSprichtMit.setActionCommand("nicht");
		btnKSprichtMit.addActionListener(this);
		btnKSprichtMit.setBounds(250, 80, 200, 50);
		add(btnKSprichtMit);
		
		JButton btnLSprichtMit = new JButton("Qualit\u00E4t hoch");
		btnLSprichtMit.setBounds(250, 210, 200, 50);
		btnLSprichtMit.setActionCommand("hoch");
		btnLSprichtMit.addActionListener(this);
		add(btnLSprichtMit);
		
		JButton btnLSprichtMit_1 = new JButton("Qualit\u00E4t normal");
		btnLSprichtMit_1.setBounds(250, 340, 200, 50);
		btnLSprichtMit_1.setActionCommand("normal");
		btnLSprichtMit_1.addActionListener(this);
		add(btnLSprichtMit_1);

	}
}
