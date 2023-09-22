package lsindija;

import lsindija.gui.WorttrainerFrame;
import lsindija.model.Rechtschreibtrainer;
import lsindija.model.Wort;
import lsindija.persistenz.Persistence;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Persistence persistence = new Persistence();
        Rechtschreibtrainer trainer = persistence.load();
        trainer.auswaehlen();

        String[] options = {"Abschicken", "Beenden"};
        boolean beendet = false;

        WorttrainerFrame frame = new WorttrainerFrame(trainer);
        while(!beendet) {
            frame.setImage(trainer.getAusgewaehlt().getImage());
        }
    }
}
