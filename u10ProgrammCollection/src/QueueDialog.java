import java.io.*;
import java.util.Iterator;

public class QueueDialog {

    private static final String pfad = "C:\\Users\\Nicolas\\Documents\\InteliJProgramme\\u10ProgrammCollection\\src\\data.txt";

    private MetaQueue<String> meineQueue;
    private File meineDatei = new File(pfad);

    /**
     * Start Methode der Klasse.
     * Legt Queue an auf Basis einer Datei.
     * Dafür wird ein BufferedStreamReader genutzt.
     * Anschließend wird die Queue Ausgegeben.
     *
     * @throws IOException
     */

    public void start() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(
                        new FileReader(meineDatei));
        meineQueue = new MetaQueue<>();

        String line;
        while((line = bufferedReader.readLine()) != null){
                meineQueue.addlast(line);
        }

        ausgabe();
        bufferedReader.close();
    }

    /**
     * Gibt inhalt der Liste aus.
     */

    public void ausgabe(){
        Iterator<String> iterator = meineQueue.iterator();
        while (iterator.hasNext()){
            String person = iterator.next();
            System.out.println(person);
        }
    }

    /**
     * Main Methode der Klasse
     * wirft IOException
     *
     * @param args
     * @throws IOException
     */

    public static void main (String[] args) throws IOException{
        new QueueDialog().start();
    }
}
