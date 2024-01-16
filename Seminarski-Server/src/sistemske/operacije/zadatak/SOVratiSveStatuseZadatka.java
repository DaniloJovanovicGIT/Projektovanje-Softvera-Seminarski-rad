/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacije.zadatak;

import domen.OpstiDomenskiObjekat;
import domen.Partner;
import domen.StatusZadatka;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemske.operacije.OpsteIzvrsenjeSO;

/**
 *
 * @author Danilo
 */
public class SOVratiSveStatuseZadatka extends OpsteIzvrsenjeSO {

    private ArrayList<OpstiDomenskiObjekat> lista;
    private ArrayList<StatusZadatka> listaStatusaZadatka;

    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
        return true;
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo) {
        boolean signal = false;
        try {
            lista = bbp.vrati(new StatusZadatka());
            signal = true;
        } catch (SQLException ex) {
            Logger.getLogger(SOVratiSveStatuseZadatka.class.getName()).log(Level.SEVERE, null, ex);
        }
        return signal;
    }

    public ArrayList<StatusZadatka> getListaStatusaZadatka() {
        listaStatusaZadatka = new ArrayList<>();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
            listaStatusaZadatka.add((StatusZadatka) opstiDomenskiObjekat);
        }
        return listaStatusaZadatka;
    }

}
