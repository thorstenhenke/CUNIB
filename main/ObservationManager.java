package main;

import model.DecisionGraph;
import model.Einstellungen;
import model.SchuelerModel;
import model.SessionModel;
import panels.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ObservationManager implements ActionListener
{

    private final SessionManager sessionManager;
    private final DecisionGraph decisionManager;
    private final ActionListener timerTask;
    private final Fenster fenster;

    // Panel
    private final AusgewaehlterSchueler schuelerPanel;
    private final BeobPanel beobachtPanel;
    private final WartePanel wartePanel;
    private final AbstractCustomPanel startPanel;

    // Statevariablen
    private SchuelerModel aktuellerSchueler;
    private volatile int zeit;
    private int durchgaenge;


    public ObservationManager(Fenster f, SessionManager sessionManager)
    {
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

        timerTask = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                fenster.updateSekunden(zeit);
                beobachtPanel.updateTime(zeit);
                wartePanel.updateTime(zeit);
                if (zeit == Einstellungen.LAENGEBEOBACHTUNG) {
                    fenster.showPanel(startPanel);
                }
                if (zeit > 0) {
                    zeit--;
                } else {
                    ((Timer) e.getSource()).stop();
                    zeitIstAbgelaufen();
                }
            }
        };
    }

    void starteSchuelerZyklus()
    {
        SessionModel sm = sessionManager.session; // singleton??
        aktuellerSchueler = sm.ziehe();
        fenster.updateSchuelerAnzahl(sm.anzahlGetesteterSchueler(), sm.arrschueler.length);
        fenster.updateSchuelerDaten(aktuellerSchueler);
        schuelerPanel.updateSchuelerDaten(aktuellerSchueler);
        fenster.showPanel(schuelerPanel);
    }

    void starteBeobachtungsZyklus()
    {
        durchgaenge++;
        fenster.updateSchuelerdurchlauf(durchgaenge);
        zeit = Einstellungen.LAENGEBEOBACHTUNG + Einstellungen.LAENGEEINTRAGEN;
        decisionManager.reset();

        // Neuerzeugen von Timer und sleep verhindern -10 Problem
        Timer beobachtungsTimer = new Timer(1000, timerTask);
        beobachtungsTimer.setInitialDelay(0);
        beobachtungsTimer.start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fenster.showPanel(beobachtPanel);
    }

    void eintragenIstAbgeschlossen()
    {
        fenster.zurueck.setVisible(false);
        if (zeit <= 0) {
            beobachtungIstAbgeschlossen();
        } else {
            fenster.showPanel(wartePanel);
        }
    }

    void zeitIstAbgelaufen()
    {
        if (decisionManager.reachedEnd()) {
            beobachtungIstAbgeschlossen();
        }
    }

    void beobachtungIstAbgeschlossen()
    {
        aktuellerSchueler.addBeobachtung(decisionManager.getHistory());
        if (durchgaenge < Einstellungen.MIKROZYKLUS) {
            starteBeobachtungsZyklus();
        } else {
            sessionManager.schuelerIstAbgeschlossen();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("AusgewaehlterSchueler::Weiter")) {
            durchgaenge = 0;
            starteBeobachtungsZyklus();
        } else if (e.getActionCommand().equals("Fenster::Zurueck")) {
            decisionManager.rollback();
            fenster.showPanel(decisionManager.actualState().panel);
        } else {
            decisionManager.next(e.getActionCommand());
            if (decisionManager.reachedEnd()) {
                eintragenIstAbgeschlossen();
            } else {
                fenster.zurueck.setVisible(true);
                fenster.showPanel(decisionManager.actualState().panel);
            }
        }
    }

    private DecisionGraph initializeDecisionManager(DecisionGraph decisionManager)
    {
        AbstractCustomPanel inhalt = new Inhalt(this);
        AbstractCustomPanel lernkontext = new Lernkontext(this);
        AbstractCustomPanel individuell = new Individuell(this);
        AbstractCustomPanel gesamteKlasse = new GesamteKlasse(this);
        AbstractCustomPanel leitung = new Leitung(this);
        AbstractCustomPanel gruppeAnzahl = new GruppeAnzahl(this);
        AbstractCustomPanel gemeinsam = new GemeinsameArbeit(this);
        AbstractCustomPanel interaktion = new Interaktion(this);
        AbstractCustomPanel erwachsener = new Erwachsener(this);
        AbstractCustomPanel qualitaet = new Qualitaet(this);

        decisionManager.addRelation(inhalt, "auf", lernkontext);
        decisionManager.addRelation(inhalt, "nau", lernkontext);
        decisionManager.addRelation(inhalt, "LEER", null);


        decisionManager.addRelation(lernkontext, "ind", individuell);
        decisionManager.addRelation(lernkontext, "ges", gesamteKlasse);
        decisionManager.addRelation(lernkontext, "par", leitung);
        decisionManager.addRelation(lernkontext, "gru", gruppeAnzahl); // muss zuerst abgefragt werden

        decisionManager.addRelation(individuell, "all", null);
        decisionManager.addRelation(individuell, "kl", erwachsener);
        decisionManager.addRelation(individuell, "lk", erwachsener);
        decisionManager.addRelation(individuell, "akk", interaktion);
        decisionManager.addRelation(individuell, "kak", interaktion);

        decisionManager.addRelation(gesamteKlasse, "tei", null);
        decisionManager.addRelation(gesamteKlasse, "vor", interaktion);

        decisionManager.addRelation(gesamteKlasse, "kl", erwachsener);
        decisionManager.addRelation(gesamteKlasse, "lk", erwachsener);
        decisionManager.addRelation(gesamteKlasse, "kak", interaktion);
        decisionManager.addRelation(gesamteKlasse, "akk", interaktion);

        decisionManager.addRelation(gruppeAnzahl, "*", leitung);

        decisionManager.addRelation(leitung, "kgl", gemeinsam);
        decisionManager.addRelation(leitung, "lgl", gemeinsam);

        decisionManager.addRelation(gemeinsam, "all", null);
        decisionManager.addRelation(gemeinsam, "tei", null);
        decisionManager.addRelation(gemeinsam, "non", null);
        decisionManager.addRelation(gemeinsam, "kl", erwachsener);
        decisionManager.addRelation(gemeinsam, "lk", erwachsener);
        decisionManager.addRelation(gemeinsam, "akk", interaktion);
        decisionManager.addRelation(gemeinsam, "kak", interaktion);

        decisionManager.addRelation(erwachsener, "*", interaktion);

        decisionManager.addRelation(interaktion, "*", qualitaet);

        decisionManager.addRelation(qualitaet, "*", null);


        // TODO Unschoen! Besser nach oben
        decisionManager.setAsStart(inhalt);

        return decisionManager;
    }
}


