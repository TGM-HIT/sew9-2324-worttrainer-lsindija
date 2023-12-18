import lsindija.model.Rechtschreibtrainer;
import lsindija.model.Wort;
import lsindija.persistenz.Persistence;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class PersistenceTests {
    // Testet, ob das Speichern eines Rechtschreibtrainer-Objekts erfolgreich ist
    @Test
    public void checkSuccessfulSave() {
        Rechtschreibtrainer trainer = new Rechtschreibtrainer(); // Erstellen eines neuen Rechtschreibtrainer-Objekts
        Persistence persistence = new Persistence(); // Erstellen eines Persistence-Objekts für das Speichern und Laden
        persistence.save(trainer);  // Speichern des Rechtschreibtrainer-Objekts

        // Überprüfen, ob die Datei existiert
        File file = new File("save.json");
        assertTrue(file.exists());
    }

    // Testet, ob das Laden eines Rechtschreibtrainer-Objekts erfolgreich ist
    @Test
    public void checkSuccessfulLoad() {
        // Erstellen und Konfigurieren eines Rechtschreibtrainer-Objekts
        Rechtschreibtrainer trainer1 = new Rechtschreibtrainer();
        trainer1.setWoerter(new Wort[]{new Wort("abcd","abcd")});
        trainer1.setGesamt(10);
        trainer1.setRichtig(5);

        // Speichern des konfigurierten Rechtschreibtrainer-Objekts
        Persistence persistence = new Persistence();
        persistence.save(trainer1);

        // Laden des Rechtschreibtrainer-Objekts
        Rechtschreibtrainer trainer2 = persistence.load();

        // Überprüfen, ob die geladenen Daten mit den gespeicherten übereinstimmen
        assertEquals(trainer2.getGesamt(), 10);
        assertEquals(trainer2.getRichtig(), 5);
    }
}
