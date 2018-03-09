import java.io.IOException;
import java.util.Scanner;

public class QueueDialog {

    private MetaQueue<String> myQueue = new MetaQueue<>();
    private Scanner input = new Scanner(System.in);

    private static final int STR_ADD = 1;
    private static final int STR_POP = 2;
    private static final int STR_SAVE = 3;
    private static final int STR_LOAD = 4;
    private static final int STR_PRINT = 5;
    private static final int STR_ENDE = 0;


    /**
     * Start Funktion, welche den Try Catch Block enthält.
     *
     * TODO How to not exit after Exception
     */

public void start(){
    int funktion = -1;
    try{
        while(funktion != STR_ENDE){
            funktion = einlesen();
            ausfuheren(funktion);
        }
    }
    catch (java.util.InputMismatchException e){
        System.err.println("Stellen sie sicher, dass ihre Eingabe korrekt ist.");
    }
    catch (Exception e){
        System.err.println(e.getMessage());
    }
}

    /**
     * Fordert den Benutzer zur Wahl einer FUnktiona auf und
     * gibt auf Basis der gewählten Funktion einen Wert zurück.
     *
     * @return  Funktion
     */

    public int einlesen(){
    StringBuffer bf = new StringBuffer();
    bf.append("ADD: \t"+STR_ADD+"\n");
    bf.append("POP: \t"+STR_POP+"\n");
    bf.append("SAVE: \t"+STR_SAVE+"\n");
    bf.append("LOAD: \t"+STR_LOAD+"\n");
    bf.append("PRINT: \t"+STR_PRINT+"\n");
    bf.append("ENDE: \t"+STR_ENDE+"\n");
    System.out.println(bf.toString());
    int auswahl = eingabeInt();

    return auswahl;
}

    /**
     * Führt auf Basis des Parameters funktion
     * die passende Funktion aus.
     *
     * @param funktion  gewählte Funktion
     */

    public void ausfuheren (int funktion) throws IOException, ClassNotFoundException{
    switch (funktion){
        case STR_ADD:
            add();
            break;
        case STR_POP:
            myQueue.removeFirst();
            break;
        case STR_SAVE:
            saveQueue();
            break;
        case STR_LOAD:
            loadQueue();
            break;
        case STR_PRINT:
            System.out.println(myQueue.toString());
            break;
        case STR_ENDE:
            System.out.println("Programmende");
            break;
        default:
            System.out.println("Falsche Eingabe:");
    }
}

    /**
     * Fügt String am Ende der Queue ein.
     */

    public void add(){
        System.out.println("Bitte Name eingeben: ");
        String str = eingabeString();
        myQueue.addlast(str);
    }

    /**
     * Speichert die aktuelle Queue in einer Datei mittels Serialization
     * @throws IOException
     */

    public void saveQueue()throws IOException{
        System.out.println(System.getProperty("user.dir")+"\n");
        System.out.println("Bitte Ordnerpfad / bzw. Dateinamen angeben: \n");
        myQueue.serialize(input.nextLine());
    }

    /**
     * Befüllt die aktuelle Qeue mit dem Inhalt einer Datei.
     * @throws IOException
     * @throws ClassNotFoundException
     */

    public void loadQueue()throws IOException, ClassNotFoundException{
        System.out.println(System.getProperty("user.dir")+"\n");
        System.out.println("Bitte Ordnerpfad / bzw. Dateinamen eingeben: \n");
        myQueue.deserialize(input.nextLine());
    }

    /**
     * Ermöglicht die Eingabe eines Strings
     * @return
     */

    private String eingabeString(){
        Scanner read = new Scanner(System.in);
        return read.nextLine();
    }

    /**
     * Ermöglicht die Eingabe eines Int
     */

    private int eingabeInt(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    /**
     * Main Funktion der Klasse Queue Dialog
     * @param args
     */

    public static void main (String[] args){
        new QueueDialog().start();
    }
}
