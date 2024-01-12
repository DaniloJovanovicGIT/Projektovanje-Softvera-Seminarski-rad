/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Danilo
 */
public class Partner implements OpstiDomenskiObjekat {

    private String pib;
    private String noviPib;
    private String naziv;
    private Date datumOsnivanja;
    private String kontaktOsoba;
    private String brojTelefona;
    private String email;
    private String vrednostZaPretragu;

    public Partner(String pib, String naziv, Date datumOsnivanja, String kontatktOsoba, String brojTelefona, String email) {
        this.pib = pib;
        this.naziv = naziv;
        this.datumOsnivanja = datumOsnivanja;
        this.kontaktOsoba = kontatktOsoba;
        this.brojTelefona = brojTelefona;
        this.email = email;
    }

    public Partner() {
    }

    @Override
    public String vratiNazivTabele() {
        return "partner";
    }

    @Override
    public String vratiNaziveKolonatabele() {
        return "(`pib`,`naziv`,`datumOsnivanja`,`kontaktOsoba`,`brojTelefona`,`email`)";
    }

    @Override
    public String vratiVrednostiZaKreiranje() {

        return "'" + pib + "','" + naziv + "','" + new java.sql.Date(datumOsnivanja.getTime()) + "','" + kontaktOsoba + "','" + brojTelefona + "','" + email + "'";
    }

    @Override
    public String vratiVrednostiZaPromenu() {
        return "pib= '"+noviPib+"', naziv= '" + naziv + "', datumOsnivanja= '" + new java.sql.Date(datumOsnivanja.getTime()) + "', kontaktOsoba='" + kontaktOsoba + "', brojTelefona='" + brojTelefona + "', email='" + email + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "pib='" + pib + "'";
    }

    @Override
    public String alijas() {
        return "p";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String uslov() {
        return "WHERE pib ='" + pib + "'";
    }

    @Override
    public String uslovZaPretragu() {
        return "WHERE pib LIKE'%" + this.vrednostZaPretragu + "%' OR naziv LIKE'%" + this.vrednostZaPretragu + "%' OR kontaktOsoba LIKE'%" + this.vrednostZaPretragu + "%'";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiSve(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            Partner partner = new Partner(rs.getString("pib"), rs.getString("naziv"), rs.getDate("datumOsnivanja"), rs.getString("kontaktOsoba"), rs.getString("brojTelefona"), rs.getString("email"));
            lista.add(partner);
        }

        rs.close();
        return lista;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatumOsnivanja() {
        return datumOsnivanja;
    }

    public void setDatumOsnivanja(Date datumOsnivanja) {
        this.datumOsnivanja = datumOsnivanja;
    }

    public String getKontaktOsoba() {
        return kontaktOsoba;
    }

    public void setKontaktOsoba(String kontatktOsoba) {
        this.kontaktOsoba = kontatktOsoba;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.pib);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partner other = (Partner) obj;
        return Objects.equals(this.pib, other.pib);
    }

    @Override
    public String toString() {
        return naziv;
    }

    public String getVrednostZaPretragu() {
        return vrednostZaPretragu;
    }

    public void setVrednostZaPretragu(String vrednostZaPretragu) {
        this.vrednostZaPretragu = vrednostZaPretragu;
    }

    public String getNoviPib() {
        return noviPib;
    }

    public void setNoviPib(String noviPib) {
        this.noviPib = noviPib;
    }

}
