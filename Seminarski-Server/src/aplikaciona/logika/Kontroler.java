/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikaciona.logika;

import domen.OpstiDomenskiObjekat;
import domen.Partner;
import sistemske.operacija.SOZapamtiPartnera;

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

    public boolean sacuvajPartnera(Partner partner) throws Exception {
        SOZapamtiPartnera so = new SOZapamtiPartnera();
        return so.opsteIzvrsenjeSO(partner);
    }

}
