import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JavaGrep{


    public static void main (String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Aufbau des FilterProgramms: JavaGrep [Filer-String] [Dateien]...");
        }

        String suchString = args[0];

        for (int i = 1; i < args.length; i++) {
            File datei = new File(args[i]);
            checkFile(datei, args[0]);
        }
    }

        public static void checkFile(File datei, String suchstring) throws IOException{
            BufferedReader in = new BufferedReader(new FileReader(datei));
            String line = "";
            int lineNumber = 0;

            while ((line = in.readLine()) != null){
                lineNumber++;
                if(line.toLowerCase().contains(suchstring)){
                    System.out.println(datei.getName() +": "+lineNumber+": "+line);
                }
                in.close();
            }
        }

    }