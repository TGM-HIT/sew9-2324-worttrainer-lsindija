package lsindija.persistenz;

import lsindija.model.Rechtschreibtrainer;

public interface PersistenceMethod {
    public Rechtschreibtrainer load();
    public void save(Rechtschreibtrainer trainer);
}
