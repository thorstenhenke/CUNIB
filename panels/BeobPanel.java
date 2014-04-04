package panels;

import main.Fenster;
import model.Einstellungen;

import java.awt.Font;

import javax.swing.JLabel;

public class BeobPanel extends AbstractCustomPanel {

	private Fenster fenster;
	private JLabel zeit;

	public BeobPanel() {

		setLayout(null);
		
		JLabel modus = new JLabel("Verbleibende Beobachtungszeit...");
		modus.setBounds(200, 100, 300, 80);
		modus.setFont(new Font("Tahoma", Font.BOLD, 17));
		modus.setVisible(true);
		this.add(modus);
		
	    zeit = new JLabel();
		zeit.setBounds(325, 200, 150, 80);
		zeit.setFont(new Font("Tahoma", Font.BOLD, 23));
		zeit.setVisible(true);
		this.add(zeit);
	}

	public void updateTime(int sekunden) {
		zeit.setText("" + (sekunden - Einstellungen.LAENGEBEOBACHTUNG));
	}
}
