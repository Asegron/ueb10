/**
 * Die Klasse ObjectQueue, zum Testen der Warteschlange
 * 
 * @author Kiran & Stelz
 * @version 1.0
 */
import java.util.*;

public class QueueDialog {
    /**
     * Konstanten
     */
    private static final int OBJEKT_ANFUEGEN 	= 1;
    private static final int OBJEKT_ENTFERNEN 	= 2;
    private static final int PRUEFE_LEER 		= 3;
    private static final int PRUEFE_VOLL 		= 4;
    private static final int AKTUELLE_ANZAHL 	= 5;
    private static final int ANZEIGEN 			= 6;
    private static final int ENDE 				= 0;

    private static final int STRING_QUEUE 		= 1;
    private static final int PERSON_QUEUE 		= 2;

    private static final String FALSCHE_EINGABE =
        "Falsche Eingabe!";

    /**
     * Attribute und Scanner
     */
    static Scanner in;
    private Queue queue;
    static int auswahl;

    /**
     * Konstruktor mit dem Scanner und der Auswahl an Warteschlangen
     * 
     * @param auswahl Auswahl der Warteschlange
     */
    public QueueDialog(int auswahl) {
        if(auswahl == STRING_QUEUE) {
            queue = new StringQueue();
            System.out.println("Eine String-Warteschlange wurde erstellt.");
        } else {
            if(auswahl == PERSON_QUEUE) {
                queue = new PersonQueue();
                System.out.println("Eine Person-Warteschlange wurde erstellt.");
            } else {
                throw new IllegalArgumentException(FALSCHE_EINGABE);
            }
        }
    }

    /**
     * Gibt das Menue aus und lest die ausgewaehlte Funktion ein
     * 
     * @return Die ausgewaehlte Funktion
     */
    private int einlesenFunktion() {
        System.out.println(
            OBJEKT_ANFUEGEN 	+ ": Objekt anfuegen.\n" +
            OBJEKT_ENTFERNEN 	+ ": Objekt entfernen.\n" +
            PRUEFE_LEER 		+ ": Pruefen, ob die Warteschlange leer ist.\n" +
            PRUEFE_VOLL 		+ ": Pruefen, ob die Warteschlange voll ist.\n" +
            AKTUELLE_ANZAHL		+ ": Zeige die aktuelle Anzahl an Objekten an.\n" +
            ANZEIGEN 			+ ": Warteschlange anzeigen.\n" +
            ENDE 				+ ": Beenden!");

        return in.nextInt();
    }

    /**
     * Führt die ausgewaehlte Funktion aus
     * 
     * @param funktion Die auszufuehrende Funktion
     */
    private void ausfuehrenFunktion(int funktion) {
        if(funktion == OBJEKT_ANFUEGEN) {
            queue.addLast(anlegenObjekt());

        } else if(funktion == OBJEKT_ENTFERNEN) {
            Object derNaechste = queue.removeFirst();
            System.out.println("Der Naechste ist: " + derNaechste);

        } else if(funktion == PRUEFE_LEER) {
            if(queue.empty() == true) {
                System.out.println("Die Warteschlange ist leer.");
            } else if(queue.empty() == false){
                System.out.println("Die Warteschlange ist nicht leer.");
            }

        } else if(funktion == PRUEFE_VOLL) {
            if(queue.full() == true) {
                System.out.println("Die Warteschlange ist voll.");
            } else if(queue.full() == false){
                System.out.println("Die Warteschlange ist nicht voll.");
            }

        } if(funktion == AKTUELLE_ANZAHL) {
            System.out.println(ObjectQueue.getSize());

        } else if(funktion == ANZEIGEN) {
            System.out.println(queue);

        } else if(funktion == ENDE) {
            System.out.println("Ende!");
        }
    }

    /**
     * Methode zum anlegen eines Objekts
     * 
     * @return Angelegtes Objekt
     */
    private Object anlegenObjekt() {
        Object neuesObjekt = null;
        String eingabe;
        String name;
        String vorname;

        if(auswahl == STRING_QUEUE) {
            System.out.println("Geben Sie bitte einen String ein: ");
            eingabe = in.next();
            neuesObjekt = new String(eingabe);

        } else if(auswahl == PERSON_QUEUE) {
            System.out.println("Geben Sie bitte einen Nachnamen ein: ");
            name = in.next();
            System.out.println("Geben Sie bitte einen Vornamen ein: ");
            vorname = in.next();
            System.out.println(new Person(name,vorname));
            neuesObjekt = new Person(name, vorname);
        }

        return neuesObjekt; 
    }

    /**
     * Start-Methode
     */
    public void start() {
        int funktion = -1;

        while(funktion != ENDE) {
            try {
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            } catch(IllegalArgumentException e) {
                System.out.println(e);
            } catch(InputMismatchException e) {
                System.out.println(e);
                in.nextLine();
            } catch(Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Main-Methode
     * 
     * @param args
     */
    public static void main(String[] args) {
        QueueDialog queueDialog;

        try {
            System.out.println("Wahlen Sie bitte eine Array-Art:\n" +
                STRING_QUEUE + ": StringQueue\n" +
                PERSON_QUEUE + ": PersonQueue\n");
            auswahl = in.nextInt();
            queueDialog = new QueueDialog(auswahl);
            queueDialog.start();

        } catch(Exception e) {
            System.out.println(e);
            e.printStackTrace();
            System.exit(1);
        }

        System.exit(0);
    }
}