/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikaciona.logika;

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
import poslovna.logika.Kontroler;
import domen.Kampanja;
import domen.Menadzer;
import domen.Odeljenje;
import domen.StatusZadatka;
import domen.Zaposleni;
import java.util.ArrayList;

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
                        odgovor = new Odgovor(partner, Operacija.ZAPAMTI_PARTNERA, "Sistem je zapamtio partnera.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(partner, Operacija.ZAPAMTI_PARTNERA, "Sistem ne može da zapamti partnera.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.VRATI_SVE_PARTNERE:
                    ArrayList<Partner> listaSvihPartnera = Kontroler.getInstance().vratiSveParntere();
                    odgovor = new Odgovor(listaSvihPartnera, Operacija.VRATI_SVE_PARTNERE, "Uspešno vraćeni partneri.", VrstaOdgovora.USPESNO);
                    break;
                case Operacija.VRATI_PARTNERE_ZA_VREDONST:
                    Partner partnerZaVrednost = (Partner) zahtev.getParametar();
                    ArrayList<Partner> listaPartneraZaVrednost = Kontroler.getInstance().vratiPartnereZaVrednost(partnerZaVrednost);
                    if (!listaPartneraZaVrednost.isEmpty()) {
                        odgovor = new Odgovor(listaPartneraZaVrednost, Operacija.VRATI_PARTNERE_ZA_VREDONST, "Sistem je našao partnere po zadatoj vrednosti.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(listaPartneraZaVrednost, Operacija.VRATI_PARTNERE_ZA_VREDONST, "Sistem ne može da nađe partnere po zadatoj vrednosti.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.IZMENI_PARTNERA:
                    Partner izmenjenPartner = (Partner) zahtev.getParametar();
                    boolean uspesnoIzmenjenoPartner = Kontroler.getInstance().izmeniPartnera(izmenjenPartner);
                    if (uspesnoIzmenjenoPartner) {
                        odgovor = new Odgovor(izmenjenPartner, Operacija.IZMENI_PARTNERA, "Sistem je promenio partnera.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(izmenjenPartner, Operacija.IZMENI_PARTNERA, "Sistem ne može da promenio partnera.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.OBRISI_PARTNERA:
                    Partner partnerZaBrisanje = (Partner) zahtev.getParametar();
                    boolean uspesnoObrisanPartner = Kontroler.getInstance().obrisiPartnera(partnerZaBrisanje);
                    if (uspesnoObrisanPartner) {
                        odgovor = new Odgovor(partnerZaBrisanje, Operacija.OBRISI_PARTNERA, "Sistem je obrisao partnera.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(partnerZaBrisanje, Operacija.OBRISI_PARTNERA, "Sistem ne može da obriše partnera.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.VRATI_SVA_ODELJENJA:
                    ArrayList<Odeljenje> listaSvihOdeljenja = Kontroler.getInstance().vratiSvaOdeljenja();
                    odgovor = new Odgovor(listaSvihOdeljenja, Operacija.VRATI_SVA_ODELJENJA, "Uspešno vraćena odeljenja.", VrstaOdgovora.USPESNO);
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
                    odgovor = new Odgovor(listaSvihZaposleni, Operacija.VRATI_SVE_ZAPOSLENE, "Uspešno vraćeni zaposleni.", VrstaOdgovora.USPESNO);
                    break;
                case Operacija.VRATI_ZAPOSLENE_ZA_VREDNOST:
                    Zaposleni zaposleniZaVrednost = (Zaposleni) zahtev.getParametar();
                    ArrayList<Zaposleni> listaZaposlenihZaVrednost = Kontroler.getInstance().vratiZaposleneZaVrednost(zaposleniZaVrednost);
                    if (!listaZaposlenihZaVrednost.isEmpty()) {
                        odgovor = new Odgovor(listaZaposlenihZaVrednost, Operacija.VRATI_ZAPOSLENE_ZA_VREDNOST, "Sistem je našao zaposlene po zadatoj vrednosti.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(listaZaposlenihZaVrednost, Operacija.VRATI_ZAPOSLENE_ZA_VREDNOST, "Sistem ne može da nađe zaposlene po zadatoj vrednosti.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.IZMENI_ZAPOSLENOG:
                    Zaposleni izmenjenZaposleni = (Zaposleni) zahtev.getParametar();
                    boolean uspesnoIzmenjenoZaposleni = Kontroler.getInstance().izmeniZaposlenog(izmenjenZaposleni);
                    if (uspesnoIzmenjenoZaposleni) {
                        odgovor = new Odgovor(izmenjenZaposleni, Operacija.IZMENI_ZAPOSLENOG, "Sistem je uspešno promenio zaposlenog.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(izmenjenZaposleni, Operacija.IZMENI_ZAPOSLENOG, "Sistem ne može da promeni zaposlenog", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.OBRISI_ZAPOSLENOG:
                    Zaposleni zaposleniZaBrisanje = (Zaposleni) zahtev.getParametar();
                    boolean uspesnoObrisanZaposleni = Kontroler.getInstance().obrisiZaposlenog(zaposleniZaBrisanje);
                    if (uspesnoObrisanZaposleni) {
                        odgovor = new Odgovor(zaposleniZaBrisanje, Operacija.OBRISI_ZAPOSLENOG, "Sistem je obrisao zaposlenog.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(zaposleniZaBrisanje, Operacija.OBRISI_ZAPOSLENOG, "Sistem ne može da obriše zaposlenog.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.VRATI_SVE_STATUSE_ZADATKA:
                    ArrayList<StatusZadatka> listaSvihStatusaZadatka = Kontroler.getInstance().vratiSveStatuseZadatka();
                    odgovor = new Odgovor(listaSvihStatusaZadatka, Operacija.VRATI_SVE_STATUSE_ZADATKA, "Uspešno vraćeni statusi zadataka.", VrstaOdgovora.USPESNO);
                    break;
                case Operacija.ZAPAMTI_KAMPANJU:
                    Kampanja novaKampanja = (Kampanja) zahtev.getParametar();
                    boolean uspesnoSacuvanaKampanja = Kontroler.getInstance().sacuvajKampanju(novaKampanja);
                    if (uspesnoSacuvanaKampanja) {
                        odgovor = new Odgovor(novaKampanja, Operacija.ZAPAMTI_KAMPANJU, "Sistem je zapamtio kampanju.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(novaKampanja, Operacija.ZAPAMTI_KAMPANJU, "Sistem ne može da zapamti kampanju.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.VRATI_SVE_KAMPANJE:
                    ArrayList<Kampanja> listaSvihKampanja = Kontroler.getInstance().vratiSveKampanje();
                    odgovor = new Odgovor(listaSvihKampanja, Operacija.VRATI_SVE_KAMPANJE, "Uspešno vraćene kampanje.", VrstaOdgovora.USPESNO);
                    break;
                case Operacija.VRATI_KAMPANJE_ZA_VREDNOST:
                    Kampanja kampanjaZaVrednost = (Kampanja) zahtev.getParametar();
                    ArrayList<Kampanja> listaKampanjaZaVrednost = Kontroler.getInstance().vratiKampanjeZaVrednost(kampanjaZaVrednost);
                    if (!listaKampanjaZaVrednost.isEmpty()) {
                        odgovor = new Odgovor(listaKampanjaZaVrednost, Operacija.VRATI_KAMPANJE_ZA_VREDNOST, "Sistem je našao kampanje po zadatoj vrednosti.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(listaKampanjaZaVrednost, Operacija.VRATI_KAMPANJE_ZA_VREDNOST, "Sistem ne može da nađe kampanje po zadatoj vrednosti.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.IZMENI_KAMPANJU:
                    Kampanja izmenjenaKampanja = (Kampanja) zahtev.getParametar();
                    boolean uspesnoIzmenjenaKampanja = Kontroler.getInstance().izmeniKampanju(izmenjenaKampanja);
                    if (uspesnoIzmenjenaKampanja) {
                        odgovor = new Odgovor(izmenjenaKampanja, Operacija.IZMENI_KAMPANJU, "Sistem je promenio kampanju.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(izmenjenaKampanja, Operacija.IZMENI_KAMPANJU, "Sistem ne može da promeni kampanju.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.OBRISI_KAMPANJU:
                    Kampanja kampanjaZaBrisanje = (Kampanja) zahtev.getParametar();
                    boolean uspesnoObrisanaKampanja = Kontroler.getInstance().obrisiKampanju(kampanjaZaBrisanje);
                    if (uspesnoObrisanaKampanja) {
                        odgovor = new Odgovor(kampanjaZaBrisanje, Operacija.OBRISI_KAMPANJU, "Sistem je obrisao kampanju.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(kampanjaZaBrisanje, Operacija.OBRISI_KAMPANJU, "Sistem ne može da obriše kampanju.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.UCITAJ_PARTNERA:
                    Partner partnerZaUcitavanje = (Partner) zahtev.getParametar();
                    Partner vraceniPartner = Kontroler.getInstance().ucitajPartnera(partnerZaUcitavanje);
                    if (vraceniPartner != null) {
                        odgovor = new Odgovor(vraceniPartner, Operacija.UCITAJ_PARTNERA, "Sistem je učitao partnera.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(vraceniPartner, Operacija.UCITAJ_PARTNERA, "Sistem ne može da učita partnera.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.UCITAJ_ZAPOSLENOG:
                    Zaposleni zaposleniZaUcitavanje = (Zaposleni) zahtev.getParametar();
                    Zaposleni vraceniZaposleni = Kontroler.getInstance().ucitajZaposlenog(zaposleniZaUcitavanje);
                    if (vraceniZaposleni != null) {
                        odgovor = new Odgovor(vraceniZaposleni, Operacija.UCITAJ_ZAPOSLENOG, "Sistem je učitao zaposlenog.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(vraceniZaposleni, Operacija.UCITAJ_ZAPOSLENOG, "Sistem ne može da učita zaposlenog.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.UCITAJ_KAMPANJU:
                    Kampanja kampanjaZaUcitavanje = (Kampanja) zahtev.getParametar();
                    Kampanja vracenaKampanja = Kontroler.getInstance().ucitajKampanju(kampanjaZaUcitavanje);
                    if (vracenaKampanja != null) {
                        odgovor = new Odgovor(vracenaKampanja, Operacija.UCITAJ_KAMPANJU, "Sistem je učitao kampanju.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(vracenaKampanja, Operacija.UCITAJ_KAMPANJU, "Sistem ne može da učita kampanju.", VrstaOdgovora.GRESKA);
                    }
                    break;
                case Operacija.LOGIN:
                    Menadzer menadzer = (Menadzer) zahtev.getParametar();
                    Menadzer ulogovaniMenadzer = Kontroler.getInstance().login(menadzer);
                    if (ulogovaniMenadzer != null) {
                        odgovor = new Odgovor(ulogovaniMenadzer, Operacija.LOGIN, "Uspešno ste se ulogovali. Dobrodošli.", VrstaOdgovora.USPESNO);
                    } else {
                        odgovor = new Odgovor(ulogovaniMenadzer, Operacija.LOGIN, "Pogrešni kredencijali. Pokušajte ponovo.", VrstaOdgovora.GRESKA);
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
