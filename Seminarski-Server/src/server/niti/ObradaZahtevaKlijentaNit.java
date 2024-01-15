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
import domen.Odeljenje;
import domen.Zaposleni;
import java.util.ArrayList;
import sistemske.operacije.OpsteIzvrsenjeSO;
import sistemske.operacije.partner.SOZapamtiPartnera;

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
            Logger.getLogger(ObradaZahtevaKlijentaNit.class.getName()).log(Level.SEVERE, "Klijent je prekinuo vezu", ex);
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
                case Operacija.VRATI_PARTNERE_ZA_VREDONST:
                    Partner partnerZaVrednost = (Partner) zahtev.getParametar();
                    ArrayList<Partner> listaPartneraZaVrednost = Kontroler.getInstance().vratiPartnereZaVrednost(partnerZaVrednost);
                    odgovor = new Odgovor(listaPartneraZaVrednost, Operacija.VRATI_PARTNERE_ZA_VREDONST, "Uspesno vraceno.", VrstaOdgovora.USPESNO);
                    break;
                case Operacija.IZMENI_PARTNERA:
                    Partner izmenjenPartner = (Partner) zahtev.getParametar();
                    boolean uspesnoIzmenjenoPartner = Kontroler.getInstance().izmeniPartnera(izmenjenPartner);
                    if (uspesnoIzmenjenoPartner) {
                        odgovor = new Odgovor(izmenjenPartner, Operacija.IZMENI_PARTNERA, "Uspesno izmenjeno.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(izmenjenPartner, Operacija.IZMENI_PARTNERA, "Izmena neuspesna.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.OBRISI_PARTNERA:
                    Partner partnerZaBrisanje = (Partner) zahtev.getParametar();
                    boolean uspesnoObrisanPartner = Kontroler.getInstance().obrisiPartnera(partnerZaBrisanje);
                    if (uspesnoObrisanPartner) {
                        odgovor = new Odgovor(partnerZaBrisanje, Operacija.OBRISI_PARTNERA, "Uspesno obrisano.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(partnerZaBrisanje, Operacija.OBRISI_PARTNERA, "Brisanje neuspesno.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.VRATI_SVA_ODELJENJA:
                    ArrayList<Odeljenje> listaSvihOdeljenja = Kontroler.getInstance().vratiSvaOdeljenja();
                    odgovor = new Odgovor(listaSvihOdeljenja, Operacija.VRATI_SVA_ODELJENJA, "Uspesno vraceno.", VrstaOdgovora.USPESNO);
                    break;
                case Operacija.ZAPAMTI_ZAPOSLENOG:
                    Zaposleni noviZaposleni = (Zaposleni) zahtev.getParametar();
                    boolean uspesnoSacuvanZaposleni = Kontroler.getInstance().sacuvajZaposlenog(noviZaposleni);
                    if (uspesnoSacuvanZaposleni) {
                        odgovor = new Odgovor(noviZaposleni, Operacija.ZAPAMTI_ZAPOSLENOG, "Sistem je zapamtio zaposlenog.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(noviZaposleni, Operacija.ZAPAMTI_ZAPOSLENOG, "Sistem ne može da zapamti zaposlenog.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.VRATI_SVE_ZAPOSLENE:
                    ArrayList<Zaposleni> listaSvihZaposleni = Kontroler.getInstance().vratiSveZaposlene();
                    odgovor = new Odgovor(listaSvihZaposleni, Operacija.VRATI_SVE_ZAPOSLENE, "Uspesno vraceno.", VrstaOdgovora.USPESNO);
                    break;
                case Operacija.VRATI_ZAPOSLENE_ZA_VREDNOST:
                    Zaposleni zaposleniZaVrednost = (Zaposleni) zahtev.getParametar();
                    ArrayList<Zaposleni> listaZaposlenihZaVrednost = Kontroler.getInstance().vratiZaposleneZaVrednost(zaposleniZaVrednost);
                    odgovor = new Odgovor(listaZaposlenihZaVrednost, Operacija.VRATI_ZAPOSLENE_ZA_VREDNOST, "Uspesno vraceno.", VrstaOdgovora.USPESNO);
                    break;
                case Operacija.IZMENI_ZAPOSLENOG:
                    Zaposleni izmenjenZaposleni = (Zaposleni) zahtev.getParametar();
                    boolean uspesnoIzmenjenoZaposleni = Kontroler.getInstance().izmeniZaposlenog(izmenjenZaposleni);
                    if (uspesnoIzmenjenoZaposleni) {
                        odgovor = new Odgovor(izmenjenZaposleni, Operacija.IZMENI_ZAPOSLENOG, "Uspesno izmenjeno.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(izmenjenZaposleni, Operacija.IZMENI_ZAPOSLENOG, "Izmena neuspesna.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.OBRISI_ZAPOSLENOG:
                    Zaposleni zaposleniZaBrisanje = (Zaposleni) zahtev.getParametar();
                    boolean uspesnoObrisanZaposleni = Kontroler.getInstance().obrisiZaposlenog(zaposleniZaBrisanje);
                    if (uspesnoObrisanZaposleni) {
                        odgovor = new Odgovor(zaposleniZaBrisanje, Operacija.OBRISI_ZAPOSLENOG, "Uspesno obrisano.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(zaposleniZaBrisanje, Operacija.OBRISI_ZAPOSLENOG, "Brisanje neuspesno.", VrstaOdgovora.GRESKA);
                    }
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
