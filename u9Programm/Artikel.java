
/**
 * Eine einfache Artikelverwaltung
 *
 * @author Christan Weis x Nicolas Klein
 * @version 03.12.2017
 */

import java.math.BigDecimal;
import java.math.MathContext;

public class Artikel
{
    private static  String MSG_KLEINERNULL      = "Eingabe muss größer Null sein.";
    private static  String MSG_NUMMER4STELLIG   = "Eine ArtikelNummer muss 4 stellig sein.";
    private static  String MSG_KEINEBEZEICHNUNG = "Es muss eine Bezeichung angegeben werden";

    private static final int MAX_ARTIKELNR = 9999;
    private static final int MIN_ARTIKELNR = 1000;

    private int     artikelNr;
    private int     artikelBestand;
    private String  artikelBezeichnung;

    private BigDecimal artikelPreisEK;
    private BigDecimal artikelPreisAktuell;


    /**
     * Konstruktor der Klasse Artikel mit 3 Werten, welcher über die set-Methoden der Attribute
     * diese inizialisiert.
     *
     * @param  artikelNr            eine Artikelnummer
     * @param  artikelBezeichnung   eine Artikelbezeichnung
     * @param  artikelBestand       ein Artikelbestand
     * @param  artikelBestand       ein ArtikelPreis
     */

    public Artikel(int artikelNr, String artikelBezeichnung, int artikelBestand, BigDecimal artikelPreis){

        setArtikelNr(artikelNr);

        setArtikelBezeichnung(artikelBezeichnung);

        setArtikelBestand(artikelBestand);

        setArtikelPreisAktuell(artikelPreis);

        setArtikelPreisEK(artikelPreis);

    }

    /**
     * Konstruktor der Klasse Artikel mit 2 Werten.
     *
     * @param  artikelNr    eine Artikelnummer
     * @param  artikelBez   eine Artikelbezeichnung
     */

    public Artikel(int artikelNr, String artikelBezeichnung){
        this(artikelNr, artikelBezeichnung, 0, BigDecimal.ZERO);
    }


    /**
     * Weist dem Attribut ArtikelPreis einen neuen Wert zu.
     * Der neue Preis muss dabei größer oder gleich 0 sein.
     *
     * @param  artikelPreisAktuel   neue Preis
     */

    public void setArtikelPreisAktuell (BigDecimal preis){

        check(preis.compareTo(BigDecimal.ZERO) >= 0, MSG_KLEINERNULL);
        this.artikelPreisAktuell = preis.setScale(2, BigDecimal.ROUND_HALF_UP);

    }


    /**
     * Weist dem Attribut ArtikelPreis einen neuen Wert zu.
     * Der neue Preis muss dabei größer oder gleich 0 sein.
     *
     * @param  artikelPreisEK       neue Preis
     */

    public void setArtikelPreisEK (BigDecimal preis){

        check(preis.compareTo(BigDecimal.ZERO) >= 0, MSG_KLEINERNULL);
        this.artikelPreisEK = preis.setScale(2, BigDecimal.ROUND_HALF_UP);

    }

    /**
     * Gibt dem Benutzer den Wert des Attributs artikelPreisAktuell zurück.
     *
     * @return        der Wert von artikelPreisAktuell
     */


    public BigDecimal getArtikelPreisAktuell(){

        return artikelPreisAktuell;

    }

    /**
     * Gibt dem Benutzer den Wert des Attributs artikelPreisEK zurück.
     *
     * @return        der Wert von artikelPreisEK
     */


    public BigDecimal getArtikelPreisEK(){

        return artikelPreisEK;

    }

    /**
     * Gibt dem Benutzer den Wert von dem Attribut aritkelNr zurück.
     *
     * @return        der Wert von artikelNr
     */

    public int getArtikelNr(){
        return this.artikelNr;
    }

    /**
     * Gibt dem Benutzer den Wert von dem Attribut aritkelBest zurück.
     *
     * @return        der Wert von artikelBest
     */

