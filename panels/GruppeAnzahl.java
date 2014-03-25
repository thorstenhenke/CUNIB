package panels;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.Fenster;

public class GruppeAnzahl extends AbstractFragePanel {
	
	public GruppeAnzahl(Fenster fenster) {
		super(fenster);
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
		btnLSprichtMit.setActionCommand("*");
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
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("*")) {
            fenster.naechsteFrage(textField.getText());
        }
    }

	@Override
	public void setVisible(boolean visible){
		super.setVisible(visible);
		if (visible){
			textField.setText("");
			textField.requestFocusInWindow();
		}
	}
}
