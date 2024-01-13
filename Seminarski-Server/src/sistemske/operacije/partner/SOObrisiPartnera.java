/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacije.partner;

import domen.OpstiDomenskiObjekat;
import domen.Partner;
import sistemske.operacije.OpsteIzvrsenjeSO;

/**
 *
 * @author Danilo
 */
public class SOObrisiPartnera extends OpsteIzvrsenjeSO {

    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
        if ((Partner) odo instanceof Partner) {
            if (((Partner) odo).getPib() == null || ((Partner) odo).getNaziv() == null || ((Partner) odo).getDatumOsnivanja() == null
                    || ((Partner) odo).getKontaktOsoba() == null || ((Partner) odo).getBrojTelefona() == null || ((Partner) odo).getEmail() == null) {
                System.out.println("Ogrenacinjena nisu zadovoljena");
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo) throws Exception {
        return bbp.obrisi(odo);
    }

}
