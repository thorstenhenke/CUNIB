package main;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class WartePanel extends Abstract_AllgemeinesPanel {

	private Fenster fenster;
	private JLabel anweisungsText; 
	private JLabel zeit; 
		
	public WartePanel(Fenster fenster) {
		this.fenster = fenster;
		
		setLayout(null);
		
		anweisungsText = new JLabel("Bitte warten..."); 
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

	@Override
	public void actionPerformed(ActionEvent arg0) {	}
	

	

}

