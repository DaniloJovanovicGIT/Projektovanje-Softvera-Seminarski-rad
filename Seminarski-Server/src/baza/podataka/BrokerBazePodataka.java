/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza.podataka;

import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class BrokerBazePodataka {

    private static BrokerBazePodataka instance;
    private static Connection konekcija;

    public BrokerBazePodataka() {
        try {
            String lokacija=konstante.Konstante.LOKACIJA_BAZE+konstante.Konstante.NAZIV_BAZE;
            String username=konstante.Konstante.USERNAME_BAZA;
            String password=konstante.Konstante.PASSWORD_BAZA;
            
            konekcija=DriverManager.getConnection(lokacija,username,password);
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(BrokerBazePodataka.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    public static BrokerBazePodataka getInstance() {
        if (instance == null) {
            instance = new BrokerBazePodataka();
        }
        return instance;
    }

     public PreparedStatement zapamti(OpstiDomenskiObjekat objekat) throws SQLException {
        String upit = "INSERT INTO " + objekat.vratiNazivTabele()+ " "
                + objekat.vratiNaziveKolonatabele()+ " VALUES(" + objekat.vratiVrednostiZaKreiranje()+ ")";
        System.out.println(upit);
        PreparedStatement ps = konekcija.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }

}
