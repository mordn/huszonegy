/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.pk.huszonegy.controller;

import hu.unideb.inf.pk.huszonegy.model.Kartya;
import hu.unideb.inf.pk.huszonegy.model.Pakli;
import java.util.Scanner;

/**
 *
 * @author Gabi
 */
public class Controller {
    
    private static final Pakli kartyapakli = new Pakli();
    private static Kartya kihuzott_kartya;
    private static int huzott_lap_index;
    
    private static String kez = "";
    private static int kez_ertek = 0;
    
    private static String gep_kez = "";
    private static int gep_kez_ertek = 0;
    
    public static void jatekos_huzas(){
        huzott_lap_index = rng(0,kartyapakli.pakli.size()-1);
        kihuzott_kartya = kartyapakli.pakli.remove(huzott_lap_index);
        if (!kez.equals(""))
            kez+=", ";
        kez+=kihuzott_kartya.getSzin()+" "+kihuzott_kartya.getJel();
        kez_ertek+=kihuzott_kartya.getErtek();
    }
    
    public static void gep_huzas(){
        huzott_lap_index = rng(0,kartyapakli.pakli.size()-1);
        kihuzott_kartya = kartyapakli.pakli.remove(huzott_lap_index);
        if (!gep_kez.equals(""))
            gep_kez+=", ";
        gep_kez+=kihuzott_kartya.getSzin()+" "+kihuzott_kartya.getJel();
        gep_kez_ertek+=kihuzott_kartya.getErtek();
    }
    
    public static void gep_jatszik(){
        gep_huzas();
        gep_huzas();
    }

    public static void jatekos_jatszik(){
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
    
    public static String osszesit() {
       
       //több pontja van kartyapakli játékosnak mint kartyapakli gépnek és nem ment túl, vagy kartyapakli gépnek van több, de csak ő ment túl
       if ((kez_ertek>gep_kez_ertek && kez_ertek < 22) || (gep_kez_ertek>kez_ertek && kez_ertek < 22 && gep_kez_ertek>21) )
           return "Gratulálok, Nyertél!!!";
       //a gépnek van több pontja, mint kartyapakli játékosnak és nem ment túl, vagy kartyapakli játékosnak van több, de csak ő ment túl       
       else if ((gep_kez_ertek>kez_ertek && gep_kez_ertek < 22)|| (kez_ertek>gep_kez_ertek && gep_kez_ertek < 22 && kez_ertek>21))
           return "A Gép Nyert!!!";
       else
           return "Döntetlen!!!";
    }
    
    private static int rng(int also,int felso){
        return (int) ( Math.random() * (felso - also + 1) ) + also;
    }

    public static String getKez() {
        return kez;
    }

    public static void setKez(String kez) {
        Controller.kez = kez;
    }

    public static String getGep_kez() {
        return gep_kez;
    }

    public static void setGep_kez(String gep_kez) {
        Controller.gep_kez = gep_kez;
    }
 
}
