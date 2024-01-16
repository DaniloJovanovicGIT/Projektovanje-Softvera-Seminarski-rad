/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konstante;

import java.text.SimpleDateFormat;

/**
 *
 * @author Danilo
 */
public class Konstante {
    //SOKET
    public static final int PORT_SERVERA = 9000;
    public static final String ADRESA_SERVERA = "localhost";
    
    //UI PORUKE
    public static final String PORUKA_USPESNO = "Uspešno izvrsšeno.";
    public static final String PORUKA_NEUSPESNO = "Došlo je do greške.";
    
    //OBRADA DATUMA
    public static final String FORMAT_DATUMA = "dd.MM.yyyy";
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(FORMAT_DATUMA);
    public static final String PORUKA_GRESKA_FORMAT_DATUMA = "Datum mora biti u formatu "+FORMAT_DATUMA+".";
}
