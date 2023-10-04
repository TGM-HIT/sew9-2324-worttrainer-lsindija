import lsindija.model.Rechtschreibtrainer;
import lsindija.model.Wort;
import lsindija.persistenz.Persistence;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class PersistenceTests {
    @Test
    public void checkSuccessfulSave() {
        Rechtschreibtrainer trainer = new Rechtschreibtrainer();
        Persistence persistence = new Persistence();
        persistence.save(trainer);
        File file = new File("save.json");
        assertTrue(file.exists());
    }

    @Test
    public void checkSuccessfulLoad() {
        Rechtschreibtrainer trainer1 = new Rechtschreibtrainer();
        trainer1.setWoerter(new Wort[]{new Wort("abcd","abcd")});
        trainer1.setGesamt(10);
        trainer1.setRichtig(5);
        Persistence persistence = new Persistence();
        persistence.save(trainer1);
        Rechtschreibtrainer trainer2 = persistence.load();
        assertEquals(trainer2.getGesamt(),10);
        assertEquals(trainer2.getRichtig(),5);
    }


}
