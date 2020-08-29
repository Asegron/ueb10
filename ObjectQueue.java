public class ObjectQueue implements Queue {
    /**
     * Konstanten
     */
    private static final int QUEUE_STANDARD_GROESSE = 10;

    private static final String QUEUE_BEREITS_VOLL = "Die Queue ist bereits voll!";
    private static final String QUEUE_IST_LEER = "Die Queue ist leer!";
    private static final String INDEX_ZU_GROSS = "Der Index ist zu gross!";

    /**
     * Attribute
     */
    private Object[] queue;
    private int size;

    public ObjectQueue() {
        queue = new Object[QUEUE_STANDARD_GROESSE];
        size = 0;
    }

    public void addLast(Object o) {
        if(full()) {
            throw new IllegalArgumentException(QUEUE_BEREITS_VOLL);
        }

        queue[size] = o;
        size++;
    }

    public Object removeFirst() {
        if(empty()) {
            throw new IllegalArgumentException();
        }

        int i;
        Object zähler = queue[0];
        size--;

        for(i = 0; i < size; i++) {
            queue[i] = queue[i + 1];
        }

        queue[i + 1] = null;
        return zähler;
    }

    public Object get(int i) {
        if(empty()) {
            throw new IllegalArgumentException(QUEUE_IST_LEER);
        }

        if(i > size) {
            throw new IllegalArgumentException(INDEX_ZU_GROSS);
        }

        return queue[i - 1];
    }

    public boolean full() {
        return (size == 10);
    }

    public boolean empty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < size; i++) {
            sb.append(queue[i] + " - ");
        }

        return sb.toString();
    }
}