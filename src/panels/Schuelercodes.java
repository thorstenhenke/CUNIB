package panels;

import main.InputValidator;
import main.SessionManager;
import model.SchuelerModel;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.LinkedList;

public class Schuelercodes extends AbstractCustomPanel
{

    private JTextField scodeA;
    private JTextField scodeB;
    private JTextField scodeC;
    private JTextField scodeD;
    private JTextField scodeE;
    private JTextField scodeF;
    private JTextField scodeG;
    private JTextField scodeH;
    private JTextArea besA;
    private JTextArea besB;
    private JTextArea besC;
    private JTextArea besD;
    private JTextArea besE;
    private JTextArea besF;
    private JTextArea besG;
    private JTextArea besH;

    private JButton btnStart;


    public Schuelercodes(SessionManager sessionManager)
    {
        this.setLayout(null);

        /**
         * BEGINN erste Spalte
         */

        // SCHULER A
        JLabel lblCodeSchuelerA = new JLabel("A Code ");
        lblCodeSchuelerA.setBounds(35, 10, 86, 14);
        this.add(lblCodeSchuelerA);

        scodeA = new JTextField();
        scodeA.setBounds(35, 50, 86, 20);
        this.add(scodeA);

        besA = new JTextArea();
        besA.setBounds(140, 10, 190, 60);
        besA.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.add(besA);

        // SCHULER B
        JLabel lblCodeSchuelerB = new JLabel("B Code");
        lblCodeSchuelerB.setBounds(35, 105, 86, 14);
        this.add(lblCodeSchuelerB);

        scodeB = new JTextField();
        scodeB.setColumns(6);
        scodeB.setBounds(35, 145, 86, 20);
        this.add(scodeB);

        besB = new JTextArea();
        besB.setBounds(140, 105, 190, 60);
        besB.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.add(besB);

        // SCHULER C
        JLabel lblCodeSchuelerC = new JLabel("C Code");
        lblCodeSchuelerC.setBounds(35, 195, 86, 14);
        this.add(lblCodeSchuelerC);

        scodeC = new JTextField();
        scodeC.setColumns(6);
        scodeC.setBounds(35, 235, 86, 20);
        this.add(scodeC);

        besC = new JTextArea();
        besC.setBounds(140, 195, 190, 60);
        besC.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.add(besC);

        // SCHULER D
        JLabel lblCodeSchuelerD = new JLabel("D Code");
        lblCodeSchuelerD.setBounds(35, 290, 86, 14);
        this.add(lblCodeSchuelerD);

        scodeD = new JTextField();
        scodeD.setColumns(6);
        scodeD.setBounds(35, 330, 86, 20);
        this.add(scodeD);

        besD = new JTextArea();
        besD.setBounds(140, 290, 190, 60);
        besD.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.add(besD);


        /**
         * BEGINN zweite Spalte
         */

        // SCHUELER E
        JLabel lblCodeSchuelerE = new JLabel("E Code");
        lblCodeSchuelerE.setBounds(365, 10, 130, 14);
        this.add(lblCodeSchuelerE);

        scodeE = new JTextField();
        scodeE.setBounds(365, 50, 86, 20);
        this.add(scodeE);

        besE = new JTextArea();
        besE.setBounds(470, 10, 210, 60);
        besE.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.add(besE);

        // SCHUELER F
        JLabel lblCodeSchuelerF = new JLabel("F Code");
        lblCodeSchuelerF.setBounds(365, 105, 245, 14);
        this.add(lblCodeSchuelerF);

        scodeF = new JTextField();
        scodeF.setColumns(6);
        scodeF.setBounds(365, 145, 86, 20);
        this.add(scodeF);

        besF = new JTextArea();
        besF.setBounds(470, 105, 210, 60);
        besF.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.add(besF);

        // SCHUELER G
        JLabel lblCodeSchuelerG = new JLabel("G Code");
        lblCodeSchuelerG.setBounds(365, 195, 200, 14);
        this.add(lblCodeSchuelerG);

        scodeG = new JTextField();
        scodeG.setColumns(6);
        scodeG.setBounds(365, 235, 86, 20);
        this.add(scodeG);

        besG = new JTextArea();
        besG.setBounds(470, 195, 210, 60);
        besG.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.add(besG);

        // SCHUELER H
        JLabel lblCodeSchuelerH = new JLabel("H Code");
        lblCodeSchuelerH.setBounds(365, 290, 245, 14);
        this.add(lblCodeSchuelerH);

        scodeH = new JTextField();
        scodeH.setColumns(6);
        scodeH.setBounds(365, 330, 86, 20);
        this.add(scodeH);

        besH = new JTextArea();
        besH.setBounds(470, 290, 210, 60);
        besH.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.add(besH);

        /**
         * BOTTOM
         */
        btnStart = new JButton("Weiter");
        btnStart.setBounds(250, 400, 200, 50);
        btnStart.setActionCommand("Schuelercodes::Weiter");
        btnStart.addActionListener(sessionManager);
        this.add(btnStart);
    }

    public Boolean inputIsValid()
    {
        String[] strCodes = new String[]{
                scodeA.getText(), scodeB.getText(), scodeC.getText(), scodeD.getText(),
                scodeE.getText(), scodeF.getText(), scodeG.getText(), scodeH.getText()
                };
        return InputValidator.hasSCodes(strCodes) && InputValidator.hasValidSCodes(strCodes);
    }

    public LinkedList getSchueler()
    {
        LinkedList<SchuelerModel> schuelerModell = new LinkedList<SchuelerModel>();
        if (!scodeA.getText().equals(""))
            schuelerModell.add(new SchuelerModel(scodeA.getText(), "A", besA.getText()));
        if (!scodeB.getText().equals(""))
            schuelerModell.add(new SchuelerModel(scodeB.getText(), "B", besB.getText()));
        if (!scodeC.getText().equals(""))
            schuelerModell.add(new SchuelerModel(scodeC.getText(), "C", besC.getText()));
        if (!scodeD.getText().equals(""))
            schuelerModell.add(new SchuelerModel(scodeD.getText(), "D", besD.getText()));
        if (!scodeE.getText().equals(""))
            schuelerModell.add(new SchuelerModel(scodeE.getText(), "E", besE.getText()));
        if (!scodeF.getText().equals(""))
            schuelerModell.add(new SchuelerModel(scodeF.getText(), "F", besF.getText()));
        if (!scodeG.getText().equals(""))
            schuelerModell.add(new SchuelerModel(scodeG.getText(), "G", besG.getText()));
        if (!scodeH.getText().equals(""))
            schuelerModell.add(new SchuelerModel(scodeH.getText(), "H", besH.getText()));

        return schuelerModell;
    }

    public void alert()
    {
        btnStart.setBorder(BorderFactory.createLineBorder(Color.red, 4));
    }
}
