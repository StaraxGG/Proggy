import java.util.Scanner;

public class QueueDialog {

    private static final int CONST_STR_QEUE = 1;
    private static final int CONST_PAT_QEUE = 2;
    private static final int CONST_STR_REM_FIRST = 3;
    private static final int CONST_PAT_REM_FIRST = 4;
    private static final int CONST_STR_ADD_LAST = 5;
    private static final int CONST_PAT_ADD_LAST = 6;
    private static final int CONST_STR_PRINT = 7;
    private static final int CONST_PAT_PRINT = 8;
    private static final int CONST_ENDE = 0;

    private StringQueue strQueue;
    private PatientQueue patQueue;


    public void start(){
        int funktion = -1;

        while (funktion != CONST_ENDE){
            try {
                funktion = auswahl();
                ausfuehren(funktion);
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
        str.append("---------------------------------------------\n");
        str.append(CONST_STR_QEUE + ": String Queue anlegen \n");
        str.append(CONST_PAT_QEUE + ": Patienten Queue anlegen \n");
        str.append(CONST_STR_REM_FIRST + ": Ersten entfernen STRQUEUE \n");
        str.append(CONST_PAT_REM_FIRST + ": Ersten entfernen PATQUEUE \n");
        str.append(CONST_STR_ADD_LAST + ": Am Schluss hinzufügen STRQUEUE \n");
        str.append(CONST_PAT_ADD_LAST + ": Am Schluss hinzufügen PATQUEUE \n");
        str.append(CONST_STR_PRINT + ": Ausgabe STRQUEUE\n");
        str.append(CONST_PAT_PRINT +": Ausgabe PATQUEUE \n");
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
            case CONST_STR_ADD_LAST:
                addLastDialogString();
                break;
            case CONST_PAT_ADD_LAST:
                addLastDialogPatient();
                break;
            case CONST_STR_REM_FIRST:
                removeFirst(strQueue);
                break;
            case CONST_PAT_REM_FIRST:
                removeFirst(patQueue);
                break;
            case CONST_STR_PRINT:
                print(strQueue);
                break;
            case CONST_PAT_PRINT:
                print(patQueue);
                break;
            case CONST_ENDE:
                System.out.print("Programmende");
        }
    }



    private void addLastDialogString(){
        System.out.println("Bitte Bezeichnung eingeben");
        strQueue.addlast(inputString());
    };

    private void addLastDialogPatient(){
        System.out.println("Bitte PNR eingeben: ");
        int pnr = inputInt();
        System.out.println("Bitte Name eingeben");
        String name = inputString();

        patQueue.addlast(new Patient(pnr, name));
    };

    private void removeFirst(Queue q){
        validiere(q);
        q.removeFirst();
    }

    private void anlegenString(){
        System.out.println("Bitte geben sei die maximale Zahl an Objekten ein: ");
        int max = inputInt();
        strQueue = new StringQueue(max);
    }

    private void anlegenPatient(){
        System.out.println("Bitte geben sei die maximale Zahl an Objekten ein: ");
        int max = inputInt();
        patQueue = new PatientQueue(max);
    }

    private void print(Queue q){
        validiere(q);
        StringBuffer str = new StringBuffer();
        for (int i=0; i<q.size();i++){
                str.append(q.get(i));
        }
        System.out.println(str.toString());
    }

    private void validiere(Queue q){
        if (q == null){
            throw new IllegalArgumentException("Es wurde noch keine Queue angelegt.");
        }
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
