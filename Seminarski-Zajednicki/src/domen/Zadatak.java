/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class Zadatak implements OpstiDomenskiObjekat {
    private Long zadatakId;
    private String naziv;
    private String opis;
    private Date ocekivaniZavrsetak;
    private List<Zaposleni> zaduzeniZaposleni;

    public Zadatak() {
    }

    public Zadatak(Long zadatakId, String naziv, String opis, Date ocekivaniZavrsetak, List<Zaposleni> zaduzeniZaposleni) {
        this.zadatakId = zadatakId;
        this.naziv = naziv;
        this.opis = opis;
        this.ocekivaniZavrsetak = ocekivaniZavrsetak;
        this.zaduzeniZaposleni = zaduzeniZaposleni;
    }
    
    

    @Override
    public String vratiNazivTabele() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiNaziveKolonatabele() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaKreiranje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaPromenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiPrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String alijas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String join() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String uslov() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiSve(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Long getZadatakId() {
        return zadatakId;
    }

    public void setZadatakId(Long zadatakId) {
        this.zadatakId = zadatakId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getOcekivaniZavrsetak() {
        return ocekivaniZavrsetak;
    }

    public void setOcekivaniZavrsetak(Date ocekivaniZavrsetak) {
        this.ocekivaniZavrsetak = ocekivaniZavrsetak;
    }

    public List<Zaposleni> getZaduzeniZaposleni() {
        return zaduzeniZaposleni;
    }

    public void setZaduzeniZaposleni(List<Zaposleni> zaduzeniZaposleni) {
        this.zaduzeniZaposleni = zaduzeniZaposleni;
    }

}
