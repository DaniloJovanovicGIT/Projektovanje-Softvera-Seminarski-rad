package sistemske.operacije.test;

import domen.Kampanja;
import domen.Partner;
import domen.Zadatak;
import domen.Zaposleni;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import sistemske.operacije.kampanja.SOZapamtiKampanju;

public class SOKreirajKampanjuTest {

    private SOZapamtiKampanju soZapamtiKampanju;
    private Kampanja kampanja;

    public SOKreirajKampanjuTest() {
    }
    //priprema podataka
    @Before
    public void setUp() {
        soZapamtiKampanju = new SOZapamtiKampanju();
        kampanja = new Kampanja();
        kampanja.setNaziv("Nova kampanja");
        kampanja.setOdgovorniZaposleni(new Zaposleni("0101990801234", null, null, 0, null));
        kampanja.setPartner(new Partner("000333777", "ITSM Akademija", null, null, null, null));
        kampanja.setZadaci(new ArrayList<Zadatak>());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            kampanja.setDatumPocetka(sdf.parse("5.3.2024"));
            kampanja.setDatumZavrsetka(sdf.parse("5.4.2024"));
        } catch (ParseException ex) {
            Logger.getLogger(SOKreirajKampanjuTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //uklanjanje promena u bazi podataka ukoliko je doslo do istih
    @After
    public void tearDown() throws SQLException { 
        soZapamtiKampanju.bbp.otvoriKonekciju();
        soZapamtiKampanju.bbp.obrisi(kampanja);
        soZapamtiKampanju.bbp.potvrdiTransakciju();
        soZapamtiKampanju.bbp.zatvoriKonekciju();
    }

    // U nastavku se nalaze test metode za svaki test slucaj
    @Test
    public void testValidniPodaci() throws Exception {
        assertEquals(true, soZapamtiKampanju.opsteIzvrsenjeSO(kampanja));
    }
    
    @Test
    public void testNeodgovarajucaKlasa() throws Exception {
        assertEquals(false, soZapamtiKampanju.opsteIzvrsenjeSO(null));
    }
    
    
    @Test
    public void testNevalidniPodaci() throws Exception {
        kampanja.setNaziv(null);
        kampanja.setDatumZavrsetka(null);
        assertEquals(false, soZapamtiKampanju.opsteIzvrsenjeSO(kampanja));
    }
    
    @Test
    public void testDatumi() throws Exception {
        Date datum = kampanja.getDatumZavrsetka();
        kampanja.setDatumZavrsetka(kampanja.getDatumPocetka());
        kampanja.setDatumPocetka(datum);
        assertEquals(false, soZapamtiKampanju.opsteIzvrsenjeSO(kampanja));
    }
}
