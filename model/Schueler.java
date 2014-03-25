package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class Schueler {

	public final String schuelercode;
	public final String status;
	public final String besondereMerkmale;  

    private LinkedList<LinkedList<Historytupel>> beobachtungen;

	public Schueler(String schuelercode, String status, String besondereMerkmale) {
		this.schuelercode 		= schuelercode;
		this.status 			= status;
		this.besondereMerkmale 	= besondereMerkmale;

        this.beobachtungen      = new LinkedList<LinkedList<Historytupel>>();
	}

    public void addBeobachtung(LinkedList<Historytupel> beobachtung) {
        beobachtungen.add(beobachtung);
    }

    @Override
    public String toString() {
        // code, status, mzp, history
        String rueckgabe = "";
        int mzp = 1;
        for (Iterator b = beobachtungen.iterator(); b.hasNext();) {
            rueckgabe += schuelercode + "," + status + "," + ++mzp + "," + b.next() + "\r\n";
        }
        return rueckgabe;
    }
}
