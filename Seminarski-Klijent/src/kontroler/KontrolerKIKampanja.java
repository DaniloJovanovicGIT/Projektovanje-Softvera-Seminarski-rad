/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Kampanja;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Operacija;
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

}
