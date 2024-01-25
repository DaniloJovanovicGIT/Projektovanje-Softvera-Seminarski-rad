/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Menadzer;
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
        posaljiZahtev(new Zahtev(Operacija.LOGIN, menadzer, true));
        return primiOdgovor();
    }

}
