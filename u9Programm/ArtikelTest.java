
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;

/**
 * Die Test-Klasse ArtikelTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class ArtikelTest
{
    private Artikel artikel1;

    /**
     * Konstruktor fuer die Test-Klasse ArtikelTest
     */

    public ArtikelTest(){}

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */

    @Before
    public void setUp()
    {
        artikel1 = new Artikel (1111, "Haus", 22, BigDecimal.ZERO);
    }

    /**
     * Prüft ob ein Zugang richtig gebucht wird.
     */
    
    @Test
    public void testZugang(){
        artikel1.zugangBestand(5);
        assertEquals("Betrag nicht korrekt gebucht",
            artikel1.getArtikelBestand(), 27);

    }
    
    /**
     * 
     * Prüft ob der eine negative Eingabe abgefangen wird.
     */
    
    @Test (expected = IllegalArgumentException.class)
    public void testZugangNegativerWert(){
        artikel1.zugangBestand(-5);
    }

    /**
     * Prüft ob ein Abgang richtig gebucht wird.
     */
    
    @Test
    public void testAbgang(){
        artikel1.abgangBestand(10);
        assertEquals("Betrag nicht korrekt abgebucht",
            artikel1.getArtikelBestand(),12);
    }
    
    /**
     * 
     * Prüft ob der eine negative Eingabe abgefangen wird.
     */
    
    @Test (expected = IllegalArgumentException.class)
    public void testAbgangNegativerWert(){
        artikel1.abgangBestand(-5);
    }
    
    /**
     * Prüft ob der BigDecimal Preis richtig gesetzt wird.
     */
    
    @Test
    public void testSetPreisEK(){
        
        BigDecimal preisEingabe = BigDecimal.valueOf(10).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal preisbd = BigDecimal.valueOf(10);
        
        artikel1.setArtikelPreisEK(preisbd);
        assertEquals("Betrag nicht korrekt",
            artikel1.getArtikelPreisEK(), preisEingabe);
    }
    
    /**
     * 
     * Prüft ob der eine negative Eingabe abgefangen wird.
     */
    
    @Test (expected = IllegalArgumentException.class)
    public void testSetPreisEKNegativerWert(){   
        BigDecimal negativerPreis = BigDecimal.valueOf(-20);
        artikel1.setArtikelPreisEK(negativerPreis);
    }
    
    /**
     * Prüft ob der BigDecimal Preis richtig gesetzt wird.
     */
    
    @Test
    public void testSetPreisAktuell(){
        
        BigDecimal preisEingabe = BigDecimal.valueOf(10).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal preisbd = BigDecimal.valueOf(10);
        
        artikel1.setArtikelPreisAktuell(preisbd);
        assertEquals("Betrag nicht korrekt",
            artikel1.getArtikelPreisAktuell(), preisEingabe);
    }
    
    /**
     * 
     * Prüft ob der eine negative Eingabe abgefangen wird.
     */
    
    @Test (expected = IllegalArgumentException.class)
    public void testSetPreisAktuellNegativerWert(){   
        BigDecimal negativerPreis = BigDecimal.valueOf(-20);
        artikel1.setArtikelPreisAktuell(negativerPreis);
    }
    
    /**
     * Prüft ob eine falsche ArtikelNr abgefangen wird.
     */
    
    @Test (expected = IllegalArgumentException.class)
    public void testNummerVierstellig(){
        artikel1.setArtikelNr(11);
    }
    
     /**
     * Prüft ob eine falsche ArtikelNr abgefangen wird.
     */
    
    @Test (expected = IllegalArgumentException.class)
    public void testNummerVierstellig2(){
        artikel1.setArtikelNr(11111111);
    }
    
     /**
     * Prüft ob eine falsche ArtikelBezeichnung abgefangen wird.
     */
    
    @Test (expected = IllegalArgumentException.class)
    public void testArtikelBez(){
        artikel1.setArtikelBezeichnung("");
    }
    
    /**
     * 
     * Prüft ob der eine negative Eingabe abgefangen wird.
     */
    
    @Test (expected = IllegalArgumentException.class)
    public void testArtikelBestand(){
        artikel1.setArtikelBestand(-5);
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @After
    public void tearDown()
    {
    }
}
