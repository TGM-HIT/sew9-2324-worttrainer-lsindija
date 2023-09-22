package lsindija.persistenz;

import lsindija.model.Rechtschreibtrainer;

/**
 * Ein Interface welches von den unterschiedlichen Speichermethoden implementiert werden soll
 */
public interface PersistenceMethod {

    /**
     * Ladet den gespeicherten Worttrainer
     * @return Den geladenen Worttrainer
     */
    public Rechtschreibtrainer load();

    /**
     * Speichert den Worttrainer
     * @param trainer Der Worttrainer der gespeichert werden soll
     */
    public void save(Rechtschreibtrainer trainer);
}
