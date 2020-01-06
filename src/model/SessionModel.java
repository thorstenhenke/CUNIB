package model;

import main.Speichern;

import java.util.Calendar;
import java.util.Collection;

public class SessionModel
{

    public final String klassennummer;
    public final String beobachter;
    public final String beobachterstunde;
    public final String fach;
    public final String schulstunde;
    public final SchuelerModel[] arrschueler;

    private int limit;

    public SessionModel(String klnr, String beobachter, String bstunde, String fach, String sstunde, Collection<SchuelerModel> schuelerModel)
    {
        this.klassennummer = klnr;
        this.beobachter = beobachter;
        this.beobachterstunde = bstunde;
        this.fach = fach;
        this.schulstunde = sstunde;
        this.arrschueler = schuelerModel.toArray(new SchuelerModel[schuelerModel.size()]);

        Speichern.createFile(this);
        Speichern.saveString(this.toString());
    }

    // vermutlich + 1
    public int anzahlGetesteterSchueler()
    {
        return arrschueler.length - limit;
    }

    public void resetRandomGenerator()
    {
        this.limit = arrschueler.length;
    }

    public Boolean hasMoreSchueler()
    {
        if (limit == 0) {
            return false;
        }
        return true;
    }

    public SchuelerModel ziehe()
    {
        int idx = arrschueler.length - limit;
        limit--;
        return arrschueler[idx];
    }

    @Override
    public String toString()
    {
        Calendar cal = Calendar.getInstance();

        String curTime = String.format("%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));

        String rueckgabe = "<Metadaten> \r\n";

        rueckgabe += "Datum: " + cal.get(Calendar.DAY_OF_MONTH) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.YEAR) + "\n\r";
        rueckgabe += "Uhrzeit: " + curTime + "\n\r";
        rueckgabe += "Klassenummer: " + klassennummer + "\r\n";
        rueckgabe += "Beobachter: " + beobachter + "\r\n";
        rueckgabe += "Beobachtung: " + beobachterstunde + "\r\n";
        rueckgabe += "Schulfach: " + fach + "\r\n";
        rueckgabe += "Schulstunde: " + schulstunde + "\r\n";
        rueckgabe += "Schueler: " + arrschueler.length + "\r\n";
        rueckgabe += "\n\r<Beobachtungen>\r\n";
        return rueckgabe;
    }
}
