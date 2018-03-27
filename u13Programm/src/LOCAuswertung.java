import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LOCAuswertung {

    private GesamtAuswertung ergebnis = new GesamtAuswertung();
    private PrintStream out = System.out;

    /**
     * Wertet eine einzelne Datei aus und speichert die
     * Ergebnisse in einem DateiAuswertung Objekt.
     * Dieses wird wiederrum in einem GesamtAuswertung Objekt
     * abgespeichert.
     * @param file  auszuwertende Datei
     * @throws IOException
     */
    public void auswertung(File file) throws IOException{
        Scanner sc = new Scanner(file);
        DateiAuswertung db = new DateiAuswertung(file.getName());

        if (!file.exists() || !file.canRead() || !file.isFile()){
            out.println("Kann" + file + "nicht lesen");
        }

        try {
            String line;
            Pattern p = Pattern.compile("(^\\/\\/)+");
            while (sc.hasNext()){
                line = sc.next().trim();
                Matcher m = p.matcher(line);

                if(line.length() != 0){
                    db.addZeilenGesamt();
                    if(m.find()){
                        db.addZeilenComment();
                    }
                    else{
                        db.addZeilenCode();
                    }
                }
            }
            ergebnis.add(db);

        }
        finally {
            sc.close();
        }
    }

    /**
     * Start Methode der Klasse LOCAuswertung.
     * Diese liest das Args Array aus und gibt
     * die einzelnen Dateien an die auswerten Methode weiter
     * welche diese dann auswertet.
     * @param args  selber Inhalt wie args Array der main Methode
     */
    public void start (String [] args) {

        try {
            out.println("Arbeitsverzeichnis: " +
                    System.getProperty("user.dir"));

            //Vorläufig---------
            args = new String[1];
            args[0] = "test.txt";
            //------------------

            if (args.length == 0) {
                throw new LOCNoFileException("Keine Datei ausgewählt.");
            }

            for (String datei : args) {
                File file = new File(datei);
                auswertung(file);
            }

            out.println(ergebnis.toString());


        } catch (LOCNoFileException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Main Methode der Klasse LOCAuswertung,
     * diese startet die Start Methode.
     * @param args
     */
    public static void main (String[] args){
        new LOCAuswertung().start(args);
    }


}
