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
public class SOUcitajPartnera extends OpsteIzvrsenjeSO {
    Partner ucitaniPartner;
    
    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
        if (odo instanceof Partner partner) {
            if (partner.getPib() == null || partner.getNaziv() == null
                    || partner.getDatumOsnivanja() == null || partner.getKontaktOsoba() == null
                    || partner.getBrojTelefona() == null || partner.getEmail() == null) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo) throws Exception {
        ucitaniPartner = (Partner) bbp.ucitaj(odo).get(0);
        return true;
    }

    public Partner getUcitaniPartner() {
        return ucitaniPartner;
    }
}
