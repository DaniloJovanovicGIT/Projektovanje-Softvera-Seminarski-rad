/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacije.kampanja;

import domen.Kampanja;
import domen.OpstiDomenskiObjekat;
import domen.Zadatak;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemske.operacije.OpsteIzvrsenjeSO;

/**
 *
 * @author Danilo
 */
public class SOZapamtiKampanju extends OpsteIzvrsenjeSO {

    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
        return true;
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo) {
        try {
            Kampanja novaKampanja = (Kampanja) odo;
            boolean kampanjaSacuvana = bbp.zapamti(novaKampanja);
            if (kampanjaSacuvana) {

                long kampanjaId = bbp.vratiPoslednjiUbaceniKey(novaKampanja);
                novaKampanja.setKampanjaId(kampanjaId);
                ArrayList<Zadatak> listaZadataka = (ArrayList<Zadatak>) novaKampanja.getZadaci();
                for (Zadatak zadatak : listaZadataka) {
                    zadatak.setKampanja(novaKampanja);
                    bbp.zapamti(zadatak);
                }
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SOZapamtiKampanju.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
