/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza.podataka;

import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class BrokerBazePodataka {

    private Connection konekcija;

    public BrokerBazePodataka() {
    }

    public void otvoriKonekciju() throws SQLException {
        if (konekcija == null || konekcija.isClosed()) {
            String lokacija = konstante.Konstante.LOKACIJA_BAZE + konstante.Konstante.NAZIV_BAZE;
            String username = konstante.Konstante.USERNAME_BAZA;
            String password = konstante.Konstante.PASSWORD_BAZA;

            konekcija = DriverManager.getConnection(lokacija, username, password);
            konekcija.setAutoCommit(false);
        }
        System.out.println("KOnekcija otvorena");
    }

    public void commit() throws SQLException {
        konekcija.commit();
        System.out.println("Commit");
    }

    public void rollback() throws SQLException {
        konekcija.rollback();
        System.out.println("Rollback");
    }

    public void zatvoriKonekciju() throws SQLException {
        konekcija.close();
        System.out.println("Konekcija zatvorena");
    }

    public ArrayList<OpstiDomenskiObjekat> vrati(OpstiDomenskiObjekat objekat) throws SQLException {
        String upit = "SELECT * FROM " + objekat.vratiNazivTabele() + " " + objekat.alijas()
                + " " + objekat.join() + " ";
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return (ArrayList<OpstiDomenskiObjekat>) objekat.vratiSve(rs);
    }

    public boolean zapamti(OpstiDomenskiObjekat objekat) throws SQLException {
        String upit = "INSERT INTO " + objekat.vratiNazivTabele() + " "
                + objekat.vratiNaziveKolonatabele() + " VALUES(" + objekat.vratiVrednostiZaKreiranje() + ")";
        System.out.println(upit);
        PreparedStatement ps = konekcija.prepareStatement(upit);
        int brojObrisanihRedova = ps.executeUpdate();
        return brojObrisanihRedova > 0;
    }

    public boolean izmeni(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "UPDATE " + odo.vratiNazivTabele() + " SET "
                + odo.vratiVrednostiZaPromenu() + " WHERE " + odo.vratiPrimarniKljuc();
        System.out.println(upit);
        PreparedStatement ps = konekcija.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        int brojObrisanihRedova = ps.executeUpdate();
        return brojObrisanihRedova > 0;
    }

    public boolean obrisi(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "DELETE FROM " + odo.vratiNazivTabele()
                + " WHERE " + odo.vratiPrimarniKljuc();
        System.out.println(upit);
        PreparedStatement ps = konekcija.prepareStatement(upit);
        int brojObrisanihRedova = ps.executeUpdate();
        return brojObrisanihRedova > 0;
    }

    public OpstiDomenskiObjekat pronadjiObjekat(OpstiDomenskiObjekat objekat) throws SQLException {
        String upit = "SELECT * FROM " + objekat.vratiNazivTabele() + " " + objekat.alijas()
                + " " + objekat.join() + " " + objekat.uslov();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return (OpstiDomenskiObjekat) objekat.vratiSve(rs);
    }

    public List<OpstiDomenskiObjekat> vratiSveSaUslovom(OpstiDomenskiObjekat objekat) throws SQLException {
        String upit = "SELECT * FROM " + objekat.vratiNazivTabele() + " " + objekat.alijas()
                + " " + objekat.join() + " " + objekat.uslovZaPretragu();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return (List<OpstiDomenskiObjekat>) objekat.vratiSve(rs);
    }
}
