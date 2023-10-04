import lsindija.model.Rechtschreibtrainer;
import lsindija.model.Wort;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModelTests {
    private Rechtschreibtrainer trainer;
    private static Wort[] wortliste;

    @BeforeAll
    public static void generateWortliste() {
        wortliste = new Wort[]{new Wort("Apfel","https://images.eatsmarter.de/sites/default/files/styles/576x432/public/apfel-576x432.jpg"),new Wort("Banane","https://www.kindersache.de/sites/default/files/styles/teaser/public/banana-42793_1280.jpg?itok=TbRV17I6")};
    }

    @BeforeEach
    public void generateWorttrainer() {
        trainer = new Rechtschreibtrainer();
        trainer.setWoerter(wortliste);
    }

    @Test
    public void testNewWorttrainer() {
        assertEquals(trainer.getRichtig(), 0);
        assertEquals(trainer.getGesamt(), 0);
    }

    @Test
    public void testGesamt() {
        trainer.setRichtig(2);
        trainer.setGesamt(4);
        assertEquals(trainer.getFalsch(), 2);
    }

    @Test
    public void testCheck() {
        trainer.auswaehlen(0);
        assertTrue(trainer.check("Apfel"));
        assertFalse(trainer.check("Banane"));
    }

    @Test
    public void testWort() {
        Wort wort = new Wort("Test", "https://www.coolebilder.at/testbild");
        assertEquals(wort.getWort(),"Test");
        assertEquals(wort.getImage(),"https://www.coolebilder.at/testbild");
    }
}
