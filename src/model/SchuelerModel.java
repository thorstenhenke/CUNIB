package model;


import main.Speichern;

import java.io.*;
import java.util.LinkedList;

public final class SchuelerModel
{

    public final String code;
    public final String status;
    public final String besonderheiten;
    private int mzp;

    private LinkedList<History> beobachtungen;

    public SchuelerModel(String schuelercode, String status, String besondereMerkmale)
    {
        this.code = schuelercode;
        this.status = status;
        this.besonderheiten = besondereMerkmale;
        this.beobachtungen = new LinkedList<History>();
        mzp = 0;
    }

    public void addBeobachtung(History history)
    {
        beobachtungen.addLast((History) deepCopy(history));
        Speichern.saveString(code + "," + status + "," + ++mzp + "," + history + "\r\n");
    }

    private Object deepCopy(Object o)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(baos).writeObject(o);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            return new ObjectInputStream(bais).readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Objekt konnet nicht serialisiert werden");
        }
        return null;
    }


    /**
     * Nur für  Debugging verweden
     */
    @Override
    public String toString()
    {
        // code, status, mzp, history
        String rueckgabe = "";
        for (History row : beobachtungen) {
            rueckgabe += code + "," + status + "," + row.toString() + "\r\n";
        }
        return rueckgabe;
    }
}
