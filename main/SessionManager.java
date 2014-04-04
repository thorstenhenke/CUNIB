package main;

import model.SchuelerModel;
import model.SessionModel;
import model.Einstellungen;
import panels.Ende;
import panels.Pause;
import panels.StartPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;


public class SessionManager implements ActionListener{
    SessionModel session;
    Fenster fenster;
    ObservationManager observationManager;

    // Panel
    private StartPanel startPanel;
    private Pause helmke;
    private Ende ende;

    // State
    private Timer timer;
    private int unterrichtsZeit;
    private int gesamtdurchlauf;

    SessionManager(Fenster fenster) {
        this.fenster = fenster;
        observationManager = new ObservationManager(fenster, this);

        // Panel
        startPanel = new StartPanel(this);
        helmke = new Pause(this);
        ende = new Ende(this);

        timer = new Timer();
        gesamtdurchlauf = 0;

        fenster.showPanel(startPanel);
    }

    public void starteSession() {
        session = startPanel.getSessionInfos();
        unterrichtsZeit = Einstellungen.LAENGESESSION;
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (unterrichtsZeit == 0) this.cancel();
                unterrichtsZeit--;
                fenster.updateMinuten(unterrichtsZeit);
            }
        };
        timer.schedule(task, 0, 1000);
        starteNeuenZyklus();
    }

    void starteNeuenZyklus() {
        System.out.println("starte Neuen Zyklus Called");
        gesamtdurchlauf++;
        fenster.updateGesamtdurchlauf(gesamtdurchlauf);
        session.resetRandomGenerator();
        observationManager.starteMakrozyklus();

    }

    void zyklusAbgeschlossen() {
        if (gesamtdurchlauf < Einstellungen.MAKROZYKLUS) {
            fenster.showPanel(helmke);
        } else {
            System.out.println(session);
            for (SchuelerModel s: session.arrschueler) {
                System.out.println(s);
            }
            fenster.showPanel(ende);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Pause::Weiter")) {
            starteNeuenZyklus();
        } else if (e.getActionCommand().equals("StartPanel::Weiter")) {
            if (startPanel.inputIsValid()) {
                starteSession();
            } else {
                startPanel.alert();
            }
        }
    }
}
