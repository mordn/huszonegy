package hu.unideb.inf.pk.huszonegy.tests;

import hu.unideb.inf.pk.huszonegy.controller.Controller;
import hu.unideb.inf.pk.huszonegy.model.Kartya;
import static org.junit.Assert.*;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabi
 */
public class Tests {
    @Test
    public void controllertest(){

    Controller ctr = new Controller();
    ctr.setGep_kez_ertek(15);
    ctr.setKez_ertek(18);
    assertEquals(ctr.osszesit(),"Gratulálok, Nyertél!!!");
    
    ctr.setGep_kez_ertek(30);
    ctr.setKez_ertek(17);
    assertEquals(ctr.osszesit(),"Gratulálok, Nyertél!!!");
    
    ctr.setGep_kez_ertek(20);
    ctr.setKez_ertek(20);
    assertEquals(ctr.osszesit(),"Döntetlen!!!");
    
    ctr.setGep_kez_ertek(15);
    ctr.setKez_ertek(10);
    assertEquals(ctr.osszesit(),"A Gép Nyert!!!");  
    
    ctr.setGep_kez_ertek(15);
    ctr.setKez_ertek(25);
    assertEquals(ctr.osszesit(),"A Gép Nyert!!!"); 
    
    
    ctr.setKez_ertek(0);
    ctr.setKez("");
    ctr.jatekos_huzas();
    ctr.jatekos_huzas();
    assertTrue("".length()<ctr.getKez().length());
    assertTrue(0<ctr.getKez_ertek());
    ctr.setKez_ertek(0);
    ctr.setKez("");

    
    ctr.setGep_kez("");
    ctr.setGep_kez_ertek(0);
    ctr.gep_huzas();
    assertTrue("".length() < ctr.getGep_kez().length());
    assertTrue(0 < ctr.getGep_kez_ertek());
    ctr.setGep_kez("");
    ctr.setGep_kez_ertek(0);
    ctr.gep_jatszik();
    assertTrue("".length() < ctr.getGep_kez().length());
    assertTrue(14 < ctr.getGep_kez_ertek());
    
    ctr.gep_jatszik();
    }    
    
    @Test
    public void kartyatest(){
    Kartya kartya = new Kartya();
    kartya.setErtek(10);
    kartya.setId(1);
    kartya.setJel("Makk");
    kartya.setSzin("Tíz");
    assertEquals(kartya.toString(),"Kartya{"  + "szin=" + kartya.getSzin() + ", jel=" + kartya.getJel() + ", ertek=" + kartya.getErtek() + '}');
    assertEquals(kartya.getId(),1);
    
    
    
    
    
    }
}