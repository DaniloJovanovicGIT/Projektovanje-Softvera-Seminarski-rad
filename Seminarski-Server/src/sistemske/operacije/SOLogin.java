/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemske.operacije;

import domen.Menadzer;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;

/**
 *
 * @author Danilo
 */
public class SOLogin extends OpsteIzvrsenjeSO {
    Menadzer ulogovaniMenadzer;
    
    @Override
    public boolean proveriOgranicenja(OpstiDomenskiObjekat odo) throws Exception {
        if (odo instanceof Menadzer menadzer) {
            if (menadzer.getUsername() == null || menadzer.getPassword() == null) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean izvrsiSO(OpstiDomenskiObjekat odo) throws Exception {
        Menadzer login = (Menadzer) odo;
        ArrayList<OpstiDomenskiObjekat> listaMenadzera = bbp.vratiSve(odo);
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaMenadzera) {
            Menadzer menadzer = (Menadzer) opstiDomenskiObjekat;
            if((menadzer.getUsername() == null ? login.getUsername() == null : menadzer.getUsername().equals(login.getUsername())) && (menadzer.getPassword() == null ? login.getPassword() == null : menadzer.getPassword().equals(login.getPassword()))){
                ulogovaniMenadzer = menadzer;
                return true;
            }
        }
        return true;
    }

    public Menadzer getUlogovaniMenadzer() {
        return ulogovaniMenadzer;
    }
}