    public int getArtikelBestand(){
        return this.artikelBestand;
    }

    /**
     * Gibt dem Benutzer den Wert des Attributs artikelBezeichnung zurück.
     *
     * @return        der Wert von artikelBezeichnung
     */

    public String getArtikelBezeichnung(){
        return this.artikelBezeichnung;
    }

    /**
     * Gibt dem Benutzer den Wert des Attributs artikelBezeichnung zurück.
     *
     * @return        der Wert von artikelBezeichnung
     */

    public String getBeschreibung(){
        return this.artikelBezeichnung;
    }

    /**
     * Gibt den Preis multipliziert mit der vorhandenen Menge zurück.
     *
     * @return      Preis*Menge
     */

    public double getGesamtPreisLagerung(){
        return this.artikelPreisAktuell.doubleValue() * this.artikelBestand;
    }
    /**
     * Weist dem Attribut ArtikelNr einen neuen Wert zu.
     * Die neue ArtikelNr muss vierstellig sein.
     *
     * @param  artikelNr    die neue ArtikelNr
     */

    public void setArtikelNr(int artikelNr){

        check(artikelNr >= MIN_ARTIKELNR && artikelNr <= MAX_ARTIKELNR, MSG_NUMMER4STELLIG);
        this.artikelNr = artikelNr;

    }

    /**
     * Weist dem Attribut ArtikelBezeichnung einen neuen Wert zu.
     * Eine neue Bezeichnung darf nicht leer sein.
     *
     * @param  artikelBezeichnung   neue Bezeichnung
     */

    public void setArtikelBezeichnung(String artikelBezeichnung){

        check(artikelBezeichnung != null && artikelBezeichnung.trim().length() > 0, MSG_KEINEBEZEICHNUNG);
        this.artikelBezeichnung = artikelBezeichnung;

    }

    /**
     * Weist dem Attribut ArtikelBestand einen neuen Wert zu.
     * Der neue Bestand muss dabei größer oder gleich 0 sein.
     *
     * @param  artikelBestand       neue Bestand
     */

    public void setArtikelBestand(int artikelBestand){
        check(artikelBestand >= 0, MSG_KLEINERNULL);
        this.artikelBestand = artikelBestand;
    }

    /**
     * Methode um das Attribut artikelBestand um den Wert zugangBestand zu erhöhen.
     *
     * @param  zugangBestand    Menge die dem Bestand hinzugefügt wird.
     */

    public void zugangBestand(int zugangBestand){
        check (zugangBestand >= 0,MSG_KLEINERNULL);
        setArtikelBestand(this.artikelBestand + zugangBestand );
    }

    /**
     * Methode um das Attribut artikelBestand um den Wert abgangBestand zu verringern.
     *
     * @param  abgangBestand    Menge die dem Bestand abgezogen wird.
     */

    public void abgangBestand(int abgangBestand){
        check(abgangBestand >= 0,MSG_KLEINERNULL);
        setArtikelBestand(this.artikelBestand - abgangBestand);
    }

    /**
     * Check Methode um Werte auf korrektheit zu prüfen.
     *
     * @param   bedienung   Zu erfüllende Bedienung (Bedienung wird auf Wahrheit geprüft. Nicht wahr führt zu Exception)
     * @param   msg         Meldung die der Exception übergeben wird.
     */

    private static void check(boolean bedienung, String msg){
        if (!bedienung){
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Methode der Klasse java.lang.Object für die textuelle Aufbereitung.
     *
     * @return  gibt eine textuelle Aufbereitung der Attribute
     *          artikel Nr, atikelBez und artikelBest aus.
     */

    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append( "Nummer: "  + artikelNr + "\n" +
                "Bezeichnung: "     + artikelBezeichnung + "\n" +
                "Bestand: "         + artikelBestand + "\n" +
                "Preis: "           + artikelPreisAktuell.toString() + "€" + "\n" +
                "Einkaufs-Preis: "  + artikelPreisEK.toString() + "€" + "\n");
        return str.toString();
    }
}
