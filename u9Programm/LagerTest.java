

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;

/**
 * Die Test-Klasse LagerTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class LagerTest
{
    
    Lager lager1;
    
    /**
     * Konstruktor fuer die Test-Klasse LagerTest
     */
    public LagerTest()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
        lager1 = new Lager("Mein Lager", 2);
    }

    
    /**
     * 
     * Prüft ob der Fall eines vollen Lagers abgefangen wird. 
     */
    
    @Test (expected = RuntimeException.class)
    public void testKapazität(){
        Artikel artikel1 = new Artikel(1111,"a1", 5, BigDecimal.ZERO);
        Artikel artikel2 = new Artikel(1112,"a2", 5, BigDecimal.ZERO);
        Artikel artikel3 = new Artikel(1112,"a3", 5, BigDecimal.ZERO);
        
        lager1.legeArtikelAn(artikel1);
        lager1.legeArtikelAn(artikel2);
        lager1.legeArtikelAn(artikel3);
    }
    
    /**
     * 
     * Prüft ob bei zweimaligem Anlegen des selben Artikels ein Fehler gefangen wird.
     */
    
    @Test (expected = RuntimeException.class)
    public void testArtikelBereitsAngelegt(){
        Artikel artikel1 = new Artikel(1111,"a1", 5, BigDecimal.ZERO);
        lager1.legeArtikelAn(artikel1);
        lager1.legeArtikelAn(artikel1);
        
    }
    
    /**
     * 
     * Prüft ob der eine negative Eingabe abgefangen wird.
     */
    
    @Test (expected = RuntimeException.class)
    public void testAbgangBestandNegativ(){
        Artikel artikel1 = new Artikel(1111,"a1", 5, BigDecimal.ZERO);
        lager1.abgangBestand(1111, -30);
    }
    
    
    /**
     * 
     * Prüft ob der eine negative Eingabe abgefangen wird.
     */
    
    @Test (expected = RuntimeException.class)
    public void testZugangBestandNegativ(){
        Artikel artikel1 = new Artikel(1111,"a1", 5, BigDecimal.ZERO);
        lager1.zugangBestand(1111, -30);
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
