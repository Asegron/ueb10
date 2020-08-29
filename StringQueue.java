public class StringQueue extends ObjectQueue {
    /**
     * Konstanten
     */
    private static final String STRING_OBJEKT_UNGUELTIG = "String-Objekt ist ungueltig!";

    /**
     * Objekt hinten anfuegen
     * 
     * @param o
     */
    public void addLast(Object o) {
        if(o instanceof String) {
            super.addLast(o);
        } else {
            throw new IllegalArgumentException(STRING_OBJEKT_UNGUELTIG);
        }
    }

    /**
     * Entfernt das erste Element und
     * gibt eine Referenz darauf zurück
     * 
     * @return
     */
    public Object removeFirst() {
        return (String)super.removeFirst();
    }

    /**
     * Das i-te Element zurueckgeben
     * 
     * @param i
     * @return
     */
    public Object get(int i) {
        return (String)super.get(i);
    }
}