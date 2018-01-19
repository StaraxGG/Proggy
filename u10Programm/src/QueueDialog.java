import com.sun.org.apache.xpath.internal.operations.String;

public class QueueDialog {

    private static final int    STRING_QUEUE_ANLEGEN    = 1;
    private static final int    PATIENT_QUEUE_ANLEGEN   = 2;
    private static final int    ENDE         = 0;

    private Queue meineQueue;


    public void start(){
        int p = -1;

        while (p != ENDE){
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
        return 0;
    };

    private void ausfuehren(int k){
        switch (k){
            case STRING_QUEUE_ANLEGEN:

            case ENDE:
                System.out.print("Programmende");
        }
    };


    private void addLast(Object e){
        meineQueue.addlast(e);
    };

    private void removeFirst(){
        valiereQue(meineQueue);
        meineQueue.get(0);
    }

    private void anlegenString(int max){
        meineQueue = new StringQueue(max);
    }

    private void anlegenPatient(int max){
        meineQueue = new PatientQueue(max);
    }

    private void print(){
        valiereQue(meineQueue);
        StringBuffer str = new StringBuffer();
        for (int i=0; i<meineQueue.size();i++){
                str.append(meineQueue.get(i));
        }
    }

    private void valiereQue(Queue q){
        if(q.empty()){
            throw new IllegalArgumentException("Ihre Warteschlange ist leer");
        }
    }
    public static void main(String[] args) {
	    new QueueDialog().start();
    }
}
