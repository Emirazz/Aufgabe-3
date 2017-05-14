package de.hawhh.informatik.sml.kino.werkzeug.barzahlung;
import java.util.EventListener;

/**
 * Interface eines Listeners, der bei Änderungen der Platzauswahl benachrichtigt
 * wird.
 * 
 * @author SE2-Team (Uni HH), PM2-Team
 * @version SoSe 2017
 */
interface GeldbetragAenderungsListener extends EventListener
{
    /**
     * Wird aufgerufen, wenn sich die Auswahl geändert hat.
     * 
     * @param event
     *            das Event, das die Änderung beschreibt.
     */
		void geldbetragAenderung(GeldAenderungsEvent event);
}
