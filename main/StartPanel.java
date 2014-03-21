package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import model.Einstellungen;

@SuppressWarnings("serial")
public class StartPanel extends Abstract_AllgemeinesPanel {

	private Fenster fenster;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JTextField textFieldKlassencode;
	private JRadioButton rdbtnMathematik;
	private JRadioButton rdbtnDeutsch;
	private JRadioButton rdbtnErsteStunde;
	private JRadioButton rdbtnZweiteStunde;
	private JButton btnStart;

	private JComboBox cBunterrichtsstunde;

	private JTextArea test1;

	private JTextArea test2;

	private JTextArea test3;

	private JTextArea test4;

	public StartPanel(Fenster fenster) {
		this.fenster = fenster; 
		this.bauePanel(); 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void bauePanel(){
		
		this.setLayout(null);
		
		JLabel lblKlassencode = new JLabel("Klassencode");
		lblKlassencode.setBounds(35, 10, 84, 14);
		this.add(lblKlassencode);
		
		textFieldKlassencode = new JTextField();
		textFieldKlassencode.setBounds(35, 40, 86, 20);
		textFieldKlassencode.setColumns(4);
		this.add(textFieldKlassencode);
		
		JLabel unterrichtsstunde = new JLabel("Unterrichtsstunde");
		unterrichtsstunde.setBounds(35, 100, 250, 14);
		this.add(unterrichtsstunde);

		String[] unterrichtsstunden = {
				""
				, "1. Stunde"
				, "2. Stunde"
				, "3. Stunde"
				, "4. Stunde"
				, "5. Stunde"
				, "6. Stunde"
				};
		
		cBunterrichtsstunde = new JComboBox();
		cBunterrichtsstunde.setModel(new DefaultComboBoxModel(unterrichtsstunden));
		cBunterrichtsstunde.setBounds(35, 120, 171, 20);
		this.add(cBunterrichtsstunde);
		
		JLabel lblFach = new JLabel("Fach");
		lblFach.setBounds(35, 170, 171, 14);
		this.add(lblFach);
		
		rdbtnDeutsch = new JRadioButton("Deutsch");
		rdbtnDeutsch.setBounds(35, 190, 100, 23);
		this.add(rdbtnDeutsch);
		
		rdbtnMathematik = new JRadioButton("Mathematik");
		rdbtnMathematik.setBounds(135, 190, 100, 23);
		this.add(rdbtnMathematik);
		
		ButtonGroup radioButtonGroupFach = new ButtonGroup();
		radioButtonGroupFach.add(rdbtnDeutsch);
		radioButtonGroupFach.add(rdbtnMathematik);	
		
		JLabel lblBeobachtungsstunde = new JLabel("Beobachtungsstunde");
		lblBeobachtungsstunde.setBounds(35, 240, 171, 14);
		this.add(lblBeobachtungsstunde);
		
		rdbtnErsteStunde = new JRadioButton("1");
		rdbtnErsteStunde.setBounds(35, 260, 100, 23);
		this.add(rdbtnErsteStunde);
		
		rdbtnZweiteStunde = new JRadioButton("2");
		rdbtnZweiteStunde.setBounds(135, 260, 100, 23);
		this.add(rdbtnZweiteStunde);
		
		ButtonGroup radioButtonGroupStunde = new ButtonGroup();
		radioButtonGroupStunde.add(rdbtnErsteStunde);
		radioButtonGroupStunde.add(rdbtnZweiteStunde);
		
		JLabel lblBeobachter = new JLabel("Beobachter");
		lblBeobachter.setBounds(35, 310, 84, 14);
		this.add(lblBeobachter);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Einstellungen.BEOBACHTER));
		comboBox.setBounds(35, 330, 171, 20);
		this.add(comboBox);
		
		/**
		 * ENDE erste Spalte
		 */
		
		JLabel lblCodeFrLeistungsstarkes = new JLabel("Leistungsstarkes Kind");
		lblCodeFrLeistungsstarkes.setBounds(300, 10, 130, 14);
		this.add(lblCodeFrLeistungsstarkes);
		
		JLabel lblstarkCode = new JLabel("Code");
		lblstarkCode.setBounds(300, 30, 245, 14);
		this.add(lblstarkCode);
		
		textField = new JTextField();
		textField.setBounds(300, 50, 86, 20);
		this.add(textField);
		
		test1 = new JTextArea();
		test1.setBounds(470, 10, 210, 60);
		test1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.add(test1);
				
		JLabel lblCodeFrLeistungsmittleres = new JLabel("Leistungsmittleres Kind");
		lblCodeFrLeistungsmittleres.setBounds(300, 105, 245, 14);
		this.add(lblCodeFrLeistungsmittleres);
		
		JLabel lblmittelCode = new JLabel("Code");
		lblmittelCode.setBounds(300, 125, 245, 14);
		this.add(lblmittelCode);
		
		textField_1 = new JTextField();
		textField_1.setColumns(6);
		textField_1.setBounds(300, 145, 86, 20);
		this.add(textField_1);
		
