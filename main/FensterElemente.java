package main;

import java.awt.Color;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.*;

import fragePanels.*;

public class FensterElemente {
	
	private Fenster fenster;
	
	public StartPanel startPanel;
	public AusgewaehlterSchueler ausgewaehlterSchueler;
	public WartePanel warte;
	public EndeUndSpeichern speichern;
	public BeobPanel beob;
	public Helmke helm;
	public AbstractBtnPanel[] fragen;
	public JLabel mikroZyklus;
	public JLabel makroZyklus;
	public JLabel schuelerStatus;
	public JLabel schuelerCode;
	public JLabel seitenNummer;
	public JLabel sekundenAnzeige;
	public JLabel minutenAnzeige;
	public Sitzung sitzung;
	public Timer beobachtungstimerTimer;
	public int sekCounter;
	public Timer stundenTimer;
	public int minCounter;
	public JButton zurueck;
	public int aktuelleFrage;
	public JLabel schuelerZaehler;

	public FensterElemente(Fenster fenster) {
		
		this.fenster = fenster;
		
		/**
		 * Create main panels
		 */
		
		startPanel 				= new StartPanel(fenster); 				preparePanel(startPanel);
		ausgewaehlterSchueler 	= new AusgewaehlterSchueler(fenster); 	preparePanel(ausgewaehlterSchueler);
		warte					= new WartePanel(fenster); 				preparePanel(warte);
		beob					= new BeobPanel(fenster);				preparePanel(beob);
		helm					= new Helmke(fenster);					preparePanel(helm);
		speichern				= new EndeUndSpeichern(fenster); 		preparePanel(speichern);
	
		startPanel.setKennung("St");
		ausgewaehlterSchueler.setKennung("Au");
		warte.setKennung("W");
		beob.setKennung("B");
		helm.setKennung("H");
		speichern.setKennung("Sp");
		
		/**
		 * Fragenpanels
		 */
		fragen = new AbstractBtnPanel[Einstellungen.ANZAHLDERFRAGEN];
		fragen[0] 	= new Inhalt(0, -1, fenster);
		fragen[1] 	= new Lernkontext(1, 0, fenster);
			fragen[2] 	= new Individuell(2, 1, fenster);
				fragen[3] 	= new Interaktion			(3, 2, fenster);
				fragen[4] 	= new Qualitaet				(4, 3, fenster);
			fragen[5] 	= new GesamteKlasse(5, 1, fenster);
				fragen[6] 	= new Interaktion			(6, 5, fenster);
				fragen[7] 	= new Qualitaet				(7, 6, fenster);
			fragen[8] 	= new Partnerarbeit(8, 1, fenster);
				fragen[9] 	= new KindGeleitet(9, 8, fenster);
					fragen[10] 	= new Interaktion		(10, 9, fenster);
					fragen[11] 	= new Qualitaet			(11, 10, fenster);
				fragen[12] 	= new L1Geleitet(12, 8, fenster);
					fragen[13] 	= new Interaktion		(13, 12, fenster);
					fragen[14] 	= new Qualitaet			(14, 13, fenster);
				fragen[15] 	= new L2Geleitet(15, 8, fenster);
					fragen[16] 	= new Interaktion		(16, 15, fenster);
					fragen[17] 	= new Qualitaet			(17, 16, fenster);
			fragen[18]  = new GruppeAnzahl(18, 1, fenster);
			fragen[19] 	= new Gruppenarbeit(19, 1, fenster);
				fragen[20] 	= new F_20_wennKindGeleitet	(20, 19, fenster);
					fragen[21] 	= new Interaktion		(21, 20, fenster);
					fragen[22] 	= new Qualitaet			(22, 21, fenster);
				fragen[23] 	= new F_23_wennL1Geleitet	(23, 19, fenster);
					fragen[24] 	= new Interaktion		(24, 23, fenster);
					fragen[25] 	= new Qualitaet			(25, 24, fenster);
				fragen[26] 	= new F_26_wennL2Geleitet	(26, 19, fenster);
					fragen[27] 	= new Interaktion		(27, 26, fenster);
					fragen[28] 	= new Qualitaet			(28, 27, fenster);
						
		for ( int i = 0; i < fragen.length; i++ ){
			preparePanel(fragen[i]);
		}

		
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
		

		schuelerZaehler = new JLabel("Sch-#");
		schuelerZaehler.setBounds(706,170,90,25);
		schuelerZaehler.setFont(new Font("Arial",Font.BOLD,23));
		schuelerZaehler.setForeground(Color.GREEN);
		schuelerZaehler.setHorizontalAlignment(JLabel.CENTER);
		

		mikroZyklus = new JLabel("D-#");
		mikroZyklus.setBounds(706,230,90,25);
		mikroZyklus.setFont(new Font("Arial",Font.BOLD,23));
		mikroZyklus.setForeground(Color.GREEN);
		mikroZyklus.setHorizontalAlignment(JLabel.CENTER);
		

		makroZyklus = new JLabel("GD-#");
		makroZyklus.setBounds(706,310,90,25);
		makroZyklus.setFont(new Font("Arial",Font.BOLD,23));
		makroZyklus.setForeground(Color.BLUE);
		makroZyklus.setHorizontalAlignment(JLabel.CENTER);
		
		// TODO das sieht irgendwie verquer aus 
		seitenNummer = new JLabel("F-" + startPanel.getKennung());
		seitenNummer.setBounds(706,510,90,25);
		seitenNummer.setFont(new Font("Arial",Font.BOLD,20));
		seitenNummer.setForeground(Color.BLACK);
		seitenNummer.setHorizontalAlignment(JLabel.CENTER);


		/**
		 * Labels && Buttons bottom 
		 */
		
		schuelerStatus=new JLabel();
		schuelerStatus.setBounds(150,480,400,25);
		schuelerStatus.setFont(new Font("Arial",Font.BOLD,18));
		schuelerStatus.setForeground(Color.BLACK);
		schuelerStatus.setHorizontalAlignment(JLabel.CENTER);
		
		schuelerCode=new JLabel();
		schuelerCode.setBounds(250,520,200,25);
		schuelerCode.setFont(new Font("Arial",Font.BOLD,18));
		schuelerCode.setForeground(Color.BLACK);
		schuelerCode.setHorizontalAlignment(JLabel.CENTER);
		
		zurueck = new JButton("Zur�ck");
		zurueck.setBounds(20, 500, 100, 30);
		zurueck.setActionCommand("zurueck");
		zurueck.setVisible(false);
		
		}
	
	private void preparePanel(JPanel panel){	
		panel.setBounds(10, 20, 700, 460);
		panel.setVisible(false);
		panel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	}
}