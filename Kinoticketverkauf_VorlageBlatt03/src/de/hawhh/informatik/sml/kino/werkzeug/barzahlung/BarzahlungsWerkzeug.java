package de.hawhh.informatik.sml.kino.werkzeug.barzahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JPanel;
import de.hawhh.informatik.sml.kino.fachwerte.Platz;
import de.hawhh.informatik.sml.kino.materialien.Kinosaal;
import de.hawhh.informatik.sml.kino.materialien.Vorstellung;

/**
 * Mit diesem Werkzeug können Tickets Bar bezahlt werden. Es arbeitet
 * auf einer Vorstellung als Material. Mit ihm kann angezeigt werden, welche
 * Plätze schon verkauft und welche noch frei sind.
 * 
 * Dieses Werkzeug ist ein eingebettetes Subwerkzeug. Es kann nicht beobachtet
 * werden.
 * 
 * @author SE2-Team (Uni HH), PM2-Team
 * @version SoSe 2017
 */
public class BarzahlungsWerkzeug
{
    // Die aktuelle Vorstellung, deren Plätze angezeigt werden. Kann null sein.
    private Vorstellung _vorstellung;

    private BarzahlungsWerkzeugUI _ui;

    /**
     * Initialisiert das BarzahlungsWerkzeug.
     */
    public BarzahlungsWerkzeug()
    {
        _ui = new BarzahlungsWerkzeugUI();
        registriereUIAktionen();
        // Am Anfang wird keine Vorstellung angezeigt:
        setVorstellung(null);
    }

    /**
     * Gibt das Panel dieses Subwerkzeugs zurück. Das Panel sollte von einem
     * Kontextwerkzeug eingebettet werden.
     * 
     * @ensure result != null
     */
    public JPanel getUIPanel()
    {
        return _ui.getUIPanel();
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
                verkaufePlaetze(_vorstellung);
            }
        });

        _ui.getOKButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                stornierePlaetze(_vorstellung);
            }
        });

        _ui.getBargeld().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setzeRueckgeld(_vorstellung);
            }
                });
    }

    /**
     * Reagiert darauf, dass sich der Geldbetrag geändert
     * hat.
     * 
     * @param plaetze die jetzt ausgewählten Plätze.
     */
    private void reagiereAufGeldbetrag(int bargeld)
    {
        
    }

    /**
     * Aktualisiert den anzuzeigenden Gesamtpreis
     */
    private void aktualisierePreisanzeige(Set<Platz> plaetze)
    {

        if (istVerkaufenMoeglich(plaetze))
        {
            int preis = _vorstellung.getPreisFuerPlaetze(plaetze);
            _ui.getPreisLabel().setText("Gesamtpreis: " + preis + " Eurocent");
        }
        else
        {
            _ui.getPreisLabel().setText("Gesamtpreis:");
        }
    }
}

