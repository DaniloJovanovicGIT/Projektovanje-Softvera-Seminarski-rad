/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacije.partner;

import domen.OpstiDomenskiObjekat;
import domen.Partner;
import java.util.List;
import sistemske.operacije.OpsteIzvrsenjeSO;

/**
 *
 * @author Danilo
 */
public class SOObrisiPartnera extends OpsteIzvrsenjeSO {

    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
         //provera da li je prosledjeni objekat instanca objekat Partner
        if (odo instanceof Partner partner) {
            if (!(partner.getPib() != null && partner.getNaziv() != null
                    && partner.getDatumOsnivanja() != null && partner.getKontaktOsoba() != null
                    && partner.getBrojTelefona() != null && partner.getEmail() != null)) {
                return false;
            }
            //Provera da li postoji partner sa istim pibom u bazi, treba da postoji da bi ga obrisali
            List<OpstiDomenskiObjekat> listaPartnera = bbp.ucitaj(odo);
            if(listaPartnera.isEmpty()){
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo) throws Exception {
        return bbp.obrisi(odo);
    }

}
