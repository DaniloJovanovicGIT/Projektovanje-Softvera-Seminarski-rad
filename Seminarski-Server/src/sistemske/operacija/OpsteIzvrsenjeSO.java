/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacija;

import baza.podataka.BrokerBazePodataka;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Zahtev;

/**
 *
 * @author Danilo
 */
public abstract class OpsteIzvrsenjeSO {

    public BrokerBazePodataka bbp = new BrokerBazePodataka();

    synchronized public boolean opsteIzvrsenjeSO(OpstiDomenskiObjekat odo) throws SQLException {
        boolean signal = false;
        try {
            bbp.otvoriKonekciju();
            boolean ogranicenjaZadovoljena = proveriOgranicenja(odo);
            if (ogranicenjaZadovoljena) {
                signal = izvrsiSO(odo);
                if (signal == true) {
                    bbp.commit();
                }
            }
            return signal;
        } catch (Exception ex) {
            bbp.rollback();
            Logger.getLogger(OpsteIzvrsenjeSO.class.getName()).log(Level.SEVERE, "Greska pri izvrsenju sistemske operacije", ex);
        } finally {
            bbp.zatvoriKonekciju();
        }
        return signal;
    }

    abstract public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception;

    abstract public boolean izvrsiSO(OpstiDomenskiObjekat odo) throws Exception;

}
