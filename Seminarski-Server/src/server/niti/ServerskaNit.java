/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.niti;

import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
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
                Socket soket = serverskiSoket.accept();
                ObradaZahtevaKlijentaNit klijentskaNit = new ObradaZahtevaKlijentaNit(soket, this);
                klijentskaNit.start();
                listaKlijentskihNiti.add(klijentskaNit);
                System.out.println("Povezao se klijent broj : " + (listaKlijentskihNiti.size() + 1));
            } catch (IOException ex) {
                Logger.getLogger(ServerskaNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
