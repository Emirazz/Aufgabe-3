package de.hawhh.informatik.sml.kino.werkzeug.barzahlung;

import java.util.EventObject;

/**
 * Event, das über eine Änderung bei der Auswahl von Plätzen informiert. Dieses
 * Event wird von einem {@link JPlatzplan} ausgelöst, wenn der Benutzer in dem
 * Platzplan Plätze auswählt. Das Event enthält die Menge der Plätze, die jetzt
 * ausgewählt sind.
 * 
 * @author SE2-Team (Uni HH), PM2-Team
 * @version SoSe 2017
 */
class GeldAenderungsEvent extends EventObject
{
    private int _betrag;

    /**
     * Erstellt ein neues GeldAenderungsEvent.
     * 
     * @param source
     *            Das Objekt, von dem das Ereignis ausgelöst wurde.
     * @param betrag 
     *            der Betrag, der sich geändert hat.
     */
    public GeldAenderungsEvent(Object source, int betrag)
    {
        super(source);
        _betrag = betrag;
    }
    
    /**
     * Gibt die Menge der nach diesem Ereignis ausgewählten Plätze zurück.
     */
    public int getBetrag()
    {
        return _betrag;
    }
    
    @Override
    public String toString()
    {
        return "GeldAenderungsEvent";
    }

    private static final long serialVersionUID = 1L;
}
