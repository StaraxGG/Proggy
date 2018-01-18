

/**
 * Lagerverwaltung.
 *
 * @author Nicolas Klein x Christian Warken
 * @version 12.12.2017
 */

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.MathContext;

public class LagerDialog
{

    private static final int LAGER_ANLEGEN      = 1;
    private static final int LAGER_ANLEGEN_VOR  = 2;
    private static final int ANLEGEN            = 3;
    private static final int ENTFERNEN          = 4;
    private static final int ZUGANG             = 5;
    private static final int ABGANG             = 6;
    private static final int PREIS_ERHOEHUNG    = 7;
    private static final int INFORMATIONEN      = 8;
    private static final int BESTANDSLISTE      = 9;
    private static final int ENDE               = 0;

    private static final int CONST_Art                =1;
    private static final int CONST_CD                 =2;
    private static final int CONST_DVD                =3;
    private static final int CONST_BUCH               =4;

    private Lager meinLager;

    /**
     * Start Methode der Klasse LagerDialog();
     */

    public void start(){

        int funktion = -1;

        while (funktion != ENDE){

            try{
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            }
            catch (java.util.InputMismatchException e){
                System.err.println("Stellen sie sicher, dass ihre Eingabe korrekt ist.");
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.err.println("Ihr Lager ist voll.");
            }
            catch (IllegalArgumentException e){
                System.err.println(e);
            }
            catch (NegativeArraySizeException e){
                System.err.println("Bitte legen sie ein Lager mit einer Größe größer 0 an.");
            }
            catch (RuntimeException e){
                System.err.println(e);
            }
            catch (Exception e){
                System.err.println(e);
                e.printStackTrace(System.out);
            }
        }

    }

    /**
     * Funktion die die Benutzereingabe einliest
     *
     * @return Benutzerauswahl der Funktionen 0-8
     */

    private int einlesenFunktion(){

        StringBuffer str = new StringBuffer();

        str.append("---------------------------------------------\n");
        str.append(LAGER_ANLEGEN        +": Lager anlegen mit Standardgröße (40) \n");
        str.append(LAGER_ANLEGEN_VOR    +": Lager anlegen mit eigenem Bestand \n");
        str.append(ANLEGEN              +": Artikel anlegen \n");
        str.append(ENTFERNEN            +": Artikel enfernen \n");
        str.append(ZUGANG               +": Zugang buchen \n");
        str.append(ABGANG               +": Abgang buchen \n");
        str.append(PREIS_ERHOEHUNG      +": Preis um % verändern \n");
        str.append(INFORMATIONEN        +": Informationen ausgeben \n");
        str.append(BESTANDSLISTE        +": Bestandsliste ausgeben \n");
        str.append(ENDE                 +": Programmende \n");
        str.append("---------------------------------------------\n");

        System.out.println(str.toString());

        return eingabeInt();

    }

    /**
     * Frägt den Benutzer nach dem gewünschten Artikel.
     * @return  auswahl des Benutzers (int 1-4);
     */

    private void einlesenArtikelArt(){

        StringBuffer str = new StringBuffer();
        str.append("Welche Art von Artikel soll angelegt werden?\n");
        str.append("---------------------------------------------\n");
        str.append(CONST_Art        +": allgemein anlegen \n");
        str.append(CONST_CD         +": CD anlegen \n");
        str.append(CONST_DVD        +": DVD anlegen \n");
        str.append(CONST_BUCH       +": Buch anlegen \n");
        str.append("---------------------------------------------\n");

        System.out.println(str.toString());

        ausfuehrenArtikelArt(eingabeInt());
    }

    /**
     * Führt auf Basis der Benutzerauswahl die passende Funktion aus.
     *
     * @param   funktion    funktion als Konstantenwert
     */

    private void ausfuehrenFunktion(int funktion){
        switch (funktion){

            case LAGER_ANLEGEN:
                lagerAnlegenDialog(false);
                break;

            case LAGER_ANLEGEN_VOR:
                lagerAnlegenDialog(true);
                break;

            case ANLEGEN:
                einlesenArtikelArt();
                break;

            case ENTFERNEN:
                entfernen();
                break;

            case ZUGANG:
                zugang();
                break;

            case ABGANG:
                abgang();
                break;

            case PREIS_ERHOEHUNG:
                preiserhoehen();
                break;

            case INFORMATIONEN:
                informationen();
                break;

            case BESTANDSLISTE:
                ausgabeBestandsListe();
                break;

            case ENDE:
                System.out.println("Programmende \n");
        }
    }

    /**
     * Führt auf Basis des ausgewählten Artikel Typs die passende Funktion aus.
     * @param   int Wert der die ausgewählte Funktion repräsentiert.
     */

    private void ausfuehrenArtikelArt(int art){
        switch (art){

            case CONST_Art:
                anlegenArtikel();
                break;

            case CONST_CD:
                anlegenCD();
                break;

            case CONST_DVD:
                anlegenDVD();
                break;

            case CONST_BUCH:
                anlegenBuch();
                break;
        }
    }
    /**
     * Prüft ob das Lager bereits angelegt wurde. Falls ja wird der
     * Benutzer gefragt ob er das bereits existierende überschreiben will.
     *
     * @param   vorgaben   true: Benutzer wird nach der für Lagergröße gefragt
     */

