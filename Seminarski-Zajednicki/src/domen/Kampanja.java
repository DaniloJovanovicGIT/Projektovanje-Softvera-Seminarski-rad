/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Danilo
 */
public class Kampanja implements OpstiDomenskiObjekat {

    private Long kampanjaId;
    private String naziv;
    private Date datumPocetka;
    private Date datumZavrsetka;
    private Zaposleni odgovorniZaposleni;
    private Partner partner;
    private List<Zadatak> zadaci;

    public Kampanja() {
    }

    public Kampanja(Long kampanjaId, String naziv, Date datumPocetka, Date datumZavrsetka, Zaposleni odgovorniZaposleni, Partner partner, List<Zadatak> zadaci) {
        this.kampanjaId = kampanjaId;
        this.naziv = naziv;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.odgovorniZaposleni = odgovorniZaposleni;
        this.partner = partner;
        this.zadaci = zadaci;
    }

    

    @Override
    public String vratiNazivTabele() {
        return "kampanja";
    }

    @Override
    public String vratiNaziveKolonatabele() {
        return "(`kampanjaId`, `naziv`, `datumPocetka`, `datumZavrsetka`, `kontaktOsoba`, `pib`)";
    }

    @Override
    public String vratiVrednostiZaKreiranje() {
        return kampanjaId + ",'" + naziv + "','" + datumPocetka + "','" + datumZavrsetka + "','" + kontaktOsoba + "','" + partner.getPib() + "'";
    }

    @Override
    public String vratiVrednostiZaPromenu() {
        return ", naziv='" + naziv + "', datumPocetka='" + datumPocetka + "', datumZavrsetka='" + datumZavrsetka + "', kontaktOsoba='" + kontaktOsoba + "', pib='" + partner.getPib() + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "kampanjaId=" + kampanjaId;
    }

    @Override
    public String alijas() {
        return "k";
    }

    @Override
    public String join() {
        return "LEFT JOIN zadatak ON kampanja.kampanjaId = zadatak.kampanjaId";
    }

    @Override
    public String uslov() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiSve(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Long getKampanjaId() {
        return kampanjaId;
    }

    public void setKampanjaId(Long kampanjaId) {
        this.kampanjaId = kampanjaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(Date datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.kampanjaId);
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
        final Kampanja other = (Kampanja) obj;
        return Objects.equals(this.kampanjaId, other.kampanjaId);
    }

    public List<Zadatak> getZadaci() {
        return zadaci;
    }

    public void setZadaci(List<Zadatak> zadaci) {
        this.zadaci = zadaci;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    @Override
    public String uslovZaPretragu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Zaposleni getOdgovorniZaposleni() {
        return odgovorniZaposleni;
    }

    public void setOdgovorniZaposleni(Zaposleni odgovorniZaposleni) {
        this.odgovorniZaposleni = odgovorniZaposleni;
    }

}
