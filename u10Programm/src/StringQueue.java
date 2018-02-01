public class StringQueue extends MetaQueue implements Queue{

    /**
     * Konstruktor der Klasse StringQueue
     * @param max   Maximale Queue Länge
     */

    public StringQueue(int max){
        super(max);
    }

    /**
     * Fügt Objekt vom Typ String am Ende der Liste ein.
     *
     * @param o Objekt vom Typ String
     */

    @Override
    public void addlast(Object o) {

        if (!o.getClass().equals(String.class)) {
            throw new IllegalArgumentException("Muss vom Typ String sein.");
        }

        if (gefuellt+1 > super.size()){
            throw new IllegalArgumentException("Warteschlange mit der Größe: "+ super.size() +" ist bereits voll.");
        }

        super.addlast(o);
    }

    /**
     * toString Methode der Klasse StringQueue
     * @return  aufbereiteter String mit inhalt der Klasse StringQueue
     */
    @Override
    public String toString(){
        return super.toString();
    }
}
