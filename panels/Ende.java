package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.Fenster;
import main.SessionManager;

@SuppressWarnings("serial")
public class Ende extends AbstractCustomPanel implements ActionListener{

    private SessionManager session;

	public Ende(SessionManager session) {
        super();
        this.session = session;
    }

    @Override
	void bauePanel() {
		this.setLayout(null);

		JLabel frage = new JLabel("Ende des Fragebogens.");
		frage.setFont(new Font("Tahoma", Font.BOLD, 17));
		frage.setForeground(Color.RED);
		frage.setBounds(10, 100, 680, 80); 
		frage.setHorizontalAlignment(JLabel.CENTER);
		this.add(frage);

		JButton beenden = new JButton("Beenden");
		beenden.setBounds(250, 300, 200, 80);
		beenden.setActionCommand("beenden");
		beenden.addActionListener(this);
		this.add(beenden);
	}
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("beenden")){
			System.exit(0);
		}
	}				
}
