import java.math.BigDecimal;

/**
 * Einfache CD Klasse für die Lagerverwaltung.
 *
 * @author (Nicolas Klein x Christan Weis)
 * @version (15.1.2018)
 */

public class CD extends Artikel
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String interpret;
    private String titel;
    private int anzahlTitel;


    /**
     * Konstruktor für Objekte der Klasse CD
     */

    public CD(int artikelNr, String artikelBezeichnung,
              int artikelBestand, BigDecimal artikelPreis,
              String interpret,String titel, int anzahlTitel )
    {
        super(artikelNr, artikelBezeichnung, artikelBestand, artikelPreis);

        this.interpret = interpret;
        this.titel = titel;
        this.anzahlTitel = anzahlTitel;
    }


    /**
     * Gibt Beschreibung zurück
     *
     * @return Beschreibung der CD
     */

    public String getBeschreibung()
    {
        return this.interpret + " : " + this.titel;
    }

    /*public String toString()
    {
        return super.toString()+
                "Interpret: "+this.interpret+"\n"+
                "Titel: "+this.titel+"\n"+
                "Anzahl Titel: "+this.anzahlTitel+"\n";
    }*/
}
