/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class Odeljenje implements OpstiDomenskiObjekat {

    private Long odeljenjeId;
    private String naziv;

    public Odeljenje() {
    }

    public Odeljenje(Long odeljenjeId, String naziv) {
        this.odeljenjeId = odeljenjeId;
        this.naziv = naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "odeljenje";
    }

    @Override
    public String vratiNaziveKolonatabele() {
        return "(`odeljenjeId`, `naziv`)";
    }

    @Override
    public String vratiVrednostiZaKreiranje() {
        return odeljenjeId + ",'" + naziv + "'";
    }

    @Override
    public String vratiVrednostiZaPromenu() {
        return ", naziv='" + naziv + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "odeljenjeId=" + odeljenjeId;
    }

    @Override
    public String alijas() {
        return "o";
    }

    @Override
    public String join() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String uslov() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiSve(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Long getOdeljenjeId() {
        return odeljenjeId;
    }

    public void setOdeljenjeId(Long odeljenjeId) {
        this.odeljenjeId = odeljenjeId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
