/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.pk.huszonegy.model;

import java.util.Vector;

/**
 *
 * @author Gabi
 */
public class Pakli {
    
    

    public Vector<Kartya> pakli;
    
    public Pakli() {
        this.pakli = new Vector<>();
        for (int i=0; i<32; i++){
            if (i<8){ //piros
                switch (i%8) {
                    case 0:
                        pakli.add(new Kartya(i,2,"Piros","Alsó"));
                        break;
                    case 1:
                        pakli.add(new Kartya(i,3,"Piros","Felső"));
                        break;
                    case 2:
                        pakli.add(new Kartya(i,4,"Piros","Király"));
                        break;
                    case 3:
                        pakli.add(new Kartya(i,11,"Piros","Ász"));
                        break;
                    case 4:
                        pakli.add(new Kartya(i,7,"Piros","Hét"));
                        break;    
                    case 5:
                        pakli.add(new Kartya(i,8,"Piros","Nyolc"));
                        break;
                    case 6:
                        pakli.add(new Kartya(i,9,"Piros","Kilenc"));
                        break;
                    case 7:
                        pakli.add(new Kartya(i,10,"Piros","Tíz"));
                        break;    
                }
            }else if (i<16){ //zold
                switch (i%8) {
                    case 0:
                        pakli.add(new Kartya(i,2,"Zöld","Alsó"));
                        break;
                    case 1:
                        pakli.add(new Kartya(i,3,"Zöld","Felső"));
                        break;
                    case 2:
                        pakli.add(new Kartya(i,4,"Zöld","Király"));
                        break;
                    case 3:
                        pakli.add(new Kartya(i,11,"Zöld","Ász"));
                        break;
                    case 4:
                        pakli.add(new Kartya(i,7,"Zöld","Hét"));
                        break;    
                    case 5:
                        pakli.add(new Kartya(i,8,"Zöld","Nyolc"));
                        break;
                    case 6:
                        pakli.add(new Kartya(i,9,"Zöld","Kilenc"));
                        break;
                    case 7:
                        pakli.add(new Kartya(i,10,"Zöld","Tíz"));
                        break;    
                }
            }else if (i<24){ //makk
                switch (i%8) {
                    case 0:
                        pakli.add(new Kartya(i,2,"Makk","Alsó"));
                        break;
                    case 1:
                        pakli.add(new Kartya(i,3,"Makk","Felső"));
                        break;
                    case 2:
                        pakli.add(new Kartya(i,4,"Makk","Király"));
                        break;
                    case 3:
                        pakli.add(new Kartya(i,11,"Makk","Ász"));
                        break;
                    case 4:
                        pakli.add(new Kartya(i,7,"Makk","Hét"));
                        break;    
                    case 5:
                        pakli.add(new Kartya(i,8,"Makk","Nyolc"));
                        break;
                    case 6:
                        pakli.add(new Kartya(i,9,"Makk","Kilenc"));
                        break;
                    case 7:
                        pakli.add(new Kartya(i,10,"Makk","Tíz"));
                        break;    
                }
            }else{           //tok   
                switch (i%8) {
                    case 0:
                        pakli.add(new Kartya(i,2,"Tök","Alsó"));
                        break;
                    case 1:
                        pakli.add(new Kartya(i,3,"Tök","Felső"));
                        break;
                    case 2:
                        pakli.add(new Kartya(i,4,"Tök","Király"));
                        break;
                    case 3:
                        pakli.add(new Kartya(i,11,"Tök","Ász"));
                        break;
                    case 4:
                        pakli.add(new Kartya(i,7,"Tök","Hét"));
                        break;    
                    case 5:
                        pakli.add(new Kartya(i,8,"Tök","Nyolc"));
                        break;
                    case 6:
                        pakli.add(new Kartya(i,9,"Tök","Kilenc"));
                        break;
                    case 7:
                        pakli.add(new Kartya(i,10,"Tök","Tíz"));
                        break;    
                }
            }
        }
    }
    
}
