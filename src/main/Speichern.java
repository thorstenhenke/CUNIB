package main;

import model.Einstellungen;
import model.SessionModel;

import javax.swing.*;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;

public class Speichern
{

    private static File targetFile;

    public static void createFile(SessionModel s)
    {
        String desktop = System.getProperty("user.home") + "/Desktop";
        String name = s.klassennummer + "-" + s.fach + "-" + s.beobachterstunde + "-" + Einstellungen.KENNUNG;
        targetFile = new File(desktop + "/" + name + Einstellungen.EXTENSION);
        for (int id = 1; targetFile.exists(); id++) {
            targetFile = new File(desktop + "/" + name + "(" + id + ")" + Einstellungen.EXTENSION);
        }
        try {
            targetFile.createNewFile();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Konnte Datei zum Speichern nicht erstellen. Bitte Papierversion nutzen!",
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void saveString(String s)
    {
        try {
            FileWriter fw = new FileWriter(targetFile, true);
            fw.write(s);
            fw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Konnte nicht in die Datei schreiben. Bitte zur Papierversion wechseln!",
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void signWithMD5()
    {
        String hash = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            FileInputStream in = new FileInputStream(targetFile);
            byte[] data = new byte[1024];
            for (int n = 0; (n = in.read(data)) > -1; ) {
                md.update(data, 0, n);
            }
            in.close();
            hash = (new HexBinaryAdapter()).marshal(md.digest()).toLowerCase();
        } catch (Exception e) {
            System.err.println("Konnte Hash nicht generieren.");
        }
        Speichern.saveString("MD5::" + hash);
    }
}
