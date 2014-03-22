package fragePanels;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import main.Fenster;

public class Gruppenarbeit extends AbstractBtnPanel {
	
	public Gruppenarbeit(int frageID, int vorgaenger, Fenster fenster) {
		super(frageID, vorgaenger, fenster);
	}

	public void bauePanel() {
		setLayout(null);
		
		JButton btnLSprichtMit = new JButton("Kind geleitet");
		btnLSprichtMit.setActionCommand("Kind geleitet");
		btnLSprichtMit.addActionListener(this);
		btnLSprichtMit.setBounds(250, 80, 200, 50);
		add(btnLSprichtMit);
		
		JButton btnLSprichtMit_1 = new JButton("L1 geleitet");
		btnLSprichtMit_1.setBounds(250, 180, 200, 50);
		btnLSprichtMit_1.setActionCommand("L1 geleitet");
		btnLSprichtMit_1.addActionListener(this);
		add(btnLSprichtMit_1);
		
		JButton btnLGeleitet = new JButton("L2 geleitet");
		btnLGeleitet.setBounds(250, 280, 200, 50);
		btnLGeleitet.setActionCommand("L2 geleitet");
		btnLGeleitet.addActionListener(this);
		add(btnLGeleitet);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Kind geleitet")){
			setAntwort(0);
			this.setVisible(false);
			fenster.naechsteFrage(20);
			}
		if(e.getActionCommand().equals("L1 geleitet")){
			setAntwort(1);
			this.setVisible(false);
			fenster.naechsteFrage(23);
			}
		if(e.getActionCommand().equals("L2 geleitet")){
			setAntwort(2);
			this.setVisible(false);
			fenster.naechsteFrage(26);
			}
	}
}
