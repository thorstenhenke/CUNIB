package main;

import model.Beobachtungseinheit;
import model.Einstellungen;
import panels.Ende;
import panels.Helmke;
import panels.StartPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;


public class SessionManager implements ActionListener{

    // Panel
    private StartPanel startPanel;
    private Helmke helmke;
    private Ende ende;

    Beobachtungseinheit session;
    Fenster fenster;
    ObservationManager observationManager;

    // State
    private Timer timer;
    private int unterrichtsZeit;
    private int gesamtdurchlauf;

    SessionManager(Fenster fenster) {
        startPanel = new StartPanel(this);
        helmke = new Helmke(this);
        ende = new Ende(this);


        timer = new Timer();
        this.fenster = fenster;
        observationManager = new ObservationManager(fenster, this);

        gesamtdurchlauf = 0;

        fenster.showPanel(startPanel);
    }

    void zyklusAbgeschlossen() {
        if (gesamtdurchlauf < Einstellungen.MAKROZYKLUS) {
            // Helmke zwischeendrin noch zeigen
            starteNeuenZyklus();
        } else {
            //ende
        }
    }

    void starteNeuenZyklus() {
        fenster.updateGesamtdurchlauf(gesamtdurchlauf);
        session.resetRandomGenerator();
        observationManager.neueBeobachtung();
        gesamtdurchlauf++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("starteSession")) {
            if (startPanel.inputIsValid()) {
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
            } else {
                startPanel.alert();
            }
        }
    }
}
