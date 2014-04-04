package model;

public class Einstellungen {


    private Einstellungen(){}

	public static final String KENNUNG 			= "ib";
	public static final String EXTENSION 		= ".txt";

    public static final int LAENGESESSION       = 45 * 60;
    public static final int LAENGEPAUSE         = 10; // eigentlich 10 Minuten
	public static final int LAENGEEINTRAGEN 	= 5;
	public static final int LAENGEBEOBACHTUNG   = 5;
	public static final int MIKROZYKLUS 		= 2;
	public static final int MAKROZYKLUS 		= 2;
	
	public static final int SCODESTELLEN 		= 1;
	public static final int KCODESTELLEN 		= 1;

	public static final String[] BEOBACHTER = {
		"", "Andrea", "Anja", "Anne", "Berna", "Christian", "Jana M.", "Jana V.", "Steffi", "Thorsten", "Claudia"
	};

    public static final String[] UNTERRICHTSSTUNDEN = {
        "", "1. Stunde", "2. Stunde", "3. Stunde", "4. Stunde", "5. Stunde", "6. Stunde"
    };


}
