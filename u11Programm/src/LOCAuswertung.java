import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LOCAuswertung {

    private File file;
    private PrintStream out = System.out;
    private int zeilenGes = 0;


    public String auswertung(File file) throws IOException{
        BufferedReader in = new BufferedReader(
                            new FileReader(file));
        int zeilen = 0;
        String auswertung;

        if (!file.exists() || !file.canRead() || !file.isFile()){
            out.println("Kann" + file + "nicht lesen");
        }

        try {
            String line;
            Pattern p = Pattern.compile("(^\\/\\/)+");
            while ((line = in.readLine()) != null){
                Matcher m = p.matcher(line.trim());
                if(!(m.find()) && line.trim().length() != 0) {
                    zeilen++;
                }
            }
            zeilenGes = zeilenGes+zeilen;
            auswertung = String.format("%-25s:%-5sLOC\n",file.getName(),Integer.toString(zeilen));
        }
        finally {
            in.close();
        }
        return auswertung;
    }

    public void start (String [] args) {

        try {
            out.println("Arbeitsverzeichnis: " +
                    System.getProperty("user.dir"));

            //Vorläufig
            //args = new String[1];
            //args[0] = "testdatei.java";

            if (args.length == 0) {
                throw new LOCAusnahme("Keine Datei ausgewählt.");
            }

            StringBuffer ergebnis = new StringBuffer();
            ergebnis.append("Auswertung Lines of Code (LOC)\n");
            for (String datei : args) {
                File file = new File(datei);
                ergebnis.append(auswertung(file));
            }

            ergebnis.append("\nGesamt:\n" + args.length +" Datei "+zeilenGes+" LOC\n");
            out.println(ergebnis.toString());

        } catch (LOCAusnahme e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }
    }


    public static void main (String[] args){
        new LOCAuswertung().start(args);
    }


}
