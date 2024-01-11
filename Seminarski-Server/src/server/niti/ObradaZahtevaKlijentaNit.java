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
import komunikacija.VrstaOdgovora;
import komunikacija.Zahtev;
import aplikaciona.logika.Kontroler;
import java.util.ArrayList;
import sistemske.operacija.OpsteIzvrsenjeSO;
import sistemske.operacija.SOZapamtiPartnera;

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
        try {
            int operacija = zahtev.getOperacija();
            Odgovor odgovor = null;
            switch (operacija) {
                case Operacija.ZAPAMTI_PARTNERA:
                    Partner partner = (Partner) zahtev.getParametar();
                    boolean sacuvanPartner = Kontroler.getInstance().sacuvajPartnera(partner);
                    if (sacuvanPartner) {
                        odgovor = new Odgovor(partner, Operacija.ZAPAMTI_PARTNERA, "Uspesno sacuvano.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(partner, Operacija.ZAPAMTI_PARTNERA, "Cuvanje neuspesno.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.VRATI_SVE_PARTNERE:
                    ArrayList<Partner> listaSvihPartnera = Kontroler.getInstance().vratiSveParntere();
                    odgovor = new Odgovor(listaSvihPartnera, Operacija.VRATI_SVE_PARTNERE, "Uspesno vraceno.", VrstaOdgovora.USPESNO);
                    
                    break;

            }
            return odgovor;
        } catch (Exception ex) {
            Logger.getLogger(ObradaZahtevaKlijentaNit.class.getName()).log(Level.SEVERE, null, ex);
            return new Odgovor(ex, -1, ex.getMessage(), VrstaOdgovora.GRESKA);
        }
    }

    public void zatvoriSoket() {
        try {
            if (soket != null && !soket.isClosed()) {
                soket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
