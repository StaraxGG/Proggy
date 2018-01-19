public interface Queue {

    void addlast(Object o);

    Object get(int i);
    boolean empty();
    boolean full();

    int size();
}
