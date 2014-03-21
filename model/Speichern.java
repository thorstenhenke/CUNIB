package model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;


public class Speichern {
 
	public static final String CARRETURN = "\r\n";
	 
	private Speichern(){}
	
	static private String fachToString(int fach){
		if (fach == Einstellungen.MATHEMATIK){
			return "-mathe";
		}
		if (fach == Einstellungen.DEUTSCH){
			return "-deutsch";
		}
		return "";
	}
	
	static public void Speichern(Sitzung sitzung) {
		try{
			// getHomeDirectory() == Win7-Desktop
			File outputfile = new File(
					FileSystemView.getFileSystemView().getHomeDirectory().getCanonicalPath()
					+ "\\" 
							+ sitzung.klassencode
							+ "-"
							+ (sitzung.beobachterstunde + 1)
							+ fachToString(sitzung.fach)
							+ Einstellungen.KENNUNG 
							+ Einstellungen.EXTENSION
					);
			PrintWriter out = new PrintWriter(outputfile);
			out.append( sitzung.getAlleSchueler()[0].toString() + Speichern.CARRETURN );
			out.append( sitzung.getAlleSchueler()[1].toString() + Speichern.CARRETURN );
			out.append( sitzung.getAlleSchueler()[2].toString() + Speichern.CARRETURN );
			out.append( sitzung.getAlleSchueler()[3].toString() );
			out.close();
			System.out.println(sitzung.beobachter);
		}catch(IOException err){	
			JOptionPane.showMessageDialog(new JFrame(),
			    "Daten konnten nicht gesichert werden!",
			    "Inane warning",
			    JOptionPane.WARNING_MESSAGE);
			System.out.println(err);
		}catch(NullPointerException err){
			JOptionPane.showMessageDialog(new JFrame(),
			    "Es sind noch keine Schüler vorhanden. Die abgespeicherte Datei ist leer",
			    "Inane warning",
			    JOptionPane.WARNING_MESSAGE);
			System.out.println(err);
		}
	}

}
