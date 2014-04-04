package panels;

import javax.swing.JButton;

import main.Fenster;
import main.ObservationManager;

public class Qualitaet extends AbstractCustomPanel {
	
	public Qualitaet(ObservationManager m) {

		setLayout(null);

        JButton btnKSprichtMit = new JButton("nicht einsch\u00E4tzbar");
		btnKSprichtMit.setActionCommand("nic");
		btnKSprichtMit.addActionListener(m);
		btnKSprichtMit.setBounds(250, 80, 200, 50);
		add(btnKSprichtMit);
		
		JButton btnLSprichtMit = new JButton("Qualit\u00E4t hoch");
		btnLSprichtMit.setBounds(250, 210, 200, 50);
		btnLSprichtMit.setActionCommand("hoc");
		btnLSprichtMit.addActionListener(m);
		add(btnLSprichtMit);
		
		JButton btnLSprichtMit_1 = new JButton("Qualit\u00E4t normal");
		btnLSprichtMit_1.setBounds(250, 340, 200, 50);
		btnLSprichtMit_1.setActionCommand("nor");
		btnLSprichtMit_1.addActionListener(m);
		add(btnLSprichtMit_1);
	}
}
