package panels;

import main.ObservationManager;
import model.SchuelerModel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class AusgewaehlterSchueler extends AbstractCustomPanel {

	private JLabel schuelerBesonderheiten;
	private JLabel schuelerCode;

	public AusgewaehlterSchueler(ObservationManager observationManager) {

		setLayout(null);
		schuelerBesonderheiten = new JLabel("Besonderheiten");
		schuelerBesonderheiten.setFont(new Font("Tahoma", Font.BOLD, 17));
		schuelerBesonderheiten.setBounds(10, 10, 680, 200);
		schuelerBesonderheiten.setHorizontalAlignment(JLabel.CENTER);
		this.add(schuelerBesonderheiten);

		schuelerCode = new JLabel("Code");
		schuelerCode.setFont(new Font("Tahoma", Font.BOLD, 17));
		schuelerCode.setBounds(250, 200, 200, 50);
		schuelerCode.setHorizontalAlignment(JLabel.CENTER);
		this.add(schuelerCode );

		JButton startBtn = new JButton("Start");
		startBtn.setBounds(250, 380, 200, 50);
	    startBtn.setActionCommand("AusgewaehlterSchueler::Weiter");
	    startBtn.addActionListener(observationManager);
		this.add(startBtn);
	}

    public void updateSchuelerDaten(SchuelerModel s) {
        schuelerCode.setText(s.code);
        schuelerBesonderheiten.setText(s.besonderheiten);
    }
}
