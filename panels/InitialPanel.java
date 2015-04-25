package panels;

import main.InputConversion;
import main.InputValidator;
import main.SessionManager;
import model.Einstellungen;
import model.SchuelerModel;
import model.SessionModel;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;

public class InitialPanel extends AbstractCustomPanel
{

    private JTextField klnr;
    private ButtonGroup bstunde;
    private ButtonGroup fach;
    private JComboBox sstunde;
    private JComboBox beobachter;

    private JButton btnStart;


    public InitialPanel(SessionManager sessionManager)
    {
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

        btnStart = new JButton("Weiter");
        btnStart.setBounds(250, 400, 200, 50);
        btnStart.setActionCommand("StartPanel::Weiter");
        btnStart.addActionListener(sessionManager);
        this.add(btnStart);
    }

    public Boolean inputIsValid()
    {
        return InputValidator.hasValidKCode(klnr.getText()) && InputValidator.hasValidRdBtn(fach)
                && InputValidator.hasValidRdBtn(bstunde) && (beobachter.getSelectedIndex() != 0)
                && (sstunde.getSelectedIndex() != 0);
    }



    public HashMap getSessionInfos()
    {
        HashMap <String, String> sessionInfo = new HashMap<String, String>();
        sessionInfo.put("Klassennummer", klnr.getText());
        sessionInfo.put("Beobachter", (String) beobachter.getSelectedItem());
        sessionInfo.put("Beobachtungsstunde", InputConversion.getSelectedItem(bstunde));
        sessionInfo.put("Fach", InputConversion.getSelectedItem(fach));
        sessionInfo.put("Schulstunde", (String) sstunde.getSelectedItem());

        return sessionInfo;
    }

    public void alert()
    {
        btnStart.setBorder(BorderFactory.createLineBorder(Color.red, 4));
    }
}
