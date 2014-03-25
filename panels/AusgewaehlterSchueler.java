package panels;

import main.Fenster;
import main.ObservationManager;
import model.Schueler;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class AusgewaehlterSchueler extends AbstractCustomPanel {

	private JLabel schuelerBesonderheiten;
	private JLabel schuelerCode;
    private ObservationManager observationManager;

	public AusgewaehlterSchueler(ObservationManager observationManager) {
        this.observationManager = observationManager;
    }

    public void updateSchuelerDaten(Schueler s) {
        schuelerCode.setText(s.schuelercode);
        schuelerBesonderheiten.setText(s.besondereMerkmale);
    }

    @Override
    void bauePanel() {
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
	    startBtn.setActionCommand("starteBeobachtung");
	    startBtn.addActionListener(observationManager);
		this.add(startBtn);	
	}
}
