public class StringQueue implements Queue{

    private String[] QueueTab;
    private int gefuellt = 0;
    private int max;

    public StringQueue(int max){
        this.max = max;
        QueueTab = new String[max];
    }

    @Override
    public void addlast(Object o) {

        if (!o.getClass().equals(String.class)) {
            throw new IllegalArgumentException("Muss vom Typ String sein.");
        }

        if (gefuellt+1 > QueueTab.length){
            throw new IllegalArgumentException("Warteschlange mit der Größe: "+max+" ist bereits voll.");
        }

        QueueTab[gefuellt] = (String) o;
        gefuellt++;
    }

    @Override
    public Object removeFirst() {
        String str = QueueTab[0];
        shiftDelete(0);
        return str;
    }

    @Override
    public String get(int i){
        return QueueTab[i];
    }

    @Override
    public boolean empty() {
        if (QueueTab.length != 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean full() {
        if (gefuellt == QueueTab.length) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return QueueTab.length;
    }

    private void shiftDelete(int k){
        for (int i=k;i<gefuellt-1;i++){
            QueueTab[i] = QueueTab[i+1];
        }
        QueueTab[gefuellt-1] = null;
        gefuellt--;
    }
}
