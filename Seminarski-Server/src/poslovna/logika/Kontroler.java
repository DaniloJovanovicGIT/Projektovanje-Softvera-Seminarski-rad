/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poslovna.logika;

import domen.OpstiDomenskiObjekat;

/**
 *
 * @author Danilo
 */
public class Kontroler {

    public static Kontroler instance;

    public Kontroler() {
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public void zapamtiPartnera(OpstiDomenskiObjekat odo) {
        
    }

  
}
