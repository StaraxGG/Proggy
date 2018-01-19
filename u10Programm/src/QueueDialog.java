import java.util.Scanner;

public class QueueDialog {

    private static final int CONST_STR_QEUE = 1;
    private static final int CONST_PAT_QEUE = 2;
    private static final int CONST_REM_FIRST = 3;
    private static final int CONST_ADD_LAST = 4;
    private static final int CONST_PRINT = 5;
    private static final int CONST_ENDE = 0;

    private Queue meineQueue;


    public void start(){
        int p = -1;

        while (p != CONST_ENDE){
            try {
                p = auswahl();
                ausfuehren(p);
            }
            catch (IllegalArgumentException e){
                System.err.println(e);
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.err.println("Array Grentze wurde überschritten.");
            }
            catch (RuntimeException e){
                System.err.println(e);
            }
            catch (Exception e){
                System.err.println("Eine unerwartete Ausnahme wurde gefangen :)");
            }
        }
    };


    private int auswahl(){

        StringBuffer str = new StringBuffer();
        str.append("Welche Art von Artikel soll angelegt werden?\n");
        str.append("---------------------------------------------\n");
        str.append(CONST_STR_QEUE + ": String Queue anlegen \n");
        str.append(CONST_PAT_QEUE + ": Patienten Queue anlegen \n");
        str.append(CONST_REM_FIRST + ": Ersten entfernen \n");
        str.append(CONST_ADD_LAST + ": Am Schluss hinzufügen \n");
        str.append(CONST_PRINT + ": Ausgabe der Qeue \n");
        str.append(CONST_ENDE + ": Programm beenden \n");
        str.append("---------------------------------------------\n");
        System.out.println(str.toString());


        return inputInt();
    };

    private void ausfuehren(int k){
        switch (k){
            case CONST_STR_QEUE:
                anlegenString();
                break;
            case CONST_PAT_QEUE:
                anlegenPatient();
                break;
            case CONST_ADD_LAST:
                addLastDialog();
                break;
            case CONST_REM_FIRST:
                removeFirst();
                break;
            case CONST_PRINT:
                print();
                break;
            case CONST_ENDE:
                System.out.print("Programmende");
        }
    };


    private void addLastDialog(String str){
        System.out.println("Bitte Bezeichnung eingeben");
        meineQueue.addlast(inputString());
    };

    private void addLastDialog(){
        System.out.println("Bitte PNR eingeben: ");
        int pnr = inputInt();
        System.out.println("Bitte Name eingeben");
        String name = inputString();

        meineQueue.addlast(new Patient(pnr, name));
    };

    private void addLast(Object e){
        meineQueue.addlast(e);
    };

    private void removeFirst(){
        validiere(meineQueue);
        meineQueue.get(0);
    }

    private void anlegenString(){
        System.out.println("Bitte geben sei die maximale Zahl an Objekten ein: ");
        int max = inputInt();
        meineQueue = new StringQueue(max);
    }

    private void anlegenPatient(){
        System.out.println("Bitte geben sei die maximale Zahl an Objekten ein: ");
        int max = inputInt();
        meineQueue = new PatientQueue(max);
    }

    private void print(){
        validiere(meineQueue);
        StringBuffer str = new StringBuffer();
        for (int i=0; i<meineQueue.size();i++){
                str.append(meineQueue.get(i));
        }
    }

    private void validiere(Queue q){
        if(q.empty()){
            throw new IllegalArgumentException("Ihre Warteschlange ist leer");
        }
    }

    private int inputInt(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private String inputString(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
    public static void main(String[] args) {
	    new QueueDialog().start();
    }
}
