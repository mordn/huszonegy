package hu.unideb.inf.pk.huszonegy.view;

import hu.unideb.inf.pk.huszonegy.controller.Controller;
/**
 * A játék elindításáért, és a megjelentítésért felelős osztály.
 * 
 * @author Bódis Gábor
 * @version 1.0
 * @since 2017-05-29
 */
public class Main {    
    /**
     * A fő belépési pont a programba. 
     * Levezérli a játékot, és kommunikál a felhasználóval.
     * 
     * @param args A parancssori argumentumok tömbke. 
     */
    public static void main(String[] args) {
        Controller ctr = new Controller();   
        System.out.println("A játékos kezd:");   
        ctr.jatekos_jatszik();
        System.out.println("A játékos végzett, a gép következik:");
        ctr.gep_jatszik();
        System.out.println("A gep keze: " + ctr.getGep_kez());
        System.out.println("A kezed: " + ctr.getKez());
        System.out.println(ctr.osszesit());
    }
}
