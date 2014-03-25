package main;


import model.DecisionGraph;
import model.Einstellungen;
import model.Schueler;
import panels.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class ObservationManager implements ActionListener{

    SessionManager sessionManager;
    DecisionGraph decisionManager;
    Fenster fenster;

    // Panel
    AusgewaehlterSchueler schuelerPanel;
    BeobPanel beobachtPanel;
    WartePanel wartePanel;

    // Statevariablen
    Schueler aktuellerSchueler;
    int zeit;
    Timer timer;

    public ObservationManager(Fenster fenster, SessionManager sessionManager) {
        this.fenster = fenster;
        this.sessionManager = sessionManager;
        this.decisionManager = initializeDecisionManager(new DecisionGraph());
        this.timer = new Timer();
    }

    void neueBeobachtung() {
        if (sessionManager.session.hasMoreSchueler()) {
            aktuellerSchueler = sessionManager.session.ziehe();
            fenster.setSchuelerCode(aktuellerSchueler.schuelercode);
            fenster.setSchuelerBesonderheiten(aktuellerSchueler.besondereMerkmale);
            schuelerPanel.updateSchuelerDaten(aktuellerSchueler);
            fenster.showPanel(schuelerPanel);
        } else {
            // steige aus | callback
            sessionManager.zyklusAbgeschlossen();
        }
    }

    void starteZyklus() {
        zeit = Einstellungen.LAENGEBEOBACHTUNG + Einstellungen.LAENGEEINTRAGEN;
        TimerTask countdown = new TimerTask() {
            @Override
            public void run() {
                if (zeit == 0) {
                    this.cancel();
                } else {
                    // notify
                    zeit--;
                }
            }
        };
        timer.schedule(countdown, 0, 1000);
        beobachte();
    }

    void beobachte() {
        // panel
        TimerTask beobachteTask = new TimerTask() {
            @Override
            public void run() {
                eintragen();
                this.cancel();
            }
        };
        timer.schedule(beobachteTask, Einstellungen.LAENGEBEOBACHTUNG * 1000);
    }

    void eintragen() {
        AbstractFragePanel actualPanel = decisionManager.actualState().panel;
        if (actualPanel == null) {
            if (zeit > 0) {

            } else {
                
            }
        } else {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("starteBeobachtung")){
            starteZyklus();
        } else {
            decisionManager.next(e.getActionCommand());
            // alternative zum direkten Aufruf durch die Panel
        }
    }

    private DecisionGraph initializeDecisionManager(DecisionGraph decisionManager){
        AbstractFragePanel inhalt         = new Inhalt(fenster);
        AbstractFragePanel lernkontext    = new Lernkontext(fenster);
        AbstractFragePanel individuell    = new Individuell(fenster);
        AbstractFragePanel gesamteKlasse  = new GesamteKlasse(fenster);
        AbstractFragePanel partnerarbeit  = new Partnerarbeit(fenster);
        AbstractFragePanel gruppenArbeit  = new Gruppenarbeit(fenster);
        AbstractFragePanel gruppeAnzahl   = new GruppeAnzahl(fenster);
        AbstractFragePanel kindGeleitet   = new KindGeleitet(fenster);
        AbstractFragePanel lehrerGeleitet = new LehrerGeleitet(fenster);
        AbstractFragePanel interaktion    = new Interaktion(fenster);
        AbstractFragePanel qualitaet      = new Qualitaet(fenster);

        decisionManager.addRelation(inhalt, "auf", lernkontext);
        decisionManager.addRelation(inhalt, "nau", lernkontext);

        decisionManager.addRelation(lernkontext, "ind", individuell);
        decisionManager.addRelation(lernkontext, "ges", gesamteKlasse);
        decisionManager.addRelation(lernkontext, "par", partnerarbeit);
        decisionManager.addRelation(lernkontext, "gru", gruppeAnzahl); // muss zuerst abgefragt werden

        decisionManager.addRelation(individuell, "all", null);
        decisionManager.addRelation(individuell, "kl1", interaktion);
        decisionManager.addRelation(individuell, "kl2", interaktion);
        decisionManager.addRelation(individuell, "l1k", interaktion);
        decisionManager.addRelation(individuell, "l2k", interaktion);
        decisionManager.addRelation(individuell, "akk", interaktion);
        decisionManager.addRelation(individuell, "kak", interaktion);

        decisionManager.addRelation(gesamteKlasse, "tei", null);
        decisionManager.addRelation(gesamteKlasse, "vor", interaktion);
        decisionManager.addRelation(gesamteKlasse, "kl1", interaktion);
        decisionManager.addRelation(gesamteKlasse, "kl2", interaktion);
        decisionManager.addRelation(gesamteKlasse, "l1k", interaktion);
        decisionManager.addRelation(gesamteKlasse, "l2k", interaktion);
        decisionManager.addRelation(gesamteKlasse, "kak", interaktion);
        decisionManager.addRelation(gesamteKlasse, "akk", interaktion);

        decisionManager.addRelation(partnerarbeit, "kil", kindGeleitet);
        decisionManager.addRelation(partnerarbeit, "l1l", lehrerGeleitet);
        decisionManager.addRelation(partnerarbeit, "l2l", lehrerGeleitet);

        decisionManager.addRelation(gruppeAnzahl, "*", gruppenArbeit);

        decisionManager.addRelation(gruppenArbeit, "kil", kindGeleitet);
        decisionManager.addRelation(gruppenArbeit, "l1l", lehrerGeleitet);
        decisionManager.addRelation(gruppenArbeit, "l2l", lehrerGeleitet);

        decisionManager.addRelation(kindGeleitet, "all", null);
        decisionManager.addRelation(kindGeleitet, "non", null);
        decisionManager.addRelation(kindGeleitet, "kak", interaktion);
        decisionManager.addRelation(kindGeleitet, "akk", interaktion);

        decisionManager.addRelation(lehrerGeleitet, "all", null);
        decisionManager.addRelation(lehrerGeleitet, "tei", null);
        decisionManager.addRelation(lehrerGeleitet, "non", null);
        decisionManager.addRelation(lehrerGeleitet, "kil", interaktion);
        decisionManager.addRelation(lehrerGeleitet, "lek", interaktion);
        decisionManager.addRelation(lehrerGeleitet, "akk", interaktion);
        decisionManager.addRelation(lehrerGeleitet, "kak", interaktion);

        decisionManager.addRelation(interaktion, "lan", qualitaet);
        decisionManager.addRelation(interaktion, "kur", qualitaet);

        decisionManager.addRelation(qualitaet, "nic", null);
        decisionManager.addRelation(qualitaet, "hoc", null);
        decisionManager.addRelation(qualitaet, "nor", null);

        decisionManager.setAsStart(inhalt);
        return decisionManager;
    }

}
