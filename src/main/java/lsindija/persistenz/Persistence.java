package lsindija.persistenz;

import lsindija.model.Rechtschreibtrainer;

/**
 * Eine Klasse die für das Speichern und Laden des Worttrainers verantwortlich ist
 * @author Leon Sindija
 * @version 2023-09-22
 */
public class Persistence {
    private PersistenceMethod persistenceMethod;

    /**
     * Initialisiert die Persistenz Klasse mit der JSON-Speichermethode
     */
    public Persistence() {
        this.persistenceMethod = new JSONSave();
    }

    /**
     * Ladet den gespeicherten Worttrainer
     * @return Den geladenen Worttrainer
     */
    public Rechtschreibtrainer load() {
        return persistenceMethod.load();
    }

    /**
     * Speichert den Worttrainer
     * @param trainer Der Worttrainer der gespeichert werden soll
     */
    public void save(Rechtschreibtrainer trainer) {
        persistenceMethod.save(trainer);
    }

}
