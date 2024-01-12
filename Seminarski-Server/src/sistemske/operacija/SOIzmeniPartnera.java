/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacija;

import domen.OpstiDomenskiObjekat;
import domen.Partner;
import java.lang.reflect.Field;

/**
 *
 * @author Danilo
 */
public class SOIzmeniPartnera extends OpsteIzvrsenjeSO {

    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
        if (odo instanceof Partner) {
            if (((Partner) odo).getNoviPib()==null || ((Partner) odo).getPib() == null || ((Partner) odo).getNaziv() == null || ((Partner) odo).getDatumOsnivanja() == null || 
            ((Partner) odo).getKontaktOsoba() == null || ((Partner) odo).getBrojTelefona() == null || ((Partner) odo).getEmail() == null) {
            return false;
        }
        return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo) throws Exception {
           return  bbp.izmeni(odo);
    }

}
