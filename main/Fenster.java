  package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Interface_SchuelerMetadaten;
import model.Sitzung;
import model.Speichern;


public class Fenster implements ActionListener,	Interface_SchuelerMetadaten	{
 
	private JFrame frame; 
	public FensterElemente fensterElemente; 

	public Fenster() {
		fensterElemente = new FensterElemente(this);
		initialize();	
	}

	private void initialize() {
		
		fensterElemente.sitzung = new Sitzung();
				
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				int input = JOptionPane.showConfirmDialog(
					    frame,
					    "Möchtest du das Programm wirklich beenden?",
					    "Programm schließen",
					    JOptionPane.YES_NO_OPTION);
				if( input == JOptionPane.YES_OPTION) {
					Speichern.Speichern(fensterElemente.sitzung);
					System.exit(0); 
				}
			}
		});

		
		frame.add(fensterElemente.sekundenAnzeige);
		frame.add(fensterElemente.minutenAnzeige);
		frame.add(fensterElemente.schuelerZaehler);
		frame.add(fensterElemente.mikroZyklus);
		frame.add(fensterElemente.makroZyklus);
		frame.add(fensterElemente.seitenNummer);

		frame.add(fensterElemente.schuelerStatus);
		frame.add(fensterElemente.schuelerCode);
		frame.add(fensterElemente.zurueck);
		
		frame.add(fensterElemente.startPanel);
		frame.add(fensterElemente.ausgewaehlterSchueler);
		frame.add(fensterElemente.warte);
		frame.add(fensterElemente.beob);
		frame.add(fensterElemente.helm);
		frame.add(fensterElemente.speichern);
		
		for ( int i = 0; i < fensterElemente.fragen.length; i++ ){
			frame.add(fensterElemente.fragen[i]);
		}

		fensterElemente.zurueck.addActionListener(this);
		fensterElemente.sitzung.registerMetadataChangedListener(this);
		fensterElemente.sitzung.registerMetadataChangedListener(fensterElemente.ausgewaehlterSchueler);
		
		fensterElemente.beobachtungstimerTimer = new javax.swing.Timer( 1000, this );
		fensterElemente.beobachtungstimerTimer.setInitialDelay(0);
		fensterElemente.beobachtungstimerTimer.setActionCommand("sek");
		
		fensterElemente.stundenTimer = new javax.swing.Timer( 1000, this );
		fensterElemente.stundenTimer.setInitialDelay(0);
		fensterElemente.stundenTimer.setActionCommand("min");
		fensterElemente.minCounter = 45 * 60; 
		
		fensterElemente.startPanel.setVisible(true);
	}
	
	public void weiterschalten(){
		if (fensterElemente.startPanel.isVisible()){
			fensterElemente.startPanel.setVisible(false);
			fensterElemente.makroZyklus.setText("GD-" + (fensterElemente.sitzung.getAktuellenMakrozyklus() + 1));
			fensterElemente.stundenTimer.start();
			neuerSchueler();
			return;
		}			
		if (fensterElemente.ausgewaehlterSchueler.isVisible()){
			fensterElemente.ausgewaehlterSchueler.setVisible(false);
			neueRunde();
			return;	
		} 
		if (fensterElemente.beob.isVisible()){
			fensterElemente.beob.setVisible(false);
			naechsteFrage(0);
			return;	
		} 
		if (fensterElemente.helm.isVisible()){
			fensterElemente.helm.setVisible(false);
			fensterElemente.sitzung.reset();
			fensterElemente.sitzung.naechsterMakrozyklus();
			fensterElemente.makroZyklus.setText("GD-" + (fensterElemente.sitzung.getAktuellenMakrozyklus() + 1));
			neuerSchueler();
		}
		if (fensterElemente.warte.isVisible()){
			fensterElemente.warte.setVisible(false);
			letzteFrageWeiterschalten();
		}
	
	}

	public void naechsteFrage(int naechsteFrage){
		if (naechsteFrage == 0){
			fensterElemente.zurueck.setVisible(false);
		} else {
			fensterElemente.zurueck.setVisible(true);
		}
		fensterElemente.aktuelleFrage = naechsteFrage;
		fensterElemente.seitenNummer.setText("F-" + fensterElemente.fragen[naechsteFrage].getFrageID());
		fensterElemente.fragen[naechsteFrage].setVisible(true); 
	}

	public void letzteFrageWeiterschalten() {
		fensterElemente.zurueck.setVisible(false);

		if (fensterElemente.sekCounter > 0) {
			fensterElemente.seitenNummer.setText("F-" + fensterElemente.warte.getKennung());
			fensterElemente.warte.setVisible(true);
			return; 
		}

		fensterElemente.sitzung.getAktuellenSchueler().incrementMikrozyklus();
		
		if (fensterElemente.sitzung.getAktuellenSchueler().istLetzterDurchgang()
				&& fensterElemente.sitzung.alleFertig()
				&& fensterElemente.sitzung.getAktuellenMakrozyklus() == 0) {
			fensterElemente.seitenNummer.setText("F-" + fensterElemente.helm.getKennung());
			fensterElemente.beobachtungstimerTimer.stop();
			updateTime(0);
			fensterElemente.helm.setVisible(true);
			
		} else if (fensterElemente.sitzung.getAktuellenSchueler().istLetzterDurchgang()
				&& fensterElemente.sitzung.alleFertig()
				&& fensterElemente.sitzung.getAktuellenMakrozyklus() == 1) {
			fensterElemente.seitenNummer.setText("F-" + fensterElemente.speichern.getKennung());
			fensterElemente.beobachtungstimerTimer.stop();
			updateTime(0);
			fensterElemente.speichern.setVisible(true);
			
		} else if (fensterElemente.sitzung.getAktuellenSchueler().istLetzterDurchgang()) {
			neuerSchueler();
		} else {
			neueRunde();
		}
	}
	
	private void neueRunde() {
		Speichern.Speichern(fensterElemente.sitzung);
		fensterElemente.mikroZyklus.setText("D-" + (fensterElemente.sitzung.getAktuellenSchueler().getAktuellenMikrozyklus() + 1));
		fensterElemente.seitenNummer.setText("F-" + fensterElemente.beob.getKennung());
		fensterElemente.beob.setVisible(true);
		starteAusfuellTimer();
	}

	private void neuerSchueler() {
		Speichern.Speichern(fensterElemente.sitzung);
		fensterElemente.sitzung.getAktuellenSchueler().resetMikrozyklus();
		fensterElemente.sitzung.naechsterSchueler();
		fensterElemente.schuelerZaehler.setText("Sch-" + fensterElemente.sitzung.getAnzahlBeobachteterSchueler());
		fensterElemente.seitenNummer.setText("F-" + fensterElemente.ausgewaehlterSchueler.getKennung());
		fensterElemente.ausgewaehlterSchueler.setVisible(true);
	}
	
	private void starteAusfuellTimer(){
		if (fensterElemente.beobachtungstimerTimer.isRunning()){
			fensterElemente.beobachtungstimerTimer.stop();
		}
		fensterElemente.sekCounter = 20;
		fensterElemente.beobachtungstimerTimer.start();
	}

	private void updateMinuten(int sekunden) {
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
		fensterElemente.minutenAnzeige.setText(formattedTime);
	}	
	
	private void updateTime(int sekunden) {
		fensterElemente.sekCounter = sekunden; 
		if (sekunden < 10 && sekunden != 0){
			fensterElemente.sekundenAnzeige.setText("0" + sekunden);
		} else {
			fensterElemente.sekundenAnzeige.setText("" + sekunden);
		}
	}
	
	@Override
	public void metadataChanged() {
		fensterElemente.schuelerStatus.setText(fensterElemente.sitzung.getAktuellenSchueler().besondereMerkmale);
		fensterElemente.schuelerCode.setText("Schülercode: " + fensterElemente.sitzung.getAktuellenSchueler().schuelercode);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("zurueck")){
			fensterElemente.fragen[fensterElemente.aktuelleFrage].setVisible(false);
			naechsteFrage(fensterElemente.fragen[fensterElemente.aktuelleFrage].getVorgaenger());
		}
		if (e.getActionCommand().equals("sek")){
			fensterElemente.beob.updateTime(fensterElemente.sekCounter);
			updateTime(fensterElemente.sekCounter);
			fensterElemente.warte.updateTime(fensterElemente.sekCounter);
			if (fensterElemente.sekCounter == 10){
				weiterschalten();
			}  
			if (fensterElemente.sekCounter == 0){
				fensterElemente.beobachtungstimerTimer.stop();
				weiterschalten();
			} else {
				fensterElemente.sekCounter--;				
			}
		}
		if (e.getActionCommand().equals("min")){
			updateMinuten(fensterElemente.minCounter);
			if (fensterElemente.minCounter == 0){
				fensterElemente.stundenTimer.stop();
			} else {
				fensterElemente.minCounter--;
			}
		}
	}
	
	/** 
	 * Hilfsmethoden: 
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenster window = new Fenster();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
