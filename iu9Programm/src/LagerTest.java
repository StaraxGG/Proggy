import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class LagerTest {

    /* -------------------------------------------- Attribute ------------------------------------------------------- */
    Lager lager;

    @Before
    public void setUp() throws Exception {
        lager = new Lager("YasinSammlung");
    }

    @Test
    public void ausgebenBestandsliste() {

        einfuegenTestDaten();
        System.out.println(lager.ausgabeBestandsliste());
        assertTrue(true);

    }

    @After
    public void tearDown() throws Exception {

    }

    public void einfuegenTestDaten(){

        CD cd = new CD(1011, "Michael Jacksons Neue Single (2018)", 10, BigDecimal.valueOf(11.95),
                "Michael Jackson", "Believe-It", 18);
        Buch buch = new Buch(2453, "Harry Potter und ein Stein (TM)", 10,  BigDecimal.valueOf(42.30),
                "Harry Potter und ein Stein (TM)", "J.K. Rolex", "Muggelverlag Hamburg");
        DVD dvd = new DVD (4242, "Informationen über Sterne Doku", 1,  BigDecimal.valueOf(25.00),
                "42 ist ein Asterix in ASCII", 111, 2004);

        lager.legeArtikelAn(cd);
        lager.legeArtikelAn(buch);
        lager.legeArtikelAn(dvd);

    }
}