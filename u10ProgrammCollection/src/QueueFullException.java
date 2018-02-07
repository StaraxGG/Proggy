public class QueueFullException extends Exception{
    public QueueFullException(){
        super("Ihre Queue ist bereits voll");
    }
}
