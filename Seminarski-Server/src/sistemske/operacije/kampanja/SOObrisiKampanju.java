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
public class SOObrisiKampanju extends OpsteIzvrsenjeSO{

    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
       //provera da li je prosledjeni objekat instanca klase Kampanja
        if (odo instanceof Kampanja kampanja) {
            if (kampanja.getPartner() == null || kampanja.getNaziv() == null || kampanja.getDatumPocetka() == null
                    || kampanja.getDatumZavrsetka() == null || kampanja.getOdgovorniZaposleni() == null || kampanja.getZadaci() == null) {
                return false;
            }
            //Provera da li postoji kampanja sa istim identifikatorom u bazi, treba da postoji
            List<OpstiDomenskiObjekat> listaPartnera = bbp.ucitaj(odo);
            if (listaPartnera.isEmpty()) {
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