    private void lagerAnlegenDialog(boolean vorgaben){

        if (meinLager != null){
            System.out.println("Es existiert bereits ein Lager!");
            System.out.println("Wollen sie wirklich ein neues Lager anlegen?");
            System.out.println("y/n");

            char decision = eingabeChar();

            if (decision == 'y'){
                lagerAnlegen(vorgaben);
            }
            else{
                System.out.println("Vorgang abgebrochen!");
            }

        }
        else{
            lagerAnlegen(vorgaben);
        }
    }

    /**
     * Legt ein neues Artikelobjekt an.
     *
     * @param   vorgegeben    true: Benutzer wird nach eigener Größe gefragt.
     */

    private void lagerAnlegen(boolean vorgegeben){

        int maxArtikel = 40;

        System.out.println("Bitte Lager-Name eingeben: ");

        String lagername = eingabeString();
        check (lagername.trim().length() != 0, "Bitte geben sie ihrem Lager einen Namen");

        if (vorgegeben){
            System.out.println("Bitte maximale Anzahl an Artikeln eingeben: ");
            maxArtikel = eingabeInt();
        }

        meinLager = new Lager(lagername, maxArtikel);
    }

    /**
     * Frägt nach den grundlegenden Informationen um einen Artikel anzulegen.
     * Anschließend gibt es ein Object[] Array mit den passenden Werten zurück.
     *
     * An Stelle 0 des Arrays: ArtikelNr als Integer.
     * An Stelle 1 des Arrays: ArtikelBezeichnung als String.
     * An Stelle 2 des Arrays: ArtikelBestand als Integer.
     * An Stelle 3 des Arrays: ArtikelPreis als BigDecimal.
     *
     * @return  array mit den passenden Werten.
     */

    public Object[] eingabeArtikel(){

        Object[] eingabenArtikel = new Object[4];

        System.out.println("Bitte ArtikelNr eingeben: ");
        eingabenArtikel[0] = eingabeInt();

        System.out.println("Bitte Bezeichnung eingeben: ");
        eingabenArtikel[1] = eingabeString();

        System.out.println("Bitte Bestand eingeben: ");
        eingabenArtikel[2] = eingabeInt();

        System.out.println("Bitte Preis eingeben: ");
        double artikelPreis = eingabeDouble();
        eingabenArtikel[3] = BigDecimal.valueOf(artikelPreis);

        return eingabenArtikel;

    }

    /**
     * Legt Artikel an, frägt Benutzer nach den benötigten Angaben.
     * Prüft ob das Array angelegt wurde, und ob das Array bereits voll ist.
     *
     */

    private void anlegenArtikel(){

        lagerKorrektCheck();

        Object[] eingaben = eingabeArtikel();

        int artikelNr = (int) eingaben[0];
        String artikelBez = (String) eingaben[1];
        int artikelBest = (int) eingaben[2];
        BigDecimal bdPreis = (BigDecimal) eingaben[3];

        Artikel neuerArtikel = new Artikel(artikelNr, artikelBez, artikelBest,bdPreis);
        meinLager.legeArtikelAn(neuerArtikel);
    }

    /**
     * Legt neues Buch an.
     * Nutzt dabei eingabeArtikel() Methode.
     *
     */

    public void anlegenBuch(){

        lagerKorrektCheck();

        Object[] eingaben = eingabeArtikel();

        int artikelNr = (int) eingaben[0];
        String artikelBez = (String) eingaben[1];
        int artikelBest = (int) eingaben[2];
        BigDecimal bdPreis = (BigDecimal) eingaben[3];

        //Titel
        System.out.println("Bitte Titel eingeben: ");
        String titel = eingabeString();
        //Author
        System.out.println("Bitte Author eingeben: ");
        String author = eingabeString();
        //Verlag
        System.out.println("Bitte Verlag eingebne: ");
        String verlag = eingabeString();

        Buch neuesBuch = new Buch(artikelNr, artikelBez,artikelBest, bdPreis,titel,author,verlag);
        meinLager.legeArtikelAn(neuesBuch);
    }

    /**
     * Legt neue CD an.
     * Nutzt dabei eingabeArtikel() Methode.
     *
     */

    public void anlegenCD(){

        lagerKorrektCheck();

        Object[] eingaben = eingabeArtikel();

        int artikelNr = (int) eingaben[0];
        String artikelBez = (String) eingaben[1];
        int artikelBest = (int) eingaben[2];
        BigDecimal bdPreis = (BigDecimal) eingaben[3];

        System.out.println("Bitte Titel eingeben: ");
        String titel = eingabeString();

        System.out.println("Bitte Interpret eingeben: ");
        String interpret = eingabeString();

        System.out.println("Bitte Anzahl Titel eingeben: ");
        int anzahl = eingabeInt();

        CD neueCD = new CD(artikelNr, artikelBez, artikelBest,
                bdPreis, interpret, titel, anzahl);

        meinLager.legeArtikelAn(neueCD);
    }

