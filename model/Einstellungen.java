package model;

public class Einstellungen
{
    public static final String KENNUNG          = "ib";
    public static final String EXTENSION        = ".txt";

    public static final int LAENGESESSION       = 45 * 60;
    public static final int LAENGEEINTRAGEN     = 10;
    public static final int LAENGEBEOBACHTUNG   = 10;

    public static final int MIKROZYKLUS         = 8;
    public static final int MAKROZYKLUS         = 1;
    public static final int PAUSE               = 4;

    public static final int MINSCODESTELLEN     = 1;
    public static final int MAXSCODESTELLEN     = 2;

    public static final int KCODESTELLEN        = 4;

    public static final String[] BEOBACHTER = {
            "", "Christian", "Jennifer", "Jessica", "Julia", "Nina", "Steffi", "Thorsten"
    };
    public static final String[] UNTERRICHTSSTUNDEN = {
            "", "1. Stunde", "2. Stunde", "3. Stunde", "4. Stunde", "5. Stunde", "6. Stunde"
    };

    public static final String[] BEOBSTUNDEN = {
            "", "1. Stunde", "2. Stunde", "3. Stunde", "4. Stunde", "5. Stunde", "6. Stunde", "7. Stunde", "8. Stunde",
            "9. Stunde", "10. Stunde"
    };

    private Einstellungen() {}
}
