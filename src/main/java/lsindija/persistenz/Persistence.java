package lsindija.persistenz;

import lsindija.model.Rechtschreibtrainer;

public class Persistence {
    private PersistenceMethod persistenceMethod;
    public Persistence() {
        this.persistenceMethod = new JSONSave();
    }

    public Rechtschreibtrainer load() {
        return persistenceMethod.load();
    }

    public void save(Rechtschreibtrainer trainer) {
        persistenceMethod.save(trainer);
    }

}
