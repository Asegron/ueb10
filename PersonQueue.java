public class PersonQueue extends ObjectQueue {
    /**
     * Konstanten
     */
    private static final String PERSON_OBJEKT_UNGUELTIG = "Person-Objekt ungueltig!";

    /**
     * Objekt hinten anfuegen
     * 
     * @param o
     */
    public void addLast(Object o) {
        if(o instanceof Person) {
            super.addLast(o);
        } else {
            throw new IllegalArgumentException(PERSON_OBJEKT_UNGUELTIG);
        }
    }

    /**
     * Entfernt das erste Element und
     * gibt eine Referenz darauf zurück
     * 
     * @return
     */
    public Object removeFirst() {
        return (Person)super.removeFirst();
    }

    /**
     * Das i-te Element zurueckgeben
     * 
     * @param i
     * @return
     */
    public Object get(int i) {
        return (Person)super.get(i);
    }
}