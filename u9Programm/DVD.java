import java.math.BigDecimal;

/**
 * Einfache DVD Klasse
 *
 * @author (Nicolas Klein x Christian Weis)
 * @version (15.1.2018)
 */

public class DVD extends Artikel
{

    private String titel;
    private int spieldauer;
    private int erscheinungsjahr;

    private String MSG_JAHRFALSCH = "Das Jahr muss sich zwischen 1950 und 2014 befindne!";

    /**
     * Konstruktor für Objekte der Klasse DVD
     */

    public DVD(int artikelNr, String artikelBezeichnung,
               int artikelBestand, BigDecimal artikelPreis,
               String titel, int spieldauer, int erscheinungsjahr)
    {
        super(artikelNr, artikelBezeichnung, artikelBestand, artikelPreis);
        this.titel = titel;
        this.spieldauer = spieldauer;

        validiereErscheinungsjahr(erscheinungsjahr);
        this.erscheinungsjahr = erscheinungsjahr;
    }

    /**
     * Validiert Erscheinungsjahr
     *
     * @param spieldauer
     */

    private void validiereErscheinungsjahr(int erscheinungsjahr){
        if (erscheinungsjahr > 2014 || erscheinungsjahr < 1950){
            throw new IllegalArgumentException(MSG_JAHRFALSCH);
        }
    }

    /**
     * Gibt Beschreibung zurück.
     *
     * @return      titel der DVD
     */

    public String getBeschreibung()
    {
        return this.titel;
    }

    public String toString(){
        return super.toString()+
                "Titel: "+this.titel+"\n"+
                "Spieldauer: "+this.spieldauer+"\n"+
                "Erscheinungsjahr: "+this.erscheinungsjahr+"\n";
    }
}
