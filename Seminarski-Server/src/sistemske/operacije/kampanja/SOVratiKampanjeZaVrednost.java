/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacije.kampanja;

import domen.Kampanja;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemske.operacije.OpsteIzvrsenjeSO;

/**
 *
 * @author Danilo
 */
public class SOVratiKampanjeZaVrednost extends OpsteIzvrsenjeSO {

    private ArrayList<OpstiDomenskiObjekat> lista;
    private ArrayList<Kampanja> listaKampanja;

    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
        return true;
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo){
        boolean signal = false;
        try {
            lista = (ArrayList<OpstiDomenskiObjekat>) bbp.vratiSveSaUslovom(odo);
            signal = true;
        } catch (SQLException ex) {
            Logger.getLogger(SOVratiKampanjeZaVrednost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return signal;
    }

    public ArrayList<Kampanja> getLista() {
        listaKampanja = new ArrayList<>();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
            listaKampanja.add((Kampanja) opstiDomenskiObjekat);
        }
        return listaKampanja;
    }
}
