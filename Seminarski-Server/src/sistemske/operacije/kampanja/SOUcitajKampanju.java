/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacije.kampanja;

import domen.Kampanja;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import sistemske.operacije.OpsteIzvrsenjeSO;

/**
 *
 * @author Danilo
 */
public class SOUcitajKampanju extends OpsteIzvrsenjeSO {
    Kampanja ucitanaKampanja;
    
    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
        //provera da li je prosledjeni objekat instanca klase Kampanja
        if (odo instanceof Kampanja kampanja) {
            if (kampanja.getPartner() == null || kampanja.getNaziv() == null || kampanja.getDatumPocetka() == null
                    || kampanja.getDatumZavrsetka() == null || kampanja.getOdgovorniZaposleni() == null || kampanja.getZadaci() == null) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo) throws Exception {
        ucitanaKampanja = (Kampanja) bbp.ucitaj(odo).get(0);
        return true;
    }

    public Kampanja getKampanja() {
        return ucitanaKampanja;
    }

}
