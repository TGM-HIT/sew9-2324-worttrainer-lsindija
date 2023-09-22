package lsindija.model;

import java.util.Random;

/**
 * Die Worttrainer Model Klasse
 * @author Leon Sindija
 * @version 2023-09-22
 */
public class Rechtschreibtrainer {
    private Wort[] woerter;
    private Wort ausgewaehlt;

    private int richtig;
    private int gesamt;


    /**
     * Das Worttrainer Spiel wird erstellt
     */
    public Rechtschreibtrainer() {
        this.richtig = 0;
        this.gesamt = 0;
    }

    /**
     * Es wird ein bestimmtes Wort anhand von einem Index ausgewählt
     * @param index Der Index des Worts welches ausgewählt werden soll
     */
    public void auswaehlen(int index) {
        ausgewaehlt = woerter[index];
    }

    /**
     * Es wird ein zufälliges Wort aus der Wortliste ausgewählt
     */
    public void auswaehlen() {
        Random random = new Random();
        int index = random.nextInt(woerter.length);
        auswaehlen(index);
    }

    /**
     * Es wird überprüft ob das übergebene Wort mit dem ausgewählten Wort übereinstimmt
     * @param wort Das Wort welches mit dem ausgewählten Wort verglichen werden soll
     * @return Ob das übergebene Wort mit dem ausgewählten Wort übereinstimmt
     */
    public boolean check(String wort) {
        if(ausgewaehlt == null) return false;

        gesamt += 1;
        if(ausgewaehlt.getWort().equals(wort)) {
            auswaehlen();
            richtig += 1;
            return true;
        }
        return false;
    }

    /**
     * Gibt die Wortliste zurück
     * @return Die Wortliste
     */
    public Wort[] getWoerter() {
        return woerter;
    }

    /**
     * Setzt die Wortliste
     * @param woerter Die neue Wortliste
     */
    public void setWoerter(Wort[] woerter) {
        this.woerter = woerter;
    }

    /**
     * Gibt das ausgewählte Wort zurück
     * @return Das ausgewählte Wort
     */
    public Wort getAusgewaehlt() {
        return ausgewaehlt;
    }


    /**
     * Setzt die Anzahl des Richtig-Zählers
     * @param richtig Die neue Anzahl
     */
    public void setRichtig(int richtig) {
        this.richtig = richtig;
    }

    /**
     * Setzt die Anzahl des Gesamt-Zählers
     * @param gesamt Die neue Anzahl
     */
    public void setGesamt(int gesamt) {
        this.gesamt = gesamt;
    }

    /**
     * Gibt den Richtig-Zähler zurück
     * @return Den Richtig-Zähler
     */
    public int getRichtig() {
        return richtig;
    }

    /**
     * Gibt den Gesamt-Zähler zurück
     * @return Den Gesamt-Zähler
     */
    public int getGesamt() {
        return gesamt;
    }

    /**
     * Errechnet den Falsch-Zähler und gibt diesen zurück
     * @return Den errechneten Falsch-Zähler
     */
    public int getFalsch() {
        return gesamt-richtig;
    }

    /**
     * Gibt die Statistik in String-Form zurück
     * @return Die Statistik in String-Form
     */
    public String getStatistik() {
        return "Statistik\nGesamt: "+getGesamt()+"\nRichtig: "+getRichtig()+"\nFalsch:"+getFalsch();
    }
}
