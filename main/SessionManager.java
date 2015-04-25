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

    void zyklusAbgeschlossen()
    {
        if (gesamtdurchlauf < Einstellungen.MAKROZYKLUS) {
            fenster.showPanel(helmke);
        } else {
            fenster.showPanel(ende);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Pause::Weiter")) {
            starteNeuenZyklus();
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
