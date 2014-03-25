package panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import main.Fenster;
import main.InputConversion;
import main.InputValidator;
import main.SessionManager;
import model.Beobachtungseinheit;
import model.Einstellungen;
import model.Schueler;

public class StartPanel extends AbstractCustomPanel {

	private Fenster fenster;

	private JTextField klnr;
    private ButtonGroup bstunde;
    private ButtonGroup fach;
	private JComboBox sstunde;
	private JComboBox beobachter;

	private JTextField scodeST;
	private JTextField scodeM;
	private JTextField scodeSW;
	private JTextField scodeI;
    private JTextArea besST;
    private JTextArea besM;
    private JTextArea besSW;
    private JTextArea besI;

	private JButton btnStart;

    private SessionManager sessionManager;

    public StartPanel(SessionManager sessionManager) {
        super();
        this.sessionManager = sessionManager;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	void bauePanel(){
		
		this.setLayout(null);
		
		JLabel lblKlassencode = new JLabel("Klassencode");
		lblKlassencode.setBounds(35, 10, 84, 14);
		this.add(lblKlassencode);
		
		klnr = new JTextField();
		klnr.setBounds(35, 40, 86, 20);
		klnr.setColumns(4);
		this.add(klnr);
		
		JLabel unterrichtsstunde = new JLabel("Unterrichtsstunde");
		unterrichtsstunde.setBounds(35, 100, 250, 14);
		this.add(unterrichtsstunde);
		
		sstunde = new JComboBox();
		sstunde.setModel(new DefaultComboBoxModel(Einstellungen.UNTERRICHTSSTUNDEN));
		sstunde.setBounds(35, 120, 171, 20);
		this.add(sstunde);
		
		JLabel lblFach = new JLabel("Fach");
		lblFach.setBounds(35, 170, 171, 14);
		this.add(lblFach);
		
		JRadioButton fachDeutsch = new JRadioButton("Deutsch");
		fachDeutsch.setBounds(35, 190, 100, 23);
		this.add(fachDeutsch);
		
		JRadioButton fachMathe = new JRadioButton("Mathematik");
		fachMathe.setBounds(135, 190, 100, 23);
		this.add(fachMathe);
		
	    fach = new ButtonGroup();
		fach.add(fachDeutsch);
		fach.add(fachMathe);
		
		JLabel lblBeobachtungsstunde = new JLabel("Beobachtungsstunde");
		lblBeobachtungsstunde.setBounds(35, 240, 171, 14);
		this.add(lblBeobachtungsstunde);
		
		JRadioButton bstunde1 = new JRadioButton("1");
		bstunde1.setBounds(35, 260, 100, 23);
		this.add(bstunde1);
		
		JRadioButton bstunde2 = new JRadioButton("2");
		bstunde2.setBounds(135, 260, 100, 23);
		this.add(bstunde2);
		
		bstunde = new ButtonGroup();
		bstunde.add(bstunde1);
		bstunde.add(bstunde2);
		
		JLabel lblBeobachter = new JLabel("Beobachter");
		lblBeobachter.setBounds(35, 310, 84, 14);
		this.add(lblBeobachter);
		
		beobachter = new JComboBox();
		beobachter.setModel(new DefaultComboBoxModel(Einstellungen.BEOBACHTER));
		beobachter.setBounds(35, 330, 171, 20);
		this.add(beobachter);
		
		/**
		 * ENDE erste Spalte
		 */
		
		JLabel lblCodeFrLeistungsstarkes = new JLabel("Leistungsstarkes Kind");
		lblCodeFrLeistungsstarkes.setBounds(300, 10, 130, 14);
		this.add(lblCodeFrLeistungsstarkes);
		
		JLabel lblstarkCode = new JLabel("Code");
		lblstarkCode.setBounds(300, 30, 245, 14);
		this.add(lblstarkCode);
		
		scodeST = new JTextField();
		scodeST.setBounds(300, 50, 86, 20);
		this.add(scodeST);
		
		besST = new JTextArea();
		besST.setBounds(470, 10, 210, 60);
		besST.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.add(besST);
				
		JLabel lblCodeFrLeistungsmittleres = new JLabel("Leistungsmittleres Kind");
		lblCodeFrLeistungsmittleres.setBounds(300, 105, 245, 14);
		this.add(lblCodeFrLeistungsmittleres);
		
		JLabel lblmittelCode = new JLabel("Code");
		lblmittelCode.setBounds(300, 125, 245, 14);
		this.add(lblmittelCode);
		
		scodeM = new JTextField();
		scodeM.setColumns(6);
		scodeM.setBounds(300, 145, 86, 20);
		this.add(scodeM);
		
		besM = new JTextArea();
		besM.setBounds(470, 105, 210, 60);
		besM.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.add(besM);
		
		JLabel lblCodeFrLeistungsschwaches = new JLabel("Leistungsschwaches Kind");
		lblCodeFrLeistungsschwaches.setBounds(300, 195, 200, 14);
		this.add(lblCodeFrLeistungsschwaches);
		
		JLabel lblschwachCode = new JLabel("Code");
		lblschwachCode.setBounds(300, 215, 245, 14);
		this.add(lblschwachCode);
		
		scodeSW = new JTextField();
		scodeSW.setColumns(6);
		scodeSW.setBounds(300, 235, 86, 20);
		this.add(scodeSW);
		
		besSW = new JTextArea();
		besSW.setBounds(470, 195, 210, 60);
		besSW.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.add(besSW);
		
		JLabel lblCodeFrInklusionskind = new JLabel("Inklusionskind");
		lblCodeFrInklusionskind.setBounds(300, 290, 245, 14);
		this.add(lblCodeFrInklusionskind);
		
		JLabel lblinklCode = new JLabel("Code");
		lblinklCode.setBounds(300, 310, 245, 14);
		this.add(lblinklCode);
		
		scodeI = new JTextField();
		scodeI.setColumns(6);
		scodeI.setBounds(300, 330, 86, 20);
		this.add(scodeI);
		
		besI = new JTextArea();
		besI.setBounds(470, 290, 210, 60);
		besI.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.add(besI);

		btnStart = new JButton("Weiter");
		btnStart.setBounds(250, 400, 200, 50);
	    btnStart.setActionCommand("starteSession");
	    btnStart.addActionListener(sessionManager);
		this.add(btnStart);	
	}

    public Boolean inputIsValid() {
        return InputValidator.hasValidKCode(klnr.getText()) && InputValidator.hasValidRdBtn(fach)
                && InputValidator.hasValidRdBtn(bstunde) && (beobachter.getSelectedIndex() != 0)
                && (sstunde.getSelectedIndex() != 0) && InputValidator.hasValidSCodes(
                new String[]{scodeST.getText(), scodeM.getText(), scodeSW.getText(), scodeI.getText()});
    }

    public Beobachtungseinheit getSessionInfos() {
        LinkedList<Schueler> schueler = new LinkedList<Schueler>();
        if (!scodeST.getText().equals(""))
            schueler.add(new Schueler(scodeST.getText(), "stark", besST.getText()));
        if (!scodeM.getText().equals(""))
            schueler.add(new Schueler(scodeM.getText(), "mittel", besM.getText()));
        if (!scodeSW.getText().equals(""))
            schueler.add(new Schueler(scodeSW.getText(), "schwach", besSW.getText()));
        if (!scodeI.getText().equals(""))
            schueler.add(new Schueler(scodeI.getText(), "inkl", besI.getText()));
        return new Beobachtungseinheit(klnr.getText(), (String) beobachter.getSelectedItem(),
                InputConversion.getSelectedItem(bstunde), InputConversion.getSelectedItem(fach),
                (String) sstunde.getSelectedItem(), schueler);
    }

    public void alert(){
        btnStart.setBorder(BorderFactory.createLineBorder(Color.red, 4));
    }
}
