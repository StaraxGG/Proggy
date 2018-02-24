import java.io.*;
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
     * Ausgabe der Queue in eine vom
     * Benutzer wählbare Datei
     */

    public void serialize(String dat)throws IOException{
        File datei = new File(dat);
        ObjectOutputStream out = new ObjectOutputStream(
                                 new BufferedOutputStream(
                                 new FileOutputStream(datei)));
        out.writeObject(queue);
        out.close();
    }

    /**
     * Einlesen der Queue aus einer vom
     * Benutzer wählbaren Datei
     *
     * TODO CHECK CAST 
     */

    public void deserialize(String dat) throws IOException, ClassNotFoundException{
        File datei = new File(dat);
        ObjectInputStream in = new ObjectInputStream(
                               new BufferedInputStream(
                               new FileInputStream(datei)));
        LinkedList<E> objQueue = (LinkedList<E>) in.readObject();
    }

    /**
     * Pseudo clone Method die eine LinkedList
     * gefüllt mit den Werten der Queue zurück gibt.
     * @return  Kopie der LinkedList queue mit Werten.
     */

    public LinkedList<E> clone(){
        LinkedList<E> listClone = new LinkedList<>();
        for (E e : queue){
            listClone.add(e);
        }
        return listClone;
    }

    /**
     * Fügt plusListe ans Ende der queue an.
     * Vorraussetzung ist das sowohl die Queue
     * als auch die plusList den selben Typ haben.
     *
     * @param plusList  anzufügende Liste.
     */

    public void append(LinkedList<E> plusList){
        for (E e: plusList){
            queue.add(e);
        }
    }

    /**
     * Überprüft zwei LinkedLists von Typ E auf
     * inhaltliche Gleicheit.
     * @param   list    mit queue zu vergleichende Liste
     * @return  true    inhaltlich gleich
     * @return  false   inhaltlich nicht gleich
     */

    public boolean equals(LinkedList<E> list) {
        Iterator<E> it1 = list.iterator();
        Iterator<E> it2 = queue.iterator();
        
        while(it1.hasNext()){
            if ((it1.next() != it2.next() || (!it2.hasNext()))){
                return false;
            }
        }
        return true;
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
