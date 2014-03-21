package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Speichern;

@SuppressWarnings("serial")
public class EndeUndSpeichern extends Abstract_AllgemeinesPanel {

	private Fenster fenster;
	private JButton beenden;
	
	public EndeUndSpeichern(Fenster fenster){
		
		this.setLayout(null);
		
		this.fenster 	= fenster;
		
		JLabel frage = new JLabel("Ende des Fragebogens.");
		frage.setFont(new Font("Tahoma", Font.BOLD, 17));
		frage.setForeground(Color.RED);
		frage.setBounds(10, 100, 680, 80); 
		frage.setHorizontalAlignment(JLabel.CENTER);
		this.add(frage);

		beenden = new JButton("Beenden");
		beenden.setBounds(250, 300, 200, 80);
		beenden.setActionCommand("beenden");
		beenden.addActionListener(this);
		this.add(beenden);
	}
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("beenden")){
			Speichern.Speichern(fenster.fensterElemente.sitzung);
			System.exit(0);
		}
	}				
}
