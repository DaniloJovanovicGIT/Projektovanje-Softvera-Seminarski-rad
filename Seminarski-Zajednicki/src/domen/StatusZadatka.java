/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class StatusZadatka implements OpstiDomenskiObjekat {

    private int statusZadatkaId;
    private String naziv;

    public StatusZadatka() {
    }

    public StatusZadatka(int statusZadatkaId, String naziv) {
        this.statusZadatkaId = statusZadatkaId;
        this.naziv = naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "statuszadatka";
    }

    @Override
    public String vratiNaziveKolonatabele() {
        return "(`statusZadatkaId`, `naziv`)";
    }

    @Override
    public String vratiVrednostiZaKreiranje() {
        return String.format("('%s')", naziv);
    }

    @Override
    public String vratiVrednostiZaPromenu() {
        return String.format("naziv = '%s'", naziv);
    }

    @Override
    public String vratiPrimarniKljuc() {
        return String.format("statusZadatkaId = '%d'", statusZadatkaId);
    }

    @Override
    public String alijas() {
        return "sz";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String uslov() {
        return String.format("WHERE statusZadatkaId = '%d'", statusZadatkaId);
    }

    @Override
    public String uslovZaPretragu() {
        return String.format("WHERE naziv LIKE '%%%s%%'", naziv);
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiSve(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> list = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("statusZadatkaId");
            String name = rs.getString("naziv");
            list.add(new StatusZadatka(id, name));
        }
        return list;
    }

    public int getStatusZadatkaId() {
        return statusZadatkaId;
    }

    public void setStatusZadatkaId(int statusZadatkaId) {
        this.statusZadatkaId = statusZadatkaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    } 
}
