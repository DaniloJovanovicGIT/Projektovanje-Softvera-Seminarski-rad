/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class Zadatak implements OpstiDomenskiObjekat {

    private Kampanja kampanja;
    private Long zadatakId;
    private String naziv;
    private String opis;
    private Date ocekivaniZavrsetak;
    private StatusZadatka statusZadatka;

    public Zadatak() {
    }

    public Zadatak(Kampanja kampanja, Long zadatakId, String naziv, String opis, Date ocekivaniZavrsetak, StatusZadatka statusZadatka) {
        this.kampanja = kampanja;
        this.zadatakId = zadatakId;
        this.naziv = naziv;
        this.opis = opis;
        this.ocekivaniZavrsetak = ocekivaniZavrsetak;
        this.statusZadatka = statusZadatka;
    }

    @Override
    public String vratiNazivTabele() {
        return "zadatak";
    }

    @Override
    public String vratiNaziveKolonatabele() {
        return "(`kampanjaId`, `zadatakId`, `naziv`, `opis`, `ocekivaniZavrsetak`,`statusZadatka`)";
    }

    @Override
    public String vratiVrednostiZaKreiranje() {
        return kampanja.getKampanjaId() + "," + zadatakId + ",'" + naziv + "','" + opis + "','" + ocekivaniZavrsetak + "'," + statusZadatka + "";
    }

    @Override
    public String vratiVrednostiZaPromenu() {
        return ", naziv='" + naziv + "', opis='" + opis + "', ocekivaniZavrsetak='" + ocekivaniZavrsetak + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "kampanjaId=" + kampanja.getKampanjaId() + " AND zadatakId=" + zadatakId;
    }

    @Override
    public String alijas() {
        return "z";
    }

    @Override
    public String join() {
        return "INNER JOIN statuszadatka sz ON z.statusZadatka = sz.statusZadatkaId";
    }

    @Override
    public String uslov() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiSve(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> listaZadataka = new ArrayList<>();

        while (rs.next()) {
            Zadatak zadatak = new Zadatak();
            zadatak.setZadatakId(rs.getLong("zadatakId"));
            zadatak.setNaziv(rs.getString("naziv"));
            zadatak.setOpis(rs.getString("opis"));
            zadatak.setOcekivaniZavrsetak(rs.getDate("ocekivaniZavrsetak"));

            
            StatusZadatka statusZadatka = new StatusZadatka();
            statusZadatka.setStatusZadatkaId(rs.getInt("sz.statusZadatkaId"));
            statusZadatka.setNaziv(rs.getString("sz.naziv"));

            zadatak.setStatusZadatka(statusZadatka);
           
            listaZadataka.add(zadatak);
        }

        return listaZadataka;
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

    public Kampanja getKampanja() {
        return kampanja;
    }

    public void setKampanja(Kampanja kampanja) {
        this.kampanja = kampanja;
    }

    @Override
    public String uslovZaPretragu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public StatusZadatka getStatusZadatka() {
        return statusZadatka;
    }

    public void setStatusZadatka(StatusZadatka statuZadatka) {
        this.statusZadatka = statuZadatka;
    }

}
