/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacija;

import baza.podataka.BrokerBazePodataka;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import komunikacija.Zahtev;

/**
 *
 * @author Danilo
 */
public abstract class OpsteIzvrsenjeSO {

    static BrokerBazePodataka bbp = BrokerBazePodataka.getInstance();
    

    synchronized public boolean opsteIzvrsenjeSO(OpstiDomenskiObjekat odo) throws Exception {
        boolean signal = false;
        bbp.otvoriKonekciju();
        boolean ogranicenjaZadovoljena = proveriOgranicenja(odo);
        if (ogranicenjaZadovoljena) {
            signal = izvrsiSO(odo);
            if (signal == true) {
                bbp.commit();
            } else {
                bbp.rollback();
            }
        }
        bbp.zatvoriKonekciju();
        return signal;
    }

    abstract public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception;

    abstract public boolean izvrsiSO(OpstiDomenskiObjekat odo) throws Exception;

}
