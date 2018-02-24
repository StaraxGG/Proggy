package Klausur1;

import java.io.*;

public class javaGrepNumbersBufferedReader {

    private File datei;
    private BufferedReader br;

    public void start(String numbersFile) throws IOException{
        datei = new File(numbersFile);
        br = new BufferedReader(new FileReader(datei));

        String line;
        while((line = br.readLine()) != null){
            String[] stringNumber = line.split("\\s+");

            int p = 2;
            for(String number :stringNumber){
                if (p % 2 == 0){
                    System.out.println(number);
                    p++;
                }
            }
        }
    }

    public static void main (String[] args){
        try{
            //auf args.length == 1 prüfen
            new javaGrepNumbersBufferedReader().start("numbers.txt");
        }
        catch(IOException e){
            System.err.println("Fehler bei der Ein und Ausgabe:" + e.getMessage());
        }
        catch(Exception e){
            System.err.println("Allgemeiner Fehler" + e.getMessage());
        }
    }
}
