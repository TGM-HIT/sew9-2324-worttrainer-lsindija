import lsindija.model.Rechtschreibtrainer;
import lsindija.model.Wort;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModelTests {
    // Instanzvariable für den Rechtschreibtrainer
    private Rechtschreibtrainer trainer;
    // Statische Variable für die Wortliste, die in allen Tests verwendet wird
    private static Wort[] wortliste;

    // Diese Methode wird einmal vor allen Tests ausgeführt, um die Wortliste zu initialisieren
    @BeforeAll
    public static void generateWortliste() {
        wortliste = new Wort[]{
                new Wort("Apfel","https://images.eatsmarter.de/sites/default/files/styles/576x432/public/apfel-576x432.jpg"),
                new Wort("Banane","https://www.kindersache.de/sites/default/files/styles/teaser/public/banana-42793_1280.jpg?itok=TbRV17I6")
        };
    }

    // Diese Methode wird vor jedem Test ausgeführt, um einen frischen Rechtschreibtrainer zu erstellen
    @BeforeEach
    public void generateWorttrainer() {
        trainer = new Rechtschreibtrainer();
        trainer.setWoerter(wortliste);
    }

    // Testet, ob ein neu erstellter Rechtschreibtrainer korrekte Anfangswerte hat
    @Test
    public void testNewWorttrainer() {
        assertEquals(trainer.getRichtig(), 0);
        assertEquals(trainer.getGesamt(), 0);
    }

    // Testet die Logik zur Berechnung der Anzahl falscher Antworten
    @Test
    public void testGesamt() {
        trainer.setRichtig(2);
        trainer.setGesamt(4);
        assertEquals(trainer.getFalsch(), 2);
    }

    // Testet die Überprüfungsfunktion des Rechtschreibtrainers
    @Test
    public void testCheck() {
        trainer.auswaehlen(0);
        assertTrue(trainer.check("Apfel"));
        assertFalse(trainer.check("Banane"));
    }

    // Testet die Funktionalität der Wortklasse
    @Test
    public void testWort() {
        Wort wort = new Wort("Test", "https://www.coolebilder.at/testbild");
        assertEquals(wort.getWort(),"Test");
        assertEquals(wort.getImage(),"https://www.coolebilder.at/testbild");
    }
}
