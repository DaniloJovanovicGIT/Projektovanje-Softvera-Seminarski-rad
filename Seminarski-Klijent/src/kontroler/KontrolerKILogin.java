/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Menadzer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Operacija;
import komunikacija.Zahtev;

/**
 *
 * @author Danilo
 */
public class KontrolerKILogin extends OpstiKontrolerKI {

    private static KontrolerKILogin instance;

    private KontrolerKILogin() {
    }

    public static KontrolerKILogin getInstance() {
        if (instance == null) {
            instance = new KontrolerKILogin();
        }
        return instance;
    }

    public Odgovor login(String username, String password) {
        Menadzer menadzer = new Menadzer();
        menadzer.setUsername(username);
        menadzer.setPassword(password);
        try {
            posaljiZahtev(new Zahtev(Operacija.LOGIN, menadzer, true));
            return primiOdgovor();
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKILogin.class.getName()).log(Level.SEVERE, "Server nije u funkciji.", ex);
        }
        return null;
    }

}
