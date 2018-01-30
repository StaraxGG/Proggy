
import java.util.LinkedList;

public class PatientQueue implements Queue {

    private LinkedList<Patient> warteschlange;
    private int max;


    public PatientQueue(int max){
        this.max = max;
        warteschlange = new LinkedList<>();
    }

    @Override
    public void addlast(Object o) {
            if(!o.getClass().equals(Patient.class)){
                throw new IllegalArgumentException("Parameter muss vom Typ Patient sein.");
            }
        if (warteschlange.size()+1 > max){
                throw new IllegalArgumentException("Ihre Warteschlange mit der Größe: "+max+" ist bereits voll.");
        }
            warteschlange.add((Patient)o);
    }

    @Override
    public Object removeFirst() {
        return warteschlange.removeFirst();
    }

    @Override
    public Object get(int i) {
        return warteschlange.get(i);
    }

    @Override
    public boolean empty() {
        return warteschlange.isEmpty();
    }

    @Override
    public boolean full() {
        return warteschlange.size() <= max;
    }

    @Override
    public int size() {
        return warteschlange.size();
    }
}
