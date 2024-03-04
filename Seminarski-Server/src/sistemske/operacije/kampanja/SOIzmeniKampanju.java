/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacije.kampanja;

import domen.Kampanja;
import domen.OpstiDomenskiObjekat;
import domen.Zadatak;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemske.operacije.OpsteIzvrsenjeSO;

/**
 *
 * @author Danilo
 */
public class SOIzmeniKampanju extends OpsteIzvrsenjeSO {

    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
        //provera da li je prosledjeni objekat instanca klase Kampanja
        if (odo instanceof Kampanja kampanja) {
            if (kampanja.getPartner() == null || kampanja.getNaziv() == null || kampanja.getDatumPocetka() == null
                    || kampanja.getDatumZavrsetka() == null || kampanja.getOdgovorniZaposleni() == null || kampanja.getZadaci() == null) {
                return false;
            }
            //Provera da li je datum pocetka kampanje pre datuma zavrsetka kampanje
            if (kampanja.getDatumPocetka().after(kampanja.getDatumZavrsetka())) {
                return false;
            }
            //Provera da li postoji kampanja sa istim identifikatorom u bazi, treba da postoji
            List<OpstiDomenskiObjekat> listaKampanja = bbp.ucitaj(odo);
            if (listaKampanja.isEmpty()) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo) {
        boolean signal = false;
        try {
            Kampanja kampanja = (Kampanja) odo;
            System.err.println(kampanja.getNaziv());
            for (Zadatak zadatak : kampanja.getZadaci()) {
                System.err.println(zadatak.getNaziv());
            }
            boolean izmenjenaKampanja = bbp.promeni(kampanja);
            if (izmenjenaKampanja) {
                for (Zadatak zadatak : kampanja.getZadaci()) {
                    if (zadatak.getZadatakId() == null) {
                        bbp.zapamti(zadatak);
                    } else {
                        bbp.promeni(zadatak);
                        System.err.println("Promenjen zadatak");
                    }
                }
            } else {
                return false;
            }
            signal = true;
        } catch (SQLException ex) {
            Logger.getLogger(SOIzmeniKampanju.class.getName()).log(Level.SEVERE, null, ex);
        }
        return signal;
    }

}
