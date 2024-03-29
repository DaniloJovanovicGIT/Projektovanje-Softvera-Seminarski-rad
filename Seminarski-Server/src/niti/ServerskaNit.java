/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domen.Menadzer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Konstante;

/**
 *
 * @author Danilo
 */
public class ServerskaNit extends Thread {

    ServerSocket serverskiSoket;
    List<ObradaZahtevaKlijentaNit> listaKlijentskihNiti;
    ArrayList<Menadzer> ulogovaniMenadzeri;

    public ServerskaNit() throws FileNotFoundException, IOException {
        Properties parametri = new Properties();
        parametri.load(new FileInputStream(Konstante.LOKACIJA_PARAMETARA_SERVERA));
        int portServera = Integer.parseInt(parametri.getProperty(Konstante.PORT_SERVERA_KEY));
        serverskiSoket = new ServerSocket(portServera);
        listaKlijentskihNiti = new ArrayList<>();
        ulogovaniMenadzeri = new ArrayList<Menadzer>();
    }

    @Override
    public void run() {
        while (serverskiSoket != null && !serverskiSoket.isClosed()) {
            try {
                System.out.println("Server je pokrenut.");
                Socket soket = serverskiSoket.accept();
                ObradaZahtevaKlijentaNit klijentskaNit = new ObradaZahtevaKlijentaNit(soket, this, ulogovaniMenadzeri);
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
