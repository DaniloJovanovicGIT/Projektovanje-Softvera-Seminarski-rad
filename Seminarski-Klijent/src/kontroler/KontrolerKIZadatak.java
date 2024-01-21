/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.StatusZadatka;
import java.util.ArrayList;
import komunikacija.Odgovor;
import komunikacija.Operacija;
import komunikacija.VrstaOdgovora;
import komunikacija.Zahtev;

/**
 *
 * @author Danilo
 */
public class KontrolerKIZadatak extends OpstiKontrolerKI {

    private static KontrolerKIZadatak instance;

    private KontrolerKIZadatak() {
    }

    public static KontrolerKIZadatak getInstance() {
        if (instance == null) {
            instance = new KontrolerKIZadatak();
        }
        return instance;
    }

    public ArrayList<StatusZadatka> vratiSveStatuseZadataka() {

        try {
            System.out.println("Saljem zahtev. Vrati sve statuse zadatka.");
            posiljalac.posalji(new Zahtev(Operacija.VRATI_SVE_STATUSE_ZADATKA, null, true));
            Odgovor odgovor = (Odgovor) primalac.primi();
            if (odgovor.getVrstaOdgovora() == VrstaOdgovora.USPESNO) {
                return (ArrayList<StatusZadatka>) odgovor.getParametar();
            } else {
                return null;
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(KontrolerKIZadatak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }
}
