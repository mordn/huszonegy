package hu.unideb.inf.pk.huszonegy.controller;

import hu.unideb.inf.pk.huszonegy.model.Kartya;
import hu.unideb.inf.pk.huszonegy.model.Pakli;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A játék irányításáért felelős osztály.
 * A modell és a view kommunikációját biztosítja, valamint itt megy végbe az összes számolás.
 * 
 * @author Bódis Gábor
 * @version 1.0
 * @since 2017-05-29
 */
public class Controller {
    /**
     * A kártyapaklit tartalmazó objektum.
     * A játékos és a gép ebből "húz" a játék menete alatt.
     */
    private final Pakli kartyapakli = new Pakli();
    /**
     * A Controller osztály loggere.
     */
    private static Logger logger = LoggerFactory.getLogger(Controller.class);
    /**
     * A {@link Controller#kartyapakli}-ból kihúzott kátyalap. 
     */
    private Kartya kihuzott_kartya;
    /**
     * A {@link Controller#kartyapakli}-ból kihúzott kátyalap sorszáma.
     */
    private int huzott_lap_index;
    /**
     * A játékos kezében lévő kártyalapok szöveges formátumban.
     */
    private String kez = "";
    /**
     * A játékos kezében lévő kártyalapok értéke.
     */
    private int kez_ertek = 0;
    /**
     * A gép kezében lévő kártyalapok szöveges formátumban.
     */
    private String gep_kez = "";
    /**
     * A gép kezében lévő kártyalapok értéke.
     */
    private int gep_kez_ertek = 0;
    /**
     * Az eljárás a játékos húzását valósítja meg.
     * Kihúz egy véletlenszerű lapot a {@link Controller#kartyapakli}-ból, majd hozzáadja a {@link Controller#kez}-hez és a {@link Controller#kez_ertek}-hez.
     */
    public void jatekos_huzas(){
        huzott_lap_index = rng(0,kartyapakli.pakli.size()-1);
        kihuzott_kartya = kartyapakli.pakli.remove(huzott_lap_index);
        if (!kez.equals(""))
            kez+=", ";
        kez+=kihuzott_kartya.getSzin()+" "+kihuzott_kartya.getJel();
        kez_ertek+=kihuzott_kartya.getErtek();
        logger.info("A játékos a {} lapot húzta.",kihuzott_kartya.toString());
    }
    /**
     * Az eljárás a gép húzását valósítja meg.
     * Kihúz egy véletlenszerű lapot a {@link Controller#kartyapakli}-ból, majd hozzáadja a {@link Controller#gep_kez}-hez és a {@link Controller#gep_kez_ertek}-hez.
     */
    public void gep_huzas(){
        huzott_lap_index = rng(0,kartyapakli.pakli.size()-1);
        kihuzott_kartya = kartyapakli.pakli.remove(huzott_lap_index);
        if (!gep_kez.equals(""))
            gep_kez+=", ";
        gep_kez+=kihuzott_kartya.getSzin()+" "+kihuzott_kartya.getJel();
        gep_kez_ertek+=kihuzott_kartya.getErtek();
        logger.info("A gép a {} lapot húzta.",kihuzott_kartya.toString());
    }
    /**
     * Az eljárás a játékos "körét" valósítja meg.
     * A játékos eldöntheti, hogy húz e még lapot, vagy megáll.
     */
    public void jatekos_jatszik(){
        logger.info("A játékos következik!");
        try (Scanner s = new Scanner(System.in)) {
            byte be;
            jatekos_huzas();
            jatekos_huzas();
            OUTER:
            for (;;) {
                System.out.println("A kezed: "+kez);
                //System.out.println(kez_ertek);
                if (kez_ertek>21){
                    System.out.println("Túlmentél!!!");
                    break;
                }
                System.out.println("Mi legyen?\n1 -- húzás, 2 -- megáll");
                be = s.nextByte();
                switch (be) {
                    case 1:
                        jatekos_huzas();
                        break;
                    case 2:
                        break OUTER;
                    default:
                        System.out.println("Rossz input!!!");
                        break;
                }
            }
        }
    }
    /**
     * A gép körét valósítja meg.
     * A gép minimális MI-vel rendelkezik. Az MI eldönti, hogy meg kell-e állni, vagy húzni kell-e még lapot.
     */
    public void gep_jatszik(){
        logger.info("A gép következik!");
        gep_huzas();
        gep_huzas();
        while (gep_kez_ertek < 15){
            gep_huzas();
        }
    }
    /**
     * A játék összesítéséért felelős metódus.
     * Megvizsgálja a játékos és a gép kezét, majd eldönti hogy ki nyert.
     * Visszaadja a győztest szöveges formátumban.
     * 
     * @return a játszma eredménye.
     */
    public String osszesit() {
       logger.info("A játék véget ért, összesítés következik!");
       //ha több pontja van a játékosnak mint a gépnek és nem ment túl
       if ((kez_ertek>gep_kez_ertek && kez_ertek < 22) ){
            logger.info("A játékos nyert. Pontszáma: {} a gép pontszáma: {}",kez_ertek,gep_kez_ertek);
            return "Gratulálok, Nyertél!!!";
       }  
       //ha a gépnek van több, de csak ő ment túl
       else if (gep_kez_ertek>kez_ertek && kez_ertek < 22 && gep_kez_ertek>21){
           logger.info("A játékos nyert. Pontszáma: {} a gép pontszáma: {}",kez_ertek,gep_kez_ertek);
           return "Gratulálok, Nyertél!!!";
       }
       //ha a gépnek van több pontja, mint a játékosnak és nem ment túl       
       else if ((gep_kez_ertek>kez_ertek && gep_kez_ertek < 22)){
           logger.info("A gép nyert. Pontszáma: {} a játékos pontszáma: {}",gep_kez_ertek,kez_ertek);
           return "A Gép Nyert!!!";
       }
       // ha a játékosnak van több, de csak ő ment túl
       else if(kez_ertek>gep_kez_ertek && gep_kez_ertek < 22 && kez_ertek>21) {
           logger.info("A gép nyert. Pontszáma: {} a játékos pontszáma: {}",gep_kez_ertek,kez_ertek);
           return "A Gép Nyert!!!";
       }
       else{
           logger.info("A játék döntetlen lett. A játékos pontszáma: {} a gép pontszáma: {}",kez_ertek,gep_kez_ertek);
           return "Döntetlen!!!";
       }
    }
    /**
     * Véletlenszám generátor.
     * Paraméterként kapott alsó és felső határ között generál egy véletlenszerű egész számot.
     * 
     * @param also a véletlen szám alsó határa
     * @param felso a véletlen szám felső határa
     * @return a generált véletlen szám.
     */
    private int rng(int also,int felso){
        return (int) ( Math.random() * (felso - also + 1) ) + also;
    }
    /**
     * Visszaadja a játékos kezét.
     * 
     * @return A játékos keze.
     */
    public String getKez() {
        return kez;
    }
    /**
     * Beállítja a játékos kezét a paraméterül kapott értékre.
     * 
     * @param kez A játékos keze.
     */
    public void setKez(String kez) {
        this.kez = kez;
    }
    /**
     * Visszaadja a gép kezét.
     * 
     * @return A gép keze.
     */
    public String getGep_kez() {
        return gep_kez;
    }
    /**
     * Beállítja a gép kezét a paraméterül kapott értékre.
     * 
     * @param gep_kez A gép keze.
     */
    public void setGep_kez(String gep_kez) {
        this.gep_kez = gep_kez;
    }
    /**
     * Visszaadja a játékos kezében lévő lapok értékét.
     * 
     * @return A játékos kezében lévő lapok értéke.
     */
    public int getKez_ertek() {
        return kez_ertek;
    }
    /**
     * Visszaadja a gép kezében lévő lapok értékét.
     * 
     * @return A gép kezében lévő lapok értéke.
     */
    public int getGep_kez_ertek() {
        return gep_kez_ertek;
    }
    /**
     * Beálltja a játékos kezében lévő lapok összértékét.
     * 
     * @param kez_ertek A játékos kezében lévő lapok összértéke.
     */
    public void setKez_ertek(int kez_ertek) {
        this.kez_ertek = kez_ertek;
    }
    /**
     * Beálltja a gép kezében lévő lapok összértékét.
     * 
     * @param gep_kez_ertek A gép kezében lévő lapok összértéke.
     */
    public void setGep_kez_ertek(int gep_kez_ertek) {    
        this.gep_kez_ertek = gep_kez_ertek;
    }
    /**
     * Konstruktor paraméter nélküli példányosításhoz. 
     */
    public Controller() {
        logger.debug("A Controller objektum létrejött");
    }
}
