package lsindija.persistenz;

import lsindija.model.Rechtschreibtrainer;
import lsindija.model.Wort;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Diese Speichermethode speichert Daten über JSON Files
 * @author Leon Sindija
 * @version 2023-09-22
 */
public class JSONSave implements PersistenceMethod {

    /**
     * Ladet den gespeicherten Worttrainer
     * @return Den geladenen Worttrainer
     */
    @Override
    public Rechtschreibtrainer load() {
        JSONObject jsonObject;
        Rechtschreibtrainer trainer = new Rechtschreibtrainer();
        try {
            jsonObject = new JSONObject(new String(Files.readAllBytes(Paths.get(new File("save.json").toURI()))));
            trainer.setGesamt(jsonObject.getInt("gesamt"));
            trainer.setRichtig(jsonObject.getInt("richtig"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Spielstand konnte nicht geladen werden. Es wird ein neuer Spielstand erstellt.");
            e.printStackTrace();
        }
        return trainer;
    }

    /**
     * @see PersistenceMethod#save(Rechtschreibtrainer) 
     * Speichert den Worttrainer
     * @param trainer Der Worttrainer der gespeichert werden soll
     */
    @Override
    public void save(Rechtschreibtrainer trainer) {
        JSONObject trainerObject = new JSONObject();
        trainerObject.put("richtig",trainer.getRichtig());
        trainerObject.put("gesamt",trainer.getGesamt());

        JSONObject trainerObject2 = new JSONObject();
        trainerObject2.put("trainer",trainer);

        try {
            File jsonFile = new File("save.json");
            FileWriter writer = new FileWriter(jsonFile);
            writer.write(trainerObject.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Es ist ein Fehler beim Speichern aufgetreten");
            e.printStackTrace();
        }

    }
}
