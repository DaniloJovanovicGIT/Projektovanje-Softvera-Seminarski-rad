/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacije.odeljenja;

import sistemske.operacije.partner.SOZapamtiPartnera;
import domen.Odeljenje;
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
public class SOVratiSvaOdeljenja extends OpsteIzvrsenjeSO{
    private ArrayList<OpstiDomenskiObjekat> lista;
    private ArrayList<Odeljenje> listaOdeljenja;
    
    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
        return true;
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo) throws Exception {
         boolean signal = false;
        try {
            lista = bbp.vratiSve(new Odeljenje());
            signal = true;
        } catch (SQLException ex) {
            Logger.getLogger(SOZapamtiPartnera.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return signal;
    }
    
    public ArrayList<Odeljenje> getLista() {
        listaOdeljenja = new ArrayList<>();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
            listaOdeljenja.add((Odeljenje) opstiDomenskiObjekat);
        }
        return listaOdeljenja;
    }
    
}
