package Klausur1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class javaGrepNumbers {

    private File numbersFile;


    public void start(String datei){
        try {
            System.getProperty("user.dir");

            numbersFile = new File(datei);
            if (!numbersFile.isFile() && !numbersFile.canRead()){
                throw new IllegalArgumentException("Datei kann nicht gelesen werden");
            }

            readNumbersFile(numbersFile);

        }
        catch (Exception e){
            System.err.println("Unerwarteter Fehler");
        }
    }

    public void readNumbersFile(File datei) throws FileNotFoundException{
        Scanner input = new Scanner(datei);
        StringBuffer sb = new StringBuffer();

        sb.append("Das Skript läuft los ...\n");
        while(input.hasNextLong()){
            sb.append(input.nextLong()+"\n");
        }
        sb.append("Das Skript ist nun zu Ende!");
        System.out.println(sb.toString());
        input.close();
    }

    public static void main(String[]args){
        System.out.println(System.getProperty("user.dir"));
        //auf args.length == 1 prüfen
        new javaGrepNumbers().start("numbers.txt");
    }
}
