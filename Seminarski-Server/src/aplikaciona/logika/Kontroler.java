/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikaciona.logika;

import domen.OpstiDomenskiObjekat;
import domen.Partner;
import java.sql.SQLException;
import java.util.ArrayList;
import sistemske.operacija.SOIzmeniPartnera;
import sistemske.operacija.SOVratiPartnereZaVrednost;
import sistemske.operacija.SOVratiSvePartnere;
import sistemske.operacija.SOZapamtiPartnera;

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
        so.opsteIzvrsenjeSO(izmenjenPartner);
        return true;
    }

}
