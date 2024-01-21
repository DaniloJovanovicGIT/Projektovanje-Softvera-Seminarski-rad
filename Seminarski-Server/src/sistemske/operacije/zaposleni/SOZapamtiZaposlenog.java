/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacije.zaposleni;

import domen.OpstiDomenskiObjekat;
import domen.Zaposleni;
import java.util.List;
import sistemske.operacije.OpsteIzvrsenjeSO;

/**
 *
 * @author Danilo
 */
public class SOZapamtiZaposlenog extends OpsteIzvrsenjeSO {

    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
        //provera da li je prosledjeni objekat instanca klase Zaposleni
        if (odo instanceof Zaposleni zaposleni) {
            if (zaposleni.getJmbg() == null || zaposleni.getIme() == null || zaposleni.getPrezime() == null
                    || zaposleni.getOdeljenje() == null) {
                return false;
            }
            //Provera da li postoji zaposleni sa istim jmbg-om u bazi
            List<OpstiDomenskiObjekat> listaPartnera = bbp.ucitaj(odo);
            if (!listaPartnera.isEmpty()) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo) throws Exception {
        return bbp.zapamti(odo);
    }

}