    /**
     * Legt neue DVD an.
     * Nutzt dabei eingabeArtikel() Methode.
     *
     */

    public void anlegenDVD(){

        lagerKorrektCheck();

        Object[] eingaben = eingabeArtikel();

        int artikelNr = (int) eingaben[0];
        String artikelBez = (String) eingaben[1];
        int artikelBest = (int) eingaben[2];
        BigDecimal bdPreis = (BigDecimal) eingaben[3];

        System.out.println("Bitte Titel eingeben: ");
        String titel = eingabeString();

        System.out.println("Bitte Spieldauer eingeben (in min): ");
        int spieldauer = eingabeInt();

        System.out.println("Bitte Erscheinungsjahr eingeben" +
                "(Muss zwischen 1950 und 2014 liegen)");
        int jahr = eingabeInt();

        DVD neueDVD = new DVD(artikelNr, artikelBez, artikelBest,
                bdPreis, titel, spieldauer, jahr);

        meinLager.legeArtikelAn(neueDVD);
    };


    /**
     * Entfernt Artikel aus dem Array. Prüft dabei vorhher ob das Array angelegt wurde.
     */

    private void entfernen(){

        lagerKorrektCheck();

        System.out.println("ArtikelNr: ");
        int artikelNr = eingabeInt();

        System.out.println("Artikel mit der Nr: "+ artikelNr + " wirklich löschen?");
        System.out.println("y/n");

        char decision = eingabeChar();

        if (decision == 'y'){
            meinLager.entferneArtikel(artikelNr);
        }
        else{
            System.out.println("Vorgang abgebrochen!");
        }
    };

    /**
     * Erhöht den Bestand eines Artikels im Lager.
     * Prüft vorher ob ein Lager korrekt angelegt wurde.
     */

    private void zugang(){

        lagerKorrektCheck();

        System.out.println("ArtikelNr: ");
        int artikelNr = eingabeInt();
        System.out.println("Wie viel soll zugebucht werden?");
        int menge = eingabeInt();
        meinLager.zugangBestand(artikelNr,menge);
        System.out.println(menge + " wurde zugebucht");
    };

    /**
     * Verringert den Bestand eines Artikels im Lager.
     * Prüft vorher ob ein Lager korrekt angelegt wurde.
     */

    private void abgang(){

        lagerKorrektCheck();

        System.out.println("ArtikelNr: ");
        int artikelNr = eingabeInt();
        System.out.println("Wie viel soll abgebucht werden?");
        int menge = eingabeInt();
        meinLager.abgangBestand(artikelNr, menge);
        System.out.println(menge + " wurde abgebucht");
    };

    /**
     * Erhöht oder verringert den Preis aller Artikel um einen
     * vom Benutzer eingegeben Prozentsatz.
     * Prüft dabei vorher ob das Lager korrekt angelegt wurde.
     */

    private void preiserhoehen(){

        lagerKorrektCheck();

        System.out.println("Um welchen Prozentsatz sollen alle Preis verändert werden?");
        System.out.println("(Hinweis: Die Preise werden auf Basis der Einkaufspreise erhöht.)");
        double satz = eingabeDouble();

        System.out.println("Preise aller Artikel um "+satz+"% erhöhen?");
        System.out.println("y/n");

        char decision = eingabeChar();

        if (decision == 'y'){
            meinLager.preisAenderung(satz);
        }
        else{
            System.out.println("Vorgang abgebrochen!");
        }
    };



    /**
     * Ruft die toString Methode auf.
     */

    private void informationen(){
        lagerKorrektCheck();
        System.out.println(meinLager.toString());
    }

    /**
     * Ruft die Bestandsliste auf.
     */

    private void ausgabeBestandsListe(){
        lagerKorrektCheck();
        System.out.println(meinLager.ausgabeBestandsliste());
    }


    /**
     * Eingabemethode
     *
     * @return eingabe des Benutzers
     */

    private int eingabeInt(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    /**
     * Eingabemethode
     *
     * @return eingabe des Benutzers
     */

    private double eingabeDouble(){
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }

    /**
     * Eingabemethode
     *
     * @return eingabe des Benutzers
     */

    private String eingabeString(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    /**
     * Eingabemethode
     *
     * @return eingabe des Benutzers
     */

    private char eingabeChar(){
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    /**
     * Checkmethode
     *
     * @param bedienung     zu prüfende Bedienung
     * @param msg           auszugebende Fehlermeldung
     */

    private static void check(boolean bedienung, String msg){
        if (!bedienung){
            throw new RuntimeException(msg);
        }
    }

    /**
     * Prüft das Lager auf Korrektheit
     */

    private void lagerKorrektCheck(){
        check(meinLager != null, "Legen sie bitte vorher ein Lager an.");
        meinLager.lagerBereitsVollCheck();
    }

    /**
     * Main Methode des LagerDialogs
     */

    public static void main (String [] args){
        new LagerDialog().start();
    }
}
