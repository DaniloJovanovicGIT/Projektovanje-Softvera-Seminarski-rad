/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.niti;

import domen.OpstiDomenskiObjekat;
import domen.Partner;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Operacija;
import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;
import poslovna.logika.Kontroler;

/**
 *
 * @author Danilo
 */
public class ObradaZahtevaKlijentaNit extends Thread {
    private Socket soket;
    private ServerskaNit serverskaNit;
    private Posiljalac posiljalac;
    private Primalac primalac;
    
    ObradaZahtevaKlijentaNit(Socket soket, ServerskaNit serverskaNit) throws IOException {
        this.soket = soket;
        this.serverskaNit = serverskaNit;
        this.posiljalac = new Posiljalac(soket);
        this.primalac = new Primalac(soket);
    }

    @Override
    public void run() {
         try {
            while (soket != null && !soket.isClosed()) {
                Zahtev zahtev = (Zahtev) primalac.primi();
                Odgovor odgovor = obradiZahtev(zahtev);
                posiljalac.posalji(odgovor);
            }
        } catch (Exception ex) {
            Logger.getLogger(ObradaZahtevaKlijentaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Odgovor obradiZahtev(Zahtev zahtev) {
        int operacija = zahtev.getOperacija();
        Odgovor odgovor = null;
        switch (operacija) {
            case Operacija.ZAPAMTI_PARTNERA:
                OpstiDomenskiObjekat odo = (OpstiDomenskiObjekat) zahtev.getParametar();
                Kontroler.getInstance().zapamtiPartnera(odo);
                break;
            case Operacija.VRATI_PARTNERE_ZA_VREDONST:
                
                break;
            
                
        }
        return null;
    }

    
}
