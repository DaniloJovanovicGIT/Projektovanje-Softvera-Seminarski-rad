/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Konstante;

/**
 *
 * @author Danilo
 */
public class PostaviParametre {

    public static void main(String[] args) {
        {
            postaviParametreServera();
            postaviParametreBaze();

        }

    }

    private static void postaviParametreServera() {
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream(Konstante.LOKACIJA_PARAMETARA_SERVERA);
            // postavi port servera
            prop.setProperty(Konstante.PORT_SERVERA_KEY, "9000");
            // sacuvaj paramtere
            prop.store(output, null);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PostaviParametre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PostaviParametre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void postaviParametreBaze() {
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream(Konstante.LOKACIJA_PARAMETARA_BAZE);
            // postavi parametre baze
            prop.setProperty(Konstante.LOKACIJA_BAZE_KEY, "jdbc:mysql://localhost:3306/seminarski");
            prop.setProperty(Konstante.USERNAME_BAZA_KEY, "root");
            prop.setProperty(Konstante.PASSWORD_BAZA_KEY, "");
            // sacuvaj postavljene parametre
            prop.store(output, null);

        } catch (IOException ex) {
            Logger.getLogger(PostaviParametre.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
