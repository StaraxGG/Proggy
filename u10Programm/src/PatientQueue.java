
import java.util.LinkedList;

public class PatientQueue implements Queue {

    private LinkedList<Patient> warteschlange = new LinkedList<>();
    private int max;


    public PatientQueue(int max){
        this.max = max;
    }

    @Override
    public void addlast(Object o) {
            if(!o.getClass().equals(Patient.class)){
                throw new IllegalArgumentException("Parameter muss vom Typ Patient sein.");
            }
            warteschlange.add((Patient)o);
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
