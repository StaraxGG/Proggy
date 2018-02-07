import java.util.Iterator;
import java.util.LinkedList;

public class MetaQueue<E> implements Queue<E>, Iterable<E>{

    private LinkedList<E> queue = new LinkedList<>();

    /**
     * Fügt Object vom Typ E am Ende der LinkedList ein.
     * @param o einzufügendes Object vom Typ E
     */

    @Override
    public void addlast(E o) {
        queue.addLast(o);
    }

    /**
     * Löscht das erste Object in der LinkedList.
     * @return  gelöschtes Object
     */

    @Override
    public Object removeFirst() {
        return queue.removeFirst();
    }

    /**
     * Gibt Object an der Stelle i zurück.
     * @param i index in der LinkedList
     * @return  Object an der Stelle i
     */

    @Override
    public E get(int i) {
        return queue.get(i);
    }

    /**
     * Prüft ob die LinkedList leer ist.
     * @return true wenn leer.
     */

    @Override
    public boolean empty() {
        return queue.isEmpty();
    }

    /**
     * Gibt aktuelle Größe der LinkedList zurück.
     * Aka anzahl Elemente in der LinkedList.
     * @return
     */

    @Override
    public int size() {
        return queue.size();
    }

    /**
     * Iterator der Qeueue.
     * @return Iterator der LinkedList
     */

    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }
}
