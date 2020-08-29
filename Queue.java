public interface Queue {
    /**
     * Objekt hinten anfuegen
     * 
     * @param o
     */
    void addLast(Object o);

    /**
     * Entfernt das erste Element und
     * gibt eine Referenz darauf zurück
     * 
     * @return
     */
    Object removeFirst();

    /**
     * Das i-te Element zurueckgeben
     * 
     * @param i
     * @return
     */
    Object get(int i);

    /**
     * Testet, ob schon Elemente eingefuegt wurden
     * 
     * @return
     */
    boolean empty();

    /**
     * Testet, ob noch Elemente einfuegbar sind,
     * d. h. ob das letzte Element schon einen Wert != null hat
     * 
     * @return
     */
    boolean full();

    /**
     * Anzahl eingefuegter Elemente
     * 
     * @return
     */
    int size();
}