/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.pk.huszonegy.model;

/**
 *
 * @author Gabi
 */
public class Kartya {
    private int id;
    private int ertek;
    private String szin;
    private String jel;

    public Kartya() {
    }

    public Kartya(int id, int ertek, String szin, String jel) {
        this.id = id;
        this.ertek = ertek;
        this.szin = szin;
        this.jel = jel;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getErtek() {
        return ertek;
    }

    public void setErtek(int ertek) {
        this.ertek = ertek;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public String getJel() {
        return jel;
    }

    public void setJel(String jel) {
        this.jel = jel;
    }

    @Override
    public String toString() {
        return "Kartya{"  + "szin=" + szin + ", jel=" + jel + ", ertek=" + ertek + '}';
    }
    
    
    
}
