/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Odeljenje;
import domen.Zaposleni;
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
public class KontorlerKIZaposleni extends OpstiKontrolerKI {

    private static KontorlerKIZaposleni instance;

    public KontorlerKIZaposleni() {
    }

    public static KontorlerKIZaposleni getInstance() {
        if (instance == null) {
            instance = new KontorlerKIZaposleni();
        }
        return instance;
    }

    public ArrayList<Odeljenje> vratiSvaOdeljenja() {
        try {
            System.out.println("Saljem zahtev. Vrati sva odeljenja.");
            posiljalac.posalji(new Zahtev(Operacija.VRATI_SVA_ODELJENJA, new Odeljenje(), true));
            Odgovor odgovor = (Odgovor) primalac.primi();
            if (odgovor.getVrstaOdgovora() == VrstaOdgovora.USPESNO) {
                return (ArrayList<Odeljenje>) odgovor.getParametar();
            } 
        } catch (Exception ex) {
            Logger.getLogger(KontorlerKIZaposleni.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Odgovor kreirajZaposlenog(Zaposleni noviZaposleni) {
        try {
            System.out.println("Saljem zahtev, kreiraj zaposlenog");
            posiljalac.posalji(new Zahtev(Operacija.ZAPAMTI_ZAPOSLENOG, noviZaposleni, true));
            return (Odgovor) primalac.primi();
        } catch (Exception ex) {
            Logger.getLogger(KontorlerKIZaposleni.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Zaposleni> vratiSveZaposlene() {
        try {
            System.out.println("Saljem zahtev. Vrati sve zaposlene.");
            posiljalac.posalji(new Zahtev(Operacija.VRATI_SVE_ZAPOSLENE, null, true));
            Odgovor odgovor = (Odgovor) primalac.primi();
            if (odgovor.getVrstaOdgovora() == VrstaOdgovora.USPESNO) {
                return (ArrayList<Zaposleni>) odgovor.getParametar();
            } else {
                return null;
            }
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Odgovor vratiZaposleneSaUslovom(String uslov) {
        Zaposleni zaposleni = new Zaposleni();
        zaposleni.setVrednostZaPretragu(uslov);
        try {
            System.out.println("Saljem zahtev. Vrati zaposlene za vrednost");
            posiljalac.posalji(new Zahtev(Operacija.VRATI_ZAPOSLENE_ZA_VREDNOST, zaposleni, true));
            return (Odgovor) primalac.primi();

        } catch (Exception ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Odgovor izmeniZaposlenog(Zaposleni izmenjenZaposleni) {
        try {
            System.out.println("Saljem zahtev. Izmeni zaposlenog");
            posiljalac.posalji(new Zahtev(Operacija.IZMENI_ZAPOSLENOG, izmenjenZaposleni, true));
            return (Odgovor) primalac.primi();
           
        } catch (Exception ex) {
            Logger.getLogger(KontorlerKIZaposleni.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Odgovor obrisiZaposlenog(Zaposleni izabraniZaposleni) {
        try {
            System.out.println("Saljem zahtev. Obrisi zaposlenog");
            posiljalac.posalji(new Zahtev(Operacija.OBRISI_ZAPOSLENOG, izabraniZaposleni, true));
            return (Odgovor) primalac.primi();
        } catch (Exception ex) {
            Logger.getLogger(KontorlerKIZaposleni.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Odgovor ucitajPartnera(Zaposleni izabraniZaposleni) {
        try {
            System.out.println("Saljem zahtev. Ucitaj zaposlenog");
            posiljalac.posalji(new Zahtev(Operacija.UCITAJ_ZAPOSLENOG, izabraniZaposleni, true));
            return (Odgovor) primalac.primi();
        } catch (Exception ex) {
            Logger.getLogger(KontorlerKIZaposleni.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
