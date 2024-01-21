/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikaciona.logika;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class ServerskaNit extends Thread {

    ServerSocket serverskiSoket;
    List<ObradaZahtevaKlijentaNit> listaKlijentskihNiti;

    public ServerskaNit() throws IOException {
        serverskiSoket = new ServerSocket(konstante.Konstante.PORT_SERVERA);
        listaKlijentskihNiti = new ArrayList<>();
    }

    @Override
    public void run() {
        while (serverskiSoket != null && !serverskiSoket.isClosed()) {
            try {
                System.out.println("Server je pokrenut na portu:" + konstante.Konstante.PORT_SERVERA);
                Socket soket = serverskiSoket.accept();
                ObradaZahtevaKlijentaNit klijentskaNit = new ObradaZahtevaKlijentaNit(soket, this);
                klijentskaNit.start();
                listaKlijentskihNiti.add(klijentskaNit);
                System.out.println("Povezao se klijent broj : " + (listaKlijentskihNiti.size()));
            } catch (SocketException e) {
                System.out.println("Serverski soket je zatvoren.");
                break;
            } catch (IOException ex) {
                Logger.getLogger(ServerskaNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void zaustaviServer() {
        try {

            for (ObradaZahtevaKlijentaNit klijentskaNit : listaKlijentskihNiti) {
                klijentskaNit.zatvoriSoket();
            }

            if (serverskiSoket != null && !serverskiSoket.isClosed()) {
                serverskiSoket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
