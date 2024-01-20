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
public class SOVratiSveKampanje extends OpsteIzvrsenjeSO {

    private ArrayList<OpstiDomenskiObjekat> lista;
    private ArrayList<Kampanja> listaKampanja;

    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
        return true;
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo) {
        boolean signal = false;
        try {
            lista = bbp.vratiSve(new Kampanja());
            signal = true;
            return signal;
        } catch (SQLException ex) {
            Logger.getLogger(SOVratiSveKampanje.class.getName()).log(Level.SEVERE, null, ex);
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
