/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Partner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Operacija;
import komunikacija.VrstaOdgovora;
import komunikacija.Zahtev;

/**
 *
 * @author Danilo
 */
public class KontrolerKIPartner extends OpstiKontrolerKI {

    private static KontrolerKIPartner instance;

    private KontrolerKIPartner() {
    }

    public static KontrolerKIPartner getInstance() {
        if (instance == null) {
            instance = new KontrolerKIPartner();
        }
        return instance;
    }

    public Odgovor kreirajPartnera(Partner partner) {
        try {
            System.out.println("Saljem zahtev." + partner.getNaziv());
            posiljalac.posalji(new Zahtev(Operacija.ZAPAMTI_PARTNERA, partner, true));
            return(Odgovor) primalac.primi();
        } catch (IOException ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    

    public ArrayList<Partner> vratiSvePartnere() {
        try {
            System.out.println("Saljem zahtev. Vrati sve partnere.");
            posiljalac.posalji(new Zahtev(Operacija.VRATI_SVE_PARTNERE, null, true));
            Odgovor odgovor = (Odgovor) primalac.primi();
            if (odgovor.getVrstaOdgovora() == VrstaOdgovora.USPESNO) {
                return (ArrayList<Partner>) odgovor.getParametar();
            } else {
                return null;
            }
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Odgovor vratiPartnereSaUslovom(String vrednostPretrazivanja) {
        Partner partner = new Partner();
        partner.setVrednostZaPretragu(vrednostPretrazivanja);
        try {
            System.out.println("Saljem zahtev. Vrati partnere za vrednost");
            posiljalac.posalji(new Zahtev(Operacija.VRATI_PARTNERE_ZA_VREDONST, partner, true));
            return (Odgovor) primalac.primi();
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean izmeniPartnera(Partner izmenjenPartner) {
        try {
            System.out.println("Saljem zahtev. Izmeni partnera");
            posiljalac.posalji(new Zahtev(Operacija.IZMENI_PARTNERA, izmenjenPartner, true));
            Odgovor odgovor = (Odgovor) primalac.primi();
            if (odgovor.getVrstaOdgovora() == VrstaOdgovora.USPESNO) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Odgovor obrisiPartnera(Partner partnerZaBrisanje) {
        try {
            System.out.println("Saljem zahtev. Obrisi partnera");
            posiljalac.posalji(new Zahtev(Operacija.OBRISI_PARTNERA, partnerZaBrisanje, true));
            return (Odgovor) primalac.primi();
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 

    public Odgovor ucitajPartnera(Partner izabraniPartner) {
        try {
            System.out.println("Saljem zahtev, ucitaj partnera.");
            posiljalac.posalji(new Zahtev(Operacija.UCITAJ_PARTNERA, izabraniPartner, true));
            return(Odgovor) primalac.primi();
        } catch (IOException ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
