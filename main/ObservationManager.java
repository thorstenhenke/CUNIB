package main;


import model.DecisionGraph;
import model.Einstellungen;
import model.SchuelerModel;
import model.SessionModel;
import panels.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Timer;
//import java.util.TimerTask;

public class ObservationManager implements ActionListener {

    private final SessionManager sessionManager;
    private final DecisionGraph decisionManager;
    private final Fenster fenster;

    // Panel
    private final AusgewaehlterSchueler schuelerPanel;
    private final BeobPanel beobachtPanel;
    private final WartePanel wartePanel;
    private final AbstractCustomPanel startPanel;

    // Statevariablen
    private SchuelerModel aktuellerSchueler;
    private volatile int zeit;
    private int intervalle;

    // Stuff
    private final ActionListener l;
    private final Timer t;
    //private final Timer t;

    public ObservationManager(Fenster f, SessionManager sessionManager) {
        this.fenster = f;
        this.sessionManager = sessionManager;
        this.decisionManager = initializeDecisionManager(new DecisionGraph());

        // Zurueck
        fenster.zurueck.setActionCommand("Fenster::Zurueck");
        fenster.zurueck.addActionListener(this);

        // Panel
        schuelerPanel = new AusgewaehlterSchueler(this);
        beobachtPanel = new BeobPanel();
        wartePanel = new WartePanel(this);
        startPanel = decisionManager.actualState().panel;

        //t = new Timer();
        /**
         * Versuche
*/
        l = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(zeit);
                //fenster.updateSekunden(zeit);
                beobachtPanel.updateTime(zeit);
                //wartePanel.updateTime(zeit);
                if (zeit > 0) {
                    zeit--;
                } else {
                    ((Timer) e.getSource()).stop();
                    zeitIstAbgelaufen();
                }
                if (zeit == Einstellungen.LAENGEBEOBACHTUNG) {
                    fenster.showPanel(startPanel);
                }
            }
        };
        t = new Timer(1000, l);
        t.setInitialDelay(0);

    }

    void starteMakrozyklus() {
        SessionModel sm = sessionManager.session;
        aktuellerSchueler = sm.ziehe(); // TODO global
        // alle benachrichtigen => ggf mit dem Pattern (Javaeigener Observer??)
        fenster.updateSchuelerAnzahl(sm.anzahlGetesteterSchueler(), sm.arrschueler.length);
        fenster.updateSchuelerDaten(aktuellerSchueler);
        schuelerPanel.updateSchuelerDaten(aktuellerSchueler);
        fenster.showPanel(schuelerPanel);
    }

    void starteMinizyklus()  {
        intervalle++;
        zeit = Einstellungen.LAENGEBEOBACHTUNG + Einstellungen.LAENGEEINTRAGEN;
        decisionManager.reset();
        // ggf nach oben wg Performance
        fenster.showPanel(beobachtPanel);
        t.restart();
        /**
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(zeit);
                if (zeit > 0) {
                    zeit--;
                } else {
                    zeitIstAbgelaufen();
                    this.cancel();
                }
                if (zeit == Einstellungen.LAENGEBEOBACHTUNG) {
                    fenster.showPanel(startPanel);
                }
            }
        },1000,1000);
         **/
    }

    void eintragenIstAbgeschlossen() {
        if (zeit <= 0) {
            intervalEnde();
        } else {
            fenster.showPanel(wartePanel);
        }
    }

    void zeitIstAbgelaufen() {
        if (decisionManager.reachedEnd()) {
            intervalEnde();
        }
    }

    void intervalEnde() {
        if (intervalle < Einstellungen.MIKROZYKLUS) {
            aktuellerSchueler.addBeobachtung(decisionManager.getHistory());
            starteMinizyklus();
        } else {
            schuelerIstAbgeschlossen();
        }
    }

    void schuelerIstAbgeschlossen() {
        if (sessionManager.session.hasMoreSchueler()) {
            starteMakrozyklus();
        } else {
            sessionManager.zyklusAbgeschlossen();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("AusgewaehlterSchueler::Weiter")) {
            intervalle = 0;
            starteMinizyklus();
        } else if (e.getActionCommand().equals("Fenster::Zurueck")) {
            decisionManager.rollback();
            fenster.showPanel(decisionManager.actualState().panel);
        } else { // Alle Buttonereignisse von den Panels
            decisionManager.next(e.getActionCommand());
            if (decisionManager.reachedEnd()) {
                eintragenIstAbgeschlossen();
            } else {
                fenster.zurueck.setVisible(true);
                fenster.showPanel(decisionManager.actualState().panel);
            }
        }
    }


    private DecisionGraph initializeDecisionManager(DecisionGraph decisionManager) {
        AbstractCustomPanel inhalt = new Inhalt(this);
        AbstractCustomPanel lernkontext = new Lernkontext(this);
        AbstractCustomPanel individuell = new Individuell(this);
        AbstractCustomPanel gesamteKlasse = new GesamteKlasse(this);
        AbstractCustomPanel partnerarbeit = new Partnerarbeit(this);
        AbstractCustomPanel gruppenArbeit = new Gruppenarbeit(this);
        AbstractCustomPanel gruppeAnzahl = new GruppeAnzahl(this);
        AbstractCustomPanel kindGeleitet = new KindGeleitet(this);
        AbstractCustomPanel lehrerGeleitet = new LehrerGeleitet(this);
        AbstractCustomPanel interaktion = new Interaktion(this);
        AbstractCustomPanel qualitaet = new Qualitaet(this);

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

        //##
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

        // TODO Unschoen! Besser nach oben
        decisionManager.setAsStart(inhalt);

        return decisionManager;
    }
}


