package model;

public class Einstellungen
{
    public static final String KENNUNG          = "ib";
    public static final String EXTENSION        = ".txt";
    public static final int LAENGESESSION       = 45 * 60;
    public static final int LAENGEEINTRAGEN     = 10;
    public static final int LAENGEBEOBACHTUNG   = 10;
    public static final int MIKROZYKLUS         = 8;
    public static final int MAKROZYKLUS         = 2;
    public static final int SCODESTELLEN        = 6;
    public static final int KCODESTELLEN        = 4;
    public static final String[] BEOBACHTER = {
            "", "Anja", "Anne", "Annelie", "Christian", "Jennifer", "Sabina", "Sophia", "Steffi", "Thorsten", "Ulrike"
    };
    public static final String[] UNTERRICHTSSTUNDEN = {
            "", "1. Stunde", "2. Stunde", "3. Stunde", "4. Stunde", "5. Stunde", "6. Stunde"
    };

    private Einstellungen() {}
}
