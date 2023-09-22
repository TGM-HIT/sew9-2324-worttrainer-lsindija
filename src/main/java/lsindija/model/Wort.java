package lsindija.model;

public class Wort {

    private String wort;
    private String image;

    public void setWort(String wort) {
        this.wort = wort;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Wort(String wort, String image) {
        this.wort = wort;
        this.image = image;
    }

    public String getWort() {
        return wort;
    }

    public String getImage() {
        return image;
    }

}
