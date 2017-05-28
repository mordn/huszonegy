/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.pk.huszonegy.view;

import hu.unideb.inf.pk.huszonegy.controller.Controller;


/**
 *
 * @author Gabi
 */
public class Main {    

    public static void main(String[] args) {
        System.out.println("A játékos kezd:");
        Controller.jatekos_jatszik();
        System.out.println("A játékos végzett, a gép jön:");
        Controller.gep_jatszik();    
        System.out.println("A kezed: " + Controller.getKez());
        System.out.println("A gep keze: " + Controller.getGep_kez());
        System.out.println(Controller.osszesit());
    }
}
