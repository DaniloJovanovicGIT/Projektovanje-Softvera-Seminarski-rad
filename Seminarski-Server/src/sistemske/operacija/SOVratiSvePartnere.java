/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacija;

import domen.OpstiDomenskiObjekat;
import domen.Partner;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sistemske.operacija.OpsteIzvrsenjeSO.bbp;

/**
 *
 * @author Danilo
 */
public class SOVratiSvePartnere extends OpsteIzvrsenjeSO{
    private ArrayList<OpstiDomenskiObjekat> lista;
    private ArrayList<Partner> listaPartnera;
     
    
    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
        return true;
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo) throws Exception {
         boolean signal = false;
        try {
            lista = bbp.vrati(new Partner());
            signal = true;
        } catch (SQLException ex) {
            Logger.getLogger(SOZapamtiPartnera.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return signal;
    }

    public ArrayList<Partner> getLista() {
        listaPartnera = new ArrayList<>();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
            listaPartnera.add((Partner) opstiDomenskiObjekat);
        }
        return listaPartnera;
    }
}
