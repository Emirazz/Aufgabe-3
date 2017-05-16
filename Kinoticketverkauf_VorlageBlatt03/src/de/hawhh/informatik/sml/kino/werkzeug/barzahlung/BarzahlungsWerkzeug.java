package de.hawhh.informatik.sml.kino.werkzeug.barzahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JOptionPane;

import de.hawhh.informatik.sml.kino.materialien.Vorstellung;
import de.hawhh.informatik.sml.kino.fachwerte.Platz;
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
    private Set<Platz> _plaetze;

    private BarzahlungsWerkzeugUI _ui;

    /**
     * Initialisiert das BarzahlungsWerkzeug.
     * @require vorstellung != null
     * @require plaetze != null
     */
    public BarzahlungsWerkzeug(Vorstellung vorstellung, Set<Platz> plaetze)
    {
    	assert vorstellung != null : "Vorbedingung verletzt: vorstellung != null";
    	assert plaetze != null : "Vorbedingung verletzt: plaetze != null";
    	
    	_vorstellung = vorstellung;
    	_plaetze = plaetze;
        _ui = new BarzahlungsWerkzeugUI(getTickets(), _vorstellung.getPreisFuerPlaetze(_plaetze));
        registriereUIAktionen();
        
        _ui.zeigeFenster();
    }
    
    /**
     * Gibt den Aufgewählten Filmtitel als String zurueck.
     */
    private String getTickets()
    {
    	String x = "Tickets für:\n" + _vorstellung.toString() + "\nPlätze: " + _plaetze;
    	return x;
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
            	if(_ui.getRueckgeld() >= 0)
            	{
            		informiereUeberAenderung();
                	reagiereAufBeendenButton();
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null,
            				"Verkaufen nicht möglich, da Einnahmen zu gering!", "Fehlermeldung", JOptionPane.ERROR_MESSAGE);
            	}
            }
        });
    }
    
    /**
     * Beendet die Anwendung.
     */
    private void reagiereAufBeendenButton()
    {
    	_ui.schliesseFenster();
    }
    
}

