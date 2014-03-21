package main;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class BeobPanel extends Abstract_AllgemeinesPanel {

	private Fenster fenster;
	private JLabel modus; 
	private JLabel zeit; 
	
	public BeobPanel(Fenster fenster) {
		this.fenster = fenster;
		
		setLayout(null);
		
		modus = new JLabel("Verbleibende Beobachtungszeit..."); 
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
		zeit.setText("" + (sekunden - 10));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
