/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacije.kampanja;

import domen.Kampanja;
import domen.OpstiDomenskiObjekat;
import domen.Zadatak;
import java.sql.SQLException;
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
        return true;
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo){
        boolean signal = false;
        try {
            Kampanja kampanja = (Kampanja) odo;
            boolean izmenjenaKampanja = bbp.promeni(kampanja);
            if(izmenjenaKampanja){
                for (Zadatak zadatak : kampanja.getZadaci()) {
                    if(zadatak.getZadatakId()==null){
                        bbp.zapamti(zadatak);
                    }else{
                        bbp.promeni(zadatak);
                    }
                }
            }else{
            return false;
            }
            signal = true;
        } catch (SQLException ex) {
            Logger.getLogger(SOIzmeniKampanju.class.getName()).log(Level.SEVERE, null, ex);
        }
        return signal;
    }
    
}
