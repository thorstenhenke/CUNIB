  package main;

import model.Einstellungen;
import model.SchuelerModel;
import panels.AbstractCustomPanel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Fenster {

    private  JLabel sekundenAnzeige;
    private  JLabel minutenAnzeige;
    private  JLabel schuelerZaehler;
    private  JLabel mikroZyklus;
    private  JLabel makroZyklus;
    private  JLabel seitenNummer;
    private  JLabel schuelerBesonderheiten;
    private  JLabel schuelerCode;

    // Zurueckfunktionalitaet
    JButton zurueck;

    // State
    JPanel actualPanel;

    // Canvas
    JFrame frame;

	public Fenster() {

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                String ObjButtons[] = {"Beenden","Abbrechen"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Soll das Programm wirklich beendet werden?", "Beenden",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        ObjButtons,ObjButtons[1]);
                if(PromptResult==0) {
                    Speichern.signWithMD5();
                    System.exit(0);
                }
            }
        });

        /**
         * Labels right sidebar
         */
        sekundenAnzeige = new JLabel("0");
        sekundenAnzeige.setBounds(706,30,90, 25);
        sekundenAnzeige.setFont(new Font("Arial",Font.BOLD,23));
        sekundenAnzeige.setForeground(Color.RED);
        sekundenAnzeige.setHorizontalAlignment(JLabel.CENTER);

        minutenAnzeige = new JLabel("0:00");
        minutenAnzeige.setBounds(706,90, 90, 25);
        minutenAnzeige.setFont(new Font("Arial",Font.BOLD,23));
        minutenAnzeige.setForeground(Color.BLACK);
        minutenAnzeige.setHorizontalAlignment(JLabel.CENTER);

        schuelerZaehler = new JLabel("S 0/0");
        schuelerZaehler.setBounds(706,170,90,25);
        schuelerZaehler.setFont(new Font("Arial",Font.BOLD,23));
        schuelerZaehler.setForeground(Color.GREEN);
        schuelerZaehler.setHorizontalAlignment(JLabel.CENTER);

        mikroZyklus = new JLabel("D 0/0");
        mikroZyklus.setBounds(706,230,90,25);
        mikroZyklus.setFont(new Font("Arial",Font.BOLD,23));
        mikroZyklus.setForeground(Color.GREEN);
        mikroZyklus.setHorizontalAlignment(JLabel.CENTER);

        makroZyklus = new JLabel("G 0/0");
        makroZyklus.setBounds(706,310,90,25);
        makroZyklus.setFont(new Font("Arial",Font.BOLD,23));
        makroZyklus.setForeground(Color.BLUE);
        makroZyklus.setHorizontalAlignment(JLabel.CENTER);


        seitenNummer = new JLabel("");
        seitenNummer.setBounds(706,510,90,25);
        seitenNummer.setFont(new Font("Arial",Font.BOLD,20));
        seitenNummer.setForeground(Color.BLACK);
        seitenNummer.setHorizontalAlignment(JLabel.CENTER);


        /**
         * Labels && Buttons bottom
         */
        schuelerBesonderheiten = new JLabel();
        schuelerBesonderheiten.setBounds(150, 480, 400, 25);
        schuelerBesonderheiten.setFont(new Font("Arial", Font.BOLD, 18));
        schuelerBesonderheiten.setForeground(Color.BLACK);
        schuelerBesonderheiten.setHorizontalAlignment(JLabel.CENTER);

        schuelerCode = new JLabel();
        schuelerCode.setBounds(250,520,200,25);
        schuelerCode.setFont(new Font("Arial",Font.BOLD,18));
        schuelerCode.setForeground(Color.BLACK);
        schuelerCode.setHorizontalAlignment(JLabel.CENTER);

        // Zurueckbutton
        zurueck = new JButton("Zurück");
        zurueck.setBounds(20, 500, 100, 30);
        zurueck.setVisible(false);
        frame.add(zurueck);

        frame.add(sekundenAnzeige);
        frame.add(minutenAnzeige);
        frame.add(schuelerZaehler);
        frame.add(mikroZyklus);
        frame.add(makroZyklus);
        frame.add(seitenNummer);
        frame.add(schuelerBesonderheiten);
        frame.add(schuelerCode);
        frame.add(zurueck);
	}

    public void showPanel(AbstractCustomPanel panel){
        if (actualPanel != null) {
            actualPanel.setVisible(false);
            frame.remove(actualPanel);
        }
        actualPanel = panel;
        frame.add(panel);
        seitenNummer.setText(panel.getKennung());
        panel.setVisible(true);
    }

	public void updateSekunden(int sekunden) {
        if (sekunden < 10 && sekunden != 0) {
            sekundenAnzeige.setText("0" + sekunden);
        } else {
            sekundenAnzeige.setText("" + sekunden);
        }
    }

	public void updateMinuten(int sekunden) {
		String formattedTime = "";
		int min = sekunden / 60;
		int sek = sekunden % 60;
		if (min < 10){
			formattedTime += "0" + min + ":";
		} else {
			formattedTime += min + ":";
		}
		if (sek < 10){
			formattedTime += "0" + sek;
		} else {
			formattedTime += "" + sek;
		}
		minutenAnzeige.setText(formattedTime);
	}

    public void updateSchuelerAnzahl(int schueleranzahl, int gesamt) {
        schuelerZaehler.setText("S " + schueleranzahl + "/" + gesamt);
    }

    public void updateSchuelerdurchlauf(int mikrodurchlauf) {
        mikroZyklus.setText("D " +  mikrodurchlauf + "/" + Einstellungen.MIKROZYKLUS);
    }

    public void updateGesamtdurchlauf(int gesamtdurchlauf) {
        makroZyklus.setText("G " + gesamtdurchlauf + "/" + Einstellungen.MAKROZYKLUS);
    }

    public void updateSchuelerDaten(SchuelerModel s) {
        schuelerCode.setText(s.code);
        schuelerBesonderheiten.setText(s.besonderheiten);
    }

    public void enableBackBTn(ActionListener l) {
        //zurueck.addActionListener(l);
        //zurueck.setVisible(true);
    }
}
