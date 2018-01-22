import java.math.BigDecimal;

/**
 * Einfache Buch Klasse.
 *
 * @author (Nicolas Klein x Christan Weis)
 * @version (15.01.2018)
 */

public class Buch extends Artikel
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String titel;
    private String author;
    private String verlag;

    /**
     * Konstruktor für Objekte der Klasse Buch
     */

    public Buch(int artikelNr, String artikelBezeichnung,
                int artikelBestand, BigDecimal artikelPreis,
                String titel, String author, String verlag)
    {
        super (artikelNr, artikelBezeichnung, artikelBestand, artikelPreis);
        this.titel = titel;
        this.author = author;
        this.verlag = verlag;
    }

    /**
     * Gibt Beschreibung zurück.
     *
     * @return        Beschreibung des Buchs
     */

    public String getBeschreibung()
    {
        return this.author + " : " + this.titel;
    }

    /*public String toString(){
        return super.toString()+
                "Titel: "+this.titel+"\n"+
                "Author: "+this.author+"\n"+
                "Verlag: "+this.verlag+"\n";
    }*/
}
