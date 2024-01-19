/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacije.kampanja;

import domen.OpstiDomenskiObjekat;
import sistemske.operacije.OpsteIzvrsenjeSO;

/**
 *
 * @author Danilo
 */
public class SOObrisiKampanju extends OpsteIzvrsenjeSO{

    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
        return true;
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo) throws Exception {
        return bbp.obrisi(odo);
    }
    
}
