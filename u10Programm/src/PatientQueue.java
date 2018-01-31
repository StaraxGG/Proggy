public class PatientQueue extends MetaQueue implements Queue {



    public PatientQueue(int max){
        super(max);
    }

    //TODO Eigene Exception

    @Override
    public void addlast(Object o) {
        if(!(o instanceof Patient)){
                throw new IllegalArgumentException("Parameter muss vom Typ Patient sein.");
            }
        if (super.size()+1 >= super.gefuellt){
                throw new IllegalArgumentException("Ihre Warteschlange mit der Größe: "+super.size()+" ist bereits voll.");
        }
        super.addlast(o);
    }

    @Override
    public Object removeFirst() {
        return super.removeFirst();
    }

    @Override
    public Patient get(int i) {
        return (Patient) super.get(i);
    }

    @Override
    public boolean empty() {
        return super.empty();
    }

    @Override
    public boolean full() {
        return super.full();
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
