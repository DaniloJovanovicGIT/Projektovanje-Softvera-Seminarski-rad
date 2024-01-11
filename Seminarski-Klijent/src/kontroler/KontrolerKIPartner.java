/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Partner;
import forme.FormaIzmeniPartnera;
import forme.FormaKreirajPartnera;
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

    private FormaKreirajPartnera formaKreirajPartnera;
    private FormaIzmeniPartnera formaIzmeniPartnera;
    private Partner partner;
    private static KontrolerKIPartner instance;

    private KontrolerKIPartner() {
    }

    public static KontrolerKIPartner getInstance() {
        if (instance == null) {
            instance = new KontrolerKIPartner();
        }
        return instance;
    }

    public void setFkp(FormaKreirajPartnera fkp) {
        this.formaKreirajPartnera = fkp;
    }

    public void setFormaIzmeniPartnera(FormaIzmeniPartnera formaIzmeniPartnera) {
        this.formaIzmeniPartnera = formaIzmeniPartnera;
    }

    public void kreirajPartnera(Partner partner) {
        try {
            System.out.println("Saljem zahtev." + partner.getNaziv());
            posiljalac.posalji(new Zahtev(Operacija.ZAPAMTI_PARTNERA, partner, true));
            Odgovor odgovor = (Odgovor) primalac.primi();
            obradiOdgovorSOZapamtiPartnera(odgovor);
        } catch (IOException ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void obradiOdgovorSOZapamtiPartnera(Odgovor odgovor) {
        formaKreirajPartnera.obradiServerskiOdgovor(odgovor);
    }

    public ArrayList<Partner> vratiSvePartnere() {
        try {
            System.out.println("Saljem zahtev. Vrati sve partnere.");
            posiljalac.posalji(new Zahtev(Operacija.VRATI_SVE_PARTNERE, null, true));
            Odgovor odgovor = (Odgovor) primalac.primi();
            if(odgovor.getVrstaOdgovora()==VrstaOdgovora.USPESNO){
                return (ArrayList<Partner>) odgovor.getParametar();
            }else{
                return null;
            }
        } catch (IOException ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
