
/**
 * Einfache Lagerverwaltung
 *
 * @author Nicolas Klein x Christian Weis
 * @version 03.12.2017
 */

import java.math.BigDecimal;

public class Lager
{
    private static String MSG_NICHTGEFUNDEN = "Artikel wurde nicht gefunden";
    private static String MSG_KLEINERNULL = "Wert darf nicht kleiner Null sein";
    private static String MSG_ARTIKELANLEGENERR = "Artikel konnte nicht angelegt werden";

    private String nameLager;
    private Artikel[] artikelTab;
    private int anzahlArtikel;

    /**
     * Konstruktor für Objekte der Klasse Lager mit zwei Parametern.
     *
     * @param nameLager         Name des Lagers
     * @param maxAnzahlArtikel   Maximale Anzahl an Artikeln die aufgenommen werden sollen
     */



    public Lager(String nameLager, int maxAnzahlArtikel){
        check (nameLager.trim().length() != 0, "Bitte geben sie ihrem Lager einen Namen");
        this.nameLager = nameLager;

        check (maxAnzahlArtikel > 0, "Ihr Lager muss mindestens 1 Artikel fassen können");
        artikelTab = new Artikel[maxAnzahlArtikel];

        this.anzahlArtikel = 0;
    }

    /**
     * Konstruktor für Objekte der Klasse Lager mit einem Parameter.
     * Die Maximale Lagergröße wird hier automatisch auf 40 Artikel gesetzt.
     *
     * @param nameLager         Name des Lagers
     */

    public Lager(String nameLager){
        this(nameLager, 40);
    }

    /**
     * Diese Methode legt ein neuen Artikel im Lager an.
     *
     * @param   neuerArtikel     Name des anzulegenden Artikels.
     */

    public void legeArtikelAn(Artikel neuerArtikel){
        int i = findeArtikel(neuerArtikel.getArtikelNr());

        check(i < 0, "Artikel bereits vorhanden.");
        check(anzahlArtikel <= artikelTab.length, MSG_ARTIKELANLEGENERR);

        artikelTab[anzahlArtikel] = neuerArtikel;
        anzahlArtikel++;

        //artikelTab = sort(artikelTab);
    }

    /**
     * Diese Methode erhöht dne Bestand des Artikels um 1.
     *
     * @param   artikelNr       Nr des anzulegenden Artikels.
     * @param   menge           Die Menge die dem Artikel zugeführt wird.
     */

    public void zugangBestand(int artikelNr, int menge){
        int i = findeArtikel(artikelNr);
        check (i >= 0, MSG_NICHTGEFUNDEN);
        check (menge > 0, MSG_KLEINERNULL);
        artikelTab[i].zugangBestand(menge);
    }

    /**
     * Diese Methode reduziert den Bestand des Artikels um menge.
     *
     * @param   artikelNr       Nr des anzulegenden Artikels.
     * @param   menge           Menge die dem Artikel abgezogen wird.
     */

    public void abgangBestand(int artikelNr, int menge){
        int i = findeArtikel(artikelNr);
        check(i >= 0, MSG_NICHTGEFUNDEN);
        check(menge > 0, MSG_KLEINERNULL);
        artikelTab[i].abgangBestand(menge);
    }

    /**
     * Diese Methode entfernt ein Artikel im Lager.
     *
     * @param   artikelNr       Nr des zu entfernenden Artikels
     */

    public void entferneArtikel(int artikelNr){
        int i = findeArtikel(artikelNr);
        check(i >= 0, MSG_NICHTGEFUNDEN);

        artikelTab[i] = artikelTab[anzahlArtikel-1];
        artikelTab[anzahlArtikel-1] = null;
        anzahlArtikel--;
    }

    /**
     * Ändert den Preis aller Artikel um eine Prozenteingabe
     *
     * @param   prozentEingabe  Prozenteingabe des Benutzers.
     */

    public void preisAenderung(double prozentEingabe){

        if (prozentEingabe >= 0){
            double prozent = (prozentEingabe/100)+1;
            BigDecimal prozentbd = BigDecimal.valueOf(prozent);

            for (int i = 0; i < anzahlArtikel; i++){

                BigDecimal PreisEK = artikelTab[i].getArtikelPreisEK();
                BigDecimal neuerPreis = PreisEK.multiply(prozentbd);
                artikelTab[i].setArtikelPreisAktuell(neuerPreis);

            }
        }
        else{
            double prozent = -1*(prozentEingabe/100);
            BigDecimal prozentbd = BigDecimal.valueOf(prozent);

            for (int i = 0; i < anzahlArtikel; i++){

                BigDecimal PreisEK = artikelTab[i].getArtikelPreisEK();
                BigDecimal abzug = PreisEK.multiply(prozentbd);
                artikelTab[i].setArtikelPreisAktuell(PreisEK.subtract(abzug));

            }
        }

    }

