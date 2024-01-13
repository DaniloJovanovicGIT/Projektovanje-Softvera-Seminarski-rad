/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Odeljenje;
import domen.Zaposleni;
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
            } else {
                return null;
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

}