public class StringQueue extends MetaQueue implements Queue{

    public StringQueue(int max){
        super(max);
    }

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

    @Override
    public Object removeFirst() {
        return super.removeFirst();
    }

    @Override
    public String get(int i){
        return (String) super.get(i);
    }

    @Override
    public boolean empty() {
        return super.empty();
    }

    @Override
    public boolean full() {
        return super.full();
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