    /**
     * Eine Methode die in dem Array nach einem Artikel sucht.
     * Als Rückgabe erhält man die Position des Artikels
     * mit der passenden ArtikelNr im Array.
     * Wird kein passendes gefunden wird -1 zurück gegeben.
     *
     * @param   artikelNr   Nummer des Artikels
     */

    private int findeArtikel(int artikelNr){

        check (artikelNr <= 9999 && artikelNr >= 1000, "Artikel Nummer ungültig");

        for (int i = 0; i < anzahlArtikel; i++){
            if (artikelTab[i].getArtikelNr() == artikelNr){
                return i;
            }
        }
        return -1;
    }

    /**
     * Gibt die in der Aufgabe gestellte Bestandliste aus.
     *
     * @return  bestandliste als String
     *
     * TODO Better formating
     */

    /*public String ausgabeBestandsliste(){
        StringBuffer sb = new StringBuffer();
        double gesamtpreis = 0;

        String str1 = String.format("------%1------\n", nameLager);
        sb.append(str1);
        //sb.append("Lagerort: " + nameLager + "\n");
        //sb.append("\n");
        //sb.append(String.format("ArtNr\tBeschreibung\t\tPreis\tBestand\tGesamt\n"));
        sb.append(String.format("%-4s | %-40s | %5s | %4s | %-6s", "ArtNr", "Beschreibung", "Preis", "Gesamt"));
        sb.append("---------------------------------------------\n");

        for (int i = 0; i < anzahlArtikel ; i++){
            sb.append(artikelTab[i].getArtikelNr()+ "\t"
                    +artikelTab[i].getBeschreibung() + "\t"
                    +artikelTab[i].getArtikelPreisAktuell().toString()+"\t"
                    +artikelTab[i].getArtikelBestand()+ "\t"
                    +artikelTab[i].getGesamtPreisLagerung()+"\n");
            gesamtpreis = gesamtpreis + artikelTab[i].getGesamtPreisLagerung();
        }
        sb.append("---------------------------------------------\n");
        sb.append("Gesamtwert:\t\t\t" + gesamtpreis + "€");

        return sb.toString();
    }*/

    public String ausgabeBestandsliste(){
        StringBuffer sb = new StringBuffer();
        BigDecimal gesamtpreis = BigDecimal.ZERO;

        sb.append(String.format("------------------------------%s------------------------------\n", nameLager));
        sb.append(String.format("%-4s | %-40.40s | %5s | %4s | %-6s \n", "ArtNr", "Beschreibung", "Preis", "Bestand", "Gesamt"));
        sb.append("---------------------------------------------------------------------------\n");

        for (int i = 0; i < anzahlArtikel ; i++){
            sb.append(artikelTab[i]);
            gesamtpreis = gesamtpreis.add(artikelTab[i].getGesamtPreisLagerung());
        }
        sb.append("---------------------------------------------------------------------------\n");
        sb.append("Gesamtwert:\t\t\t" + gesamtpreis + "€");

        return sb.toString();
    }

    /**
     * toString Methode des Lagers.
     */

    public String toString(){
        artikelTab = sort(artikelTab);

        StringBuffer str = new StringBuffer();

        str.append("\n");
        str.append("//////////////////////////////\n");

        str.append("Lager: "+ nameLager + "\n" +
                "Maximal-Größe: " + artikelTab.length + "\n" +
                "Gefüllt:" + anzahlArtikel + "\n");

        for (int i = 0; i < anzahlArtikel; i++){
            str.append("//////////////////////////////\n");
            str.append(artikelTab[i].toString());
        }

        str.append("//////////////////////////////\n");

        str.append("\n");

        return str.toString();

    }

    /**
     * Diese Methode sortiert das Array ArtikelTab auf Basis der ArtikelNr
     *
     * @return neues sortiertes Array der Klasse Artikel
     */


    private Artikel[] sort(Artikel[] a){
        for (int i = 0; i < anzahlArtikel; i++){

            int minPos = i;

            for (int j = i; j < anzahlArtikel; j++){
                if (a[j].getArtikelNr() < a[minPos].getArtikelNr()){
                    minPos = j;
                }
            }

            Artikel t = a[i];
            a[i] = a[minPos];
            a[minPos] = t;
        }

        return a;
    }

    /**
     * Diese Methode prüft ob das Lager bereits voll ist.
     * Dadurch wird verhindert, dass die Größe des Arrays überschritten wird.
     *
     * TODO Prüfen ob ArtikelTab kleiner oder gleich sein darf.
     */

    public void lagerBereitsVollCheck(){
        check(anzahlArtikel <= artikelTab.length, "Das Lager ist voll");
    }

    /**
     * Check Methode welche für eine beliebige Aussage
     * bedienung prüft ob diese erfüllt ist.
     *
     * @param   bedienung   zu prüfende Bedienung
     * @param   msg         auszugebende Fehlermeldung
     */
    private static void check(boolean bedienung, String msg){
        if (!bedienung){
            throw new RuntimeException(msg);
        }
    }



}
