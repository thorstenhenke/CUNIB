package fragePanels;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import main.Fenster;
import fragePanels.AbstractBtnPanel;

public class Qualitaet extends AbstractBtnPanel {

	private JButton btnKSprichtMit;
	private JButton btnLSprichtMit;
	private JButton btnLSprichtMit_1;
	
	public Qualitaet(int frageID, int vorgaenger,Fenster fenster) {
		super(frageID, vorgaenger, fenster);
	}

	/**
	 * Create the panel.
	 */
	public void bauePanel() {
		setLayout(null);
		
		btnKSprichtMit = new JButton("nicht einsch\u00E4tzbar");
		btnKSprichtMit.setActionCommand("nicht");
		btnKSprichtMit.addActionListener(this);
		btnKSprichtMit.setBounds(250, 80, 200, 50);
		add(btnKSprichtMit);
		
		btnLSprichtMit = new JButton("Qualit\u00E4t hoch");
		btnLSprichtMit.setBounds(250, 210, 200, 50);
		btnLSprichtMit.setActionCommand("hoch");
		btnLSprichtMit.addActionListener(this);
		add(btnLSprichtMit);
		
		btnLSprichtMit_1 = new JButton("Qualit\u00E4t normal");
		btnLSprichtMit_1.setBounds(250, 340, 200, 50);
		btnLSprichtMit_1.setActionCommand("normal");
		btnLSprichtMit_1.addActionListener(this);
		add(btnLSprichtMit_1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("nicht")){
			setAntwort(0);
			this.setVisible(false);
			fenster.letzteFrageWeiterschalten();
		}
		if(e.getActionCommand().equals("hoch")){
			setAntwort(1);
			this.setVisible(false);
			fenster.letzteFrageWeiterschalten();
		}
		if(e.getActionCommand().equals("normal")){
			setAntwort(2);
			this.setVisible(false);
			fenster.letzteFrageWeiterschalten();
		}
		
	}

}
