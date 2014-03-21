package model;

public class Einstellungen {
	
	private Einstellungen(){}
	
	public static final int MISSINGVALUE 		= -9;
	public static final String DELIMETER 		= ";";
	
	public static final String KENNUNG 			= "-ib";
	public static final String EXTENSION 		= ".dat";
	
	public static final int DEUTSCH 			= 0; 
	public static final int MATHEMATIK 			= 1;
	
	public static final int ERSTESTUNDE 		= 0;
	public static final int ZWEITESTUNDE 		= 1;	
	
	public static final int TIMERSEK 			= 20;	// Angaben in Sekunden 	   	
	public static final int BEGINNBEOBACHTUNG 	= 10;
	public static final int MIKROZYKLUS 		= 8; 
	public static final int MAKROZYKLUS 		= 2; 
	
	public static final int STARK 				= 0;
	public static final int MITTEL 				= 1; 
	public static final int SCHWACH 			= 2; 
	public static final int INKL 				= 3;
	
	public static final int SCODESTELLEN 		= 6;
	public static final int KCODESTELLEN 		= 4;
	
	public static final int ANZAHLDERFRAGEN 	= 29;
	public static final int ANZAHLDERKINDER 	= 4;
	
	public static final String[] BEOBACHTER = {
		"", "Andrea", "Anja", "Anne", "Berna", "Christian", "Jana M.", "Jana V.", "Steffi", "Thorsten", "Claudia"
		};
}
