package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Sitzung { 
	 
	public String klassencode; 
	public int fach;
	public int beobachterstunde;
	public int beobachter;
	public int schulstunde;
	
	private Schueler[] schuelerarray;
	private int anzahlBeobachteterSchueler; 
	private int aktuellerSchueler; 
	private boolean[] schonGewaehlt;
	private Random randomGenerator;
	
	private String[] schuelercodes; 
	
	private ArrayList<Interface_SchuelerMetadaten> listener = new ArrayList<Interface_SchuelerMetadaten>();
	
	private int makroZyklus; 

	
	public Sitzung(){
		schonGewaehlt 				= new boolean[Einstellungen.ANZAHLDERKINDER];
		randomGenerator 			= new Random(); 
		makroZyklus 				= 0; 
		anzahlBeobachteterSchueler 	= 0; 
	}
	
	public void reset(){
		anzahlBeobachteterSchueler = 0;
		if (schuelercodes[0].equals("-9")){
			schonGewaehlt[0] = true;
		} else {
			schonGewaehlt[0] = false;
		}
		if (schuelercodes[1].equals("-9")){
			schonGewaehlt[1] = true;
		} else {
			schonGewaehlt[1] = false;
		}
		if (schuelercodes[2].equals("-9")){
			schonGewaehlt[2] = true;
		} else {
			schonGewaehlt[2] = false;
		}
		if (schuelercodes[3].equals("-9")){
			schonGewaehlt[3] = true;
		} else {
			schonGewaehlt[3] = false;
		}
	}
	
	public boolean alleFertig(){
		return schonGewaehlt[0] && schonGewaehlt[1] && schonGewaehlt[2] && schonGewaehlt[3];
	}
	
	
	public void naechsterSchueler(){
		anzahlBeobachteterSchueler++;
		if (alleFertig()){
			aktuellerSchueler = -1;
			return;
		}
		aktuellerSchueler = randomGenerator.nextInt(Einstellungen.ANZAHLDERKINDER);
		System.out.println(Arrays.toString(schonGewaehlt));
		while(schonGewaehlt[aktuellerSchueler]){
			aktuellerSchueler = randomGenerator.nextInt(Einstellungen.ANZAHLDERKINDER);
		}
		schonGewaehlt[aktuellerSchueler] = true;
		notifyMetadataChanged();
	}
	
	public void naechsterMakrozyklus(){
		reset();
		makroZyklus++;
	}

	/**
	 * GETTER	
	 */
	public Schueler getAktuellenSchueler(){
		return schuelerarray[aktuellerSchueler];
	}
	
	public Schueler[] getAlleSchueler(){
		return schuelerarray; 
	}
	
	public String getAnzahlBeobachteterSchueler(){
		return "" + anzahlBeobachteterSchueler; 
	}
	
	public int getAktuellenMakrozyklus(){
		return makroZyklus;
		
	}
	
	/**
	 * SETTER
	 */

	public void setFach(int fach) {
		this.fach = fach;
	}

	public void setBeobachterstunde(int beobachterstunde) {
		this.beobachterstunde = beobachterstunde;
	}

	public void setBeobachter(int beobachter) {
		this.beobachter = beobachter - 1;
	}
	
	public void setSchulstunde(int schulstunde){
		this.schulstunde = schulstunde; 
	}
	
	public void setKlassencode(String klassencode) {
		this.klassencode = klassencode;
	}

	public void setSchueler(String[] schuelercode, String[] besonderheiten) {
		this.schuelercodes = schuelercode; 
		System.out.println(Arrays.toString(schuelercode));
		schuelerarray = new Schueler[4]; 
		schuelerarray[0] = new Schueler(schuelercodes[0], Einstellungen.STARK, this, besonderheiten[0]); 
		schuelerarray[1] = new Schueler(schuelercodes[1], Einstellungen.MITTEL, this, besonderheiten[1]);
		schuelerarray[2] = new Schueler(schuelercodes[2], Einstellungen.SCHWACH, this, besonderheiten[2]);
		schuelerarray[3] = new Schueler(schuelercodes[3], Einstellungen.INKL, this, besonderheiten[3]);
		reset();
	}
	
	/**
	 * Observermethoden
	 */
	
	public void registerMetadataChangedListener(Interface_SchuelerMetadaten l){
		listener.add(l);
	}
	
	private void notifyMetadataChanged(){
		for (Interface_SchuelerMetadaten element : listener) {
			element.metadataChanged();
		}
	}
}
