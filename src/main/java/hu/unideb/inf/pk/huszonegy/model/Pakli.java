package hu.unideb.inf.pk.huszonegy.model;

import java.util.Vector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Egy kártyapaklit megvalósító modell osztálya.
 * 
 * @author Bódis Gábor
 * @version 1.0
 * @since 2017-05-29
 */
public class Pakli {
    /**
     * A kártyapaklit megvalósító vektor.
     */
    public Vector<Kartya> pakli;
    /**
     * A Pakli osztály loggere.
     */
    private static Logger logger = LoggerFactory.getLogger(Pakli.class);
    /**
     * Konstruktor paraméter nélküli példányosításhoz. 
     * A konstruktor feltölti a {@link Pakli#pakli}-t a 32 db magyar kártyával.
     */
    public Pakli() {
        this.pakli = new Vector<>();
        for (int i=0; i<32; i++){
            if (i<8){ 
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
            }else if (i<16){ 
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
            }else if (i<24){ 
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
            }else{              
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
        logger.debug("A pakli létrehozva, feltöltve a 32 magyar kártyával");
    }
}
