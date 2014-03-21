package main;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public abstract class Abstract_AllgemeinesPanel extends JPanel implements ActionListener{

	private String kennung; 
	
	public void setKennung(String kennung){
		this.kennung = kennung; 
	}
	
	public String getKennung(){
		return kennung;
	}
}
