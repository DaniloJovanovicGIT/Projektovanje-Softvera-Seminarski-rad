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
public class Zaposleni implements OpstiDomenskiObjekat {

    private String jmbg;
    private String ime;
    private String prezime;
    private int staz;
    private Odeljenje odeljenje;

    public Zaposleni() {
    }

    public Zaposleni(String jmbg, String ime, String prezime, int staz, Odeljenje odeljenje) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.staz = staz;
        this.odeljenje = odeljenje;
    }

    @Override
    public String vratiNazivTabele() {
        return "zaposleni";
    }

    @Override
    public String vratiNaziveKolonatabele() {
        return "(`jmbg`, `ime`, `prezime`, `staz`, `odeljenjeId`)";
    }

    @Override
    public String vratiVrednostiZaKreiranje() {
        return "'" + jmbg + "','" + ime + "','" + prezime + "'," + staz + "," + odeljenje.getOdeljenjeId();
    }

    @Override
    public String vratiVrednostiZaPromenu() {
        return ", ime='" + ime + "', prezime='" + prezime + "', staz=" + staz + ", odeljenjeId=" + odeljenje.getOdeljenjeId();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "jmbg='" + jmbg + "'";
    }

    @Override
    public String alijas() {
        return "z";
    }

    @Override
    public String join() {
        return "INNER JOIN odeljenje ON zaposleni.odeljenjeId = odeljenje.odeljenjeId";
    }

    @Override
    public String uslov() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiSve(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getStaz() {
        return staz;
    }

    public void setStaz(int staz) {
        this.staz = staz;
    }

    public Odeljenje getOdeljenje() {
        return odeljenje;
    }

    public void setOdeljenje(Odeljenje odeljenje) {
        this.odeljenje = odeljenje;
    }



    @Override
    public String uslovZaPretragu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
