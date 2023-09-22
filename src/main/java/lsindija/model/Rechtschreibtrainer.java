package lsindija.model;

import java.util.Random;

public class Rechtschreibtrainer {
    private Wort[] woerter;
    private Wort ausgewaehlt;

    private int richtig;
    private int gesamt;


    public Rechtschreibtrainer() {
        this.richtig = 0;
        this.gesamt = 0;
    }

    public void auswaehlen(int index) {
        ausgewaehlt = woerter[index];
    }

    public void auswaehlen() {
        Random random = new Random();
        int index = random.nextInt(woerter.length);
        auswaehlen(index);
    }

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

    public Wort[] getWoerter() {
        return woerter;
    }

    public void setWoerter(Wort[] woerter) {
        this.woerter = woerter;
    }

    public Wort getAusgewaehlt() {
        return ausgewaehlt;
    }

    public void setAusgewaehlt(Wort ausgewaehlt) {
        this.ausgewaehlt = ausgewaehlt;
    }

    public void setRichtig(int richtig) {
        this.richtig = richtig;
    }

    public void setGesamt(int gesamt) {
        this.gesamt = gesamt;
    }

    public int getRichtig() {
        return richtig;
    }

    public int getGesamt() {
        return gesamt;
    }

    public int getFalsch() {
        return gesamt-richtig;
    }

    public String getStatistik() {
        return "Statistik\nGesamt: "+getGesamt()+"\nRichtig: "+getRichtig()+"\nFalsch:"+getFalsch();
    }
}
