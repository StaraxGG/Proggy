public class MetaQueue implements Queue {

    Object[] queueTab;
    int gefuellt = 0;

    public MetaQueue(int max){
        queueTab = new Object[max];
    }

    @Override
    public void addlast(Object o) {
        queueTab[gefuellt] = o;
        gefuellt++;
    }

    @Override
    public Object removeFirst() {
        Object removedItem = queueTab[0];
        shiftDelete(0);
        return removedItem;
    }

    @Override
    public Object get(int i) {
        return queueTab[i];
    }

    @Override
    public boolean empty() {
        if (queueTab.length == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean full() {
        if (gefuellt >= queueTab.length){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return queueTab.length;
    }

    private void shiftDelete(int k){
        for (int i=k;i<gefuellt-1;i++){
            queueTab[i] = queueTab[i+1];
        }
        queueTab[gefuellt-1] = null;
        gefuellt--;
    }

    @Override
    public String toString(){
        StringBuffer str = new StringBuffer();
        for (int i=0; i<gefuellt; i++){
            str.append(queueTab[i]);
        }
        return str.toString();
    }
}
