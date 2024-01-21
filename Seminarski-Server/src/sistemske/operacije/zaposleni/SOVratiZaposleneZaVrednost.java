/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacije.zaposleni;

import domen.OpstiDomenskiObjekat;
import domen.Zaposleni;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemske.operacije.OpsteIzvrsenjeSO;

/**
 *
 * @author Danilo
 */
public class SOVratiZaposleneZaVrednost extends OpsteIzvrsenjeSO {

    private ArrayList<OpstiDomenskiObjekat> lista;
    private ArrayList<Zaposleni> listaZaposlenih;

    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
        return odo instanceof Zaposleni;
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo) throws Exception {
        Zaposleni zaposleni = (Zaposleni) odo;
        boolean signal = false;
        try {
            lista = (ArrayList<OpstiDomenskiObjekat>) bbp.vratiZaVrednost(zaposleni);
            signal = true;
        } catch (SQLException ex) {
            Logger.getLogger(SOVratiSveZaposlene.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return signal;
    }

    public ArrayList<Zaposleni> getLista() {
        listaZaposlenih = new ArrayList<>();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
            listaZaposlenih.add((Zaposleni) opstiDomenskiObjekat);
        }
        return listaZaposlenih;
    }
}
