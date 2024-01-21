/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private String vrednostZaPretragu;

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
        return "(`naziv`, `datumPocetka`, `datumZavrsetka`, `jmbg`, `pib`)";
    }

    @Override
    public String vratiNazivPrimarnogKljuca() {
        return "kampanjaId";
    }

    @Override
    public String vratiVrednostiZaKreiranje() {
        return "'" + naziv + "','" + new java.sql.Date(datumPocetka.getTime()) + "','" + new java.sql.Date(datumZavrsetka.getTime()) + "','" + odgovorniZaposleni.getJmbg() + "','" + partner.getPib() + "'";
    }

    @Override
    public String vratiVrednostiZaPromenu() {
        return " naziv='" + naziv + "', datumPocetka='" + new java.sql.Date(datumPocetka.getTime()) + "', datumZavrsetka='" + new java.sql.Date(datumZavrsetka.getTime()) + "', jmbg='" + odgovorniZaposleni.getJmbg() + "', pib='" + partner.getPib() + "'";
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
        return "JOIN partner p ON k.pib=p.pib JOIN zaposleni z ON k.jmbg = z.jmbg LEFT JOIN odeljenje o ON z.odeljenjeId=o.odeljenjeId LEFT JOIN zadatak zad ON k.kampanjaId=zad.kampanjaId"
                + " LEFT JOIN statusZadatka sz ON zad.statusZadatka = sz.statusZadatkaId";
    }

    @Override
    public String uslov() {
        return "WHERE k.kampanjaId = " + kampanjaId;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiSve(ResultSet rs) throws SQLException {
        Map<Integer, Kampanja> kampanjaMap = new HashMap<>();
        ArrayList<OpstiDomenskiObjekat> kampanje = new ArrayList<>();

        while (rs.next()) {
            int kampanjaId = rs.getInt("k.kampanjaId");
            Kampanja kampanja = kampanjaMap.get(kampanjaId);

            if (kampanja == null) {
                kampanja = new Kampanja();
                kampanja.setKampanjaId(rs.getLong("k.kampanjaId"));
                kampanja.setNaziv(rs.getString("k.naziv"));
                kampanja.setDatumPocetka(rs.getDate("k.datumPocetka"));
                kampanja.setDatumZavrsetka(rs.getDate("k.datumZavrsetka"));
                kampanja.setZadaci(new ArrayList<>());

                Partner partner = new Partner();
                partner.setPib(rs.getString("p.pib"));
                partner.setNaziv(rs.getString("p.naziv"));
                partner.setDatumOsnivanja(rs.getDate("p.datumOsnivanja"));
                partner.setKontaktOsoba(rs.getString("p.kontaktOsoba"));
                partner.setBrojTelefona(rs.getString("p.brojTelefona"));
                partner.setEmail(rs.getString("p.email"));

                kampanja.setPartner(partner);

                Zaposleni glavniOdgovorni = new Zaposleni();
                glavniOdgovorni.setJmbg(rs.getString("z.jmbg"));
                glavniOdgovorni.setIme(rs.getString("z.ime"));
                glavniOdgovorni.setPrezime(rs.getString("z.prezime"));
                glavniOdgovorni.setStaz(rs.getInt("z.staz"));

                Odeljenje odeljenje = new Odeljenje();
                odeljenje.setOdeljenjeId(rs.getInt("o.odeljenjeId"));
                odeljenje.setNaziv(rs.getString("o.naziv"));

                glavniOdgovorni.setOdeljenje(odeljenje);

                kampanja.setOdgovorniZaposleni(glavniOdgovorni);

                kampanjaMap.put(kampanjaId, kampanja);
                kampanje.add(kampanja);
            }

            Zadatak zadatak = new Zadatak();
            zadatak.setKampanja(kampanja);
            zadatak.setNaziv(rs.getString("zad.naziv"));
            zadatak.setOpis(rs.getString("zad.opis"));
            zadatak.setZadatakId(rs.getLong("zad.zadatakId"));
            zadatak.setOcekivaniZavrsetak(rs.getDate("zad.ocekivaniZavrsetak"));

            StatusZadatka statusZadatka = new StatusZadatka();
            statusZadatka.setStatusZadatkaId(rs.getInt("sz.statusZadatkaId"));
            statusZadatka.setNaziv(rs.getString("sz.naziv"));

            zadatak.setStatusZadatka(statusZadatka);

            kampanja.getZadaci().add(zadatak);
        }

        return kampanje;
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
        return "WHERE k.naziv LIKE'%" + this.vrednostZaPretragu + "%' OR p.naziv LIKE'%" + this.vrednostZaPretragu + "%' OR z.ime LIKE'%" + this.vrednostZaPretragu + "%'OR z.prezime LIKE'%" + this.vrednostZaPretragu + "%'OR o.naziv LIKE'%" + this.vrednostZaPretragu + "%'";
    }

    public Zaposleni getOdgovorniZaposleni() {
        return odgovorniZaposleni;
    }

    public void setOdgovorniZaposleni(Zaposleni odgovorniZaposleni) {
        this.odgovorniZaposleni = odgovorniZaposleni;
    }

    public void setVrednostZaPretragu(String uslov) {
        this.vrednostZaPretragu = uslov;
    }
}
