

public interface Queue<E>{

    void addlast(E o);

    Object removeFirst();

    Object get(int i);
    boolean empty();

    int size();
}
