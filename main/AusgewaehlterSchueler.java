package main;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import model.Interface_SchuelerMetadaten;

public class AusgewaehlterSchueler extends Abstract_AllgemeinesPanel implements Interface_SchuelerMetadaten {

	private JLabel schuelerBesonderheiten;
	private Fenster fenster;
	private JLabel schuelerCode;

	public AusgewaehlterSchueler(Fenster fenster) {
		this.fenster = fenster;
		
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
	    startBtn.setActionCommand("Start");
	    startBtn.addActionListener(this);
		this.add(startBtn);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().endsWith("Start")){
			fenster.weiterschalten();		
		}
	}

	@Override
	public void metadataChanged() {
		schuelerBesonderheiten.setText(fenster.fensterElemente.sitzung.getAktuellenSchueler().besondereMerkmale);
		schuelerCode.setText("Code: " + fenster.fensterElemente.sitzung.getAktuellenSchueler().schuelercode);
	}
}
