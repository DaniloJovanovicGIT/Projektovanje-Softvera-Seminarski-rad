/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package forme;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import komunikacija.Odgovor;
import komunikacija.VrstaOdgovora;

/**
 *
 * @author Danilo
 */
public interface FormaInterfejs {

    /**
     *
     * @param odgovor
     * @param zatvori
     * @param aThis
     */
    public default void prikaziObavestenje(Odgovor odgovor, boolean zatvori, JFrame aThis) {
        if (odgovor == null) {
            JOptionPane.showMessageDialog(aThis, "Komunikacija sa serverom je prekinuta. Pokrenite server.", konstante.Konstante.PORUKA_NEUSPESNO, JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else if (odgovor.getVrstaOdgovora() == VrstaOdgovora.USPESNO) {
            JOptionPane.showMessageDialog(aThis, odgovor.getPoruka(), konstante.Konstante.PORUKA_USPESNO, JOptionPane.INFORMATION_MESSAGE);
        } else if (odgovor.getVrstaOdgovora() == VrstaOdgovora.GRESKA) {
            JOptionPane.showMessageDialog(aThis, odgovor.getPoruka(), konstante.Konstante.PORUKA_NEUSPESNO, JOptionPane.ERROR_MESSAGE);
            aThis.dispose();
        }

        if (zatvori) {
            aThis.dispose();
        }
    }
}
