package model;

import java.text.DateFormat;
import java.util.GregorianCalendar;

public final class Schueler {
	
	public final Sitzung sitzung;
	
	public final String schuelercode;
	public final int status;
	public final String besondereMerkmale;  
	
	private int mikrozyklus;
	
	private int[][][] antworten;


	public Schueler(String schuelercode, int status, Sitzung sitzung, String besondereMerkmale) {
		super();
		this.sitzung 			= sitzung; 
		this.schuelercode 		= schuelercode;
		this.status 			= status;
		this.besondereMerkmale 	= besondereMerkmale; 
		
		mikrozyklus = 0;
		
		antworten = new int
				[Einstellungen.MAKROZYKLUS]
				[Einstellungen.MIKROZYKLUS]
				[Einstellungen.ANZAHLDERFRAGEN]; 
		codeMissingValues();
	}
	
	private void codeMissingValues(){
		for (int i = 0; i < Einstellungen.MAKROZYKLUS; i++) {
			for (int j = 0; j < Einstellungen.MIKROZYKLUS; j++) {
				for (int k = 0; k < Einstellungen.ANZAHLDERFRAGEN; k++) {
					antworten[i][j][k] = Einstellungen.MISSINGVALUE;					
				}
			}
		}		
	}
	
	public boolean istLetzterDurchgang() {
		return mikrozyklus == Einstellungen.MIKROZYKLUS;
	}
	
	public int getAktuellenMikrozyklus(){
		return mikrozyklus ;
	}
	
	public void incrementMikrozyklus(){
		mikrozyklus++;
	}
	
	public void resetMikrozyklus(){
		mikrozyklus = 0; 
	}
	
	public void setAntwort(int makroZyklus, int minZyklus, int idFrage, int antwort){
		if (	makroZyklus 	< Einstellungen.MAKROZYKLUS
			&& 	minZyklus 		< Einstellungen.MIKROZYKLUS
			&& 	idFrage 		< Einstellungen.ANZAHLDERFRAGEN ) 
		{			
			antworten[makroZyklus][minZyklus][idFrage] = antwort; 			
		}
	}
	
	private String getToday(){
		GregorianCalendar now = new GregorianCalendar();
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);   // 14.04.12
		return df.format(now.getTime()); 
	}
	
	@Override
	public String toString(){
		String zeile =
				sitzung.klassencode 		+ Einstellungen.DELIMETER +
				schuelercode 				+ Einstellungen.DELIMETER +
				status 						+ Einstellungen.DELIMETER +
				getToday()					+ Einstellungen.DELIMETER +
				sitzung.schulstunde 		+ Einstellungen.DELIMETER +
				sitzung.fach 				+ Einstellungen.DELIMETER +
				sitzung.beobachterstunde 	+ Einstellungen.DELIMETER +
				sitzung.beobachter;
		for (int i = 0; i < Einstellungen.MAKROZYKLUS; i++) {
			for (int j = 0; j < Einstellungen.MIKROZYKLUS; j++) {
				for (int k = 0; k < Einstellungen.ANZAHLDERFRAGEN; k++) {
					zeile += Einstellungen.DELIMETER + antworten[i][j][k];					
				}
			}
		}
		return zeile;
	}
}
