/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poslovna.logika;

import domen.Kampanja;
import domen.Odeljenje;
import domen.OpstiDomenskiObjekat;
import domen.Partner;
import domen.StatusZadatka;
import domen.Zaposleni;
import java.sql.SQLException;
import java.util.ArrayList;
import sistemske.operacije.partner.SOIzmeniPartnera;
import sistemske.operacije.partner.SOObrisiPartnera;
import sistemske.operacije.partner.SOVratiPartnereZaVrednost;
import sistemske.operacije.odeljenja.SOVratiSvaOdeljenja;
import sistemske.operacije.kampanja.SOIzmeniKampanju;
import sistemske.operacije.kampanja.SOObrisiKampanju;
import sistemske.operacije.kampanja.SOVratiKampanjeZaVrednost;
import sistemske.operacije.kampanja.SOVratiSveKampanje;
import sistemske.operacije.kampanja.SOZapamtiKampanju;
import sistemske.operacije.partner.SOVratiSvePartnere;
import sistemske.operacije.partner.SOZapamtiPartnera;
import sistemske.operacije.zadatak.SOVratiSveStatuseZadatka;
import sistemske.operacije.zaposleni.SOIzmeniZaposlenog;
import sistemske.operacije.zaposleni.SOObrisiZaposlenog;
import sistemske.operacije.zaposleni.SOVratiSveZaposlene;
import sistemske.operacije.zaposleni.SOVratiZaposleneZaVrednost;
import sistemske.operacije.zaposleni.SOZapamtiZaposlenog;

/**
 *
 * @author Danilo
 */
public class Kontroler {

    public static Kontroler instance;

    public Kontroler() {
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public boolean sacuvajPartnera(Partner partner) throws Exception {
        SOZapamtiPartnera so = new SOZapamtiPartnera();
        return so.opsteIzvrsenjeSO(partner);
    }

    public ArrayList<Partner> vratiSveParntere() throws Exception {
        SOVratiSvePartnere so = new SOVratiSvePartnere();
        so.opsteIzvrsenjeSO(new Partner());
        return so.getLista();
    }

    public ArrayList<Partner> vratiPartnereZaVrednost(Partner partner) throws Exception {
        SOVratiPartnereZaVrednost so = new SOVratiPartnereZaVrednost();
        so.opsteIzvrsenjeSO(partner);
        return so.getListaPartnera();
    }

    public boolean izmeniPartnera(Partner izmenjenPartner) throws SQLException {
        SOIzmeniPartnera so = new SOIzmeniPartnera();
        return so.opsteIzvrsenjeSO(izmenjenPartner);
    }

    public boolean obrisiPartnera(Partner partnerZaBrisanje) throws SQLException {
        SOObrisiPartnera so = new SOObrisiPartnera();
        return so.opsteIzvrsenjeSO(partnerZaBrisanje);
    }

    public ArrayList<Odeljenje> vratiSvaOdeljenja() throws Exception {
        SOVratiSvaOdeljenja so = new SOVratiSvaOdeljenja();
        so.opsteIzvrsenjeSO(new Odeljenje());
        return so.getLista();
    }

    public boolean sacuvajZaposlenog(Zaposleni noviZaposleni) throws SQLException {
        SOZapamtiZaposlenog so = new SOZapamtiZaposlenog();
        return so.opsteIzvrsenjeSO(noviZaposleni);
    }

    public ArrayList<Zaposleni> vratiSveZaposlene() throws SQLException {
        SOVratiSveZaposlene so =  new SOVratiSveZaposlene();
        so.opsteIzvrsenjeSO(new Zaposleni());
        return so.getLista();
    }

    public ArrayList<Zaposleni> vratiZaposleneZaVrednost(Zaposleni zaposleniZaVrednost) throws SQLException {
        SOVratiZaposleneZaVrednost so = new SOVratiZaposleneZaVrednost();
        so.opsteIzvrsenjeSO(zaposleniZaVrednost);
        return so.getLista();
    }

    public boolean izmeniZaposlenog(Zaposleni izmenjenZaposleni) throws SQLException {
        SOIzmeniZaposlenog so = new SOIzmeniZaposlenog();
        return so.opsteIzvrsenjeSO(izmenjenZaposleni);
    }

    public boolean obrisiZaposlenog(Zaposleni zaposleniZaBrisanje) throws SQLException {
        SOObrisiZaposlenog so = new SOObrisiZaposlenog();
        return so.opsteIzvrsenjeSO(zaposleniZaBrisanje);
    }

    public ArrayList<StatusZadatka> vratiSveStatuseZadatka() throws SQLException {
        SOVratiSveStatuseZadatka so = new SOVratiSveStatuseZadatka();
        so.opsteIzvrsenjeSO(new StatusZadatka());
        return so.getListaStatusaZadatka();
    }

    public boolean sacuvajKampanju(Kampanja novaKampanja) throws SQLException {
        SOZapamtiKampanju so = new SOZapamtiKampanju();
        return so.opsteIzvrsenjeSO(novaKampanja);
    }

    public ArrayList<Kampanja> vratiSveKampanje() throws SQLException {
        SOVratiSveKampanje so = new SOVratiSveKampanje();
        so.opsteIzvrsenjeSO(new Kampanja());
        return so.getLista();
    }

    public ArrayList<Kampanja> vratiKampanjeZaVrednost(Kampanja kampanjaZaVrednost) throws SQLException {
        SOVratiKampanjeZaVrednost so = new SOVratiKampanjeZaVrednost();
        so.opsteIzvrsenjeSO(kampanjaZaVrednost);
        return so.getLista();
    }

    public boolean izmeniKampanju(Kampanja izmenjenaKampanja) throws SQLException {
        SOIzmeniKampanju so = new SOIzmeniKampanju();
        return so.opsteIzvrsenjeSO(izmenjenaKampanja);
    }

    public boolean obrisiKampanju(Kampanja kampanjaZaBrisanje) throws Exception {
        SOObrisiKampanju so = new SOObrisiKampanju();
        return so.opsteIzvrsenjeSO(kampanjaZaBrisanje);
    }

}
