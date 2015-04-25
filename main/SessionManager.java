package main;

import model.Einstellungen;
import model.SessionModel;
import panels.Ende;
import panels.InitialPanel;
import panels.Pause;
import panels.Schuelercodes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;


public class SessionManager implements ActionListener
{
    SessionModel session;
    Fenster fenster;
    ObservationManager observationManager;

    // Panel
    private InitialPanel initialPanel;
    private Schuelercodes schuelerPanel;
    private Pause helmke;
    private Ende ende;

    // State
    private Timer timer;
    private int unterrichtsZeit;
    private int gesamtdurchlauf;

    SessionManager(Fenster fenster)
    {
        this.fenster = fenster;

        // Panel
        initialPanel = new InitialPanel(this);
        schuelerPanel = new Schuelercodes(this);
        helmke = new Pause(this);
        ende = new Ende(this);

        // Zurueck Button
        fenster.zurueck.setActionCommand("Schuelercodes::Zurueck");
        fenster.zurueck.addActionListener(this);
        fenster.zurueck.setVisible(false);

        // Seitenanzeige
        timer = new Timer();
        gesamtdurchlauf = 0;

        fenster.showPanel(initialPanel);
    }

    public void starteSession()
    {
        fenster.zurueck.setVisible(false);
        observationManager = new ObservationManager(fenster, this);

        session = new SessionModel(
                (String) initialPanel.getSessionInfos().get("Klassennummer"),
                (String) initialPanel.getSessionInfos().get("Beobachter"),
                (String) initialPanel.getSessionInfos().get("Beobachtungsstunde"),
                (String) initialPanel.getSessionInfos().get("Fach"),
                (String) initialPanel.getSessionInfos().get("Schulstunde"),
                schuelerPanel.getSchueler()
                );
        unterrichtsZeit = Einstellungen.LAENGESESSION;

        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                if (unterrichtsZeit == 0) this.cancel();
                unterrichtsZeit--;
                SwingUtilities.invokeLater(
                        new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                fenster.updateMinuten(unterrichtsZeit);
                            }
                        }
                );
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
        starteNeuenZyklus();
    }

    void starteNeuenZyklus()
    {
        gesamtdurchlauf++;
        fenster.updateGesamtdurchlauf(gesamtdurchlauf);
        session.resetRandomGenerator();
        observationManager.starteSchuelerZyklus();

    }

    void resumeFromBreak(){
        if (session.hasMoreSchueler()){
            // einfach da weitermachen wo wir aufgehoert haben
            observationManager.starteSchuelerZyklus();
        } else {
            // es muss ein neuer Zyklus gestartet werden
            starteNeuenZyklus();
            // TODO ist das wirklich so einafch an der Stelle? muss man nicht nochmal pruefen
        }
    }

    boolean isTimeForBreak(){
        if ((!session.hasMoreSchueler()) && (gesamtdurchlauf < Einstellungen.MAKROZYKLUS)){
            return true;
        } else if (session.anzahlGetesteterSchueler() == Einstellungen.PAUSE){
            return true;
        }
        return false;
    }

    boolean isEnde(){
        return (!session.hasMoreSchueler()) && (gesamtdurchlauf == Einstellungen.MAKROZYKLUS);
    }

    void schuelerIstAbgeschlossen(){
        if (isEnde()){
            fenster.showPanel(ende);
        } else if (isTimeForBreak()){
            fenster.showPanel(helmke);
        } else {
            observationManager.starteSchuelerZyklus();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Pause::Weiter")) {
            resumeFromBreak();
        } else if (e.getActionCommand().equals("StartPanel::Weiter")) {
            if (initialPanel.inputIsValid()){
                fenster.showPanel(schuelerPanel);
                fenster.zurueck.setVisible(true);
            } else {
                initialPanel.alert();
            }
        } else if (e.getActionCommand().equals("Schuelercodes::Weiter")) {
            if (schuelerPanel.inputIsValid()) {
                starteSession();
            } else {
                schuelerPanel.alert();
            }
        } else if (e.getActionCommand().equals("Schuelercodes::Zurueck")) {
            fenster.zurueck.setVisible(false);
            fenster.showPanel(initialPanel);
        }
    }
}
