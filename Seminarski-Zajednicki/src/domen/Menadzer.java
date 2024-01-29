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
public class Menadzer implements OpstiDomenskiObjekat {

    private Long menadzerId;
    private String ime;
    private String prezime;
    private String username;
    private String password;

    public Menadzer() {
    }

    public Menadzer(Long menadzerId, String ime, String prezime, String username, String password) {
        this.menadzerId = menadzerId;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    @Override
    public String vratiNazivTabele() {
        return "menadzer";
    }

    @Override
    public String vratiNazivPrimarnogKljuca() {
        return "menadzerId";
    }

    @Override
    public String vratiNaziveKolonatabele() {
        return "menadzerId, ime, prezime, username, password";
    }

    @Override
    public String vratiVrednostiZaKreiranje() {
        return String.format("'%d', '%s', '%s', '%s', '%s'",
                menadzerId, ime, prezime, username, password);

    }

    @Override
    public String vratiVrednostiZaPromenu() {
        return String.format("ime = '%s', prezime = '%s', username = '%s', password = '%s'",
                ime, prezime, username, password);
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "menadzerId = " + menadzerId;
    }

    @Override
    public String alijas() {
        return "m";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String uslov() {
        return "username = '" + username + "'";
    }

    @Override
    public String uslovZaPretragu() {
        return "ime LIKE '%" + ime + "%' OR prezime LIKE '%" + prezime + "%'";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiSve(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Menadzer m = new Menadzer();
            m.setMenadzerId(rs.getLong("menadzerId"));
            m.setIme(rs.getString("ime"));
            m.setPrezime(rs.getString("prezime"));
            m.setUsername(rs.getString("username"));
            m.setPassword(rs.getString("password"));
            lista.add(m);
        }
        return lista;
    }

    public Long getMenadzerId() {
        return menadzerId;
    }

    public void setMenadzerId(Long menadzerId) {
        this.menadzerId = menadzerId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.menadzerId);
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
        final Menadzer other = (Menadzer) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    
    
}