		test2 = new JTextArea();
		test2.setBounds(470, 105, 210, 60);
		test2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.add(test2);
		
		JLabel lblCodeFrLeistungsschwaches = new JLabel("Leistungsschwaches Kind");
		lblCodeFrLeistungsschwaches.setBounds(300, 195, 200, 14);
		this.add(lblCodeFrLeistungsschwaches);
		
		JLabel lblschwachCode = new JLabel("Code");
		lblschwachCode.setBounds(300, 215, 245, 14);
		this.add(lblschwachCode);
		
		textField_2 = new JTextField();
		textField_2.setColumns(6);
		textField_2.setBounds(300, 235, 86, 20);
		this.add(textField_2);
		
		test3 = new JTextArea();
		test3.setBounds(470, 195, 210, 60);
		test3.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.add(test3);
		
		JLabel lblCodeFrInklusionskind = new JLabel("Inklusionskind\r\n");
		lblCodeFrInklusionskind.setBounds(300, 290, 245, 14);
		this.add(lblCodeFrInklusionskind);
		
		JLabel lblinklCode = new JLabel("Code");
		lblinklCode.setBounds(300, 310, 245, 14);
		this.add(lblinklCode);
		
		textField_3 = new JTextField();
		textField_3.setColumns(6);
		textField_3.setBounds(300, 330, 86, 20);
		this.add(textField_3);	
		
		test4 = new JTextArea();
		test4.setBounds(470, 290, 210, 60);
		test4.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.add(test4);

		btnStart = new JButton("Weiter");
		btnStart.setBounds(250, 400, 200, 50);
	    btnStart.setActionCommand("Weiter");
	    btnStart.addActionListener(this);
		this.add(btnStart);	
	}
		
	private int beobachterStundeToInteger(){
		if (rdbtnErsteStunde.isSelected())
			return 0; 
		if (rdbtnZweiteStunde.isSelected()){
			return 1; 
		}
		return Einstellungen.MISSINGVALUE;
	}
	
	private int fachToInteger(){
		if (rdbtnDeutsch.isSelected())
			return 0; 
		if (rdbtnMathematik.isSelected())
			return 1;
		return Einstellungen.MISSINGVALUE;
	}
	
	private boolean isValidRAdioBtn(){
		return 	(rdbtnMathematik.isSelected() || rdbtnDeutsch.isSelected()) 
			&&	(rdbtnErsteStunde.isSelected() || rdbtnZweiteStunde.isSelected());
	}
	
	private boolean isValidStunde(){
		if (cBunterrichtsstunde.getSelectedItem().equals("")){
			return false; 
		}
		return true;
	}
	
	private boolean isValidComboBox(){
		if (comboBox.getSelectedItem().equals("")){
			return false;
		}
		return true;
	}
	
	private boolean isValid_S_Code(String schuelercode){
		return schuelercode.equals("-9") || validateCode(schuelercode, Einstellungen.SCODESTELLEN); 
	}
	
	private boolean isValid_K_Code(String klassencode){
		return validateCode(klassencode, Einstellungen.KCODESTELLEN); 
	}
	
	private boolean validateCode(String strcode, int ndigits){
		char[] digits = strcode.toCharArray();
		if (digits.length == 0 || digits.length != ndigits) 
			return false; 
		for (char c : digits) {
			if ( ! Character.isDigit(c)) 
				return false;
		}
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Weiter")){
			String[] schuelercodes = new String[] {
					textField.getText(),
					textField_1.getText(),
					textField_2.getText(),
					textField_3.getText(),
					
			};
			String[] besonderheiten = new String[] { 
					test1.getText(),
					test2.getText(),
					test3.getText(),
					test4.getText()
			};
			String klassencode 	= textFieldKlassencode.getText();
			int fach 			= fachToInteger();
			int stunde 			= beobachterStundeToInteger();
			int beobachter 		= comboBox.getSelectedIndex(); 
			int schulstunde		= cBunterrichtsstunde.getSelectedIndex();
			if ( isValid_S_Code(textField.getText())
					&& 	isValid_S_Code(textField_1.getText())
					&& 	isValid_S_Code(textField_2.getText())
					&& 	isValid_S_Code(textField_3.getText())
					&& 	isValid_K_Code(klassencode)
					&& 	isValidRAdioBtn()
					&& 	isValidComboBox()
					&& 	isValidStunde()
					){
				fenster.fensterElemente.sitzung.setKlassencode(klassencode); 
				fenster.fensterElemente.sitzung.setSchueler(schuelercodes, besonderheiten);
				fenster.fensterElemente.sitzung.setFach(fach); 
				fenster.fensterElemente.sitzung.setBeobachterstunde(stunde);
				fenster.fensterElemente.sitzung.setBeobachter(beobachter);
				fenster.fensterElemente.sitzung.setSchulstunde(schulstunde);
				fenster.weiterschalten();			
			} else {
				btnStart.setBorder(BorderFactory.createLineBorder(Color.red, 4));
			}

		}
	}
}
