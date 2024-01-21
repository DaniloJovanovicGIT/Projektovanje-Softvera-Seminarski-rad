/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacije.partner;

import sistemske.operacije.partner.SOZapamtiPartnera;
import domen.OpstiDomenskiObjekat;
import domen.Partner;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemske.operacije.OpsteIzvrsenjeSO;

/**
 *
 * @author Danilo
 */
public class SOVratiPartnereZaVrednost extends OpsteIzvrsenjeSO {

    private ArrayList<OpstiDomenskiObjekat> lista;
    private ArrayList<Partner> listaPartnera;

    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
        if (odo instanceof Partner) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo) throws Exception {
        Partner partner = (Partner) odo;
        boolean signal = false;
        try {
            lista = (ArrayList<OpstiDomenskiObjekat>) bbp.vratiZaVrednost(partner);
            signal = true;
        } catch (SQLException ex) {
            Logger.getLogger(SOZapamtiPartnera.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return signal;
    }

    public ArrayList<Partner> getListaPartnera() {
        listaPartnera = new ArrayList<>();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
            listaPartnera.add((Partner) opstiDomenskiObjekat);
        }
        return listaPartnera;
    }

}
