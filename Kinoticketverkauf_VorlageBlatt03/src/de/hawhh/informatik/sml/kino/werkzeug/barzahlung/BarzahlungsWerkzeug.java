package de.hawhh.informatik.sml.kino.werkzeug.barzahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import de.hawhh.informatik.sml.kino.materialien.Vorstellung;
import de.hawhh.informatik.sml.kino.werkzeuge.ObservableSubwerkzeug;

/**
 * Mit diesem Werkzeug können Tickets Bar bezahlt werden. Es arbeitet
 * auf einer Vorstellung als Material. Mit ihm kann angezeigt werden, was gezahlt werden muss und
 * welches Rueckgeld gezahlt werden muss fuer Betrag x.
 * 
 * 
 * @author Emira Zorgati
 * @version SoSe 2017
 */
public class BarzahlungsWerkzeug extends ObservableSubwerkzeug
{
    // Die aktuelle Vorstellung, deren Tickets verkauft werden. Darf nicht null sein.
    private Vorstellung _vorstellung;

    private BarzahlungsWerkzeugUI _ui;

    /**
     * Initialisiert das BarzahlungsWerkzeug.
     * @require vorstellung != null
     */
    public BarzahlungsWerkzeug(Vorstellung vorstellung, JFrame owner)
    {
    	assert vorstellung != null : "Vorbedingung verletzt: vorstellung != null";
    	
    	_vorstellung = vorstellung;
        _ui = new BarzahlungsWerkzeugUI(owner);
        registriereUIAktionen();
        
        _ui.zeigeFenster();
    }
    
    /**
     * Gibt den Aufgewählten Filmtitel als String zurueck.
     */
    private String getTickets()
    {
    	return "Tickets für:" + _vorstellung.getFilm();
    }

    /**
     * Fügt der UI die Funktionalität hinzu mit entsprechenden Listenern.
     */
    private void registriereUIAktionen()
    {
        _ui.getAbbruchButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	reagiereAufBeendenButton();
            }
        });

        _ui.getOKButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	informiereUeberAenderung();
            	reagiereAufBeendenButton();
            }
        });
    }
    
    /**
     * Beendet die Anwendung.
     */
    private void reagiereAufBeendenButton()
    {
    	System.exit(0);
    }
    
}

