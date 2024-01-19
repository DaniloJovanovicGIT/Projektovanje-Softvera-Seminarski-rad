/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Kampanja;
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
public class KontrolerKIKampanja extends OpstiKontrolerKI {

    private static KontrolerKIKampanja instance;

    public KontrolerKIKampanja() {
    }

    public static KontrolerKIKampanja getInstance() {
        if (instance == null) {
            instance = new KontrolerKIKampanja();
        }
        return instance;
    }

    public Odgovor kreirajKampanju(Kampanja kampanja) {

        try {
            System.out.println("Saljem zahtev, kreiraj zaposlenog");
            posiljalac.posalji(new Zahtev(Operacija.ZAPAMTI_KAMPANJU, kampanja, true));
            return (Odgovor) primalac.primi();
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKIKampanja.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Kampanja> vratiSveKampanje() {
        try {
            System.out.println("Saljem zahtev. Vrati sve kampanje.");
            posiljalac.posalji(new Zahtev(Operacija.VRATI_SVE_KAMPANJE, null, true));
            Odgovor odgovor = (Odgovor) primalac.primi();
            if (odgovor.getVrstaOdgovora() == VrstaOdgovora.USPESNO) {
                return (ArrayList<Kampanja>) odgovor.getParametar();
            } else {
                return null;
            }
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Kampanja> vratiKampanjeSaUslovom(String uslov) {
        Kampanja kampanja = new Kampanja();
        kampanja.setVrednostZaPretragu(uslov);
        try {
            System.out.println("Saljem zahtev. Vrati kampanje za vrednost");
            posiljalac.posalji(new Zahtev(Operacija.VRATI_KAMPANJE_ZA_VREDNOST, kampanja, true));
            Odgovor odgovor = (Odgovor) primalac.primi();
            if (odgovor.getVrstaOdgovora() == VrstaOdgovora.USPESNO) {
                return (ArrayList<Kampanja>) odgovor.getParametar();
            } else {
                return null;
            }
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Odgovor izmeniKampanju(Kampanja izmenjenaKampanja) {
        try {
            System.out.println("Saljem zahtev. Izmeni kampanju");
            posiljalac.posalji(new Zahtev(Operacija.IZMENI_KAMPANJU, izmenjenaKampanja, true));
            return (Odgovor) primalac.primi();

        } catch (Exception ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Odgovor obrisiKampanju(Kampanja kampanja) {
        try {
            System.out.println("Saljem zahtev. Obriši kampanju");
            posiljalac.posalji(new Zahtev(Operacija.OBRISI_KAMPANJU, kampanja, true));
            return (Odgovor) primalac.primi();

        } catch (Exception ex) {
            Logger.getLogger(KontrolerKIPartner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
