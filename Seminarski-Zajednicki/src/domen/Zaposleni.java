/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private String vrednostZaPretragu;
    private String noviJmbg;

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
    public String vratiNazivPrimarnogKljuca() {
        return "jmbg";
    }

    @Override
    public String vratiVrednostiZaKreiranje() {
        return "'" + jmbg + "','" + ime + "','" + prezime + "'," + staz + "," + odeljenje.getOdeljenjeId();
    }

    @Override
    public String vratiVrednostiZaPromenu() {
        return "jmbg ='" + noviJmbg + "', ime='" + ime + "', prezime='" + prezime + "', staz=" + staz + ", odeljenjeId=" + odeljenje.getOdeljenjeId();
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
        return "INNER JOIN odeljenje o ON z.odeljenjeId = o.odeljenjeId";
    }

    @Override
    public String uslov() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiSve(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Zaposleni zaposleni = new Zaposleni();
            zaposleni.setJmbg(rs.getString("jmbg"));
            zaposleni.setIme(rs.getString("ime"));
            zaposleni.setPrezime(rs.getString("prezime"));
            zaposleni.setStaz(rs.getInt("staz"));

            Odeljenje odeljenje = new Odeljenje();
            odeljenje.setOdeljenjeId(rs.getInt("odeljenjeId"));
            odeljenje.setNaziv(rs.getString("naziv"));
            zaposleni.setOdeljenje(odeljenje);
            lista.add(zaposleni);
        }
        return lista;
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
        return "WHERE z.ime LIKE'%" + this.vrednostZaPretragu + "%' OR z.prezime LIKE'%" + this.vrednostZaPretragu + "%' OR z.jmbg LIKE'%" + this.vrednostZaPretragu + "%' OR o.naziv LIKE'%" + this.vrednostZaPretragu + "%'";
    }

    public String getVrednostZaPretragu() {
        return vrednostZaPretragu;
    }

    public void setVrednostZaPretragu(String vrednostZaPretragu) {
        this.vrednostZaPretragu = vrednostZaPretragu;
    }

    public String getNoviJmbg() {
        return noviJmbg;
    }

    public void setNoviJmbg(String noviJmbg) {
        this.noviJmbg = noviJmbg;
    }

    @Override
    public String toString() {
        return ime + " " + prezime + "(" + odeljenje.getNaziv() + ")";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.jmbg);
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
        final Zaposleni other = (Zaposleni) obj;
        return Objects.equals(this.jmbg, other.jmbg);
    }
}
