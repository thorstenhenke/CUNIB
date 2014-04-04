package panels;

import main.Fenster;
import main.ObservationManager;

import java.awt.Font;

import javax.swing.JLabel;

public class WartePanel extends AbstractCustomPanel {

	private JLabel zeit;

    public WartePanel(ObservationManager observationManager) {
		setLayout(null);
		
		JLabel anweisungsText = new JLabel("Bitte warten...");
		anweisungsText.setBounds(250, 100, 300, 80);
		anweisungsText.setFont(new Font("Tahoma", Font.BOLD, 17));
		anweisungsText.setVisible(true);
		this.add(anweisungsText);
	
		zeit = new JLabel();
		zeit.setBounds(325, 200, 150, 80);
		zeit.setFont(new Font("Tahoma", Font.BOLD, 23));
		zeit.setVisible(true);
		this.add(zeit);
	}
	
	public void updateTime(int sekunden){
		zeit.setText("" + sekunden);
	}
}

