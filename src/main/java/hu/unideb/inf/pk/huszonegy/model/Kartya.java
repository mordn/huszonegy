package hu.unideb.inf.pk.huszonegy.model;
/**
 * Egy kártyalap modell osztálya.
 *
 * @author Bódis Gábor
 * @version 1.0
 * @since 2017-05-29
 */
public class Kartya {
    /**
     * A kártya sorszáma.
     */
    private int id;
    /**
     * A kártya értéke. 
     * Alsó = 2, Felső = 3, Király = 4, Ász = 11. A számozott kártyalapok értéke a számmal egyenértékű.
     */
    private int ertek;
    /**
     * A kártya színe. Lehet: Piros, Zöld, Makk, Tök.
     */
    private String szin;
    /**
     * A kártya Jele. Lehet: 7, 8, 9, 10, Alsó, Felső, Király, Ász.
     */
    private String jel;
    /**
     * Konstruktor paraméter nélküli példányosításhoz.
     */
    public Kartya() {
    }
    /**
     * Konstruktor paraméterekkel való példányosításhoz.
     * 
     * @param id A kártyalap sorszáma.
     * @param ertek A kártyalap értéke.
     * @param szin A kártyalap színe.
     * @param jel A kártyalap jele.
     */
    public Kartya(int id, int ertek, String szin, String jel) {
        this.id = id;
        this.ertek = ertek;
        this.szin = szin;
        this.jel = jel;
    }
    /**
     * Visszaadja a kártyalap sorszámát.
     * 
     * @return a kártya sorszáma.
     */
    public int getId() {
        return id;
    }
    /**
     * Beállítja a kártya sorszámát a paraméterül kapott sorszámra.
     * 
     * @param id A kártyalap sorszáma.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Visszaadja a kártyalap értékét.
     * 
     * @return A kártyalap értéke.
     */
    public int getErtek() {
        return ertek;
    }
    /**
     * Beállítja a kártya értékét a paraméterül kapott értékre.
     * 
     * @param ertek A kártyalap értéke.
     */
    public void setErtek(int ertek) {
        this.ertek = ertek;
    }
    /**
     * Visszaadja a kártyalap színét.
     * 
     * @return A kártyalap színe.
     */
    public String getSzin() {
        return szin;
    }
    /**
     * Beállítja a kártyalap színét.
     * 
     * @param szin A kártyalap színe.
     */
    public void setSzin(String szin) {
        this.szin = szin;
    }
    /**
     * Visszaadja a kártyalap jelét.
     * 
     * @return A kártyalap értéke.
     */
    public String getJel() {
        return jel;
    }
    /**
     * Beálltja a kártyalap jelét.
     * 
     * @param jel A kártylap jele.
     */
    public void setJel(String jel) {
        this.jel = jel;
    }
    /**
     * A modell kiíratását biztosító metódus.
     * 
     * @return A kártya sorszáma, színe, jele és értéke szöveges formátumban.
     */
    @Override
    public String toString() {
        return "Kartya{"  + "szin=" + szin + ", jel=" + jel + ", ertek=" + ertek + '}';
    }  
}
