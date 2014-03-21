package fragePanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.Fenster;

public class F_18_GruppeAnzahl extends AbstractBtnPanel {
	
	public F_18_GruppeAnzahl(int frageID, int vorgaenger,Fenster fenster) {
		super(frageID, vorgaenger, fenster);
	}
	private JTextField textField;

	public void bauePanel() {
		setLayout(null);
		
		JLabel lblAnzahlDerKinder = new JLabel("Anzahl der Kinder");
		lblAnzahlDerKinder.setBounds(10, 100, 690, 30);
		lblAnzahlDerKinder.setFont(new Font("Arial",Font.BOLD,23));
		lblAnzahlDerKinder.setHorizontalAlignment(JLabel.CENTER);
		add(lblAnzahlDerKinder);
		
		textField = new JTextField();
		textField.setBounds(250, 200, 200, 50);
		add(textField);
		
		JButton btnLSprichtMit = new JButton("Weiter");
		btnLSprichtMit.setActionCommand("weiter");
		btnLSprichtMit.addActionListener(this);
		btnLSprichtMit.setBounds(250, 350, 200, 50);
		add(btnLSprichtMit);
	}

	private boolean noValidInput(){
		if (textField.getText().equals("")){
			return true; 
		}
		return false;
	}

	@Override
	public void setVisible(boolean visible){
		super.setVisible(visible);
		if (visible){
			textField.setText("");
			textField.requestFocusInWindow();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("weiter")){
			if (noValidInput()){
				textField.setBorder(BorderFactory.createLineBorder(Color.red, 4));
			} else {
				setAntwort(Integer.parseInt(textField.getText()));
				this.setVisible(false);
				fenster.naechsteFrage(19);				
			}
		}
	}
}
