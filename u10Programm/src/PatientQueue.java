public class PatientQueue extends MetaQueue implements Queue {

    //TODO Eigene Exception

    /**
     * Konstruktor der Klasse PatientQueue
     * @param max   größe der Queue
     */

    public PatientQueue(int max) {
        super(max);
    }

    /**
     * Fügt Objekte vom Typ String am Ende der Liste an
     * @param o Objekt vom Typ Object das am Ende eingefügt werden soll.
     */

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

    /**
     * String Methode der Klasse PatientQueue
     * @return  aufbereiter String
     */

    @Override
    public String toString(){
        return super.toString();
    }
}
