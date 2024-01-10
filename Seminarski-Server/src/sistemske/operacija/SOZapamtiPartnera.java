/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacija;

import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class SOZapamtiPartnera extends OpsteIzvrsenjeSO {

    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
        //Treba da se implementira
        return true;
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo) throws SQLException {
        boolean signal = false;
        try {
            bbp.zapamti(odo);
            signal = true;
        } catch (SQLException ex) {
            Logger.getLogger(SOZapamtiPartnera.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return signal;
    }

}
