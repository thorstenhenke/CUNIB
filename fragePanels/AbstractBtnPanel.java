package fragePanels;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Fenster;
import model.Sitzung;

public abstract class AbstractBtnPanel extends JPanel implements ActionListener{

	protected Fenster fenster;
	
	protected int vorgaenger; 
	protected int frageID;
	
	public AbstractBtnPanel(int frageID, int vorgaenger, Fenster fenster){
		this.fenster 	= fenster;
		this.vorgaenger = vorgaenger;
		this.frageID 	= frageID;
		this.bauePanel(); 
		
	}
	
	public int getVorgaenger(){
		return vorgaenger;
	}
	
	public String getFrageID(){
		return "" + frageID;
	}
	
	protected void setAntwort(int btnID){
		// TODO hier die Speichermethode??
		fenster.fensterElemente.sitzung.getAktuellenSchueler().setAntwort(
					fenster.fensterElemente.sitzung.getAktuellenMakrozyklus(),
					fenster.fensterElemente.sitzung.getAktuellenSchueler().getAktuellenMikrozyklus(),
					frageID,
					btnID);
	}
	public abstract void bauePanel(); 
}
