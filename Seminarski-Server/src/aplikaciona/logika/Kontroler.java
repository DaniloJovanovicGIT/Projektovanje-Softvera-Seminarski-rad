/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikaciona.logika;

import domen.Odeljenje;
import domen.OpstiDomenskiObjekat;
import domen.Partner;
import domen.Zaposleni;
import java.sql.SQLException;
import java.util.ArrayList;
import sistemske.operacije.partner.SOIzmeniPartnera;
import sistemske.operacije.partner.SOObrisiPartnera;
import sistemske.operacije.partner.SOVratiPartnereZaVrednost;
import sistemske.operacije.SOVratiSvaOdeljenja;
import sistemske.operacije.partner.SOVratiSvePartnere;
import sistemske.operacije.partner.SOZapamtiPartnera;
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

}
