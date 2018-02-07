public class MetaQueue implements Queue {

    // <>
    Object[] queueTab;
    int gefuellt = 0;

    /**
     * Konsturktor der Klasse MetaQeue
     * @param max   maximale Queue Länge
     */

    public MetaQueue(int max){
        queueTab = new Object[max];
    }

    /**
     * Fügt ein Objekt am Ende der Liste ein.
     * @param o Objekt vom Typ Object das am Ende eingefügt werden soll.
     */

    @Override
    public void addlast(Object o) {
        queueTab[gefuellt] = o;
        gefuellt++;
    }

    /**
     * Löscht das Objekt am Anfang der Liste.
     *
     * @return  gelöschtes Objekt
     */

    @Override
    public Object removeFirst() {
        Object removedItem = queueTab[0];
        shiftDelete(0);
        return removedItem;
    }

    /**
     * Gibt das Objekt an der Position i zurück.
     * @param   i     Position des Objektes im Array
     * @return  Objekt an der Stelle i
     */

    @Override
    public Object get(int i) {
        return queueTab[i];
    }

    /**
     * Gibt true zurück wenn das Array leer ist.
     * @return  true = leer
     */

    @Override
    public boolean empty() {
        if (queueTab.length == 0){
            return true;
        }
        return false;
    }

    /**
     * Prüft ob das Array voll ist.
     * @return  true = voll
     */

    @Override
    public boolean full() {
        if (gefuellt >= queueTab.length){
            return true;
        }
        return false;
    }

    /**
     * Gibt größe des Arrays zurück.
     * @return  länge des Arrays
     */

    @Override
    public int size() {
        return queueTab.length;
    }

    /**
     * Löscht ein Objekt an einer Position des Arrays und rückt auf.
     * @param k
     */

    private void shiftDelete(int k){
        for (int i=k;i<gefuellt-1;i++){
            queueTab[i] = queueTab[i+1];
        }
        queueTab[gefuellt-1] = null;
        gefuellt--;
    }

    /**
     * ToString Methode der Klasse MetaQueue
     * @return  aufbereiteter String mit inhalte der Klasse MetaQueue
     */

    @Override
    public String toString(){
        StringBuffer str = new StringBuffer();
        for (int i=0; i<gefuellt; i++){
            str.append(queueTab[i]);
        }
        return str.toString();
    }
}
