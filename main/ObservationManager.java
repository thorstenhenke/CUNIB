package main;


import model.DecisionGraph;
import model.Einstellungen;
import model.SchuelerModel;
import panels.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ObservationManager implements ActionListener {

    private SessionManager sessionManager;
    private DecisionGraph decisionManager;
    private Fenster fenster;

    final Timer t;

    // Panel
    private AusgewaehlterSchueler schuelerPanel;
    private BeobPanel beobachtPanel;
    private WartePanel wartePanel;

    // Statevariablen
    private SchuelerModel aktuellerSchuelerModell;
    private int zeit;
    private int intervalle;

    public ObservationManager(Fenster f, SessionManager sessionManager) {
        // TODO callbacks ggf durch interne Zustände abfangen

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

        //Diverse Timer :)
        t = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fenster.updateSekunden(zeit);
                beobachtPanel.updateTime(zeit);
                wartePanel.updateTime(zeit);
                System.out.println("Zeit " + zeit);
                if (zeit <= 1) {
                    zeit = 0;
                    t.stop();
                    trageein();
                } else {
                    zeit--;
                }
            }
        });
        t.setInitialDelay(0);

    }

    void starteMakrozyklus() {
        if (sessionManager.session.hasMoreSchueler()) {
            aktuellerSchuelerModell = sessionManager.session.ziehe();
            fenster.updateSchuelerDaten(aktuellerSchuelerModell);
            fenster.updateSchuelerAnzahl(sessionManager.session.anzahlGetesteterSchueler(), sessionManager.session.arrschueler.length);
            schuelerPanel.updateSchuelerDaten(aktuellerSchuelerModell);
            fenster.showPanel(schuelerPanel);
        } else {
            sessionManager.zyklusAbgeschlossen(); // callback
        }
    }

    void starteMiniZyklus() {
        if (intervalle < Einstellungen.MIKROZYKLUS) {
            intervalle++;
            this.zeit = Einstellungen.LAENGEBEOBACHTUNG + Einstellungen.LAENGEEINTRAGEN;
            t.start(); // <= ???
            System.out.println("t.start() => " + zeit);
            beobachte();
        } else {
            starteMakrozyklus(); // callback
        }
    }

    void beobachte() {
        Timer b = new Timer(1000 * Einstellungen.LAENGEBEOBACHTUNG, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trageein();
            }
        });
        b.setRepeats(false);
        b.start();
        fenster.updateSchuelerdurchlauf(intervalle);
        decisionManager.reset();
        fenster.showPanel(beobachtPanel);
    }

    void trageein() {
        AbstractCustomPanel actualPanel = decisionManager.actualState().panel;
        if (actualPanel == null) {
            fenster.zurueck.setVisible(false);
            if (zeit == 0) {
                System.out.println("Trage ein");
                aktuellerSchuelerModell.addBeobachtung(decisionManager.getHistory());
                decisionManager.resetHistory();
                starteMiniZyklus(); // callback
            } else { // zeit > 0
                fenster.showPanel(wartePanel);
            }
        } else {
            fenster.zurueck.setVisible(true);
            fenster.showPanel(actualPanel);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("AusgewaehlterSchueler::Weiter")) {
            intervalle = 0;
            starteMiniZyklus();
        } else if (e.getActionCommand().equals("Fenster::Zurueck")) {
            decisionManager.rollback();
            trageein();
        } else {
            decisionManager.next(e.getActionCommand());
            trageein();
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
