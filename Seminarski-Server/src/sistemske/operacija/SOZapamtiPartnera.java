/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacija;

import domen.OpstiDomenskiObjekat;
import domen.Partner;
import java.lang.reflect.Field;
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
       if ((Partner)odo instanceof Partner) {
            if (((Partner) odo).getPib() == null || ((Partner) odo).getNaziv() == null || ((Partner) odo).getDatumOsnivanja() == null || 
            ((Partner) odo).getKontaktOsoba() == null || ((Partner) odo).getBrojTelefona() == null || ((Partner) odo).getEmail() == null) {
            return false;
        }
        return true;
        } else {
            return false;
        }
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
