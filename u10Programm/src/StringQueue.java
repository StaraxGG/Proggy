public class StringQueue implements Queue{

    String[] QueueTab;
    int gefuellt = 0;


    @Override
    public void addlast(Object o) {
        if (!o.getClass().equals(String.class)){
            throw new IllegalArgumentException("Muss vom Typ String sein.");
        }
        QueueTab[gefuellt] = (String) o;
    }

    @Override
    public String get(int i) {
        String str = QueueTab[i];
        shiftDelete(i);
        return str;
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
        for (int i=k;i<QueueTab.length-1;i++){
            QueueTab[i] = QueueTab[i+1];
        }
        QueueTab[gefuellt-1] = null;
        gefuellt--;
    }
}
