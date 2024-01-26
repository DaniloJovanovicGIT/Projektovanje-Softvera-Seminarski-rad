/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;

/**
 *
 * @author Danilo
 */
public  class OpstiKontrolerKI {
    protected int brojSoketa = konstante.Konstante.PORT_SERVERA;
    protected String adresaServera = konstante.Konstante.ADRESA_SERVERA;
    protected Socket soket;
    protected Posiljalac posiljalac;
    protected Primalac primalac;

    public OpstiKontrolerKI() {
      
         try {
             this.soket = new Socket(adresaServera, brojSoketa);
             this.posiljalac = new Posiljalac(soket);
             this.primalac = new Primalac(soket);
         } catch (IOException ex) {
             java.util.logging.Logger.getLogger(OpstiKontrolerKI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
        
    }

    protected void posaljiZahtev(Zahtev zahtev) throws IOException {
        try {
            posiljalac.posalji(zahtev);
        } catch (IOException ex) {
            throw ex;
        }
    }

    protected Odgovor primiOdgovor() {
        try {
            return (Odgovor) primalac.primi();
        }  catch (Exception ex) {
             Logger.getLogger(OpstiKontrolerKI.class.getName()).log(Level.SEVERE, null, ex);
         }
        return null;
    }
    
}
