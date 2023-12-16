/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Danilo
 */
public interface OpstiDomenskiObjekat extends Serializable{
    String vratiNazivTabele();
    
    String vratiNaziveKolonatabele();
    
    String vratiVrednostiZaKreiranje();
    
    String vratiVrednostiZaPromenu();
    
    String vratiPrimarniKljuc();
    
    String alijas();
    
    String join();
    
    String uslov();
        
    List<OpstiDomenskiObjekat> vratiSve(ResultSet rs) throws SQLException;
}
