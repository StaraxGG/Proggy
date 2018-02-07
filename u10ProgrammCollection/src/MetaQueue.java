import java.util.Iterator;
import java.util.LinkedList;

public class MetaQueue<E> implements Queue<E>, Iterable<E>{

    private int max = 0;
    private LinkedList<E> queue = new LinkedList<>();

    public MetaQueue(int i){
        this.max = i;
    }

    @Override
    public void addlast(E o) {
        queue.addLast(o);
    }

    @Override
    public Object removeFirst() {
        return queue.removeFirst();
    }

    @Override
    public E get(int i) {
        return queue.get(i);
    }

    @Override
    public boolean empty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }
}
